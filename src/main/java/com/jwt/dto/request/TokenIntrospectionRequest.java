package com.jwt.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class TokenIntrospectionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6620146984741328356L;
	/**
	 * 
	 */

	/**
	 * 
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"Token"
	})
	@JsonProperty(value ="Token")
	private String token;
	
	
	
	public TokenIntrospectionRequest(String token) {
		super();
		this.token = token;
		
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}
	

	
	
}
