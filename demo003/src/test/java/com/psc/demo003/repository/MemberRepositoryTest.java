package com.psc.demo003.repository;

import java.util.Optional;

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
		member.setName("멤버이름");
		member.setDname("멤버부서");
		member.setPassword(passwordEncoder.encode("member"));
		member.setRole(Role.ROLE_MEMBER);
		member.setEnabled(true);
		memberRepository.save(member);
		
		member = new Member();
		member.setId("manager");
		member.setName("매니저이름");
		member.setDname("매니저부서");
		member.setPassword(passwordEncoder.encode("manager"));
		member.setRole(Role.ROLE_MANAGER);
		member.setEnabled(true);
		memberRepository.save(member);
		
		member = new Member();
		member.setId("admin");
		member.setName("어드민이름");
		member.setDname("어드민부서");
		member.setPassword(passwordEncoder.encode("admin"));
		member.setRole(Role.ROLE_ADMIN);
		member.setEnabled(true);
		memberRepository.save(member);
	}
	
	@Test
	public void A001_사용자_정보_조회() {
		
		Optional<Member> optionalMember = memberRepository.findById("admin");
		
		if(optionalMember.isPresent()) {
			log.debug(optionalMember.get().toString());
		}
	}
	

}
