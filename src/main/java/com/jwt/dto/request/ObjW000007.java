package com.jwt.dto.request;

import java.io.Serializable;

public class ObjW000007 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -901889301348014966L;
	String COBR_UNO          ;
	String TRADE_TYPE        ;
	String TRADER_IBAN       ;
	String TRADER_NTN         ;
	String TRADER_NAME       ;
	String FI_UNO           ;
	String COB_Status           ;
	
	
	public ObjW000007() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObjW000007(String cOBR_UNO, String tRADE_TYPE, String tRADER_IBAN, String tRADER_NTN, String tRADER_NAME,
			String fI_UNO, String cOB_Status) {
		super();
		COBR_UNO = cOBR_UNO;
		TRADE_TYPE = tRADE_TYPE;
		TRADER_IBAN = tRADER_IBAN;
		TRADER_NTN = tRADER_NTN;
		TRADER_NAME = tRADER_NAME;
		FI_UNO = fI_UNO;
		COB_Status = cOB_Status;
	}
	
	public ObjW000007(String cOBR_UNO, String tRADE_TYPE, String tRADER_IBAN, String tRADER_NTN, String tRADER_NAME,
			String fI_UNO ) {
		super();
		COBR_UNO = cOBR_UNO;
		TRADE_TYPE = tRADE_TYPE;
		TRADER_IBAN = tRADER_IBAN;
		TRADER_NTN = tRADER_NTN;
		TRADER_NAME = tRADER_NAME;
		FI_UNO = fI_UNO;
		
	}

	public String getCOBR_UNO() {
		return COBR_UNO;
	}
	public void setCOBR_UNO(String cOBR_UNO) {
		COBR_UNO = cOBR_UNO;
	}
	public String getTRADE_TYPE() {
		return TRADE_TYPE;
	}
	public void setTRADE_TYPE(String tRADE_TYPE) {
		TRADE_TYPE = tRADE_TYPE;
	}
	public String getTRADER_IBAN() {
		return TRADER_IBAN;
	}
	public void setTRADER_IBAN(String tRADER_IBAN) {
		TRADER_IBAN = tRADER_IBAN;
	}
	public String getTRADER_NTN() {
		return TRADER_NTN;
	}
	public void setTRADER_NTN(String tRADER_NTN) {
		TRADER_NTN = tRADER_NTN;
	}
	public String getTRADER_NAME() {
		return TRADER_NAME;
	}
	public void setTRADER_NAME(String tRADER_NAME) {
		TRADER_NAME = tRADER_NAME;
	}
	public String getFI_UNO() {
		return FI_UNO;
	}
	public void setFI_UNO(String fI_UNO) {
		FI_UNO = fI_UNO;
	}

	public String getCOB_Status() {
		return COB_Status;
	}

	public void setCOB_Status(String cOB_Status) {
		COB_Status = cOB_Status;
	}
	
}
