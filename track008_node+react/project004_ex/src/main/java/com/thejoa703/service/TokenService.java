package com.thejoa703.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Redis 기반 RefreshToken 관리 서비스
 * - 키를 userId로 통일하여 JWT subject와 일관성 유지
 */
@Service
@RequiredArgsConstructor
public class TokenService {

    private final StringRedisTemplate redisTemplate;

    /** RefreshToken 저장 */
    public void saveRefreshToken(String userId, String refreshToken, long expirationMillis) {
        redisTemplate.opsForValue().set("refresh:" + userId, refreshToken, expirationMillis, TimeUnit.MILLISECONDS);
    }

    /** RefreshToken 조회 */
    public String getRefreshToken(String userId) {
        return redisTemplate.opsForValue().get("refresh:" + userId);
    }

    /** RefreshToken 삭제 */
    public void deleteRefreshToken(String userId) {
        redisTemplate.delete("refresh:" + userId);
    }
}
