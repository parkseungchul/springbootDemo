package com.psc.demo001.repository;

import org.springframework.data.repository.CrudRepository;

import com.psc.demo001.domain.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer>{

}
