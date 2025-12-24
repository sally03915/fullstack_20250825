package com.thejoa703.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.thejoa703.oauth.Oauth2IUserService;
import com.thejoa703.security.JwtAuthenticationFilter;
import com.thejoa703.security.OAuth2SuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final Oauth2IUserService oauth2IUserService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/join", "/users/login", "/images/**", "/oauth2/**", "/login/oauth2/**").permitAll()
                .requestMatchers("/users/mypage", "/users/update", "/users/delete").authenticated()
                .requestMatchers("/api/**").authenticated() // 🔹 API는 인증 필요하도록 수정 권장
                .anyRequest().permitAll()
            )
            // 🔹 formLogin은 웹 페이지용, API만 쓴다면 제거 가능
            .formLogin(form -> form
                .loginPage("/users/login")
                .loginProcessingUrl("/users/loginProc")
                .defaultSuccessUrl("/users/mypage", true)
                .failureUrl("/users/fail")
                .permitAll()
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/users/login")
                .successHandler(oAuth2SuccessHandler) // JWT 발급 핸들러
                .userInfoEndpoint(userInfo -> userInfo.userService(oauth2IUserService))
            )
            .csrf(csrf -> csrf.disable()); // 🔹 REST API 기반이면 disable

        // 🔹 JWT 필터 추가
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}

