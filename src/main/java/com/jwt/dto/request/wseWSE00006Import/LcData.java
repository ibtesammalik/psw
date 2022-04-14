
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
    "advPayPercentage",
    "sightPercentage",
    "usancePercentage",
    "days",
    "totalPercentage"
})
@Generated("jsonschema2pojo")
public class LcData implements Serializable
{

    @JsonProperty("advPayPercentage")
    private Integer advPayPercentage;
    @JsonProperty("sightPercentage")
    private Integer sightPercentage;
    @JsonProperty("usancePercentage")
    private Integer usancePercentage;
    @JsonProperty("days")
    private Integer days;
    @JsonProperty("totalPercentage")
    private Integer totalPercentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5501464039840522043L;

    @JsonProperty("advPayPercentage")
    public Integer getAdvPayPercentage() {
        return advPayPercentage;
    }

    @JsonProperty("advPayPercentage")
    public void setAdvPayPercentage(Integer advPayPercentage) {
        this.advPayPercentage = advPayPercentage;
    }

    @JsonProperty("sightPercentage")
    public Integer getSightPercentage() {
        return sightPercentage;
    }

    @JsonProperty("sightPercentage")
    public void setSightPercentage(Integer sightPercentage) {
        this.sightPercentage = sightPercentage;
    }

    @JsonProperty("usancePercentage")
    public Integer getUsancePercentage() {
        return usancePercentage;
    }

    @JsonProperty("usancePercentage")
    public void setUsancePercentage(Integer usancePercentage) {
        this.usancePercentage = usancePercentage;
    }

    @JsonProperty("days")
    public Integer getDays() {
        return days;
    }

    @JsonProperty("days")
    public void setDays(Integer days) {
        this.days = days;
    }

    @JsonProperty("totalPercentage")
    public Integer getTotalPercentage() {
        return totalPercentage;
    }

    @JsonProperty("totalPercentage")
    public void setTotalPercentage(Integer totalPercentage) {
        this.totalPercentage = totalPercentage;
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
