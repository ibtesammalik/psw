package com.jwt.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class ResponseUnauthorize implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4431417511515875405L;
	/**
	 * 
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
		"timestamp",
		"status",
		"error",
		"path"
	})
	@JsonProperty(value ="timestamp")
	private LocalDateTime timeStamp;
	@JsonProperty(value ="status")
	private String status;
	@JsonProperty(value ="error")
	private String error;
	@JsonProperty(value ="message")
	private String message;
	@JsonProperty(value ="path")
	private String path;




	public ResponseUnauthorize(LocalDateTime timeStamp, String status, String error, String message, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	

	


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}






	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}






	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}






}
