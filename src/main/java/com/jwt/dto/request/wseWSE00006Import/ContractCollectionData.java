
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
    "docAgainstPayPercentage",
    "docAgainstAcceptancePercentage",
    "days",
    "totalPercentage"
})
@Generated("jsonschema2pojo")
public class ContractCollectionData implements Serializable
{

    @JsonProperty("advPayPercentage")
    private Integer advPayPercentage;
    @JsonProperty("docAgainstPayPercentage")
    private Integer docAgainstPayPercentage;
    @JsonProperty("docAgainstAcceptancePercentage")
    private Integer docAgainstAcceptancePercentage;
    @JsonProperty("days")
    private Integer days;
    @JsonProperty("totalPercentage")
    private Integer totalPercentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4463244647879540479L;

    @JsonProperty("advPayPercentage")
    public Integer getAdvPayPercentage() {
        return advPayPercentage;
    }

    @JsonProperty("advPayPercentage")
    public void setAdvPayPercentage(Integer advPayPercentage) {
        this.advPayPercentage = advPayPercentage;
    }

    @JsonProperty("docAgainstPayPercentage")
    public Integer getDocAgainstPayPercentage() {
        return docAgainstPayPercentage;
    }

    @JsonProperty("docAgainstPayPercentage")
    public void setDocAgainstPayPercentage(Integer docAgainstPayPercentage) {
        this.docAgainstPayPercentage = docAgainstPayPercentage;
    }

    @JsonProperty("docAgainstAcceptancePercentage")
    public Integer getDocAgainstAcceptancePercentage() {
        return docAgainstAcceptancePercentage;
    }

    @JsonProperty("docAgainstAcceptancePercentage")
    public void setDocAgainstAcceptancePercentage(Integer docAgainstAcceptancePercentage) {
        this.docAgainstAcceptancePercentage = docAgainstAcceptancePercentage;
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
