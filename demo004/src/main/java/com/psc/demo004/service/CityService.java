package com.psc.demo004.service;

import java.util.List;

public interface CityService {
	
	public void deleteAll() throws Exception;
	
	public void firstDbInsert(com.psc.demo004.model.City city) throws Exception;

	public void secondDbInsert(com.psc.demo004.model.City city) throws Exception;
	
	public List<com.psc.demo004.model.City> firstDbSelect();
	
	public List<com.psc.demo004.model.City> secondDbSelect();
	
	public void transcationDB1RollBackY();

	public void transcationDB1RollBackN() throws Exception;
	
	public void transcationDB2RollBackY() throws Exception;

	public void transcationDB2RollBackN() throws Exception;
}
