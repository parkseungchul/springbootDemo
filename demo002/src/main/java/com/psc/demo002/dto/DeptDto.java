package com.psc.demo002.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DeptDto {
	
	public DeptDto() {
		
	}
	
	private int deptno;
	private String dname;
	private String loc;
	
	

}
