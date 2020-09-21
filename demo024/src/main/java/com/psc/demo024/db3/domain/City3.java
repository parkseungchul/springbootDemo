package com.psc.demo024.db3.domain;

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
public class City3 {
	public City3() {}
	
	@Id
	private Long id;
	private String counntry;
	private String name;
	private Long population; 
}
