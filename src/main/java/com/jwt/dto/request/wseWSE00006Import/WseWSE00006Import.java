
package com.jwt.dto.request.wseWSE00006Import;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    "data",
    "signature"
})
@Generated("jsonschema2pojo")
public class WseWSE00006Import implements Serializable
{

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
    @JsonProperty("data")
    private Data data;
    @JsonProperty("signature")
    private String signature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5515245183273840169L;

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

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
