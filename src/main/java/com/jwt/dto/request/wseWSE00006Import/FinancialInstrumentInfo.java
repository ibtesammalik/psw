
package com.jwt.dto.request.wseWSE00006Import;

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
    "importerNtn",
    "importerName",
    "importerIban",
    "modeOfPayment",
    "finInsUniqueNumber",
    "contractCollectionData",
    "lcData",
    "cashMargin",
    "paymentInformation",
    "itemInformation",
    "financialTranInformation",
    "remarks"
})
@Generated("jsonschema2pojo")
public class FinancialInstrumentInfo implements Serializable
{

    @JsonProperty("importerNtn")
    private String importerNtn;
    @JsonProperty("importerName")
    private String importerName;
    @JsonProperty("importerIban")
    private String importerIban;
    @JsonProperty("modeOfPayment")
    private String modeOfPayment;
    @JsonProperty("finInsUniqueNumber")
    private String finInsUniqueNumber;
    @JsonProperty("contractCollectionData")
    private ContractCollectionData contractCollectionData;
    @JsonProperty("lcData")
    private LcData lcData;
    @JsonProperty("cashMargin")
    private CashMargin cashMargin;
    @JsonProperty("OpenAccountData")
    private OpenAccountData openAccountData;
    @JsonProperty("paymentInformation")
    private PaymentInformation paymentInformation;
    @JsonProperty("itemInformation")
    private List<ItemInformationFinancalInst> itemInformation = null;
    @JsonProperty("financialTranInformation")
    private FinancialTranInformation financialTranInformation;
    @JsonProperty("remarks")
    private String remarks;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5496496947796618037L;

    @JsonProperty("importerNtn")
    public String getImporterNtn() {
        return importerNtn;
    }

    @JsonProperty("importerNtn")
    public void setImporterNtn(String importerNtn) {
        this.importerNtn = importerNtn;
    }

    @JsonProperty("importerName")
    public String getImporterName() {
        return importerName;
    }

    @JsonProperty("importerName")
    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    @JsonProperty("importerIban")
    public String getImporterIban() {
        return importerIban;
    }

    @JsonProperty("importerIban")
    public void setImporterIban(String importerIban) {
        this.importerIban = importerIban;
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

    @JsonProperty("contractCollectionData")
    public ContractCollectionData getContractCollectionData() {
        return contractCollectionData;
    }

    @JsonProperty("contractCollectionData")
    public void setContractCollectionData(ContractCollectionData contractCollectionData) {
        this.contractCollectionData = contractCollectionData;
    }

    @JsonProperty("lcData")
    public LcData getLcData() {
        return lcData;
    }

    @JsonProperty("lcData")
    public void setLcData(LcData lcData) {
        this.lcData = lcData;
    }

    @JsonProperty("cashMargin")
    public CashMargin getCashMargin() {
        return cashMargin;
    }

    @JsonProperty("cashMargin")
    public void setCashMargin(CashMargin cashMargin) {
        this.cashMargin = cashMargin;
    }
    
    @JsonProperty("openAccountData")
    public OpenAccountData getOpenAccountData() {
		return openAccountData;
	}
    
    @JsonProperty("openAccountData")
	public void setOpenAccountData(OpenAccountData openAccountData) {
		this.openAccountData = openAccountData;
	}

	@JsonProperty("paymentInformation")
    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    @JsonProperty("paymentInformation")
    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    @JsonProperty("itemInformation")
    public List<ItemInformationFinancalInst> getItemInformation() {
        return itemInformation;
    }

    @JsonProperty("itemInformation")
    public void setItemInformation(List<ItemInformationFinancalInst> itemInformation) {
        this.itemInformation = itemInformation;
    }

    @JsonProperty("financialTranInformation")
    public FinancialTranInformation getFinancialTranInformation() {
        return financialTranInformation;
    }

    @JsonProperty("financialTranInformation")
    public void setFinancialTranInformation(FinancialTranInformation financialTranInformation) {
        this.financialTranInformation = financialTranInformation;
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
