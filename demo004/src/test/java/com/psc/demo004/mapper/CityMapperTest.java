package com.psc.demo004.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.psc.demo004.mapper.first.CityMapper1;
import com.psc.demo004.mapper.second.CityMapper2;
import com.psc.demo004.model.City;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityMapperTest {
	
	@Autowired
	CityMapper1 cityMapper1;
	
	@Autowired
	CityMapper2 cityMapper2;
	
	@Test
	@Transactional
	public void A001_시티1_테이블_삭제() {
		cityMapper1.dropCity1();
	}
	
	@Test
	@Transactional
	public void A002_시티1_테이블_생성() {
		cityMapper1.createCity1();
	}
	
	
	@Test
	@Transactional
	public void A003_시티1_입력() {
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
		

		for(City getCity: cityList) {
			cityMapper1.insertCity1(getCity);
		}

	}
	
	@Test
	public void A004_시티1_조회() {
		cityMapper1.selectAllCity1().forEach(city -> {
			log.info("================> " + city.toString());
		});
	}
	
	@Test
	@Transactional
	public void A005_시티1_삭제() {
		cityMapper1.deleteCity1();
	}
	
	
	
	@Test
	@Transactional
	public void B001_시티2_테이블_삭제() {
		cityMapper2.dropCity2();
	}
	
	@Test
	@Transactional
	public void B002_시티2_테이블_생성() {
		cityMapper2.createCity2();
	}
	
	
	@Test
	@Transactional
	public void B003_시티2_입력() {
		List<City> cityList = new ArrayList<City>();
		City city;
		
		city = new City(11L, "San Francisco", "US", 10000L);
		cityList.add(city);
		
		city = new City(22L, "서울", "KR", 20000L);
		cityList.add(city);
		
		city = new City(33L, "東京", "JP", 30000L);
		cityList.add(city);
		
		city = new City(44L, "부산", "KR", 40000L);
		cityList.add(city);
		

		for(City getCity: cityList) {
			cityMapper2.insertCity2(getCity);
		}

	}
	
	@Test
	public void B004_시티2_조회() {
		cityMapper2.selectAllCity2().forEach(city -> {
			log.info("================> " + city.toString());
		});
	}
	
	@Test
	@Transactional
	public void B005_시티2_삭제() {
		cityMapper2.deleteCity2();
	}

}
