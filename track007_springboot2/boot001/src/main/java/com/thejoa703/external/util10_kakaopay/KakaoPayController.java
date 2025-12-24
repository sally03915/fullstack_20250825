package com.thejoa703.external.util10_kakaopay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KakaoPayController {

    @Autowired
    private KakaoPayService kakaoPayService;
    
    @GetMapping("/pay/kakao")
    public String kakao() {
        return "external/kakaoPay";
    }
    
    @PostMapping("/pay/ready")
    public String kakaoPayReady() {
        Map<String, String> result = kakaoPayService.kakaoPayReady();
        return "redirect:" + result.get("redirectUrl");
    }


    // 결제 성공 시 카카오페이가 redirect 해주는 URL
    @GetMapping("/pay/success")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pgToken, Model model) {
        Map<String, Object> result = kakaoPayService.kakaoPayApprove(pgToken);
        model.addAttribute("result", result);
        return "external/kakaoPaySuccess"; // Thymeleaf, JSP 등 뷰 파일
    }

    @GetMapping("/pay/fail")
    @ResponseBody
    public String kakaoPayFail() {
        return "결제 실패";
    }

    @GetMapping("/pay/cancel")
    @ResponseBody
    public String kakaoPayCancel() {
        return "결제 취소";
    }
}

/////////////////////// 크롬에서 작성할것.