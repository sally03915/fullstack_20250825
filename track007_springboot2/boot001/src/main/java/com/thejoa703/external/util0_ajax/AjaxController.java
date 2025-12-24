package com.thejoa703.external.util0_ajax;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {


	@GetMapping("/ajax/csv")
	public String ajax000_csv() { return "external/ajax000_csv";}   
	

	@GetMapping("/ajax/xml")
	public String ajax001_xml() { return "external/ajax001_xml";}   
	

	@GetMapping("/ajax/json")
	public String ajax002_json() { return "external/ajax002_json";}   
}