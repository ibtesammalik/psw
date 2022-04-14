package com.jwt.util;

import java.io.Serializable;

public class ProcessingCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5287476937938005870L;
	private String code;
	private String description;
	public ProcessingCode(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
