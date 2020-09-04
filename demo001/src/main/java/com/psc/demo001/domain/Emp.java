package com.psc.demo001.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_emp")
public class Emp {
	
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	
    @CreationTimestamp
    private Timestamp hiredate;
    
	private Integer sal;
	private Integer comm;
	
    @ManyToOne
    private Dept dept;
	
	
	

}
