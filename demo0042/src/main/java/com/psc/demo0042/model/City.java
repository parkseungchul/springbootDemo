package com.psc.demo0042.model;

import org.apache.ibatis.type.Alias;

import lombok.ToString;

@ToString
@Alias("city")
public class City {
    private Long id;
    private String name;
    private String country;
    private Long population;

    public City() {
    }

    public City(Long id, String name, String country, Long population) {
    	this.id         = id;
        this.name       = name;
        this.country    = country;
        this.population = population;
    }
}