package com.psc.demo001.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psc.demo001.dto.DeptDto;
import com.psc.demo001.service.DeptService;

import groovyjarjarpicocli.CommandLine.Parameters;

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
	
	@RequestMapping("/deptList")
	public String deptList(ModelMap modelMap){
		modelMap.addAttribute("deptDtos", deptService.listDept());
		return "/UI/deptList";
	}
	
	@RequestMapping("/deptList/{deptno}")
	public String dept(ModelMap modelMap, @PathVariable("deptno") int deptno){
		modelMap.addAttribute("deptDto", deptService.selectDeptDto(deptno));
		return "/UI/dept";
	}
	
	
	
}
