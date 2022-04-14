package com.jwt.dao;

import com.jwt.model.PswWsmsgsRrlog;

public interface SaveRequestResponseDao {

	int saveReqResMsg(PswWsmsgsRrlog e) throws Exception;

	int saveReqMsg(PswWsmsgsRrlog e) throws Exception;

	int saveResMsg(PswWsmsgsRrlog e) throws Exception;

}
