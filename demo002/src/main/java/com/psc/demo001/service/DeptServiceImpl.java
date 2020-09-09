package com.psc.demo001.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.psc.demo001.dto.DeptDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService{

	private List<DeptDto> deptDtoList;
	
	/**
	 * 테스트를 위한 데이터 셋 생성
	 */
	@PostConstruct
	public void init() {
		
		deptDtoList = new ArrayList<DeptDto>();
		for(int i = 10; i< 1000; i++) {
			DeptDto deptDto = new DeptDto(i,  String.valueOf(i), String.valueOf(i));
			deptDtoList.add(deptDto);
		}
		this.deptDtoList = deptDtoList;
	}
	
	@Override
	public List<DeptDto> listDept() {
		return deptDtoList;
	}

	@Override
	public DeptDto selectDeptDto(int deptno) {
		for(DeptDto deptDto: deptDtoList) {
			int searchDeptno = deptDto.getDeptno();
			if (searchDeptno == deptno) {
				return deptDto;
			}
		}
		return null;
	}

}
