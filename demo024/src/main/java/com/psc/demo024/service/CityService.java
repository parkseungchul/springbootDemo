package com.psc.demo024.service;

import java.util.List;

import com.psc.demo024.model.City;

public interface CityService {
	
	public List<City> cityDb1List(); 
	
	public List<City> cityDb2List(); 
	
	public void firstDbInsert(com.psc.demo024.model.City city) throws Exception;

	public void secondDbInsert(com.psc.demo024.model.City city) throws Exception;
	
	public void transcationDB1RollBackY();

	public void transcationDB1RollBackN();
	
	public void transcationDB2RollBackY();

	public void transcationDB2RollBackN();
	
	public void transcationDB3RollBackY();

	public void transcationDB3RollBackN();
}
