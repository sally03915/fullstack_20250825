package com.thejoa703.external.util12_map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/map")
public class KakaoMapController {

    private final KakaoMap kakaoMapService;

    public KakaoMapController(KakaoMap kakaoMapService) {
        this.kakaoMapService = kakaoMapService;
    }

    // REST API 엔드포인트 (주소 → 좌표 변환)
    @ResponseBody
    @GetMapping("/geo")
    public String getGeo(@RequestParam String address) {
        return kakaoMapService.getGeoByAddress(address);
    }
    
    // 타임리프 페이지 연결
    @GetMapping("/viewjs")
    public String viewjs() {
        return "external/kakaoMapJs"; // templates/map.html 렌더링
    }
    
    // 타임리프 페이지 연결
    @GetMapping("/viewjs2")
    public String view0() {
        return "external/kakaoMapJs_naver"; // templates/map.html 렌더링
    }
}
