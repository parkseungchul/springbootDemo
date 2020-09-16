package com.psc.demo024.mapper.first;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.psc.demo024.model.City;
@Mapper
public interface CityMapper1 {
    City selectCityById1(Long id) throws Exception;
    
    List<City> selectAllCity1()  throws Exception;;
    
    void insertCity1(City city)  throws Exception;;
    
    void deleteCity1()  throws Exception;;
    
    void createCity1()  throws Exception;;
    
    void dropCity1()  throws Exception;;
}
