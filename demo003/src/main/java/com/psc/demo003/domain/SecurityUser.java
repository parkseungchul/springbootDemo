package com.psc.demo003.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class SecurityUser extends User{
	
	private String dname;
	private Member member;
	
	public SecurityUser(Member member) {
		super(member.getId()
			, member.getPassword()
			, AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		this.dname = member.getDname();
		this.member = member;
	}
	


	
}
