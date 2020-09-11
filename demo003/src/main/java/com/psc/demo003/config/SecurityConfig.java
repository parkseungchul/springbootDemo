package com.psc.demo003.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.psc.demo003.componet.JwtHandlerInterceptorImpl;
import com.psc.demo003.componet.UserDetailServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
	
	@Autowired
	HandlerInterceptor jwtHandlerInterceptor;
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
        .addInterceptor(jwtHandlerInterceptor)
        .addPathPatterns("/api/**");
    }
	
	@Autowired
	private UserDetailServiceImpl userDetailService;

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/").permitAll();                          // 개나 소나 양이나 닭이나 다 접근
		security.authorizeRequests().antMatchers("/api/**").permitAll();                    // 토근으로 처리 스프링 시큐리티에 포함하지 않음
		security.authorizeRequests().antMatchers("/main").authenticated();                  // 로그인 된 누구나 메인페이지
		security.authorizeRequests().antMatchers("/member/**").authenticated();             // 로그인 된 누구나
		security.authorizeRequests().antMatchers("/manager").hasAnyRole("MANAGER","ADMIN"); // MANAGER, ADMIN 그룹 접근 가능
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");             // ADMIN 그룹 접근 가능
		
		security.csrf().disable();
		
		security.formLogin().loginPage("/login").defaultSuccessUrl("/main", true);  // 로그인 페이지 정의와 성공했을 경우 넘기는 URL
		security.formLogin().loginProcessingUrl("/loginAction").defaultSuccessUrl("/main", true);
		security.exceptionHandling().accessDeniedPage("/accessDenied");             // 권한이 없을 경우 넘어가는 페이지 정의
		security.logout().logoutUrl("/logout").logoutSuccessUrl("/");                // 로그 아웃 
		security.userDetailsService(userDetailService);
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}


}
