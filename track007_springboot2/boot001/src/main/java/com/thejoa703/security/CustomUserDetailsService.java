package com.thejoa703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
        // username은 "email:provider" 형태로 들어온다고 가정
        String[] parts = username.split(":");
        String email = parts[0];
        String provider = parts.length > 1 ? parts[1] : "local";

        AppUserDto param = new AppUserDto();
        param.setEmail(email);
        param.setProvider(provider);

        AppUserAuthDto authDto = userDao.readAuthByEmail(param);
        if (authDto == null) { throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username); }
        
        AppUserDto                 user = userDao.findByEmail(param);
        if (user == null) { throw new UsernameNotFoundException("사용자 기본정보를 찾을 수 없습니다: " + username); }

        return new CustomUserDetails(user, authDto);
    }
}
