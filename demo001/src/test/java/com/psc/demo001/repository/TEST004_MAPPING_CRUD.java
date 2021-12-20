package com.psc.demo001.repository;

import com.psc.demo001.domain.*;
import com.psc.demo001.domain.embed.Pks_DeptEmp;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jdo.annotations.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TEST004_MAPPING_CRUD {

    @Autowired
    private MappingRepository mappingRepository;


    @Test
    @Transactional
    public void MAPPING_테스트_데이터_CRUD() {
        Pks_DeptEmp pks_deptEmp;
        Mapping mapping;


        pks_deptEmp = new Pks_DeptEmp(10, 7839);
        mapping = new Mapping(pks_deptEmp, "ACCOUNTING", "KING");
        mappingRepository.save(mapping);

        pks_deptEmp = new Pks_DeptEmp(10, 7698);
        mapping = new Mapping(pks_deptEmp, "ACCOUNTING", "BLAKE");
        mappingRepository.save(mapping);

        pks_deptEmp = new Pks_DeptEmp(20, 7698);
        mapping = new Mapping(pks_deptEmp, "RESEARCH", "BLAKE");
        mappingRepository.save(mapping);

        mappingRepository.findAll().forEach(i -> {
            log.debug(i.toString());
        });

        mappingRepository.deleteAll();
    }
}
