
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
    "consigneeName",
    "consigneeAddress",
    "consigneeCountry",
    "consigneeIban",
    "portOfDischarge",
    "deliveryTerms",
    " financialInstrumentCurrency",
    "financialInstrumentValue",
    "expiryDate"
})
@Generated("jsonschema2pojo")
public class PaymentInformation implements Serializable
{

    @JsonProperty("consigneeName")
    private String consigneeName;
    @JsonProperty("consigneeAddress")
    private String consigneeAddress;
    @JsonProperty("consigneeCountry")
    private String consigneeCountry;
    @JsonProperty("consigneeIban")
    private String consigneeIban;
    @JsonProperty("portOfDischarge")
    private String portOfDischarge;
    @JsonProperty("deliveryTerms")
    private String deliveryTerms;
    @JsonProperty(" financialInstrumentCurrency")
    private String financialInstrumentCurrency;
    @JsonProperty("financialInstrumentValue")
    private Double financialInstrumentValue;
    @JsonProperty("expiryDate")
    private String expiryDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6707664446586282425L;

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

    @JsonProperty("consigneeCountry")
    public String getConsigneeCountry() {
        return consigneeCountry;
    }

    @JsonProperty("consigneeCountry")
    public void setConsigneeCountry(String consigneeCountry) {
        this.consigneeCountry = consigneeCountry;
    }

    @JsonProperty("consigneeIban")
    public String getConsigneeIban() {
        return consigneeIban;
    }

    @JsonProperty("consigneeIban")
    public void setConsigneeIban(String consigneeIban) {
        this.consigneeIban = consigneeIban;
    }

    @JsonProperty("portOfDischarge")
    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    @JsonProperty("portOfDischarge")
    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    @JsonProperty("deliveryTerms")
    public String getDeliveryTerms() {
        return deliveryTerms;
    }

    @JsonProperty("deliveryTerms")
    public void setDeliveryTerms(String deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    @JsonProperty(" financialInstrumentCurrency")
    public String getFinancialInstrumentCurrency() {
        return financialInstrumentCurrency;
    }

    @JsonProperty(" financialInstrumentCurrency")
    public void setFinancialInstrumentCurrency(String financialInstrumentCurrency) {
        this.financialInstrumentCurrency = financialInstrumentCurrency;
    }

    @JsonProperty("financialInstrumentValue")
    public Double getFinancialInstrumentValue() {
        return financialInstrumentValue;
    }

    @JsonProperty("financialInstrumentValue")
    public void setFinancialInstrumentValue(Double financialInstrumentValue) {
        this.financialInstrumentValue = financialInstrumentValue;
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
