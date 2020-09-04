package com.psc.demo001.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptTest {

	@Autowired
	DeptRepository deptRepository;
	
	public void 부서_정보_단건_조회(Integer deptno) {
		Optional<Dept> depts = deptRepository.findById(10);
		
		if (depts.isPresent()) {
			log.info(depts.get().toString());
		}else {
			log.debug("Data not found! deptno: " + deptno);
		}
	}
	
	@Test
	public void A001_부서_정보_단건_삽입() {
		Dept dept = new Dept();
		dept.setDeptno(10);
		dept.setLoc("서울");
		dept.setDname("HR");
		deptRepository.save(dept);
		부서_정보_단건_조회(10);
	}

	@Test
	public void A002_부서_정보_단건_수정() {
		Dept dept = new Dept();
		dept.setDeptno(10);
		dept.setLoc("서울");
		dept.setDname("SAL");
		deptRepository.save(dept);
		부서_정보_단건_조회(10);
	}
	
	@Test
	public void A003_부서_정보_단건_삭제(){
		Dept dept = new Dept();
		dept.setDeptno(10);
		deptRepository.delete(dept);
		부서_정보_단건_조회(10);
	}
	
	@Test
	public void A004_부서_정보_다건_삽입() {
		List<Dept> deptList = new ArrayList<Dept>(); 
		for(int i = 1000; i <2001; i++) {
			Dept dept = new Dept();
			dept.setDeptno(i);
			dept.setDname(String.valueOf(i));
			dept.setLoc(String.valueOf(i));
			deptList.add(dept);
		}
		deptRepository.saveAll(deptList);
	}
	
	@Test
	public void A005_부서명칭_검색() {
		deptRepository.findByDnameContaining("00").forEach(dept -> {
			log.debug(dept.toString());
		});
	}
	
	@Test
	public void A006_부서명칭_검색_단순_페이징() {
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "dname");
		deptRepository.findByDnameContaining("00", pageable).forEach(dept -> {
			log.debug(dept.toString());
		});
	}
	
	
	@Test
	public void A007_부서_정보_다건_삭제() {
		deptRepository.deleteAll();
	}
	
	
	
}
