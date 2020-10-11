package com.psc.demo024.mapper.first;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.psc.demo024.model.City;

@Mapper
public interface CityMapper1 {
    City selectCityById1(Long id) throws Exception;
    
    List<City> selectAllCity1();
    
    void insertCity1(City city);
    
    void deleteCity1();
    
    void createCity1()  throws Exception;
    
    void dropCity1()  throws Exception;
}
