package com.psc.demo024.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psc.demo024.db3.repository.CityRepository3;
import com.psc.demo024.mapper.first.CityMapper1;
import com.psc.demo024.mapper.second.CityMapper2;
import com.psc.demo024.model.City;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityMapper1 cityMapper1;
	
	@Autowired
	private CityMapper2 cityMapper2;
	
	@Autowired
	private CityRepository3 CityRepository;

	@Override
	public List<City> cityDb1List() {
		return cityMapper1.selectAllCity1();
	}

	@Override
	public List<City> cityDb2List() {
		return cityMapper2.selectAllCity2();
	}

	@Override
	public void firstDbInsert(City city){
		cityMapper1.insertCity1(city);

	}

	@Override
	public void secondDbInsert(City city){
		cityMapper2.insertCity2(city);
	}
	
	@Override
	@Transactional
	public void transcationDB1RollBackY(){
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper1.insertCity1(new City(2L, "서울", "KR", 20000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		
	}

	@Override
	public void transcationDB1RollBackN(){
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper1.insertCity1(new City(2L, "서울", "KR", 20000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
	}

	@Override
	@Transactional
	public void transcationDB2RollBackY(){
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper2.insertCity2(new City(2L, "서울", "KR", 20000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
	}

	@Override
	public void transcationDB2RollBackN(){
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper2.insertCity2(new City(2L, "서울", "KR", 20000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
	}

	@Override
	@Transactional
	public void transcationDB3RollBackY() {
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper2.insertCity2(new City(2L, "서울", "KR", 20000L));
		CityRepository.save(new com.psc.demo024.db3.domain.City3(1L, "San Francisco", "US", 10000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		
	}

	@Override
	public void transcationDB3RollBackN() {
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper2.insertCity2(new City(2L, "서울", "KR", 20000L));
		CityRepository.save(new com.psc.demo024.db3.domain.City3(1L, "San Francisco", "US", 10000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		
	}

}
