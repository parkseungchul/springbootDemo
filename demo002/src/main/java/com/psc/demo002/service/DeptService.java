package com.psc.demo002.service;

import java.util.List;

import com.psc.demo002.dto.DeptDto;

public interface DeptService {

	public List<DeptDto> listDept();
	
	public DeptDto selectDeptDto(int deptno);
}
