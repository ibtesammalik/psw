
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
import com.jwt.dto.request.wseWSE00006Import.OpenAccountData;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exporterNtn",
    "exporterName",
    "exporterIban",
    "modeOfPayment",
    "finInsUniqueNumber",
    "contractCollectionData",
    "lcData",
    "paymentInformation",
    "itemInformation"
})
@Generated("jsonschema2pojo")
public class FinancialInstrumentInfo implements Serializable
{

    @JsonProperty("exporterNtn")
    private String exporterNtn;
    @JsonProperty("exporterName")
    private String exporterName;
    @JsonProperty("exporterIban")
    private String exporterIban;
    @JsonProperty("modeOfPayment")
    private String modeOfPayment;
    @JsonProperty("finInsUniqueNumber")
    private String finInsUniqueNumber;
    @JsonProperty("contractCollectionData")
    private ContractCollectionData contractCollectionData;
    @JsonProperty("lcData")
    private LcData lcData;
    @JsonProperty("OpenAccountData")
    private OpenAccountData openAccountData;
    @JsonProperty("paymentInformation")
    private PaymentInformation paymentInformation;
    @JsonProperty("itemInformation")
    private List<ItemInformationFinancialInf> itemInformation = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5786944184820312208L;

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

    @JsonProperty("exporterIban")
    public String getExporterIban() {
        return exporterIban;
    }

    @JsonProperty("exporterIban")
    public void setExporterIban(String exporterIban) {
        this.exporterIban = exporterIban;
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
    public List<ItemInformationFinancialInf> getItemInformation() {
        return itemInformation;
    }

    @JsonProperty("itemInformation")
    public void setItemInformation(List<ItemInformationFinancialInf> itemInformation) {
        this.itemInformation = itemInformation;
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
