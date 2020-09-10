package com.psc.demo003.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.psc.demo003.domain.Member;
import com.psc.demo003.domain.SecurityUser;
import com.psc.demo003.repository.MemberRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> optional = memberRepository.findById(username);
		
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username +" 사용자 없음");
		}else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
	}

}
