package com.thejoa703.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.thejoa703.entity.AppUser;

public class CustomUserDetails implements UserDetails, OAuth2User {

    private final AppUser user;
    private final Map<String, Object> attributes;

    public CustomUserDetails(AppUser user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes != null ? attributes : Map.of();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole())); // 단일 권한 필드 사용
    }

    @Override public String getPassword() { return user.getPassword(); }
    @Override public String getUsername() { return user.getEmail() + ":" + user.getProvider(); }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return !user.isDeleted(); }

    @Override public Map<String, Object> getAttributes() { return attributes; }
    @Override public String getName() { return String.valueOf(user.getId()); }

    public AppUser getUser() { return user; }
}