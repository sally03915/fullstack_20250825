package com.thejoa703.external.util05_kakao_____;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KaKaoLoginController {
	@Autowired   KaKaoLogin api;
	
	@GetMapping("/kakaologin")
	public String login(Model model) { 
		model.addAttribute("url" , api.step1());
		return "login";
	}
	// localhot:8080/kakao
	@GetMapping("/kakao")
	public String  loginuser(@RequestParam("code") String code, Model model) {
		List<String>  infos = api.step2(code);
		model.addAttribute("nickname"  , infos.get(0));  
		model.addAttribute("profile_image"  , infos.get(1));  
		model.addAttribute("logout"  , api.step4());  
		return "login_result";  // view
	}

	@GetMapping("/kakaologout")
	public String kakaologout(Model model) { 
		model.addAttribute("url" , api.step1());
		return "login";
	}
	
}
