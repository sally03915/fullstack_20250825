package com.thejoa703.external.util05_kakao_____;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class KakaoApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    // 친구 목록 조회
    public String getFriends(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<Void> request = new HttpEntity<>(headers);
        return restTemplate.exchange(
        	    "https://kapi.kakao.com/v1/api/talk/friends",
        	    HttpMethod.GET,
        	    request,
        	    String.class
        	).getBody();
    }

    // 친구에게 메시지 보내기
    public String sendMessage(String accessToken, String uuid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        Map<String, Object> templateObject = Map.of(
            "object_type", "text",
            "text", "안녕하세요! 카카오 메시지 테스트입니다.",
            "link", Map.of(
                "web_url", "https://developers.kakao.com",
                "mobile_web_url", "https://developers.kakao.com"
            ),
            "button_title", "바로가기"
        );

        Map<String, Object> body = Map.of(
            "receiver_uuids", List.of(uuid),
            "template_object", templateObject
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        return restTemplate.postForObject(
                "https://kapi.kakao.com/v1/api/talk/friends/message/default/send",
                request,
                String.class
        );
    }
}
