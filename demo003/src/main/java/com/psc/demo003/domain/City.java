package com.psc.demo003.domain;

import java.io.Serializable;

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
public class City implements Serializable{
	
	@Id
	private Long id;
	private String name;
	private String country;
	private Long population;
}
