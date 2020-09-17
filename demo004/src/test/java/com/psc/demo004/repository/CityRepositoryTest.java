package com.psc.demo004.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.psc.demo004.domain.City;
import com.psc.demo004.repository.CityRepository;

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
	@Transactional
	public void A001_CITY_데이터_삽입() {
		List<City> cityList = new ArrayList<City>();
		City city;
		city = new City(1L, "San Francisco", "US", 10000L);
		cityList.add(city);
		
		city = new City(2L, "서울", "KR", 20000L);
		cityList.add(city);
		
		city = new City(3L, "東京", "JP", 30000L);
		cityList.add(city);
		
		city = new City(4L, "부산", "KR", 40000L);
		cityList.add(city);
		cityRepository.saveAll(cityList);
	}
	
	
	@Test
	public void A002_CITY_데이터_조회() {
		cityRepository.findAll().forEach(city ->{
			log.info(city.toString());
		});
	}
	
	@Test
	@Transactional
	public void A003_CITY_데이터_삭제() {
		cityRepository.deleteAll();
	}
}
