package com.psc.demo003.service;

public interface JwtService {
	
	String createToken(String subject, long ttlMillis);
	
	String getSubject(String token);
	
	public void isUsable(String jwt) throws Exception;

}
