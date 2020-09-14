package com.psc.demo004.mapper;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.psc.demo004.mapper.first.CityMapper;
import com.psc.demo004.model.City;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityTest {
	
	
	@Autowired
	CityMapper cityMapper;
	
	
	@Test
	public void A001_시티1_조회() {
		cityMapper.selectAllCity().forEach(city ->{
			log.info("================>"+city.toString());
		});
	}
	

}
