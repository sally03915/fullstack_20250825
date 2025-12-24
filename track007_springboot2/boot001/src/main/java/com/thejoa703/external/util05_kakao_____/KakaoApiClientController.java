package com.thejoa703.external.util05_kakao_____;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoApiClientController {

    private final KakaoApiClient kakaoApiClient = new KakaoApiClient();

    // 친구 목록을 뷰로 전달
    @GetMapping("/kakao/friends")
    public String getFriends(@RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient,
                             Model model) {
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        String friendsJson = kakaoApiClient.getFriends(accessToken);

        model.addAttribute("friends", friendsJson); // 뷰에서 JSON 그대로 출력하거나 파싱해서 사용
        return "external/kakaofriend"; // friends.html (Thymeleaf 등) 뷰로 이동
    }

    // 특정 친구에게 메시지 보내기
    @GetMapping("/kakao/send")
    public String sendMessage(@RegisteredOAuth2AuthorizedClient("kakao") OAuth2AuthorizedClient authorizedClient,
                              @RequestParam String uuid,
                              Model model) {
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        String response = kakaoApiClient.sendMessage(accessToken, uuid);

        model.addAttribute("result", response);
        return "external/kakaofriendresult";
    }
}
