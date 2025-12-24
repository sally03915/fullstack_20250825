package com.thejoa703.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.thejoa703.oauth.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(auth -> auth
            	// 누구나 접근 가능
                .antMatchers( "/map/**" ,"/api/**" , "/users/iddouble", "/users/login", "/users/join", "/css/**", "/js/**", "/images/**").permitAll()
                
                // 로그인한 사용자만 접근 가능
                .antMatchers(
                        "/board/write",
                        "/board/edit",
                        "/board/delete",
                        "/users/mypage",
                        "/users/delete",
                        "/users/update"
                ).authenticated()
                //그 외 요청은 모두 허용
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/users/login")
                .loginProcessingUrl("/users/loginProc")
                .defaultSuccessUrl("/users/mypage", true)
                .failureUrl("/users/fail")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                .logoutSuccessUrl("/users/login")
                .invalidateHttpSession(true)
                .permitAll()
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/users/login") // ← Form 로그인과 동일하게 통합
                .defaultSuccessUrl("/users/mypage", true) // ← 성공 후 동일 페이지로 이동
                .userInfoEndpoint(userInfo -> userInfo.userService(principalOauth2UserService))
            )
            //            CSRF 보안 예외 처리            특정 URL은 CSRF 검증을 하지 않음
            .csrf(csrf -> csrf.ignoringAntMatchers(
                "/users/join",
                "/users/update",
                "/users/delete",
                "/board/insert",
                "/board/update",
                "/board/delete"
            ));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}

