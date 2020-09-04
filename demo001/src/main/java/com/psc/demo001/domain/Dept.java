package com.psc.demo001.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_dept")
public class Dept {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;
}
