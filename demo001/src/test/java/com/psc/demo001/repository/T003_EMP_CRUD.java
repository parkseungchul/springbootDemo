package com.psc.demo001.repository;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Transactional;

import com.psc.demo001.domain.DeptRepository;
import com.psc.demo001.domain.EmpRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class T003_EMP_CRUD {
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Autowired
	private EmpRepository empRepository;
	
	@Test
	@Transactional
	public void EMP_테스트_데이터_삽입() {
		Dept dept90 = new Dept();
		dept90.setDeptno(90);
		deptRepository.save(dept90);
		List<Emp> empList = new ArrayList<Emp>();
		for(int i = 9001; i< 10000; i++ ) {
			Emp emp = new Emp();
			emp.setEmpno(i);
			emp.setEname(String.valueOf(i));
			emp.setDept(dept90);
			empList.add(emp);
		}
		empRepository.saveAll(empList);
	}

	@Test
	public void EMP001_조인정보_가져오기() {
		empRepository.findByEmp().forEach(emp -> {
			log.debug(emp.toString() + emp.getDept().toString());
		});
	}
	
	@Test
	public void EMP002_조인정보_검색_가져오기(){
		empRepository.findByEmpDeptDeptno(10).forEach(emp -> {
			log.debug(emp.toString() + emp.getDept().toString());
		});
	}
	
	@Test
	public void EMP003_조인정보_검색_페이징() {
		//EMP_테스트_데이터_삽입();
		Long totCnt = empRepository.countByDeptDeptno(90);	
		log.debug(String.valueOf(totCnt));
		
		if (totCnt == 0) {
			return; 
		}
		int pageSize = 10;
		int pageCnt = (int) (totCnt/pageSize);
		for (int i=0; i< pageCnt + 1; i++) {
			log.debug("==========[" + (i+1) + "] Page ==========");
			Pageable pageable = PageRequest.of(i, pageSize, Sort.Direction.DESC, "empno");
			
			empRepository.findByEmpDeptDeptno(90, pageable).forEach(emp ->{
				log.debug(emp.toString() );
			});
		}
	}
	
	@Test
	public void EMP004_조인정보_검색_페이징_커스텀_리턴() {
		//EMP_테스트_데이터_삽입();
		Long totCnt = empRepository.countByDeptDeptno(90);	
		log.debug(String.valueOf(totCnt));
		
		if (totCnt == 0) {
			return; 
		}
		int pageSize = 10;
		int pageCnt = (int) (totCnt/pageSize);
		for (int i=0; i< pageCnt + 1; i++) {
			log.debug("==========[" + (i+1) + "] Page ==========");
			Pageable pageable = PageRequest.of(i, pageSize, Sort.Direction.DESC, "empno");
			
			empRepository.findByEmpDeptDeptno2(90, pageable).forEach(empDto ->{
				log.debug(empDto.toString() );
			});
		}
	}
	
	@Test
	public void EMP005_사원정보_검색() {
		empRepository.findByEnameContaining("90").forEach(emp -> {
			log.debug(emp.toString());
		});
		
	}
		
	@Test
	public void EMP006_사원정보_검색_페이징() {
		Long totCnt = empRepository.countByEnameContaining("90");
		log.debug(String.valueOf(totCnt));
		if (totCnt == 0) {
			return; 
		}
		int pageSize = 10;
		int pageCnt = (int) (totCnt/pageSize);
		for (int i=0; i< pageCnt + 1; i++) {
			log.debug("==========[" + (i+1) + "] Page ==========");
			Pageable pageable = PageRequest.of(i, pageSize, Sort.Direction.DESC, "empno");
			
			empRepository.findByEnameContaining("90", pageable).forEach(emp ->{
				log.debug(emp.toString() );
			});
		}
	}
}
