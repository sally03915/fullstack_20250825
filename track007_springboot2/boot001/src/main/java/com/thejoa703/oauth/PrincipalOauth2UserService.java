package com.thejoa703.oauth;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.external.util05_kakao_____.KakaoApiClient;
import com.thejoa703.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired  AppUserDao dao;
    @Autowired  PasswordEncoder passwordEncoder; // 추가

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String provider = userRequest.getClientRegistration().getRegistrationId();

        UserInfoOAuth2 info;
        String accessToken;
        if ("google".equals(provider)) {
            info = new UserInfoGoogle(oAuth2User.getAttributes());
        } else if ("kakao".equals(provider)) {
            info = new UserInfoKakao(oAuth2User.getAttributes()); 
            accessToken = userRequest.getAccessToken().getTokenValue();   //## accessToken 작성
        } else if ("naver".equals(provider)) {
            info = new UserInfoNaver(oAuth2User.getAttributes());
        } else {
            throw new OAuth2AuthenticationException("지원하지 않는 OAuth2 provider: " + provider);
        }

        String email = info.getEmail();
        String nickname = info.getNickname();
        String providerId = info.getProviderId();

        AppUserDto userParam = new AppUserDto();
        userParam.setEmail(email);
        userParam.setProvider(provider);
        AppUserDto user = dao.findByEmail(userParam);

        if (user == null) {
            user = new AppUserDto();
            user.setEmail(email);
            user.setNickname(nickname != null && !nickname.isBlank() ? nickname : "사용자");
            user.setProvider(provider);
            user.setProviderId(providerId);
            user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString())); // 인코딩 적용
            user.setMbtiTypeId(0);

            dao.insertAppUser(user);

            AuthDto auth = new AuthDto();
            auth.setEmail(user.getEmail());
            auth.setAuth("ROLE_USER");
            dao.insertAuth(auth);

            log.info("신규 소셜 사용자 가입: email={}, provider={}", email, provider);
        } else {
            if (nickname != null && !nickname.isBlank()) {
                user.setNickname(nickname);
                dao.updateAppUser(user);
                log.info("소셜 사용자 닉네임 업데이트: email={}, provider={}, nickname={}", email, provider, nickname);
            }
        }

        AppUserAuthDto authDto = dao.readAuthByEmail(userParam);
        CustomUserDetails customUserDetails = new CustomUserDetails(user, authDto);

        Map<String, Object> attrs = new HashMap<>(oAuth2User.getAttributes());
        attrs.put("provider", provider);
        attrs.put("email", email);
        attrs.put("nickname", nickname);
        customUserDetails.setAttributes(attrs);

        return customUserDetails;
    }
}
