package com.compnay.boot002.basic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Basic001_Controller {

	  //@GetMapping("/basic1")
	  @RequestMapping("/basic1")
	  @ResponseBody
	  public String basic1() {  return "basic1"; }
	  // 테스트 :      localhost:8181/boot2/basic1


	  @RequestMapping("/basic2")
	  public String basic2(Model model) {
		  model.addAttribute("greeting" , "Hello");
		  return "basic2";
	  }  // 테스트 :      localhost:8181/boot2/basic2
}





