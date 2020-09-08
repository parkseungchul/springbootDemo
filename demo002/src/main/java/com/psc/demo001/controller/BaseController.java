package com.psc.demo001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	
	@RequestMapping("/")
	public String singleUI() {
		
		return "/UI/single";
	}
	
	@RequestMapping("/multiple")
	public String multipleUI() {
		
		return "/UI/multiple";
	}
}
