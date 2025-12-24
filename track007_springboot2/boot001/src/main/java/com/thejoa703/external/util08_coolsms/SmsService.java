package com.thejoa703.external.util08_coolsms;

import java.util.*;
import org.springframework.stereotype.Component; 
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;  

@Component
public class SmsService {

	public String phoneNumberCheck(String to) throws CoolsmsException {
		 String result = "";
		 String api_key = "NCSYWPXZC1PAQQ2V";
		 String api_secret = "XE7HXBTAUK66VPAXHSQV7WEXG8NDCHAZ";
		  
		 Random  rand = new Random();
		 for(int i=0; i<6; i++) {  result += Integer.toString(rand.nextInt(10));   }
		 
		 Message message = new Message(api_key, api_secret);
		 HashMap<String, String> params = new HashMap<String, String>();
		 
		 params.put("to"  ,  to );           // 수신전화번호 - ajax로 view화면에서 받아온값
	     params.put("from",  to );  // 발신전화번화 - 02,031,,,회사번호  / 테스트 - 발신, 수신
	     params.put("type", "SMS");
	     params.put("text",  "인증번호 [ " + result + "] 입니다.");
		 
	     message.send(params);
		 return result;
	}
}
