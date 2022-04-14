
package com.jwt.dto.request.wse00004;

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

@Generated("jsonschema2pojo")
public class ConsignorConsigneeInfo implements Serializable
{

    @JsonProperty("ntnFtn")
    private String ntnFtn;
    @JsonProperty("strn")
    private String strn;
    @JsonProperty("consigneeName")
    private String consigneeName;
    @JsonProperty("consigneeAddress")
    private String consigneeAddress;
    @JsonProperty("consignorName")
    private String consignorName;
    @JsonProperty("consignorAddress")
    private String consignorAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6553298175740439425L;

    @JsonProperty("ntnFtn")
    public String getNtnFtn() {
        return ntnFtn;
    }

    @JsonProperty("ntnFtn")
    public void setNtnFtn(String ntnFtn) {
        this.ntnFtn = ntnFtn;
    }

    @JsonProperty("strn")
    public String getStrn() {
        return strn;
    }

    @JsonProperty("strn")
    public void setStrn(String strn) {
        this.strn = strn;
    }

    @JsonProperty("consigneeName")
    public String getConsigneeName() {
        return consigneeName;
    }

    @JsonProperty("consigneeName")
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    @JsonProperty("consigneeAddress")
    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    @JsonProperty("consigneeAddress")
    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    @JsonProperty("consignorName")
    public String getConsignorName() {
        return consignorName;
    }

    @JsonProperty("consignorName")
    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
    }

    @JsonProperty("consignorAddress")
    public String getConsignorAddress() {
        return consignorAddress;
    }

    @JsonProperty("consignorAddress")
    public void setConsignorAddress(String consignorAddress) {
        this.consignorAddress = consignorAddress;
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
