package com.psc.demo001.service;

import java.util.List;

import com.psc.demo001.dto.DeptDto;

public interface DeptService {

	public List<DeptDto> listDept();
	
	public DeptDto selectDeptDto(int deptno);
}
