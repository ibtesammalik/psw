
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
    "intendedPayDate",
    "transportDocDate",
    "finalDateOfShipment",
    "expiryDate"
})
@Generated("jsonschema2pojo")
public class FinancialTranInformation implements Serializable
{

    @JsonProperty("intendedPayDate")
    private String intendedPayDate;
    @JsonProperty("transportDocDate")
    private String transportDocDate;
    @JsonProperty("finalDateOfShipment")
    private String finalDateOfShipment;
    @JsonProperty("expiryDate")
    private String expiryDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1584031380638356745L;

    @JsonProperty("intendedPayDate")
    public String getIntendedPayDate() {
        return intendedPayDate;
    }

    @JsonProperty("intendedPayDate")
    public void setIntendedPayDate(String intendedPayDate) {
        this.intendedPayDate = intendedPayDate;
    }

    @JsonProperty("transportDocDate")
    public String getTransportDocDate() {
        return transportDocDate;
    }

    @JsonProperty("transportDocDate")
    public void setTransportDocDate(String transportDocDate) {
        this.transportDocDate = transportDocDate;
    }

    @JsonProperty("finalDateOfShipment")
    public String getFinalDateOfShipment() {
        return finalDateOfShipment;
    }

    @JsonProperty("finalDateOfShipment")
    public void setFinalDateOfShipment(String finalDateOfShipment) {
        this.finalDateOfShipment = finalDateOfShipment;
    }

    @JsonProperty("expiryDate")
    public String getExpiryDate() {
        return expiryDate;
    }

    @JsonProperty("expiryDate")
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
