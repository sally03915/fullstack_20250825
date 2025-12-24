package com.thejoa703.oauth;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.thejoa703.entity.AppUser;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class Oauth2IUserService extends DefaultOAuth2UserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String provider = userRequest.getClientRegistration().getRegistrationId();

        UserInfoOAuth2 info;
        if ("google".equals(provider)) {
            info = new UserInfoGoogle(oAuth2User.getAttributes());
        } else if ("kakao".equals(provider)) {
            info = new UserInfoKakao(oAuth2User.getAttributes());
        } else if ("naver".equals(provider)) {
            info = new UserInfoNaver(oAuth2User.getAttributes());
        } else {
            throw new OAuth2AuthenticationException("지원하지 않는 OAuth2 provider : " + provider);
        }

        String email = info.getEmail();
        String nickname = info.getNickname();
        String providerId = info.getProviderId();

        // 🔹 JPA 기반 조회
        AppUser user = appUserRepository.findByEmailAndProvider(email, provider)
                .orElseGet(() -> {
                    AppUser newUser = new AppUser();
                    newUser.setEmail(email);
                    newUser.setNickname(nickname != null ? nickname : "사용자");
                    newUser.setProvider(provider);
                    newUser.setProviderId(providerId);
                    newUser.setPassword(passwordEncoder.encode(UUID.randomUUID().toString())); // 랜덤 패스워드
                    return appUserRepository.save(newUser);
                });

        // 닉네임 업데이트
        if (nickname != null && !nickname.isBlank() && !nickname.equals(user.getNickname())) {
            user.setNickname(nickname);
            appUserRepository.save(user);
        }

        Map<String, Object> attrs = new HashMap<>(oAuth2User.getAttributes());
        attrs.put("provider", provider);
        attrs.put("email", email);
        attrs.put("nickname", nickname);

        return new CustomUserDetails(user, attrs);
    }
}
