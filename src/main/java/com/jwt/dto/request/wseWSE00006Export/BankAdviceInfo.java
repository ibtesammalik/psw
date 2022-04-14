
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
    "bcaUniqueIdNumber",
    "iban",
    "gdNumber",
    "exporterNtn",
    "exporterName",
    "modeOfPayment",
    "finInsUniqueNumber",
    "bcaInformation",
    "deductions",
    "netAmountRealized",
    "remarks"
})
@Generated("jsonschema2pojo")
public class BankAdviceInfo implements Serializable
{

    @JsonProperty("bcaUniqueIdNumber")
    private String bcaUniqueIdNumber;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("gdNumber")
    private List<String> gdNumber = null;
    @JsonProperty("exporterNtn")
    private String exporterNtn;
    @JsonProperty("exporterName")
    private String exporterName;
    @JsonProperty("modeOfPayment")
    private String modeOfPayment;
    @JsonProperty("finInsUniqueNumber")
    private String finInsUniqueNumber;
    @JsonProperty("bcaInformation")
    private BcaInformation bcaInformation;
    @JsonProperty("deductions")
    private Deductions deductions;
    @JsonProperty("netAmountRealized")
    private NetAmountRealized netAmountRealized;
    @JsonProperty("remarks")
    private String remarks;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2183783382073340327L;

    @JsonProperty("bcaUniqueIdNumber")
    public String getBcaUniqueIdNumber() {
        return bcaUniqueIdNumber;
    }

    @JsonProperty("bcaUniqueIdNumber")
    public void setBcaUniqueIdNumber(String bcaUniqueIdNumber) {
        this.bcaUniqueIdNumber = bcaUniqueIdNumber;
    }

    @JsonProperty("iban")
    public String getIban() {
        return iban;
    }

    @JsonProperty("iban")
    public void setIban(String iban) {
        this.iban = iban;
    }

    @JsonProperty("gdNumber")
    public List<String> getGdNumber() {
        return gdNumber;
    }

    @JsonProperty("gdNumber")
    public void setGdNumber(List<String> gdNumber) {
        this.gdNumber = gdNumber;
    }

    @JsonProperty("exporterNtn")
    public String getExporterNtn() {
        return exporterNtn;
    }

    @JsonProperty("exporterNtn")
    public void setExporterNtn(String exporterNtn) {
        this.exporterNtn = exporterNtn;
    }

    @JsonProperty("exporterName")
    public String getExporterName() {
        return exporterName;
    }

    @JsonProperty("exporterName")
    public void setExporterName(String exporterName) {
        this.exporterName = exporterName;
    }

    @JsonProperty("modeOfPayment")
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    @JsonProperty("modeOfPayment")
    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    @JsonProperty("finInsUniqueNumber")
    public String getFinInsUniqueNumber() {
        return finInsUniqueNumber;
    }

    @JsonProperty("finInsUniqueNumber")
    public void setFinInsUniqueNumber(String finInsUniqueNumber) {
        this.finInsUniqueNumber = finInsUniqueNumber;
    }

    @JsonProperty("bcaInformation")
    public BcaInformation getBcaInformation() {
        return bcaInformation;
    }

    @JsonProperty("bcaInformation")
    public void setBcaInformation(BcaInformation bcaInformation) {
        this.bcaInformation = bcaInformation;
    }

    @JsonProperty("deductions")
    public Deductions getDeductions() {
        return deductions;
    }

    @JsonProperty("deductions")
    public void setDeductions(Deductions deductions) {
        this.deductions = deductions;
    }

    @JsonProperty("netAmountRealized")
    public NetAmountRealized getNetAmountRealized() {
        return netAmountRealized;
    }

    @JsonProperty("netAmountRealized")
    public void setNetAmountRealized(NetAmountRealized netAmountRealized) {
        this.netAmountRealized = netAmountRealized;
    }

    @JsonProperty("remarks")
    public String getRemarks() {
        return remarks;
    }

    @JsonProperty("remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
