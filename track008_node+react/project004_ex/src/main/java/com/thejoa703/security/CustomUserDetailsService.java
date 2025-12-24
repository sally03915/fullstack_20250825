package com.thejoa703.security;

import com.thejoa703.entity.AppUser;
import com.thejoa703.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService 구현체
 * - local 로그인 시: email + provider("local")로 사용자 조회(loadUserByUsername)
 * - 소셜 로그인 시: email + provider로 사용자 조회(loadUserByEmailAndProvider)
 * - JWT 필터 인증 시: userId로 조회(loadUserById)
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public CustomUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    /** 
     * 🔹 local 로그인: email + provider("local")로 조회
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByEmailAndProvider(email, "local")
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email + " with provider local"));
        return new CustomUserDetails(user, null); // attributes는 null
    }

    /**
     * 🔹 소셜 로그인: email + provider로 조회
     */
    public UserDetails loadUserByEmailAndProvider(String email, String provider) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByEmailAndProvider(email, provider)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email + " with provider " + provider));
        return new CustomUserDetails(user, null); // attributes는 null
    }

    /** 🔹 JWT 필터: userId 기반 조회 */
    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found by id: " + id));
        return new CustomUserDetails(user, null); // attributes는 null
    }
}
