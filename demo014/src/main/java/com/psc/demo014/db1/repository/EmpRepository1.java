package com.psc.demo014.db1.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psc.demo014.db1.domain.Emp1;
import com.psc.demo014.dto.EmpDto;

public interface EmpRepository1 extends CrudRepository<Emp1, Integer>{

	/**
	 * EMP001_조인정보_가져오기
	 * @return
	 */
	@Query("SELECT E FROM Dept1 D INNER JOIN Emp1 E ON D.deptno = E.dept.deptno")
	List<Emp1> findByEmp();
	
	/**
	 * EMP002_조인정보_검색_가져오기
	 * @param deptno
	 * @return
	 */
	@Query("SELECT E FROM Emp1 E LEFT OUTER JOIN Dept1 D ON D.deptno = E.dept.deptno WHERE D.deptno = :deptno")
	List<Emp1> findByEmpDeptDeptno(Integer deptno);
	
	/**
	 * EMP003_조인정보_검색_페이징
	 * @param deptno
	 * @param pageable
	 * @return
	 */
	@Query("SELECT E FROM Emp1 E LEFT OUTER JOIN Dept1 D ON D.deptno = E.dept.deptno WHERE D.deptno = :deptno")
	List<Emp1> findByEmpDeptDeptno(Integer deptno,  Pageable pageable);
	
	/**
	 * EMP005_조인정보_검색_페이징_커스텀_리턴
	 * @param deptno
	 * @param pageable
	 * @return
	 */
	@Query("SELECT new com.psc.demo014.dto.EmpDto(E.empno, E.ename, E.job, E.mgr, E.hiredate, E.sal, E.comm, D.deptno) FROM Emp1 E LEFT OUTER JOIN Dept1 D ON D.deptno = E.dept.deptno WHERE D.deptno = :deptno")
	List<EmpDto> findByEmpDeptDeptno2(Integer deptno, Pageable pageable);
	
	/**
	 * 패이징을 위한 총 갯수 가져오기
	 * @param deptno
	 * @return
	 */
	Long countByDeptDeptno(Integer deptno);
	
	@Query("DELETE FROM Emp1 WHERE deptno = :deptno")
	Long deleteByDeptDeptno(Integer deptno);
	
	Long deleteByEmpno(Integer empno);
	
	/**
	 * EMP005_사원정보_검색
	 * @param ename
	 * @return
	 */
	List<Emp1> findByEnameContaining(String ename);
	
	/**
	 * EMP006_사원정보_검색_페이징
	 * @param ename
	 * @param pageable
	 * @return
	 */
	List<Emp1> findByEnameContaining(String ename,  Pageable pageable);
	
	/**
	 * 페이징을 위한 총 갯수 가져오기
	 * @param ename
	 * @return
	 */
	Long countByEnameContaining(String ename);
	
	

	
	

	
}
