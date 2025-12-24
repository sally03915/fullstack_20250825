package com.thejoa703.security;

import com.thejoa703.entity.AppUser;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class OAuth2RedirectResolver {
    public String resolveAfterLogin(HttpServletRequest request, AppUser user) {
        // 예: 쿠키/세션/파라미터에서 redirectUrl 읽기
        String redirect = request.getParameter("redirect");
        return (redirect != null && !redirect.isBlank()) ? redirect : "/users/mypage";
    }
}
