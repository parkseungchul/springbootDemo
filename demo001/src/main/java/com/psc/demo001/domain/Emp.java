package com.psc.demo001.domain;

import java.sql.Timestamp;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "dept")
@Entity
@Table(name="tbl_emp")
public class Emp {
	

	public Emp() {}
	public Emp(Integer empno, String ename, String job, Integer mgr, Timestamp hiredate, Integer sal, Integer comm, Integer deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		this.dept = dept;
		
		
	}
	
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
    private Timestamp hiredate;
	private Integer sal;
	private Integer comm;
	
    @ManyToOne
    @JoinColumn(name="deptno", nullable=false)
    private Dept dept;
	
	
	

}
