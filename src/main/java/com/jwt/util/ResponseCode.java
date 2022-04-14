package com.jwt.util;

import java.io.Serializable;

public class ResponseCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8563984701026069168L;
	private String code ;
	private String statusName ;
	private String statusMessage ;
	private String description ;


	public ResponseCode(String code, String statusName, String statusMessage ,String description) {
		super();
		this.code = code;
		this.statusName = statusName;
		this.statusMessage = statusMessage;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}


}
