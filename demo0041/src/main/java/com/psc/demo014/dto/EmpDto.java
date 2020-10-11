package com.psc.demo014.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpDto {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
    private Date hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
	
	public EmpDto(Integer empno, String ename, String job, Integer mgr, Date hiredate, Integer sal, Integer comm, Integer deptno) {

		this.empno = empno;
		this.ename = ename;
		this.job   = job;
		this.mgr   = mgr;
		this.hiredate = hiredate;
		this.sal      = sal;
		this.comm     = comm;
		this.deptno   = deptno;




	}

}
