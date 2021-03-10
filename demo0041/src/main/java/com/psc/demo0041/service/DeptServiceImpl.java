package com.psc.demo0041.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psc.demo0041.db1.domain.Dept1;
import com.psc.demo0041.db1.repository.DeptRepository1;
import com.psc.demo0041.db2.repository.DeptRepository2;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptRepository1 deptRepository1;
	
	@Autowired
	DeptRepository2 deptRepository2;
	
	@Override
	@Transactional
	public void transcationXATest(){
		Dept1 dept50 = new Dept1(50, "CCCC", "CCCC");
		deptRepository1.save(dept50);
		deptRepository2.deleteAll();
	}

	@Override
	public void transcationNonXATest() {
		Dept1 dept50 = new Dept1(50, "CCCC", "CCCC");
		deptRepository1.save(dept50);
		deptRepository2.deleteAll();
	}

}
