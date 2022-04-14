package com.jwt.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class TokenAcquisitionResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4431417511515875405L;
	/**
	 * 
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"access_token",
	"expires_in",
	"token_type",
	"scope"
	})
	@JsonProperty(value ="access_token")
	private String token;
	@JsonProperty(value ="expires_in")
	private long expireDate;
	@JsonProperty(value ="token_type")
	private String tokenType;
	@JsonProperty(value ="scope")
	private String scope;
	
	
	public TokenAcquisitionResponse(String token, long expireDate, String tokenType, String scope) {
		super();
		this.token = token;
		this.expireDate = expireDate;
		this.tokenType = tokenType;
		this.scope = scope;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public long getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(long expireDate) {
		this.expireDate = expireDate;
	}
	
	
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	

	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}

	
	
}
