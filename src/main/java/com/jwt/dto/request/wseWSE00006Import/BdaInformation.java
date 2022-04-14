
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
    "totalBdaAmountFcy",
    "totalBdaAmountCurrency",
    "sampleAmountExclude",
    "sampleAmountCurrency",
    "netBdaAmountFcy",
    "netBdaAmountCurrency",
    "exchangeRateFcy",
    "netBdaAmountPkr",
    "amountInWords",
    "currencyFcy",
    "bdaAmountFcy",
    "bdaAmountPkr",
    "bdaDocumentRefNumber",
    "commisionAmountFcy",
    "commisionAmountPkr",
    "fedFcy",
    "fedAmountPkr",
    "swiftChargesPkr",
    "otherChargesPkr",
    "remarks",
    "balanceBdaAmountFcy"
})
@Generated("jsonschema2pojo")
public class BdaInformation implements Serializable
{

    @JsonProperty("totalBdaAmountFcy")
    private Double totalBdaAmountFcy;
    @JsonProperty("totalBdaAmountCurrency")
    private String totalBdaAmountCurrency;
    @JsonProperty("sampleAmountExclude")
    private Double sampleAmountExclude;
    @JsonProperty("sampleAmountCurrency")
    private String sampleAmountCurrency;
    @JsonProperty("netBdaAmountFcy")
    private Double netBdaAmountFcy;
    @JsonProperty("netBdaAmountCurrency")
    private String netBdaAmountCurrency;
    @JsonProperty("exchangeRateFiFcy")
    private Double exchangeRateFiFcy;
    @JsonProperty("netBdaAmountPkr")
    private Double netBdaAmountPkr;
    @JsonProperty("amountInWords")
    private String amountInWords;
    @JsonProperty("currencyFcy")
    private String currencyFcy;
    @JsonProperty("exchangeRateFcy")
    private Double exchangeRateFcy;
    @JsonProperty("bdaAmountFcy")
    private Double bdaAmountFcy;
    @JsonProperty("bdaAmountPkr")
    private Double bdaAmountPkr;
    @JsonProperty("bdaDocumentRefNumber")
    private String bdaDocumentRefNumber;
    @JsonProperty("commisionAmountFcy")
    private Double commisionAmountFcy;
    @JsonProperty("commisionAmountPkr")
    private Double commisionAmountPkr;
    @JsonProperty("fedFcy")
    private Double fedFcy;
    @JsonProperty("fedAmountPkr")
    private Double fedAmountPkr;
    @JsonProperty("swiftChargesPkr")
    private Double swiftChargesPkr;
    @JsonProperty("otherChargesPkr")
    private Double otherChargesPkr;
    @JsonProperty("remarks")
    private String remarks;
    @JsonProperty("balanceBdaAmountFcy")
    private Double balanceBdaAmountFcy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4611933644234945339L;

    @JsonProperty("totalBdaAmountFcy")
    public Double getTotalBdaAmountFcy() {
        return totalBdaAmountFcy;
    }

    @JsonProperty("totalBdaAmountFcy")
    public void setTotalBdaAmountFcy(Double totalBdaAmountFcy) {
        this.totalBdaAmountFcy = totalBdaAmountFcy;
    }

    @JsonProperty("totalBdaAmountCurrency")
    public String getTotalBdaAmountCurrency() {
        return totalBdaAmountCurrency;
    }

    @JsonProperty("totalBdaAmountCurrency")
    public void setTotalBdaAmountCurrency(String totalBdaAmountCurrency) {
        this.totalBdaAmountCurrency = totalBdaAmountCurrency;
    }

    @JsonProperty("sampleAmountExclude")
    public Double getSampleAmountExclude() {
        return sampleAmountExclude;
    }

    @JsonProperty("sampleAmountExclude")
    public void setSampleAmountExclude(Double sampleAmountExclude) {
        this.sampleAmountExclude = sampleAmountExclude;
    }

    @JsonProperty("sampleAmountCurrency")
    public String getSampleAmountCurrency() {
        return sampleAmountCurrency;
    }

    @JsonProperty("sampleAmountCurrency")
    public void setSampleAmountCurrency(String sampleAmountCurrency) {
        this.sampleAmountCurrency = sampleAmountCurrency;
    }

    @JsonProperty("netBdaAmountFcy")
    public Double getNetBdaAmountFcy() {
        return netBdaAmountFcy;
    }

    @JsonProperty("netBdaAmountFcy")
    public void setNetBdaAmountFcy(Double netBdaAmountFcy) {
        this.netBdaAmountFcy = netBdaAmountFcy;
    }

    @JsonProperty("netBdaAmountCurrency")
    public String getNetBdaAmountCurrency() {
        return netBdaAmountCurrency;
    }

    @JsonProperty("netBdaAmountCurrency")
    public void setNetBdaAmountCurrency(String netBdaAmountCurrency) {
        this.netBdaAmountCurrency = netBdaAmountCurrency;
    }

    @JsonProperty("exchangeRateFiFcy")
    public Double getExchangeRateFiFcy() {
		return exchangeRateFiFcy;
	}

    @JsonProperty("exchangeRateFiFcy")
	public void setExchangeRateFiFcy(Double exchangeRateFiFcy) {
		this.exchangeRateFiFcy = exchangeRateFiFcy;
	}
	
    
    @JsonProperty("netBdaAmountPkr")
    public Double getNetBdaAmountPkr() {
        return netBdaAmountPkr;
    }

    @JsonProperty("netBdaAmountPkr")
    public void setNetBdaAmountPkr(Double netBdaAmountPkr) {
        this.netBdaAmountPkr = netBdaAmountPkr;
    }

    @JsonProperty("amountInWords")
    public String getAmountInWords() {
        return amountInWords;
    }

    @JsonProperty("amountInWords")
    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    @JsonProperty("currencyFcy")
    public String getCurrencyFcy() {
        return currencyFcy;
    }

    @JsonProperty("currencyFcy")
    public void setCurrencyFcy(String currencyFcy) {
        this.currencyFcy = currencyFcy;
    }

    @JsonProperty("exchangeRateFcy")
    public Double getExchangeRateFcy() {
        return exchangeRateFcy;
    }

    @JsonProperty("exchangeRateFcy")
    public void setExchangeRateFcy(Double exchangeRateFcy) {
        this.exchangeRateFcy = exchangeRateFcy;
    }


	@JsonProperty("bdaAmountFcy")
    public Double getBdaAmountFcy() {
        return bdaAmountFcy;
    }

    @JsonProperty("bdaAmountFcy")
    public void setBdaAmountFcy(Double bdaAmountFcy) {
        this.bdaAmountFcy = bdaAmountFcy;
    }

    @JsonProperty("bdaAmountPkr")
    public Double getBdaAmountPkr() {
        return bdaAmountPkr;
    }

    @JsonProperty("bdaAmountPkr")
    public void setBdaAmountPkr(Double bdaAmountPkr) {
        this.bdaAmountPkr = bdaAmountPkr;
    }

    @JsonProperty("bdaDocumentRefNumber")
    public String getBdaDocumentRefNumber() {
        return bdaDocumentRefNumber;
    }

    @JsonProperty("bdaDocumentRefNumber")
    public void setBdaDocumentRefNumber(String bdaDocumentRefNumber) {
        this.bdaDocumentRefNumber = bdaDocumentRefNumber;
    }

    @JsonProperty("commisionAmountFcy")
    public Double getCommisionAmountFcy() {
        return commisionAmountFcy;
    }

    @JsonProperty("commisionAmountFcy")
    public void setCommisionAmountFcy(Double commisionAmountFcy) {
        this.commisionAmountFcy = commisionAmountFcy;
    }

    @JsonProperty("commisionAmountPkr")
    public Double getCommisionAmountPkr() {
        return commisionAmountPkr;
    }

    @JsonProperty("commisionAmountPkr")
    public void setCommisionAmountPkr(Double commisionAmountPkr) {
        this.commisionAmountPkr = commisionAmountPkr;
    }

    @JsonProperty("fedFcy")
    public Double getFedFcy() {
        return fedFcy;
    }

    @JsonProperty("fedFcy")
    public void setFedFcy(Double fedFcy) {
        this.fedFcy = fedFcy;
    }

    @JsonProperty("fedAmountPkr")
    public Double getFedAmountPkr() {
        return fedAmountPkr;
    }

    @JsonProperty("fedAmountPkr")
    public void setFedAmountPkr(Double fedAmountPkr) {
        this.fedAmountPkr = fedAmountPkr;
    }

    @JsonProperty("swiftChargesPkr")
    public Double getSwiftChargesPkr() {
        return swiftChargesPkr;
    }

    @JsonProperty("swiftChargesPkr")
    public void setSwiftChargesPkr(Double swiftChargesPkr) {
        this.swiftChargesPkr = swiftChargesPkr;
    }

    @JsonProperty("otherChargesPkr")
    public Double getOtherChargesPkr() {
        return otherChargesPkr;
    }

    @JsonProperty("otherChargesPkr")
    public void setOtherChargesPkr(Double otherChargesPkr) {
        this.otherChargesPkr = otherChargesPkr;
    }

    @JsonProperty("remarks")
    public String getRemarks() {
        return remarks;
    }

    @JsonProperty("remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonProperty("balanceBdaAmountFcy")
    public Double getBalanceBdaAmountFcy() {
        return balanceBdaAmountFcy;
    }

    @JsonProperty("balanceBdaAmountFcy")
    public void setBalanceBdaAmountFcy(Double balanceBdaAmountFcy) {
        this.balanceBdaAmountFcy = balanceBdaAmountFcy;
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
