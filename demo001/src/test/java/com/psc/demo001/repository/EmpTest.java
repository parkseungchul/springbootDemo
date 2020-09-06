package com.psc.demo001.repository;

import org.junit.FixMethodOrder;
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
public class EmpTest {

	@Autowired
	private EmpRepository empRepository;
	

	public void EMP001_사원_단건_삽입() {
		
		Dept dept = new Dept();
		dept.setDeptno(10);

	}
}
