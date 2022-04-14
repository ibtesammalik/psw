package com.jwt.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.List;

public class MsgOne2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4732072831614485317L;

	/**
	 * 
	 */
	

	String IBAN   ;
	
	Array  APMI         ;
	Array  APME;
	
	
	public MsgOne2(String iBAN,  Array aPMI, Array APME) {
		super();
		this.IBAN = iBAN;
		
		this.APMI = aPMI;
		this.APME = APME;
	}
	
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	
	
	

	
	
	public Array getAPMI() {
		return APMI;
	}

	public void setAPMI(Array aPMI) {
		APMI = aPMI;
	}

	public Array getAPME() {
		return APME;
	}

	public void setAPME(Array aPME) {
		APME = aPME;
	}
	
	
	


}
