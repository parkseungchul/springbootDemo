package com.psc.demo024.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="city")
@AllArgsConstructor
public class City {
	public City() {}
	
	@Id
	private Long id;
	private String counntry;
	private String name;
	private Long population; 
}
