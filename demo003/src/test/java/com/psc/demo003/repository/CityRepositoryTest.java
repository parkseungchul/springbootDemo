package com.psc.demo003.repository;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.psc.demo003.domain.City;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityRepositoryTest {

	@Autowired
	CityRepository cityRepository;
	
	
	@Test
	public void A001_도시_정보_테이블_생성() {
		cityRepository.count();
	}
	
	
	@Test
	@Transactional
	public void A002_도시_정보_삽입() {
		City city = new City();
		
		city = new City();
		city.setId(1L);
		city.setName("San Francisco");
		city.setCountry("US");
		city.setPopulation(10000L);
		cityRepository.save(city);
		
		city = new City();
		city.setId(2L);
		city.setName("서울");
		city.setCountry("KR");
		city.setPopulation(20000L);
		cityRepository.save(city);
		
		city = new City();
		city.setId(3L);
		city.setName("東京");
		city.setCountry("KR");
		city.setPopulation(30000L);
		cityRepository.save(city);
		
		city = new City();
		city.setId(3L);
		city.setName("부산");
		city.setCountry("KR");
		city.setPopulation(40000L);
		cityRepository.save(city);
	}
	
	@Test
	@Transactional
	public void A003_도시_정보_삭제() {
		cityRepository.deleteAll();
	}
}
