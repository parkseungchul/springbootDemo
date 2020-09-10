package com.psc.demo003.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	
	@GetMapping("/")
	public String index(ModelMap modelMap){
		modelMap.addAttribute("data", "index");
		return "index";
	}
	
	@GetMapping("/member")
	public String member(ModelMap modelMap){
		modelMap.addAttribute("data", "member");
		return "member";
	}
	
	@GetMapping("/manager")
	public String manager(ModelMap modelMap) {
		modelMap.addAttribute("data", "manager");
		return "manager";
	}
	
	@GetMapping("/admin")
	public String admin(ModelMap modelMap) {
		modelMap.addAttribute("data", "admin");
		return "admin";
	}
	
	
}
