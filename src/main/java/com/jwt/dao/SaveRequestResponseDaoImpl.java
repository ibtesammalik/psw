package com.jwt.dao;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jwt.model.PswWsmsgsRrlog;

@Repository("saveRequestResponseDao")
public class SaveRequestResponseDaoImpl implements SaveRequestResponseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public int saveReqResMsg(PswWsmsgsRrlog	 e) throws Exception{  
	    String query="insert into PSW_WSMSGS_RRLOG values( ?,?,?,?)";  
	    return jdbcTemplate.update(query, e.getMsgid(), e.getWsRequest(), e.getWsResponse() , 	new Date());  
	}  
	
	@Override
	public int saveReqMsg(PswWsmsgsRrlog	 e) throws Exception{  
		  String query="update PSW_WSMSGS_RRLOG set WSR_DATE = ? , WS_RESPONSE = ? where MSGID = ?";  
	    return jdbcTemplate.update(query, 	new Date(),e.getWsResponse() , e.getMsgid());  
	}  
	
	@Override
	public int saveResMsg(PswWsmsgsRrlog e) throws Exception{  
		   String query="insert into PSW_WSMSGS_RRLOG values( ?,?,?,?)";  
	    return jdbcTemplate.update(query, e.getMsgid(), e.getWsRequest(), null , new Date());  
	}  
	
}
