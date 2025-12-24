package com.thejoa703.security;

import com.thejoa703.entity.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

/**
 * JWT 토큰 발급 및 검증 유틸리티
 * - subject를 userId로 사용
 * - roles 클레임을 추가하여 권한 정보 포함
 * - AccessToken: 짧은 만료시간, RefreshToken: 긴 만료시간
 */
@Component
public class JwtTokenProvider {

    private final SecretKey secretKey;
    private final long accessExpirationMillis;
    private final long refreshExpirationMillis;

    public JwtTokenProvider(
            @Value("${security.jwt.secret:change-this-secret-to-a-strong-value}") String secret,
            @Value("${security.jwt.access-expiration-millis:1800000}") long accessExpirationMillis,   // 30분
            @Value("${security.jwt.refresh-expiration-millis:604800000}") long refreshExpirationMillis // 7일
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.accessExpirationMillis = accessExpirationMillis;
        this.refreshExpirationMillis = refreshExpirationMillis;
    }

    /** AccessToken 발급 (userId + role 포함) */
    public String generateAccessToken(AppUser user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + accessExpirationMillis);

        return Jwts.builder()
                .setSubject(user.getId().toString()) // subject=userId
                .claim("roles", List.of(user.getRole())) // ✅ 권한 클레임 추가
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    /** RefreshToken 발급 (userId 기반) */
    public String generateRefreshToken(AppUser user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + refreshExpirationMillis);

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    /** 토큰 유효성 검증 */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 토큰에서 userId(subject) 추출 */
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    /** 토큰에서 roles 클레임 추출 */
    public List<String> getRolesFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("roles", List.class);
    }

    public long getRefreshExpirationMillis() {
        return refreshExpirationMillis;
    }

    public long getAccessExpirationMillis() {
        return accessExpirationMillis;
    }
}
