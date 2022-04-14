package com.jwt.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.dao.TokenManagementDao;
import com.jwt.dto.response.TokenAcquisitionResponse;

@Service
public class TokenMangementService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6203148822583737105L;
	
		
	@Autowired
	private TokenManagementDao tokenDao;
	
	
	public
	Map<String, Object>  addToken(TokenAcquisitionResponse dto, String code)	throws  SQLException{
		
		
		return tokenDao.addToken(dto, code);
	}
	
	public
	Map<String, Object>  getForInActiveToken(StringBuilder token, String wsCat)	throws  SQLException{
		
		
		return tokenDao.getForInActiveToken(token, wsCat);
	}
	
}
