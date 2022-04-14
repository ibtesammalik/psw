package com.jwt.dao;

import java.sql.SQLException;
import java.util.Map;

import com.jwt.dto.request.ObjGd;
import com.jwt.dto.request.ObjW000005;
import com.jwt.dto.request.ObjW000007;
import com.jwt.dto.request.PswRequest;
import com.jwt.dto.request.wse00003.Wse00003Dto;
import com.jwt.dto.request.wse00004.Wse00004Dto;
import com.jwt.dto.request.wseWSE00006Export.WseWSE00006Export;
import com.jwt.dto.request.wseWSE00006Import.WseWSE00006Import;

public interface RequestManagementDao {

	Map<String, Object> getForInActiveToken(StringBuilder token, String wsCat) throws SQLException;

//	Map<String, Object> msg1VerifyIban(PswRequest dto, String code, String requestType)
//			throws SQLException;

//	Map<String, Object> msg2345getDataAgainstIbanPswReponse(PswRequest dto, String code, String requestType) throws SQLException;

	
	boolean insertWSE00003Records(Wse00003Dto wse00003Dto, String code, String requestType)
			throws SQLException, ClassNotFoundException;

	
	boolean getWSE00004Records(Wse00004Dto wse00004Dto, String code, String requestType)
			throws SQLException, ClassNotFoundException;

	Map<String, Object> verifyRequest(PswRequest dto, String code, String requestType) throws SQLException;

	Map<String, Object> getWSE00006ExportRecords(WseWSE00006Export wse00006ExportDto, String code, String requestType)
			throws SQLException, ClassNotFoundException;

	Map<String, Object> getWSE00006ImportRecords(WseWSE00006Import wse00006ExportDto, String code, String requestType)
			throws SQLException, ClassNotFoundException;


	Map<String, Object> msg1VerifyIban(PswRequest dto, String code, String requestType, ObjGd[] fiUno, String gdno,
			String gdStatus, ObjW000005 obj5, ObjW000007 obj7);


	


}
