package com.psc.demo004.mapper.first;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.psc.demo004.model.City;
@Mapper
public interface CityMapper {
    City selectCityById(Long id);
    List<City> selectAllCity();
    void insertCity(City city);
}
