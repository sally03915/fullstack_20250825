package com.thejoa703.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis 설정 클래스
 * - RedisConnectionFactory: Redis 서버 연결 관리
 * - RedisTemplate: Redis 데이터 접근을 위한 템플릿
 * - 보완: host/port는 application.yml에서 spring.redis.host/port로 관리하는 것이 권장됨
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 기본 localhost:6379 연결 (보완: application.yml에서 관리 권장)
        return new LettuceConnectionFactory("localhost", 6379);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
