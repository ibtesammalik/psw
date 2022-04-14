
package com.jwt.dto.request.wse00004;

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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jwt.dto.request.DataSerializerUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Generated("jsonschema2pojo")
public class FinancialInformation implements Serializable
{

    @JsonProperty("financialInstrument")
    private List<FinancialInstrument> financialInstrument = null;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("totalDeclaredValue")
    
    private Double totalDeclaredValue;
    @JsonProperty("invoiceNumber")
    private String invoiceNumber;
    @JsonProperty("invoiceDate")
    private String invoiceDate;
    @JsonProperty("deliveryTerm")
    private String deliveryTerm;
    @JsonProperty("fobValueUsd")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double fobValueUsd;
    @JsonProperty("freightUsd")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double freightUsd;
    @JsonProperty("cfrValueUsd")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double cfrValueUsd;
    @JsonProperty("insuranceUsd")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double insuranceUsd;
    @JsonProperty("landingChargesUsd")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double landingChargesUsd;
    @JsonProperty("assessedValueUsd")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double assessedValueUsd;
    @JsonProperty("OtherCharges")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double otherCharges;
    @JsonProperty("exchangeRate")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double exchangeRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5791194515655798533L;

    @JsonProperty("financialInstrument")
    public List<FinancialInstrument> getFinancialInstrument() {
        return financialInstrument;
    }

    @JsonProperty("financialInstrument")
    public void setFinancialInstrument(List<FinancialInstrument> financialInstrument) {
        this.financialInstrument = financialInstrument;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("totalDeclaredValue")
    public Double getTotalDeclaredValue() {
        return totalDeclaredValue;
    }

    @JsonProperty("totalDeclaredValue")
    public void setTotalDeclaredValue(Double totalDeclaredValue) {
        this.totalDeclaredValue = totalDeclaredValue;
    }

    @JsonProperty("invoiceNumber")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("invoiceNumber")
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonProperty("invoiceDate")
    public String getInvoiceDate() {
        return invoiceDate;
    }

    @JsonProperty("invoiceDate")
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @JsonProperty("deliveryTerm")
    public String getDeliveryTerm() {
        return deliveryTerm;
    }

    @JsonProperty("deliveryTerm")
    public void setDeliveryTerm(String deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }

    @JsonProperty("fobValueUsd")
    public Double getFobValueUsd() {
        return fobValueUsd;
    }

    @JsonProperty("fobValueUsd")
    public void setFobValueUsd(Double fobValueUsd) {
        this.fobValueUsd = fobValueUsd;
    }

    @JsonProperty("freightUsd")
    public Double getFreightUsd() {
        return freightUsd;
    }

    @JsonProperty("freightUsd")
    public void setFreightUsd(Double freightUsd) {
        this.freightUsd = freightUsd;
    }

    @JsonProperty("cfrValueUsd")
    public Double getCfrValueUsd() {
        return cfrValueUsd;
    }

    @JsonProperty("cfrValueUsd")
    public void setCfrValueUsd(Double cfrValueUsd) {
        this.cfrValueUsd = cfrValueUsd;
    }

    @JsonProperty("insuranceUsd")
    public Double getInsuranceUsd() {
        return insuranceUsd;
    }

    @JsonProperty("insuranceUsd")
    public void setInsuranceUsd(Double insuranceUsd) {
        this.insuranceUsd = insuranceUsd;
    }

    @JsonProperty("landingChargesUsd")
    public Double getLandingChargesUsd() {
        return landingChargesUsd;
    }

    @JsonProperty("landingChargesUsd")
    public void setLandingChargesUsd(Double landingChargesUsd) {
        this.landingChargesUsd = landingChargesUsd;
    }

    @JsonProperty("assessedValueUsd")
    public Double getAssessedValueUsd() {
        return assessedValueUsd;
    }

    @JsonProperty("assessedValueUsd")
    public void setAssessedValueUsd(Double assessedValueUsd) {
        this.assessedValueUsd = assessedValueUsd;
    }

    @JsonProperty("OtherCharges")
    public Double getOtherCharges() {
        return otherCharges;
    }

    @JsonProperty("OtherCharges")
    public void setOtherCharges(Double otherCharges) {
        this.otherCharges = otherCharges;
    }

    @JsonProperty("exchangeRate")
    public Double getExchangeRate() {
        return exchangeRate;
    }

    @JsonProperty("exchangeRate")
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
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
