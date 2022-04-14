package com.jwt.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"messageId",
	"timestamp",
	"senderId",
	"receiverId",
	"processingCode",
	"message"	
})
public class ResponseViewMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 913571053220639061L;

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
	@JsonProperty("message")
	private Message message;
	

	public ResponseViewMessage(String messageId, String timestamp, String senderId, String receiverId,
			String processingCode, Message message) {
		super();
		this.messageId = messageId;
		this.timestamp = timestamp;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.processingCode = processingCode;
		this.message = message;
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

	
	@JsonProperty("message")
	public Message getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(Message message) {
		this.message = message;
	}

	
}
