package com.psc.demo0041.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.psc.demo0041.db1.domain.Dept1;
import com.psc.demo0041.db1.domain.Emp1;
import com.psc.demo0041.db1.repository.DeptRepository1;
import com.psc.demo0041.db1.repository.EmpRepository1;
import com.psc.demo0041.db2.domain.Dept2;
import com.psc.demo0041.db2.domain.Emp2;
import com.psc.demo0041.db2.repository.DeptRepository2;
import com.psc.demo0041.db2.repository.EmpRepository2;
import com.psc.demo0041.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class T001_DEPT_EMP_트랜잭션_테스트 {
	
	@Autowired
	EmpRepository1 empRepository1;
	
	@Autowired
	DeptRepository1 deptRepository1;
	
	@Autowired
	EmpRepository2 empRepository2;
	
	@Autowired
	DeptRepository2 deptRepository2;
	
	
	@Autowired
	DeptService deptService;
	
	@Before
	@Transactional
	public void deleteDept50() {
		
		A001_DB1_DEPT_EPM_전체삽입();
		B001_DB2_DEPT_EPM_전체삽입();
		
		if(deptRepository1.findById(50).isPresent()) {
			deptRepository1.deleteById(50);
		}
	}

    @Test
	@Transactional
	public void A001_DB1_DEPT_EPM_전체삽입(){

		List<Dept1> deptList = new ArrayList<Dept1>();
		Dept1 dept10 = new Dept1(10, "ACCOUNTING", "NEW YORK"); deptList.add(dept10);
		Dept1 dept15 = new Dept1(15, "TEST", "TEST"  ); deptList.add(dept15);
		Dept1 dept20 = new Dept1(20, "RESEARCH"  , "DALLAS"  ); deptList.add(dept20);
		Dept1 dept30 = new Dept1(30, "SALES"     , "CHICAGO" ); deptList.add(dept30);
		Dept1 dept40 = new Dept1(40, "OPERATIONS", "BOSTON"  ); deptList.add(dept40);

		deptRepository1.saveAll(deptList);

	
		List<Emp1> empList = new ArrayList<Emp1>();
		Emp1 emp;
		emp = new Emp1(7839, "KING"  , "PRESIDENT", null, getTimestamp("1981-11-17 00:00:00.000"), 5000, null, 10); empList.add(emp);
		emp = new Emp1(7698, "BLAKE" , "MANAGER"  , 7839, getTimestamp("1981-01-05 00:00:00.000"), 2850, null, 30); empList.add(emp);
		emp = new Emp1(7782, "CLARK" , "MANAGER"  , 7839, getTimestamp("1981-09-06 00:00:00.000"), 2450, null, 10); empList.add(emp);
		emp = new Emp1(7566, "JONES" , "MANAGER"  , 7839, getTimestamp("1981-02-04 00:00:00.000"), 2975, null, 20); empList.add(emp);
		emp = new Emp1(7788, "SCOTT" , "ANALYST"  , 7566, getTimestamp("1987-07-13 00:00:00.000"), 3000, null, 20); empList.add(emp);
		emp = new Emp1(7902, "FORD"  , "ANALYST"  , 7566, getTimestamp("1981-03-12 00:00:00.000"), 3000, null, 20); empList.add(emp);
		emp = new Emp1(7369, "SMITH" , "CLERK"    , 7566, getTimestamp("1980-12-17 00:00:00.000"),  800, null, 20); empList.add(emp);
		emp = new Emp1(7499, "ALLEN" , "SALESMAN" , 7698, getTimestamp("1981-02-20 00:00:00.000"), 1600,  300, 30); empList.add(emp);
		emp = new Emp1(7521, "WARD"  , "SALESMAN" , 7698, getTimestamp("1981-02-22 00:00:00.000"), 1250,  500, 30); empList.add(emp);
		emp = new Emp1(7654, "MARTIN", "SALESMAN" , 7698, getTimestamp("1981-09-28 00:00:00.000"), 1250, 1400, 30); empList.add(emp);
		emp = new Emp1(7844, "TURNER", "SALESMAN" , 7698, getTimestamp("1981-09-08 00:00:00.000"), 1500,    0, 30); empList.add(emp);
		emp = new Emp1(7876, "ADAMS" , "CLERK"    , 7698, getTimestamp("1971-07-13 00:00:00.000"), 1100, null, 20); empList.add(emp);
		emp = new Emp1(7900, "JAMES" , "CLERK"    , 7698, getTimestamp("1981-03-12 00:00:00.000"),  950, null, 30); empList.add(emp);
		emp = new Emp1(7934, "MILLER", "CLERK"    , 7782, getTimestamp("1982-01-23 00:00:00.000"), 1300, null, 10); empList.add(emp);
		empRepository1.saveAll(empList);

	}
    
    @Test
	@Transactional
    public void A002_DB1_EMP_DEPT_전체삭제() {
    	empRepository1.deleteAll();
    	deptRepository1.deleteAll();
    }
    
	@Test
	@Transactional
	public void B001_DB2_DEPT_EPM_전체삽입(){

		List<Dept2> deptList = new ArrayList<Dept2>();
		Dept2 dept10 = new Dept2(10, "ACCOUNTING", "NEW YORK"); deptList.add(dept10);
		Dept2 dept15 = new Dept2(15, "TEST", "TEST"  ); deptList.add(dept15);
		Dept2 dept20 = new Dept2(20, "RESEARCH"  , "DALLAS"  ); deptList.add(dept20);
		Dept2 dept30 = new Dept2(30, "SALES"     , "CHICAGO" ); deptList.add(dept30);
		Dept2 dept40 = new Dept2(40, "OPERATIONS", "BOSTON"  ); deptList.add(dept40);

		deptRepository2.saveAll(deptList);

	
		List<Emp2> empList = new ArrayList<Emp2>();
		Emp2 emp;
		emp = new Emp2(7839, "KING"  , "PRESIDENT", null, getTimestamp("1981-11-17 00:00:00.000"), 5000, null, 10); empList.add(emp);
		emp = new Emp2(7698, "BLAKE" , "MANAGER"  , 7839, getTimestamp("1981-01-05 00:00:00.000"), 2850, null, 30); empList.add(emp);
		emp = new Emp2(7782, "CLARK" , "MANAGER"  , 7839, getTimestamp("1981-09-06 00:00:00.000"), 2450, null, 10); empList.add(emp);
		emp = new Emp2(7566, "JONES" , "MANAGER"  , 7839, getTimestamp("1981-02-04 00:00:00.000"), 2975, null, 20); empList.add(emp);
		emp = new Emp2(7788, "SCOTT" , "ANALYST"  , 7566, getTimestamp("1987-07-13 00:00:00.000"), 3000, null, 20); empList.add(emp);
		emp = new Emp2(7902, "FORD"  , "ANALYST"  , 7566, getTimestamp("1981-03-12 00:00:00.000"), 3000, null, 20); empList.add(emp);
		emp = new Emp2(7369, "SMITH" , "CLERK"    , 7566, getTimestamp("1980-12-17 00:00:00.000"),  800, null, 20); empList.add(emp);
		emp = new Emp2(7499, "ALLEN" , "SALESMAN" , 7698, getTimestamp("1981-02-20 00:00:00.000"), 1600,  300, 30); empList.add(emp);
		emp = new Emp2(7521, "WARD"  , "SALESMAN" , 7698, getTimestamp("1981-02-22 00:00:00.000"), 1250,  500, 30); empList.add(emp);
		emp = new Emp2(7654, "MARTIN", "SALESMAN" , 7698, getTimestamp("1981-09-28 00:00:00.000"), 1250, 1400, 30); empList.add(emp);
		emp = new Emp2(7844, "TURNER", "SALESMAN" , 7698, getTimestamp("1981-09-08 00:00:00.000"), 1500,    0, 30); empList.add(emp);
		emp = new Emp2(7876, "ADAMS" , "CLERK"    , 7698, getTimestamp("1971-07-13 00:00:00.000"), 1100, null, 20); empList.add(emp);
		emp = new Emp2(7900, "JAMES" , "CLERK"    , 7698, getTimestamp("1981-03-12 00:00:00.000"),  950, null, 30); empList.add(emp);
		emp = new Emp2(7934, "MILLER", "CLERK"    , 7782, getTimestamp("1982-01-23 00:00:00.000"), 1300, null, 10); empList.add(emp);
		empRepository2.saveAll(empList);
	}
	
    @Test
	@Transactional
    public void B002_DB2_EMP_DEPT_전체삭제() {
    	empRepository2.deleteAll();
    	deptRepository2.deleteAll();
    }
	
	/**
	 * 데이터가 롤백이 되므로 50 인서트 되면 안됨!!
	 */
	@Test
	public void C001_트랜잰션_테스트_롤백() {
		try {
			deptService.transcationXATest();
			
		}catch(Exception e) {
			
		}
		
		Assert.assertTrue(!deptRepository1.findById(50).isPresent());
	}
	
	@Test
	public void C002_트랜잰션_테스트_롤백_안됨() {
		 try {
			 deptService.transcationNonXATest();
		 }catch(Exception e) {
			 
		 }
		 
		 Assert.assertTrue(deptRepository1.findById(50).isPresent());
	}

	
	public Timestamp getTimestamp(String timeStamp){
		LocalDateTime localDateTime = LocalDateTime.parse(timeStamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));  
		return Timestamp.valueOf(localDateTime);
	}
}
