package com.thejoa703.external.util08_coolsms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

 
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class SmsController {
	
    @Autowired  SmsService  mobile;
    
	@GetMapping("/api/coolsms")
	public String coolsms() {
		return "external/coolsms";
	}
    
    @GetMapping("/api/coolsmsapi")
    public @ResponseBody
    String sendSMS(@RequestParam  String to) throws CoolsmsException {
    	return  mobile.phoneNumberCheck(to);  
    }
    
}
