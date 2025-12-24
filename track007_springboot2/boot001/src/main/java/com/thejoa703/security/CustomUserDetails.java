package com.thejoa703.security;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AppUserAuthDto;

public class CustomUserDetails implements UserDetails, OAuth2User {

    private static final long serialVersionUID = 1L;

    private AppUserDto user;
    private AppUserAuthDto authDto;
    private Map<String, Object> attributes;

    // 일반 로그인용
    public CustomUserDetails(AppUserDto user, AppUserAuthDto authDto) {
        this.user = user;
        this.authDto = authDto;
        this.attributes = new HashMap<>();
        this.attributes.put("email", user.getEmail());
        this.attributes.put("provider", user.getProvider());
    }

    // OAuth2 로그인용
    public CustomUserDetails(AppUserDto user, Map<String, Object> attributes) {
        this.user = user;
        this.authDto = new AppUserAuthDto();
        this.authDto.setAuthList(List.of()); // 권한 리스트 기본값
        this.attributes = new HashMap<>(attributes != null ? attributes : Map.of());
        this.attributes.put("email", user.getEmail());
        this.attributes.put("provider", user.getProvider());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authDto == null || authDto.getAuthList() == null || authDto.getAuthList().isEmpty()) {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authDto.getAuthList().stream()
                .filter(a -> a.getAuth() != null && !a.getAuth().isBlank())
                .map(a -> new SimpleGrantedAuthority(a.getAuth()))
                .collect(Collectors.toList());
    }

    @Override public String getPassword() { return user.getPassword(); }
    @Override public String getUsername() { return user.getEmail() + ":" + user.getProvider(); }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    @Override public Map<String, Object> getAttributes() { return attributes; }
    @Override public String getName() { return user.getEmail() + ":" + user.getProvider(); }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    /** 🔹 컨트롤러에서 사용하기 위한 getter 추가 */
    public AppUserDto getUser() { return this.user; }
    public String getEmail() { return user.getEmail(); }
    public String getProvider() { return user.getProvider(); }

}
