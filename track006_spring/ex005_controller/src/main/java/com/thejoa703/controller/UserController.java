package com.thejoa703.controller;
 
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thejoa703.dto.UserVO;
import com.thejoa703.service.UserService;

@Controller
public class UserController {
	@Autowired  UserService service;
	 
	@RequestMapping(value="/users_json" , method=RequestMethod.GET)
	public String home() { return "users_json"; }
	
	
	//@RequestMapping("/list.do")  ver-1
	@RequestMapping(  value="/list"  , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object>  getUserList() {
		Map<String, Object>  result = new HashMap<>();
		result.put("result" , Boolean.TRUE);
		result.put("data"   , service.readAll()); 
		return result;
	}
	
	//@RequestMapping("/select.do")  ver-1
	@RequestMapping( value="/select/{no}" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object>   getUser( @PathVariable  int no  ){	   //@RequestParam	
		Map<String, Object>  result = new HashMap<>();
		result.put("result" , Boolean.TRUE);
		result.put("data"   , service.read(no)); 
		return result;
		//model.addAttribute("dto" , service.read(no));    
	}
	
	//@RequestMapping("/insert.do")  ver-1 })
	@RequestMapping(value="/insertUser"  , 
					method=RequestMethod.POST , 
					headers= {"Content-type=application/json"})
	@ResponseBody
	public Map<String, Object> getInsert(@RequestBody  UserVO vo ){   
										// @ModelAttribute  UserVO  vo - 405
		if(vo  != null) { service.insert(vo); }
		Map<String, Object>  result = new HashMap<>();
		result.put("result" , Boolean.TRUE); 
		return result;
		//if(vo  != null) { service.insert(vo); } return "redirect:/list.do";
	}

	// ver-1	@RequestMapping("/update.do")
		@RequestMapping(value = "/updateUser", 
				method = RequestMethod.PUT, 
				headers = { "Content-type=application/json" })
		@ResponseBody	
		public Map<String , Object> updateUser(@RequestBody UserVO user) {
			if (user != null)	
				service.update(user);
			Map<String , Object> result = new HashMap<>();
			result.put("result", Boolean.TRUE);
			return result;
		}
		
	// ver-1	@RequestMapping("/delete.do")
		@RequestMapping(value = "/deleteUser/{no}", 
						method = RequestMethod.DELETE)
		@ResponseBody	
		public Map<String , Object> deleteUser(@PathVariable int no) {
			service.delete(no);
			Map<String , Object> result = new HashMap<>();
			result.put("result", Boolean.TRUE);
			return result;
		}
	}
 