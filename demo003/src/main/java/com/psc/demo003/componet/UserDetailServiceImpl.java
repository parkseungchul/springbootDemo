package com.psc.demo003.componet;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.psc.demo003.constants.Constant;
import com.psc.demo003.domain.Member;
import com.psc.demo003.domain.SecurityUser;
import com.psc.demo003.repository.MemberRepository;
import com.psc.demo003.service.JwtService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService{

	
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private JwtService jwtService;
	
	
	@Autowired 
	private HttpServletResponse response;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional = memberRepository.findById(username);
		
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username +" 사용자 없음");
		}else {
			
			// Token 생성 및 토큰 정책
			String token = jwtService.createToken(username, 1000 * 60);
			response.setHeader(Constant.AUTH_HEADER, token);
		
			Member member = optional.get();
			return new SecurityUser(member);
		}
	}

}
