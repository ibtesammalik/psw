package com.jwt.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint  {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		final String expired = (String) request.getAttribute("expired");
		 if (expired!=null){
			 response.sendError(HttpServletResponse.SC_UNAUTHORIZED,expired);
	        }else{
	        	response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
	        }
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
		
	}
	 @Override
	    public void afterPropertiesSet() throws Exception    {
	        setRealmName("MCB Islamic PSW");
	        super.afterPropertiesSet();
	    }
}
