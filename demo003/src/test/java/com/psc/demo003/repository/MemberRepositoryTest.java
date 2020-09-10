package com.psc.demo003.repository;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.psc.demo003.domain.Member;
import com.psc.demo003.domain.Role;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void A001_사용자_정보_삽입() {
		
		Member member = new Member();
		member.setId("member");
		member.setName("멤버");
		member.setPassword(passwordEncoder.encode("member"));
		member.setRole(Role.ROLE_MEMBER);
		memberRepository.save(member);
		
		member = new Member();
		member.setId("manager");
		member.setName("매니저");
		member.setPassword(passwordEncoder.encode("manager"));
		member.setRole(Role.ROLE_MANAGER);
		memberRepository.save(member);
		
		member = new Member();
		member.setId("admin");
		member.setName("어드민");
		member.setPassword(passwordEncoder.encode("admin"));
		member.setRole(Role.ROLE_ADMIN);
		memberRepository.save(member);
		
	}
	

}
