package com.jwt.service;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.config.Iconstants;
import com.jwt.dao.MessageDao;
import com.jwt.dao.SaveRequestResponseDao;
import com.jwt.model.PswWsmsgsRrlog;

@Service
public class saveRequestService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5843635288236107431L;

	
	@Autowired
	private SaveRequestResponseDao saveDao;

	@Autowired
	MessageDao	 mesRepository;
	
	
	public int saveReqResMsg(PswWsmsgsRrlog e) throws Exception{
		return saveDao.saveReqResMsg(e);
		}
	
	public int saveResMsg(PswWsmsgsRrlog e) throws Exception{
		return saveDao.saveResMsg(e);
		}
	
	public int saveReqMsg(PswWsmsgsRrlog e) throws Exception{
		return saveDao.saveReqMsg(e);
		}
	

}