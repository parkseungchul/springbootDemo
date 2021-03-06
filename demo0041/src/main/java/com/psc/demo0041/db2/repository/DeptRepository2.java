package com.psc.demo0041.db2.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.psc.demo0041.db1.domain.Dept1;
import com.psc.demo0041.db2.domain.Dept2;

public interface DeptRepository2 extends CrudRepository<Dept2, Integer>{
	
	/**
	 * dname 포함 검색 
	 * @param dname
	 * @return
	 */
	List<Dept1> findByDnameContaining(String dname);
	
	/**
	 * dname 포함 검색, 내림차순
	 * @param dname
	 * @return
	 */
	List<Dept1> findByDnameContainingOrderByDnameAsc(String dname);
	
	/**
	 * dname 포함 검색 갯수
	 * @param dname
	 * @return
	 */
	Long countByDnameContaining(String dname);
	
	/**
	 * dname 포함 검색, 페이징
	 * @param dname
	 * @param pageable
	 * @return
	 */
	List<Dept1> findByDnameContaining(String dname, Pageable pageable);
	
	
	

}
