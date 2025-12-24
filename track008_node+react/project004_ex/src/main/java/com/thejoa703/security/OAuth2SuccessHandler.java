package com.thejoa703.security;

import com.thejoa703.entity.AppUser;
import com.thejoa703.oauth.Oauth2IUserService;
import com.thejoa703.service.TokenService;
import com.thejoa703.util.JwtTokenProvider; // 프로젝트의 JWT 유틸/프로바이더에 맞게 수정
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider; // Access/Refresh 발급용
    private final TokenService tokenService;         // Refresh 토큰 저장(예: Redis)
    private final OAuth2RedirectResolver redirectResolver; // 리다이렉트 URL 결정 (옵션)

    // 쿠키로 내려줄지, 쿼리스트링으로 내려줄지 선택
    private final boolean useCookie = true;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) {

        try {
            // Authentication에서 CustomUserDetails 꺼내기
            CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
            AppUser user = principal.getUser();

            // JWT 발급
            String accessToken = jwtTokenProvider.generateAccessToken(user.getId(), user.getEmail(), user.getRole());
            String refreshToken = jwtTokenProvider.generateRefreshToken(user.getId(), user.getEmail());

            // Refresh 저장 (예: Redis 키 = userId, 값 = refreshToken)
            tokenService.saveRefreshToken(String.valueOf(user.getId()), refreshToken, Duration.ofDays(14));

            // 토큰 전달
            if (useCookie) {
                addHttpOnlyCookie(response, "accessToken", accessToken, 60 * 60);       // 1h
                addHttpOnlyCookie(response, "refreshToken", refreshToken, 60 * 60 * 24 * 14); // 14d
                // 최종 이동할 페이지
                String redirectUrl = Optional.ofNullable(redirectResolver)
                        .map(r -> r.resolveAfterLogin(request, user))
                        .orElse("/users/mypage");
                response.sendRedirect(redirectUrl);
            } else {
                String redirectUrl = Optional.ofNullable(redirectResolver)
                        .map(r -> r.resolveAfterLogin(request, user))
                        .orElse("/users/mypage");
                // 쿼리스트링으로 전달하는 방식 (프론트가 쿠키가 아닌 로컬스토리지에 저장하는 설계일 때)
                response.sendRedirect(redirectUrl + "?accessToken=" + urlEncode(accessToken) +
                        "&refreshToken=" + urlEncode(refreshToken));
            }

        } catch (Exception e) {
            log.error("OAuth2 success handling failed", e);
            try {
                response.sendRedirect("/users/fail");
            } catch (Exception ignored) {}
        }
    }

    private void addHttpOnlyCookie(HttpServletResponse response, String name, String value, int maxAgeSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setSecure(true); // HTTPS 환경 권장
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeSeconds);
        response.addCookie(cookie);
    }

    private String urlEncode(String s) {
        return java.net.URLEncoder.encode(s, StandardCharsets.UTF_8);
    }
}
