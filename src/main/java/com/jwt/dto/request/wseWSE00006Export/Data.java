
package com.jwt.dto.request.wseWSE00006Export;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "cobUniqueIdNumber",
    "tradeTranType",
    "financialInstrumentInfo",
    "gdInfo",
    "bankAdviceInfo"
})
@Generated("jsonschema2pojo")
public class Data implements Serializable
{

    @JsonProperty("cobUniqueIdNumber")
    private String cobUniqueIdNumber;
    @JsonProperty("tradeTranType")
    private String tradeTranType;
    @JsonProperty("financialInstrumentInfo")
    private FinancialInstrumentInfo financialInstrumentInfo;
    @JsonProperty("gdInfo")
    private List<GdInfo> gdInfo = null;
    @JsonProperty("bankAdviceInfo")
    private List<BankAdviceInfo> bankAdviceInfo = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8003946309080755011L;

    @JsonProperty("cobUniqueIdNumber")
    public String getCobUniqueIdNumber() {
        return cobUniqueIdNumber;
    }

    @JsonProperty("cobUniqueIdNumber")
    public void setCobUniqueIdNumber(String cobUniqueIdNumber) {
        this.cobUniqueIdNumber = cobUniqueIdNumber;
    }

    @JsonProperty("tradeTranType")
    public String getTradeTranType() {
        return tradeTranType;
    }

    @JsonProperty("tradeTranType")
    public void setTradeTranType(String tradeTranType) {
        this.tradeTranType = tradeTranType;
    }

    @JsonProperty("financialInstrumentInfo")
    public FinancialInstrumentInfo getFinancialInstrumentInfo() {
        return financialInstrumentInfo;
    }

    @JsonProperty("financialInstrumentInfo")
    public void setFinancialInstrumentInfo(FinancialInstrumentInfo financialInstrumentInfo) {
        this.financialInstrumentInfo = financialInstrumentInfo;
    }

    @JsonProperty("gdInfo")
    public List<GdInfo> getGdInfo() {
        return gdInfo;
    }

    @JsonProperty("gdInfo")
    public void setGdInfo(List<GdInfo> gdInfo) {
        this.gdInfo = gdInfo;
    }

    @JsonProperty("bankAdviceInfo")
    public List<BankAdviceInfo> getBankAdviceInfo() {
        return bankAdviceInfo;
    }

    @JsonProperty("bankAdviceInfo")
    public void setBankAdviceInfo(List<BankAdviceInfo> bankAdviceInfo) {
        this.bankAdviceInfo = bankAdviceInfo;
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
