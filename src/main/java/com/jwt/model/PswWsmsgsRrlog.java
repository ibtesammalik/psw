package com.jwt.model;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;

public class PswWsmsgsRrlog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8079517405025674188L;
	private String msgid;
	private String wsRequest;
	private String wsResponse;
	private Date wsrDate;

	public PswWsmsgsRrlog() {
	}

	public PswWsmsgsRrlog(String msgid) {
		this.msgid = msgid;
	}

	public PswWsmsgsRrlog(String msgid, String wsRequest, String wsResponse, Date wsrDate) {
		this.msgid = msgid;
		this.wsRequest = wsRequest;
		this.wsResponse = wsResponse;
		this.wsrDate = wsrDate;
	}

	@Column(name = "MSGID", nullable = false, length = 8)
	public String getMsgid() {
		return this.msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	
	

	
	public String getWsRequest() {
		return wsRequest;
	}

	public void setWsRequest(String wsRequest) {
		this.wsRequest = wsRequest;
	}

	public String getWsResponse() {
		return wsResponse;
	}

	public void setWsResponse(String wsResponse) {
		this.wsResponse = wsResponse;
	}

	public Date getWsrDate() {
		return this.wsrDate;
	}

	public void setWsrDate(Date wsrDate) {
		this.wsrDate = wsrDate;
	}

}
