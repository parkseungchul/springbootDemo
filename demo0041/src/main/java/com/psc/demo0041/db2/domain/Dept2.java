package com.psc.demo0041.db2.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "empList")
@Entity
@Table(name="tbl_dept")
public class Dept2 {
	
	public Dept2() {}
	public Dept2(Integer deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	@Id
	private Integer deptno;
	private String dname;
	private String loc;

    @OneToMany(mappedBy = "dept", cascade  = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Emp2> empList;
}
