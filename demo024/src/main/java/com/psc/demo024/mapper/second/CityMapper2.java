package com.psc.demo024.mapper.second;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.psc.demo024.model.City;
@Mapper
public interface CityMapper2 {
    City selectCityById2(Long id)  throws Exception;;
    
    List<City> selectAllCity2()  throws Exception;;
    
    void insertCity2(City city)  throws Exception;;
    
    void deleteCity2()  throws Exception;;
    
    void createCity2()  throws Exception;;
    
    void dropCity2()  throws Exception;;
}
