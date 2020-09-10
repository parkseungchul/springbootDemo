package com.psc.demo003.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User{

	public SecurityUser(Member member) {
		
		super(member.getId()
			, member.getPassword()
			, AuthorityUtils.createAuthorityList(member.getRole().toString()));

	}

}
