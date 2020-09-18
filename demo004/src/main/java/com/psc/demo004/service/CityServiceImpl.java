package com.psc.demo004.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psc.demo004.mapper.first.CityMapper1;
import com.psc.demo004.mapper.second.CityMapper2;
import com.psc.demo004.model.City;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper1 cityMapper1;
	
	@Autowired
	private CityMapper2 cityMapper2;
	

	@Override
	public void firstDbInsert(City city){
		cityMapper1.insertCity1(city);

	}

	@Override
	public void secondDbInsert(City city) throws Exception{
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
	public void transcationDB1RollBackN() throws Exception {
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper1.insertCity1(new City(2L, "서울", "KR", 20000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
	}

	@Override
	@Transactional
	public void transcationDB2RollBackY() throws Exception {
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper2.insertCity2(new City(2L, "서울", "KR", 20000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
	}

	@Override
	public void transcationDB2RollBackN() throws Exception {
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
		cityMapper2.insertCity2(new City(2L, "서울", "KR", 20000L));
		cityMapper1.insertCity1(new City(1L, "San Francisco", "US", 10000L));
	}

	@Override
	public void deleteAll() throws Exception{
		cityMapper1.deleteCity1();
		cityMapper2.deleteCity2();
		
	}

	@Override
	public List<City> firstDbSelect(){
		return cityMapper1.selectAllCity1();
	}

	@Override
	public List<City> secondDbSelect(){
		return cityMapper2.selectAllCity2();
	}
	


}
