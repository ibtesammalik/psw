
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
    "cashmarginPercentage",
    "cashmarginValue"
})
@Generated("jsonschema2pojo")
public class CashMargin implements Serializable
{

    @JsonProperty("cashmarginPercentage")
    private Integer cashmarginPercentage;
    @JsonProperty("cashmarginValue")
    private Double cashmarginValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4078860543593708489L;

    @JsonProperty("cashmarginPercentage")
    public Integer getCashmarginPercentage() {
        return cashmarginPercentage;
    }

    @JsonProperty("cashmarginPercentage")
    public void setCashmarginPercentage(Integer cashmarginPercentage) {
        this.cashmarginPercentage = cashmarginPercentage;
    }

    @JsonProperty("cashmarginValue")
    public Double getCashmarginValue() {
        return cashmarginValue;
    }

    @JsonProperty("cashmarginValue")
    public void setCashmarginValue(Double cashmarginValue) {
        this.cashmarginValue = cashmarginValue;
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
