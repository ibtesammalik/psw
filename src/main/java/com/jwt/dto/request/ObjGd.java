package com.jwt.dto.request;

import java.io.Serializable;



public class ObjGd implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7700245007937195953L;
	String FI_MOP          ;
	String FI_UNO        ;
	
	
	
	
	public ObjGd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjGd(String fI_MOP,	String fI_UNO) {
		super();
		FI_MOP = fI_MOP;
		FI_UNO = fI_UNO;
	}
	
	public String getFI_MOP() {
		return FI_MOP;
	}
	public void setFI_MOP(String fI_MOP) {
		FI_MOP = fI_MOP;
	}
	public String getFI_UNO() {
		return FI_UNO;
	}
	public void setFI_UNO(String fI_UNO) {
		FI_UNO = fI_UNO;
	}
	
}
