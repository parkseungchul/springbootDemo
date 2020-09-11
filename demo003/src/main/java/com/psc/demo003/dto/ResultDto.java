package com.psc.demo003.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResultDto {

	private boolean result;
	private String msg;
	private Object object;

	public ResultDto(boolean result, String msg, Object object){
		this.result = result;
		this.msg = msg;
		this.object = object;	
	}

	
}
