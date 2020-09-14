package com.psc.demo001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

	
	@RequestMapping("/")
	public String List() {
		
		return "index";
	}
}
