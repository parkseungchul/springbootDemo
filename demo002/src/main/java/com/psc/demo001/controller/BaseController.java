package com.psc.demo001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psc.demo001.dto.DeptDto;
import com.psc.demo001.service.DeptService;

@Controller
public class BaseController {

	@Autowired
	DeptService deptService;
	
	@RequestMapping("/")
	public String singleUI() {
		
		return "/UI/single";
	}
	
	@RequestMapping("/multiple")
	public String multipleUI() {
		
		return "/UI/multiple";
	}
	
	@RequestMapping("/list")
	public String list(ModelMap modelMap){
		modelMap.addAttribute("deptDtos", deptService.listDept());
		return "/UI/list";
	}
}
