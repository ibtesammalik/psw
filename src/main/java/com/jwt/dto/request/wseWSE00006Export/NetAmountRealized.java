
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
    "bcaFc",
    "fcyExchangeRate",
    "bcaPkr",
    "dateOfRealized",
    "adjustFromSpecialFcyAcc",
    "isFinInsCurrencyDiff",
    "currency",
    "isRemAmtSettledWithDiscount",
    "totalBcaAmount",
    "amountRealized",
    "balance",
    "allowedDiscount",
    "allowedDiscountPercentage"
})
@Generated("jsonschema2pojo")
public class NetAmountRealized implements Serializable
{

    @JsonProperty("bcaFc")
    private Double bcaFc;
    @JsonProperty("fcyExchangeRate")
    private Double fcyExchangeRate;
    @JsonProperty("bcaPkr")
    private Double bcaPkr;
    @JsonProperty("dateOfRealized")
    private String dateOfRealized;
    @JsonProperty("adjustFromSpecialFcyAcc")
    private Double adjustFromSpecialFcyAcc;
    @JsonProperty("isFinInsCurrencyDiff")
    private String isFinInsCurrencyDiff;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isRemAmtSettledWithDiscount")
    private String isRemAmtSettledWithDiscount;
    @JsonProperty("totalBcaAmount")
    private Double totalBcaAmount;
    @JsonProperty("amountRealized")
    private Double amountRealized;
    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("allowedDiscount")
    private Double allowedDiscount;
    @JsonProperty("allowedDiscountPercentage")
    private Integer allowedDiscountPercentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6307491733005584564L;

    @JsonProperty("bcaFc")
    public Double getBcaFc() {
        return bcaFc;
    }

    @JsonProperty("bcaFc")
    public void setBcaFc(Double bcaFc) {
        this.bcaFc = bcaFc;
    }

    @JsonProperty("fcyExchangeRate")
    public Double getFcyExchangeRate() {
        return fcyExchangeRate;
    }

    @JsonProperty("fcyExchangeRate")
    public void setFcyExchangeRate(Double fcyExchangeRate) {
        this.fcyExchangeRate = fcyExchangeRate;
    }

    @JsonProperty("bcaPkr")
    public Double getBcaPkr() {
        return bcaPkr;
    }

    @JsonProperty("bcaPkr")
    public void setBcaPkr(Double bcaPkr) {
        this.bcaPkr = bcaPkr;
    }

    @JsonProperty("dateOfRealized")
    public String getDateOfRealized() {
        return dateOfRealized;
    }

    @JsonProperty("dateOfRealized")
    public void setDateOfRealized(String dateOfRealized) {
        this.dateOfRealized = dateOfRealized;
    }

    @JsonProperty("adjustFromSpecialFcyAcc")
    public Double getAdjustFromSpecialFcyAcc() {
        return adjustFromSpecialFcyAcc;
    }

    @JsonProperty("adjustFromSpecialFcyAcc")
    public void setAdjustFromSpecialFcyAcc(Double adjustFromSpecialFcyAcc) {
        this.adjustFromSpecialFcyAcc = adjustFromSpecialFcyAcc;
    }

    @JsonProperty("isFinInsCurrencyDiff")
    public String getIsFinInsCurrencyDiff() {
        return isFinInsCurrencyDiff;
    }

    @JsonProperty("isFinInsCurrencyDiff")
    public void setIsFinInsCurrencyDiff(String isFinInsCurrencyDiff) {
        this.isFinInsCurrencyDiff = isFinInsCurrencyDiff;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("isRemAmtSettledWithDiscount")
    public String getIsRemAmtSettledWithDiscount() {
        return isRemAmtSettledWithDiscount;
    }

    @JsonProperty("isRemAmtSettledWithDiscount")
    public void setIsRemAmtSettledWithDiscount(String isRemAmtSettledWithDiscount) {
        this.isRemAmtSettledWithDiscount = isRemAmtSettledWithDiscount;
    }

    @JsonProperty("totalBcaAmount")
    public Double getTotalBcaAmount() {
        return totalBcaAmount;
    }

    @JsonProperty("totalBcaAmount")
    public void setTotalBcaAmount(Double totalBcaAmount) {
        this.totalBcaAmount = totalBcaAmount;
    }

    @JsonProperty("amountRealized")
    public Double getAmountRealized() {
        return amountRealized;
    }

    @JsonProperty("amountRealized")
    public void setAmountRealized(Double amountRealized) {
        this.amountRealized = amountRealized;
    }

    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @JsonProperty("allowedDiscount")
    public Double getAllowedDiscount() {
        return allowedDiscount;
    }

    @JsonProperty("allowedDiscount")
    public void setAllowedDiscount(Double allowedDiscount) {
        this.allowedDiscount = allowedDiscount;
    }

    @JsonProperty("allowedDiscountPercentage")
    public Integer getAllowedDiscountPercentage() {
        return allowedDiscountPercentage;
    }

    @JsonProperty("allowedDiscountPercentage")
    public void setAllowedDiscountPercentage(Integer allowedDiscountPercentage) {
        this.allowedDiscountPercentage = allowedDiscountPercentage;
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
