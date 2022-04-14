
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
    "beneficiaryName",
    "beneficiaryAddress",
    "beneficiaryCountry",
    "beneficiaryIban",
    "exporterName",
    "exporterAddress",
    "exporterCountry",
    "portOfShipment",
    "deliveryTerms",
    "financialInstrumentValue",
    "financialInstrumentCurrency",
    "exchangeRate",
    "lcContractNo"
})
@Generated("jsonschema2pojo")
public class PaymentInformation implements Serializable
{

    @JsonProperty("beneficiaryName")
    private String beneficiaryName;
    @JsonProperty("beneficiaryAddress")
    private String beneficiaryAddress;
    @JsonProperty("beneficiaryCountry")
    private String beneficiaryCountry;
    @JsonProperty("beneficiaryIban")
    private String beneficiaryIban;
    @JsonProperty("exporterName")
    private String exporterName;
    @JsonProperty("exporterAddress")
    private String exporterAddress;
    @JsonProperty("exporterCountry")
    private String exporterCountry;
    @JsonProperty("portOfShipment")
    private String portOfShipment;
    @JsonProperty("deliveryTerms")
    private String deliveryTerms;
    @JsonProperty("financialInstrumentValue")
    private Double financialInstrumentValue;
    @JsonProperty("financialInstrumentCurrency")
    private String financialInstrumentCurrency;
    @JsonProperty("exchangeRate")
    private Double exchangeRate;
    @JsonProperty("lcContractNo")
    private String lcContractNo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3033604030562344856L;

    @JsonProperty("beneficiaryName")
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    @JsonProperty("beneficiaryName")
    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    @JsonProperty("beneficiaryAddress")
    public String getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    @JsonProperty("beneficiaryAddress")
    public void setBeneficiaryAddress(String beneficiaryAddress) {
        this.beneficiaryAddress = beneficiaryAddress;
    }

    @JsonProperty("beneficiaryCountry")
    public String getBeneficiaryCountry() {
        return beneficiaryCountry;
    }

    @JsonProperty("beneficiaryCountry")
    public void setBeneficiaryCountry(String beneficiaryCountry) {
        this.beneficiaryCountry = beneficiaryCountry;
    }

    @JsonProperty("beneficiaryIban")
    public String getBeneficiaryIban() {
        return beneficiaryIban;
    }

    @JsonProperty("beneficiaryIban")
    public void setBeneficiaryIban(String beneficiaryIban) {
        this.beneficiaryIban = beneficiaryIban;
    }

    @JsonProperty("exporterName")
    public String getExporterName() {
        return exporterName;
    }

    @JsonProperty("exporterName")
    public void setExporterName(String exporterName) {
        this.exporterName = exporterName;
    }

    @JsonProperty("exporterAddress")
    public String getExporterAddress() {
        return exporterAddress;
    }

    @JsonProperty("exporterAddress")
    public void setExporterAddress(String exporterAddress) {
        this.exporterAddress = exporterAddress;
    }

    @JsonProperty("exporterCountry")
    public String getExporterCountry() {
        return exporterCountry;
    }

    @JsonProperty("exporterCountry")
    public void setExporterCountry(String exporterCountry) {
        this.exporterCountry = exporterCountry;
    }

    @JsonProperty("portOfShipment")
    public String getPortOfShipment() {
        return portOfShipment;
    }

    @JsonProperty("portOfShipment")
    public void setPortOfShipment(String portOfShipment) {
        this.portOfShipment = portOfShipment;
    }

    @JsonProperty("deliveryTerms")
    public String getDeliveryTerms() {
        return deliveryTerms;
    }

    @JsonProperty("deliveryTerms")
    public void setDeliveryTerms(String deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    @JsonProperty("financialInstrumentValue")
    public Double getFinancialInstrumentValue() {
        return financialInstrumentValue;
    }

    @JsonProperty("financialInstrumentValue")
    public void setFinancialInstrumentValue(Double financialInstrumentValue) {
        this.financialInstrumentValue = financialInstrumentValue;
    }

    @JsonProperty("financialInstrumentCurrency")
    public String getFinancialInstrumentCurrency() {
        return financialInstrumentCurrency;
    }

    @JsonProperty("financialInstrumentCurrency")
    public void setFinancialInstrumentCurrency(String financialInstrumentCurrency) {
        this.financialInstrumentCurrency = financialInstrumentCurrency;
    }

    @JsonProperty("exchangeRate")
    public Double getExchangeRate() {
        return exchangeRate;
    }

    @JsonProperty("exchangeRate")
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @JsonProperty("lcContractNo")
    public String getLcContractNo() {
        return lcContractNo;
    }

    @JsonProperty("lcContractNo")
    public void setLcContractNo(String lcContractNo) {
        this.lcContractNo = lcContractNo;
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
