package com.jwt.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MsgOne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1274408972294330913L;

	String IBAN   ;
	String ACCOUNT_TITLE ;
	String ACCOUNT_NO   ;
	BigDecimal   ACCOUNT_STATUS ;
	List<BigDecimal>  ACCOUNT_TYPE  ;
	String NTN    ;
	Integer CNIC       ;
	List<BigDecimal>   APMI         ;
	List<BigDecimal>   APME;
	
	
	public MsgOne(String iBAN, String aCCOUNT_TITLE, String aCCOUNT_NO, BigDecimal aCCOUNT_STATUS, Array aCCOUNT_TYPE,
			String nTN, Integer cNIC, Array aPMI, Array APME) throws SQLException {
		super();
		IBAN = iBAN;
		ACCOUNT_TITLE = aCCOUNT_TITLE;
		ACCOUNT_NO = aCCOUNT_NO;
		ACCOUNT_STATUS = aCCOUNT_STATUS;
		List<Object> d1=java.util.Arrays.asList(aCCOUNT_TYPE.getArray());
		BigDecimal arr[] =(BigDecimal[]) d1.get(0) ;
		ACCOUNT_TYPE= Arrays.asList(arr);
		NTN = nTN;
		CNIC = cNIC;
		List<Object> d2=java.util.Arrays.asList(aCCOUNT_TYPE.getArray());
		d2=java.util.Arrays.asList(aPMI.getArray());
		BigDecimal arr1[] =(BigDecimal[]) d2.get(0) ;
		APMI = Arrays.asList(arr1);
		
		List<Object> d3=java.util.Arrays.asList(aCCOUNT_TYPE.getArray());
		BigDecimal arr3[] =(BigDecimal[]) d3.get(0) ;
		this.APME= Arrays.asList(arr3);
		
	}
	
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getACCOUNT_TITLE() {
		return ACCOUNT_TITLE;
	}
	public void setACCOUNT_TITLE(String aCCOUNT_TITLE) {
		ACCOUNT_TITLE = aCCOUNT_TITLE;
	}
	public String getACCOUNT_NO() {
		return ACCOUNT_NO;
	}
	public void setACCOUNT_NO(String aCCOUNT_NO) {
		ACCOUNT_NO = aCCOUNT_NO;
	}
	
	

	
	

	

	public BigDecimal getACCOUNT_STATUS() {
		return ACCOUNT_STATUS;
	}

	public void setACCOUNT_STATUS(BigDecimal aCCOUNT_STATUS) {
		ACCOUNT_STATUS = aCCOUNT_STATUS;
	}

	public Integer getCNIC() {
		return CNIC;
	}

	public void setCNIC(Integer cNIC) {
		CNIC = cNIC;
	}

	public String getNTN() {
		return NTN;
	}
	public void setNTN(String nTN) {
		NTN = nTN;
	}

	

	public List<BigDecimal> getACCOUNT_TYPE() {
		return ACCOUNT_TYPE;
	}

	public void setACCOUNT_TYPE(List<BigDecimal> aCCOUNT_TYPE) {
		ACCOUNT_TYPE = aCCOUNT_TYPE;
	}

	public List<BigDecimal> getAPMI() {
		return APMI;
	}

	public void setAPMI(List<BigDecimal> aPMI) {
		APMI = aPMI;
	}

	public List<BigDecimal> getAPME() {
		return APME;
	}

	public void setAPME(List<BigDecimal> aPME) {
		APME = aPME;
	}

	
	
	


}
