package com.psc.demo001.repository;

import com.psc.demo001.domain.Dept;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepository extends CrudRepository<Dept, Integer>{

}
