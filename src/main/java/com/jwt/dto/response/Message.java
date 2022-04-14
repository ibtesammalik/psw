package com.jwt.dto.response;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"code",
	"description"	
})
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4916238803145591418L;

	@JsonProperty("code")
	private String code;
	@JsonProperty("description")
	private String description;


	public Message(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}



}
