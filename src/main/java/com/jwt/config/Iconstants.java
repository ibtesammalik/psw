package com.jwt.config;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jwt.util.ProcessingCode;
import com.jwt.util.ResponseCode;



public interface Iconstants {

	public static final String BEARER_TOKEN= "Bearer ";
	public static final String HEADER= "authorization";
	public static final String ISSUER= "MCBIslamicBankIssuer";
	public static final String SECRET_KEY= "MCBIslamicBankKey";

	public static final String CLIENT_ID= "psw.mib.spa";
	public static final String CLIENT_SECRET= "1R27XY78Y34";
	public static final String SCOPE="testScope";
	public static final String BANK_MNEMONIC="MIB";
	public static final String PSW_MNEMONIC="PSW";
	public static final String INTROSECPTION_USERNAME="mibusername";
	public static final String INTROSECPTION_PASSWORD="mibpassword";

	
	Map<String, ResponseCode> ResponseCode = Stream.of(new Object[][] { 
		{ "200", new ResponseCode("200","OK","OK","The request has succeeded. The information returned with the response is dependent on the method used in the request.") }, 
		{ "209", new ResponseCode("209","Accept","","Decision made by the business user on system.") },	  
		{ "210", new ResponseCode("210","Reject","","Decision made by the business user on system.") }, 
		{ "211", new ResponseCode("211","Cancelled","","Transaction marked as cancelled. ") },	 
		{ "212", new ResponseCode("212","Reversal","","Transaction reversal, mark message as null and void.") }, 
		{ "213", new ResponseCode("213","Settled","","Transaction marked as settled.") },	 
		{ "214", new ResponseCode("214","Not Allowed","","Transaction is not allowed") }, 
		{ "400", new ResponseCode("400","Bad Request","","The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.") },	 
		{ "401", new ResponseCode("401","Unauthorized","","The request requires user authentication") }, 
		{ "500", new ResponseCode("500","Internal Server Error","","The server encountered an unexpected error.") },	 
		{ "700", new ResponseCode("700","Data Not Found","","If the data is not found in our system, for example IBAN.") }, 
		{ "701", new ResponseCode("701","Signature Mismatch","Signature Invalid","When the provided signature of data is incorrect.") },	 
		{ "702", new ResponseCode("702","Invalid Method ID","","When the method id provided in the request is incorrect.") }, 
		{ "703", new ResponseCode("703","Unknown Sender ID","","When the sender id provided is not found in PSW.") },	 
		{ "704", new ResponseCode("704","Validation Error","","When fields of request have incorrect data this error code will be returned along with a description of the field.") }, 
	}).collect(Collectors.toMap(data -> (String) data[0], data -> (ResponseCode) data[1]));	
	
	
	Map<String, ProcessingCode> procesCode = Stream.of(new Object[][] { 
		{ "101", new ProcessingCode("101","Update GD and Financial Information (Financial & GD Information (Import) - Message 2)") }, 
		{ "102", new ProcessingCode("102","Update GD and Financial Information (Financial & GD Information (Export) - Message 2)") },	  
		{ "301", new ProcessingCode("301","Verification of IBAN, Email and Mobile No. (Trader Profile - Message 1)") }, 
		{ "302", new ProcessingCode("302","Get Account Details & Authorized Payment Modes (Trader Profile - Message 2)") },	 
		{ "303", new ProcessingCode("303","Get Negative List of Countries (Trader Profile - Message 3)") }, 
		{ "304", new ProcessingCode("304","Get Negative List of Commodities (Trader Profile - Message 4)") },	 
		{ "305", new ProcessingCode("305","Get Negative List of Suppliers (Trader Profile - Message 5)") }, 
		{ "306", new ProcessingCode("306","Sharing of Change of Bank Request with AD (Change of Bank Request – Message 1)") },	 
		{ "307", new ProcessingCode("307","Sharing of GD and Financial Information with the other selected AD (Change of Bank Request – Message 3)") }, 
		{ "308", new ProcessingCode("308","Sharing of Change of Bank Request Approval/Rejection message with old AD by PSW (Change of Bank Request – Message 5)") },	 
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (ProcessingCode	) data[1]));	

	public interface latestToken{
		String queryForToken="SELECT WSTVAL , WST_GENDATE, WST_EXPIRY" + 
				" FROM PSW_WSTOKEN " + 
				" WHERE WST_GENDATE =(SELECT MAX(WST_GENDATE) FROM PSW_WSTOKEN)";


		String queryToAddToken="INSERT INTO PSW_WSTOKEN (RESP_CODE, WSTVAL, WST_GENDATE, WST_EXPIRY, WST_TYPE,WST_GENBY,WST_CAT) VALUES (?, ?, ?, ?, ?,?,? )";
	}

}