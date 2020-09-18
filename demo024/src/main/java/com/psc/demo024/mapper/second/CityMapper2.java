package com.psc.demo024.mapper.second;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.psc.demo024.model.City;
@Mapper
public interface CityMapper2 {
    City selectCityById2(Long id);
    
    List<City> selectAllCity2();
    
    void insertCity2(City city);
    
    void deleteCity2();
    
    void createCity2();
    
    void dropCity2();
}
