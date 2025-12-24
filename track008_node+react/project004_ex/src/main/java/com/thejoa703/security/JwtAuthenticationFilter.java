package com.thejoa703.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * JWT 인증 필터
 * - Authorization 헤더에서 Bearer 토큰 추출
 * - 토큰 subject(userId)와 roles 클레임 검증 후 SecurityContext에 인증 정보 저장
 * - CustomUserDetailsService.loadUserById() 사용
 * - /auth/** 경로는 인증을 건너뛰도록 처리
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider,
                                   CustomUserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        // ✅ 공개 엔드포인트는 필터 건너뛰기
        if (path.startsWith("/auth/signup") ||
            path.startsWith("/auth/login") ||
            path.startsWith("/auth/refresh") ||
            path.startsWith("/auth/logout")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (jwtTokenProvider.validateToken(token)) {
                String userIdSubject = jwtTokenProvider.getUserIdFromToken(token);
                List<String> roles = jwtTokenProvider.getRolesFromToken(token); // ✅ roles 클레임 추출

                if (userIdSubject != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    try {
                        Long userId = Long.valueOf(userIdSubject);

                        // ✅ userId 기반 조회
                        var userDetails = userDetailsService.loadUserById(userId);

                        // ✅ 토큰 roles를 GrantedAuthority로 변환 (ROLE_ prefix 보장)
                        var authorities = roles.stream()
                                .map(role -> new SimpleGrantedAuthority(
                                        role.startsWith("ROLE_") ? role : "ROLE_" + role))
                                .toList();

                        var authToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, authorities);

                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    } catch (NumberFormatException ignored) {
                        // subject가 숫자로 변환되지 않으면 인증하지 않음
                    }
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
