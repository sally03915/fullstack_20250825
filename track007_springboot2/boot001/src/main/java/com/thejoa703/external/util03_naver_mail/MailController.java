package com.thejoa703.external.util03_naver_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {

	@Autowired  NaverMail  api;
	
	@GetMapping("/api/mail")  
	public String mail() {  return  "external/mail"; }

	@PostMapping("/api/mail")  
	public String mail_send(String subject, String content) {   
		api.sendMail(subject, content);  
		return  "external/mail_result"; 
	}
	
}
