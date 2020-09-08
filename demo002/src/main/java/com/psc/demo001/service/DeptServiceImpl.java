package com.psc.demo001.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.psc.demo001.dto.DeptDto;

@Service
public class DeptServiceImpl implements DeptService{

	@Override
	public List<DeptDto> listDept() {
		List<DeptDto> deptDtoList = new ArrayList<DeptDto>();
		for(int i = 10; i< 20; i++) {
			DeptDto deptDto = new DeptDto(i, String.valueOf(i), String.valueOf(i));
			deptDtoList.add(deptDto);
		}
		return deptDtoList;
	}

}
