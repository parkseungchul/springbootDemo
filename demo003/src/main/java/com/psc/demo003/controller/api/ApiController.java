package com.psc.demo003.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psc.demo003.domain.Member;
import com.psc.demo003.dto.ResultDto;
import com.psc.demo003.repository.MemberRepository;
import com.psc.demo003.service.JwtService;

import javafx.scene.DepthTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService securityService;
	
	@PostMapping("/createToken")
	public ResultDto createToken(Authentication authentication, String username, String password) {
		Optional<Member> optional = memberRepository.findById(username);
		if(optional.isPresent()) {
			boolean isRight = passwordEncoder.matches(password, optional.get().getPassword());
			if(isRight) {
				log.debug("로그인 성공");
				return new ResultDto(true, "login success", securityService.createToken(username, 1000 * 60));
			}else {
				log.debug("비밀번호가 맞지 않습니다.");
				return new ResultDto(false, "password incorrect", null);
			}
		}else {
			log.debug("사용자가 존재하지 않습니다.");
			return new ResultDto(false, "user not found", null);
		}
		
	}
	
	@PostMapping("/test")
	public ResultDto test() {
		
		return new ResultDto(true, "test", null);
	}
}
