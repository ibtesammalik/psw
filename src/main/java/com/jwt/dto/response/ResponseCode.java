package com.jwt.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCode<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8705528854241824938L;
	
	@JsonProperty(value ="")
	T reponseCode;
	String code;
	
	
	public ResponseCode() {
		super();
	
	}

	public ResponseCode(T reponseCode, String status) {
		super();
		this.reponseCode = reponseCode;
		this.code = status;
	}
	
	public ResponseCode(T reponseCode) {
		super();
		this.reponseCode = reponseCode;
		
	}
	
	public T getReponseCode() {
		return reponseCode;
	}
	public void setReponseCode(T reponseCode) {
		this.reponseCode = reponseCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
