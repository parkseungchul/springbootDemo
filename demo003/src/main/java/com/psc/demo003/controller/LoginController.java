package com.psc.demo003.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public void login() {
	}
	
	@GetMapping("/main")
	public String main(ModelMap modelMap) {
		modelMap.addAttribute("data", "main");
		return "main";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied(ModelMap modelMap) {
		modelMap.addAttribute("data", "accessDenied");
		return "accessDenied";
	}
	

}
