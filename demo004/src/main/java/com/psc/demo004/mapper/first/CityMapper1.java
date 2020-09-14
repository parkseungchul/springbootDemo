package com.psc.demo004.mapper.first;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.psc.demo004.model.City;
@Mapper
public interface CityMapper1 {
    City selectCityById1(Long id);
    
    List<City> selectAllCity1();
    
    void insertCity1(City city);
    
    void deleteCity1();
}
