package com.psc.demo004.mapper.first;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.psc.demo004.model.City;
@Mapper
public interface CityMapper1 {
    City selectCityById1(Long id) throws Exception;
    
    List<City> selectAllCity1();
    
    void insertCity1(City city);
    
    void deleteCity1() throws Exception;
    
    void createCity1() throws Exception;
    
    void dropCity1() throws Exception;
}
