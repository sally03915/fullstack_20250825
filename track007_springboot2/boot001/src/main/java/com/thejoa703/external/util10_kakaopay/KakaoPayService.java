package com.thejoa703.external.util10_kakaopay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoPayService {

    @Value("${kakaopay.secret-key}")
    private String secretKey;

    private String tid; // 결제 준비 시 받은 거래 ID 저장

    // 결제 준비
    public Map<String, String> kakaoPayReady() {
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + secretKey);
        headers.add("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("cid", "TC0ONETIME");
        params.put("partner_order_id", "partner_order_id");
        params.put("partner_user_id", "partner_user_id");
        params.put("item_name", "초코파이");
        params.put("quantity", 1);
        params.put("total_amount", 2200);
        params.put("vat_amount", 200);
        params.put("tax_free_amount", 0);
        params.put("approval_url", "http://localhost:8484/pay/success");
        params.put("fail_url", "http://localhost:8484/pay/fail");
        params.put("cancel_url", "http://localhost:8484/pay/cancel");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        JsonObject jsonObject = JsonParser.parseString(response.getBody()).getAsJsonObject();
        tid = jsonObject.get("tid").getAsString(); // 거래 ID 저장
        String redirectUrl = jsonObject.get("next_redirect_pc_url").getAsString();

        Map<String, String> result = new HashMap<>();
        result.put("redirectUrl", redirectUrl);
        return result;
    }

    // 결제 승인
    public Map<String, Object> kakaoPayApprove(String pgToken) {
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + secretKey);
        headers.add("Content-Type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("cid", "TC0ONETIME");
        params.put("tid", tid);
        params.put("partner_order_id", "partner_order_id");
        params.put("partner_user_id", "partner_user_id");
        params.put("pg_token", pgToken);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        JsonObject jsonObject = JsonParser.parseString(response.getBody()).getAsJsonObject();
        Map<String, Object> result = new HashMap<>();
        // aid가 있을 때만 넣기
        if (jsonObject.has("aid")) {
            result.put("aid", jsonObject.get("aid").getAsString());
        }
        // amount 객체 파싱
        if (jsonObject.has("amount")) {
            JsonObject amountObj = jsonObject.getAsJsonObject("amount");
            result.put("total", amountObj.get("total").getAsInt());
            result.put("vat", amountObj.get("vat").getAsInt());
            result.put("amount", amountObj.toString()); // 전체 문자열도 필요하면 저장
        }
 
        result.put("status", "success");
        return result;
    }
}
