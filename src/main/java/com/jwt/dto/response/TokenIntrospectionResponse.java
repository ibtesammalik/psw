package com.jwt.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class TokenIntrospectionResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4431417511515875405L;
	/**
	 * 
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"nbf",
	"exp",
	"aud",
	"client_id",
	"jti",
	"iat",
	"active",
	"scope"
	})
	@JsonProperty(value ="nbf")
	private String nbf;
	@JsonProperty(value ="exp")
	private String exp;
	@JsonProperty(value ="aud")
	private String aud;
	@JsonProperty(value ="client_id")
	private String clientId;
	@JsonProperty(value ="jti")
	private String jti;
	@JsonProperty(value ="iat")
	private String iat;
	@JsonProperty(value ="active")
	private String active;
	@JsonProperty(value ="scope")
	private String scope;
	
	
	public TokenIntrospectionResponse(String nbf, String exp, String aud, String clientId ,String jti, String iat, String active,
			String scope) {
		super();
		this.nbf = nbf;
		this.exp = exp;
		this.aud = aud;
		this.clientId = clientId;
		this.jti = jti;
		this.iat = iat;
		this.active = active;
		this.scope = scope;
	}
	public String getNbf() {
		return nbf;
	}
	public void setNbf(String nbf) {
		this.nbf = nbf;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getAud() {
		return aud;
	}
	public void setAud(String aud) {
		this.aud = aud;
	}
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	

	
	
}
