package com.psc.demo001.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.psc.demo001.domain.Dept;

public interface DeptRepository extends CrudRepository<Dept, Integer>{
	
	/**
	 * dname 포함 검색 
	 * @param dname
	 * @return
	 */
	List<Dept> findByDnameContaining(String dname);
	
	/**
	 * dname 포함 검색, 내림차순
	 * @param dname
	 * @return
	 */
	List<Dept> findByDnameContainingOrderByDnameAsc(String dname);
	
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
	List<Dept> findByDnameContaining(String dname, Pageable pageable);
	
	
	

}
