package com.psc.demo024.db3.repository;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.psc.demo024.db3.domain.City3;
import com.psc.demo024.db3.repository.CityRepository3;
import com.psc.demo024.mapper.CityMapperTest;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityRepository3Test {

	@Autowired
	CityRepository3 cityRepository;
	
	
	@Test
	public void A001_도시_데이터_삽입() {
		City3 city = new City3(1L, "San Francisco", "US", 10000L);
		cityRepository.save(city);
		Assert.assertTrue(cityRepository.findById(1L).isPresent());
	}
	
	@Test
	public void A002_도시_데이터_삭제() {
		cityRepository.deleteAll();
		Assert.assertTrue(!cityRepository.findAll().iterator().hasNext());
	}
}
