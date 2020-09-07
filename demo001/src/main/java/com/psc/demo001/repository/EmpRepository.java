package com.psc.demo001.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psc.demo001.domain.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer>{

	@Query("SELECT E FROM Dept D INNER JOIN Emp E ON D.deptno = E.dept.deptno")
	List<Emp> findByEmp();
	
	@Query("SELECT E FROM Emp E LEFT OUTER JOIN Dept D ON D.deptno = E.dept.deptno WHERE D.deptno = :deptno")
	List<Emp> findByEmpDeptDeptno(Integer deptno);
	
	@Query("SELECT E FROM Emp E LEFT OUTER JOIN Dept D ON D.deptno = E.dept.deptno WHERE D.deptno = :deptno")
	List<Emp> findByEmpDeptDeptno(Integer deptno,  Pageable pageable);
	
	Long countByDeptDeptno(Integer deptno);
	
	@Query("DELETE FROM Emp WHERE deptno = :deptno")
	Long deleteByDeptDeptno(Integer deptno);
	
	Long deleteByEmpno(Integer empno);
	
	
}
