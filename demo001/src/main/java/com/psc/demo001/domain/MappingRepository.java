package com.psc.demo001.domain;

import com.psc.demo001.domain.embed.Pks_DeptEmp;
import org.springframework.data.repository.CrudRepository;

public interface MappingRepository extends CrudRepository<Mapping, Pks_DeptEmp> {
}
