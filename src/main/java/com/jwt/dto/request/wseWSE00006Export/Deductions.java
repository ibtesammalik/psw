
package com.jwt.dto.request.wseWSE00006Export;

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
    "foreignBankChargesFcy",
    "agentCommissionFcy",
    "withholdingTaxPkr",
    "edsPkr"
})
@Generated("jsonschema2pojo")
public class Deductions implements Serializable
{

    @JsonProperty("foreignBankChargesFcy")
    private Double foreignBankChargesFcy;
    @JsonProperty("agentCommissionFcy")
    private Double agentCommissionFcy;
    @JsonProperty("withholdingTaxPkr")
    private Double withholdingTaxPkr;
    @JsonProperty("edsPkr")
    private Double edsPkr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2100537486796199749L;

    @JsonProperty("foreignBankChargesFcy")
    public Double getForeignBankChargesFcy() {
        return foreignBankChargesFcy;
    }

    @JsonProperty("foreignBankChargesFcy")
    public void setForeignBankChargesFcy(Double foreignBankChargesFcy) {
        this.foreignBankChargesFcy = foreignBankChargesFcy;
    }

    @JsonProperty("agentCommissionFcy")
    public Double getAgentCommissionFcy() {
        return agentCommissionFcy;
    }

    @JsonProperty("agentCommissionFcy")
    public void setAgentCommissionFcy(Double agentCommissionFcy) {
        this.agentCommissionFcy = agentCommissionFcy;
    }

    @JsonProperty("withholdingTaxPkr")
    public Double getWithholdingTaxPkr() {
        return withholdingTaxPkr;
    }

    @JsonProperty("withholdingTaxPkr")
    public void setWithholdingTaxPkr(Double withholdingTaxPkr) {
        this.withholdingTaxPkr = withholdingTaxPkr;
    }

    @JsonProperty("edsPkr")
    public Double getEdsPkr() {
        return edsPkr;
    }

    @JsonProperty("edsPkr")
    public void setEdsPkr(Double edsPkr) {
        this.edsPkr = edsPkr;
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
