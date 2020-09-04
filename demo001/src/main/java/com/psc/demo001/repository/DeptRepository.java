package com.psc.demo001.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.psc.demo001.domain.Dept;

public interface DeptRepository extends CrudRepository<Dept, Integer>{
	
	List<Dept> findByDnameContaining(String dname);
	
	List<Dept> findByDnameContaining(String dname, Pageable pageable);
	

}
