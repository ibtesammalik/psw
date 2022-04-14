package com.jwt.dto.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class PswRequest implements Serializable {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
		"messageId",
		"timestamp",
		"senderId",
		"receiverId",
		"processingCode",
		"operationCode",
		"data",
		"signature"
	})
	private static final long serialVersionUID = 1944602606944346805L;
	/**
	 * 
	 */



	@JsonProperty("messageId")
	private String messageId;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("senderId")
	private String senderId;
	@JsonProperty("receiverId")
	private String receiverId;
	@JsonProperty("processingCode")
	private String processingCode;
	@JsonProperty("operationCode")
	private String operationCode;
	@JsonProperty("data")
	private Map<String, Object> data = new HashMap<String, Object>();
	@JsonProperty("signature")
	private String signature;
	
	

	public PswRequest(String messageId, String timestamp, String senderId, String receiverId,
			String processingCode, String operationCode, Map<String, Object> data, String signature) {
		super();
		this.messageId = messageId;
		this.timestamp = timestamp;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.processingCode = processingCode;
		this.operationCode = operationCode;
		this.data = data;
		this.signature = signature;
	}

	public PswRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("messageId")
	public String getMessageId() {
		return messageId;
	}

	@JsonProperty("messageId")
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("senderId")
	public String getSenderId() {
		return senderId;
	}

	@JsonProperty("senderId")
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@JsonProperty("receiverId")
	public String getReceiverId() {
		return receiverId;
	}

	@JsonProperty("receiverId")
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	@JsonProperty("processingCode")
	public String getProcessingCode() {
		return processingCode;
	}

	@JsonProperty("processingCode")
	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	@JsonProperty("operationCode")
	public String getOperationCode() {
		return operationCode;
	}

	@JsonProperty("operationCode")
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	@JsonProperty("data")
	public Map<String, Object> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@JsonProperty("signature")
	public String getSignature() {
		return signature;
	}

	@JsonProperty("signature")
	public void setSignature(String signature) {
		this.signature = signature;
	}

	



}
