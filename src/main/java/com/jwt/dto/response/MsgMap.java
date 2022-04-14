package com.jwt.dto.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MsgMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8705797474840745995L;
	/**
	 * 
	 */
	
	private Map<String, Object> data = new HashMap<String, Object>();
	public MsgMap(Map<String, Object> data) {
		super();
		this.data = data;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public MsgMap() {
		
	}
	
	
	
	
	
	


}
