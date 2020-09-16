package com.psc.demo024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psc.demo024.mapper.first.CityMapper1;
import com.psc.demo024.mapper.second.CityMapper2;
import com.psc.demo024.model.City;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityMapper1 cityMapper1;
	
	@Autowired
	private CityMapper2 cityMapper2;

	@Override
	@Transactional
	public void cityRollBackY() throws Exception{
		City city = new City(1115L, "인천", "KR", 60000L);
		cityMapper1.insertCity1(city);
		
		city = new City(44L, "부산", "KR", 40000L);
		cityMapper2.insertCity2(city);
	}
	
	@Override
	public void cityRollBackN() throws Exception{
		City city = new City(1115L, "인천", "KR", 60000L);
		cityMapper1.insertCity1(city);
		
		city = new City(44L, "부산", "KR", 40000L);
		cityMapper2.insertCity2(city);
	}

}
