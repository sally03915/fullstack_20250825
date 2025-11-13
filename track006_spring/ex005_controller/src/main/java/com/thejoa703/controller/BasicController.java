package com.thejoa703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

	@RequestMapping("/basic.do")
	public String home(Model model) {
		model.addAttribute("result" , "sally");
		return "result.jsp";
	}
}
