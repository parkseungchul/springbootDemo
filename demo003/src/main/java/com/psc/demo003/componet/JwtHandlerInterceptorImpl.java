package com.psc.demo003.componet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psc.demo003.constants.Constant;
import com.psc.demo003.dto.ResultDto;
import com.psc.demo003.service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtHandlerInterceptorImpl implements HandlerInterceptor{

	@Autowired
	private JwtService jwtService; 
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	
        final String token = request.getHeader(Constant.AUTH_HEADER);
        log.debug("===================================================");
        log.debug(request.getRequestURI());
        log.debug(token);
        log.debug("===================================================");
        try{
        	if(token == null) {
        		responseError(response, Constant.AUTH_INVALID);
        		return false;
        	}
            jwtService.isUsable(token);
            return true;
 
        }catch(ExpiredJwtException ex) {
            responseError(response, Constant.TOKEN_TIMEOUT);
            return false;
        }catch (Exception e){
            responseError(response, Constant.AUTH_INVALID);
            return false;
        }
    }
    
    public void responseError(HttpServletResponse response, String message) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        ResultDto resultDto = new ResultDto(false, message, null);
        response.setContentType("application/json;  charset=utf-8");
        //response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(mapper.writeValueAsString(resultDto));
    }
}
