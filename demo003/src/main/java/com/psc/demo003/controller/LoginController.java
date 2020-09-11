package com.psc.demo003.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.psc.demo003.domain.Member;
import com.psc.demo003.domain.SecurityUser;
import com.psc.demo003.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/login")
	public void login() {
	}
	
	@GetMapping("/main")
	public String main(Authentication authentication, ModelMap modelMap) {

		SecurityUser user = (SecurityUser) authentication.getPrincipal();
		
		log.debug("========= ========= =========");
		log.debug(user.toString());
		log.debug("========= ========= =========");
		
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("data", "main");
		
		return "main";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied(ModelMap modelMap) {
		modelMap.addAttribute("data", "accessDenied");
		return "accessDenied";
	}
	

}
