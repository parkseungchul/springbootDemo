package com.psc.demo001.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.psc.demo001.domain.Dept;
import com.psc.demo001.domain.Emp;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class T001_DEPT_EMP_기본_데이터 {
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	DeptRepository deptRepository;
	

    @Test
    @Transactional
    public void A001_EMP_DEPT_전체삭제() {
    	empRepository.deleteAll();
    	deptRepository.deleteAll();
    }
	
	
	@Test
	@Transactional
	public void A002_DEPT_EPM_전체삽입(){

		List<Dept> deptList = new ArrayList<Dept>();
		Dept dept10 = new Dept(10, "ACCOUNTING", "NEW YORK"); deptList.add(dept10);
		Dept dept15 = new Dept(15, "TEST", "TEST"  ); deptList.add(dept15);
		Dept dept20 = new Dept(20, "RESEARCH"  , "DALLAS"  ); deptList.add(dept20);
		Dept dept30 = new Dept(30, "SALES"     , "CHICAGO" ); deptList.add(dept30);
		Dept dept40 = new Dept(40, "OPERATIONS", "BOSTON"  ); deptList.add(dept40);

		deptRepository.saveAll(deptList);

	
		List<Emp> empList = new ArrayList<Emp>();
		Emp emp;
		emp = new Emp(7839, "KING"  , "PRESIDENT", null, getTimestamp("1981-11-17 00:00:00.000"), 5000, null, 10); empList.add(emp);
		emp = new Emp(7698, "BLAKE" , "MANAGER"  , 7839, getTimestamp("1981-01-05 00:00:00.000"), 2850, null, 30); empList.add(emp);
		emp = new Emp(7782, "CLARK" , "MANAGER"  , 7839, getTimestamp("1981-09-06 00:00:00.000"), 2450, null, 10); empList.add(emp);
		emp = new Emp(7566, "JONES" , "MANAGER"  , 7839, getTimestamp("1981-02-04 00:00:00.000"), 2975, null, 20); empList.add(emp);
		emp = new Emp(7788, "SCOTT" , "ANALYST"  , 7566, getTimestamp("1987-07-13 00:00:00.000"), 3000, null, 20); empList.add(emp);
		emp = new Emp(7902, "FORD"  , "ANALYST"  , 7566, getTimestamp("1981-03-12 00:00:00.000"), 3000, null, 20); empList.add(emp);
		emp = new Emp(7369, "SMITH" , "CLERK"    , 7566, getTimestamp("1980-12-17 00:00:00.000"),  800, null, 20); empList.add(emp);
		emp = new Emp(7499, "ALLEN" , "SALESMAN" , 7698, getTimestamp("1981-02-20 00:00:00.000"), 1600,  300, 30); empList.add(emp);
		emp = new Emp(7521, "WARD"  , "SALESMAN" , 7698, getTimestamp("1981-02-22 00:00:00.000"), 1250,  500, 30); empList.add(emp);
		emp = new Emp(7654, "MARTIN", "SALESMAN" , 7698, getTimestamp("1981-09-28 00:00:00.000"), 1250, 1400, 30); empList.add(emp);
		emp = new Emp(7844, "TURNER", "SALESMAN" , 7698, getTimestamp("1981-09-08 00:00:00.000"), 1500,    0, 30); empList.add(emp);
		emp = new Emp(7876, "ADAMS" , "CLERK"    , 7698, getTimestamp("1971-07-13 00:00:00.000"), 1100, null, 20); empList.add(emp);
		emp = new Emp(7900, "JAMES" , "CLERK"    , 7698, getTimestamp("1981-03-12 00:00:00.000"),  950, null, 30); empList.add(emp);
		emp = new Emp(7934, "MILLER", "CLERK"    , 7782, getTimestamp("1982-01-23 00:00:00.000"), 1300, null, 10); empList.add(emp);
		empRepository.saveAll(empList);

	}
	
	
	
	public Timestamp getTimestamp(String timeStamp){
		LocalDateTime localDateTime = LocalDateTime.parse(timeStamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));  
		return Timestamp.valueOf(localDateTime);
	}
}
