package com.psc.demo004.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="city")
@ToString
public class City {
	
	public City() {}

	public City(Long id, String country, String name, Long population) {
		this.id = id;
		this.country = country;
		this.name = name;
		this.population = population;
	}
	
	@Id
	private Long id;
	private String country;
	private String name;
	private Long population;
}
