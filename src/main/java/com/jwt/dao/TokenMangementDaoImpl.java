package com.jwt.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.jwt.dto.response.TokenAcquisitionResponse;

@Repository("tokenManagementDao")
public class TokenMangementDaoImpl implements TokenManagementDao ,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6203148822583737105L;
	
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	
	/*
	 * @Override public StringBuilder addToken(TokenAcquisitionResponse dto, String
	 * code) throws SQLException{ jdbcTemplate.update(
	 * Iconstants.latestToken.queryToAddToken, new Object[]{code, dto.getToken(),new
	 * Date(),Long.parseLong(dto.getExpireDate()),dto.getTokenType(),"AD","AD"} );
	 * return new StringBuilder(dto.getToken()); }
	 */
	
	@Override
	public
	Map<String, Object> addToken(TokenAcquisitionResponse dto, String code)	throws  SQLException{
		
		
		 LocalDateTime to = LocalDateTime.now();
		 
		 SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("PSW_WSTPROC");
		 SqlParameterSource in = new MapSqlParameterSource().
				 addValue("P_REQTYPE", "WSTG").
				 addValue("P_REQCAT", "AD").
				 addValue("P_WSTVAL", dto.getToken() ).
				 addValue("P_WSTRESP_CODE", code).
				 addValue("P_WST_TYPE", dto.getTokenType()).
				 addValue("P_WST_EXPIRY", dto.getExpireDate());
		 Map<String, Object> out = jdbcCall.execute(in);

		

		return out;
			
		
		
	}
	

	@Override
	public Map<String, Object> getForInActiveToken(StringBuilder token, String wsCat) throws SQLException {
		
		
		 LocalDateTime to = LocalDateTime.now();
		 
		 SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("PSW_WSTPROC");
		 SqlParameterSource in = new MapSqlParameterSource().
				 addValue("P_REQTYPE", "WSTV").
				 addValue("P_WSTVAL", token.toString()).
				 addValue("P_WSTRESP_CODE", null).
				 addValue("P_WST_EXPIRY", null).
				 addValue("P_WST_TYPE", null).
				 addValue("P_REQCAT", "AD");
		 Map<String, Object> out = jdbcCall.execute(in);

		

		return out;
			
		
		
	}


	

}
