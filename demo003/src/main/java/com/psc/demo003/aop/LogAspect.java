package com.psc.demo003.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspect {
	
	@Around("execution(* com.psc.demo003.service..*(..))")
	public Object service(ProceedingJoinPoint pjp) throws Throwable {
		log.info("========== Service ========== " + pjp.getSignature().getDeclaringTypeName());
		
		Object result = pjp.proceed();
		
		return result;
	}
	
	@Around("execution(* com.psc.demo003.controller..*(..))")
	public Object controller(ProceedingJoinPoint pjp) throws Throwable {
		log.info("========== Controller ========== " + pjp.getSignature().getDeclaringTypeName());
		log.info("========== Controller ========== " + pjp.getSignature().getDeclaringType());
		Object result = pjp.proceed();
		
		return result;
	}

}
