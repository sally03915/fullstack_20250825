package com.thejoa703.service;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.RefreshRequest;
import com.thejoa703.dto.TokenResponse;
import com.thejoa703.entity.AppUser;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

/**
 * 인증 관련 서비스
 * - 로그인: 이메일/비밀번호 검증 → 토큰 발급 → Redis 저장
 * - 로그아웃: RefreshToken 삭제
 * - 리프레시: RefreshToken 검증 → 새 AccessToken/RefreshToken 발급
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final TokenService tokenService;
    private final AppUserRepository appUserRepository;

    /** 로그인 처리 */
    public TokenResponse login(LoginRequest request) {
        // AuthenticationManager로 인증 수행 (local일 때만 password 검증)
        if ("local".equalsIgnoreCase(request.getProvider())) {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        }

        // 🔹 email + provider 기반 사용자 조회
        AppUser user = appUserRepository.findByEmailAndProvider(request.getEmail(), request.getProvider())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User not found with provider: " + request.getProvider()));

        // ✅ 토큰 발급
        String accessToken = jwtTokenProvider.generateAccessToken(user);
        String refreshToken = jwtTokenProvider.generateRefreshToken(user);

        // Redis에 RefreshToken 저장
        tokenService.saveRefreshToken(user.getId().toString(), refreshToken,
                jwtTokenProvider.getRefreshExpirationMillis());

        return new TokenResponse(accessToken, refreshToken);
    }

    /** 로그아웃 처리: RefreshToken 삭제 */
    public void logout(Long userId, String refreshToken) {
        log.info("=== LOGOUT START ===");

        // RefreshToken 검증
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid refresh token");
        }

        String storedRefresh = tokenService.getRefreshToken(userId.toString());
        if (storedRefresh == null || !storedRefresh.equals(refreshToken)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Refresh token mismatch");
        }

        // Redis에서 RefreshToken 삭제
        tokenService.deleteRefreshToken(userId.toString());
        log.info("Refresh token deleted for user {}", userId);
        log.info("=== LOGOUT END ===");
    }

    /** 리프레시 처리: 새 AccessToken/RefreshToken 발급 */
    public TokenResponse refresh(RefreshRequest request) {
        String refreshToken = request.getRefreshToken();

        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid refresh token");
        }

        String userId = jwtTokenProvider.getUserIdFromToken(refreshToken);
        AppUser user = appUserRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        String storedRefresh = tokenService.getRefreshToken(user.getId().toString());
        if (storedRefresh == null || !storedRefresh.equals(refreshToken)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Refresh token mismatch");
        }

        // ✅ 새 토큰 발급 (role 포함)
        String newAccess = jwtTokenProvider.generateAccessToken(user);
        String newRefresh = jwtTokenProvider.generateRefreshToken(user);

        // Redis에 새 RefreshToken 저장
        tokenService.saveRefreshToken(user.getId().toString(), newRefresh, jwtTokenProvider.getRefreshExpirationMillis());

        return new TokenResponse(newAccess, newRefresh);
    }
}
