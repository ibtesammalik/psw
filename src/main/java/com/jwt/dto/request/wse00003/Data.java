
package com.jwt.dto.request.wse00003;

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

@Generated("jsonschema2pojo")
public class Data implements Serializable
{

    @JsonProperty("gdNumber")
    private String gdNumber;
    @JsonProperty("consignmentCategory")
    private String consignmentCategory;
    @JsonProperty("gdStatus")
    private String gdStatus;
    @JsonProperty("gdType")
    private String gdType;
    @JsonProperty("collectorate")
    private String collectorate;
    @JsonProperty("blAwbNumber")
    private String blAwbNumber;
    @JsonProperty("blAwbDate")
    private String blAwbDate;
    @JsonProperty("virAirNumber")
    private String virAirNumber;
    @JsonProperty("consignorConsigneeInfo")
    private ConsignorConsigneeInfo consignorConsigneeInfo;
    @JsonProperty("financialInfo")
    private FinancialInfo financialInfo;
    @JsonProperty("generalInformation")
    private GeneralInformation generalInformation;
    @JsonProperty("itemInformation")
    private List<ItemInformation> itemInformation = null;
    @JsonProperty("negativeList")
    private NegativeList negativeList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3694934650806148079L;

    @JsonProperty("gdNumber")
    public String getGdNumber() {
        return gdNumber;
    }

    @JsonProperty("gdNumber")
    public void setGdNumber(String gdNumber) {
        this.gdNumber = gdNumber;
    }

    @JsonProperty("gdStatus")
    public String getGdStatus() {
        return gdStatus;
    }

    @JsonProperty("gdStatus")
    public void setGdStatus(String gdStatus) {
        this.gdStatus = gdStatus;
    }

    @JsonProperty("consignmentCategory")
    public String getConsignmentCategory() {
        return consignmentCategory;
    }

    @JsonProperty("consignmentCategory")
    public void setConsignmentCategory(String consignmentCategory) {
        this.consignmentCategory = consignmentCategory;
    }

    @JsonProperty("gdType")
    public String getGdType() {
        return gdType;
    }

    @JsonProperty("gdType")
    public void setGdType(String gdType) {
        this.gdType = gdType;
    }

    @JsonProperty("collectorate")
    public String getCollectorate() {
        return collectorate;
    }

    @JsonProperty("collectorate")
    public void setCollectorate(String collectorate) {
        this.collectorate = collectorate;
    }

    @JsonProperty("blAwbNumber")
    public String getBlAwbNumber() {
        return blAwbNumber;
    }

    @JsonProperty("blAwbNumber")
    public void setBlAwbNumber(String blAwbNumber) {
        this.blAwbNumber = blAwbNumber;
    }

    @JsonProperty("blAwbDate")
    public String getBlAwbDate() {
        return blAwbDate;
    }

    @JsonProperty("blAwbDate")
    public void setBlAwbDate(String blAwbDate) {
        this.blAwbDate = blAwbDate;
    }

    @JsonProperty("virAirNumber")
    public String getVirAirNumber() {
        return virAirNumber;
    }

    @JsonProperty("virAirNumber")
    public void setVirAirNumber(String virAirNumber) {
        this.virAirNumber = virAirNumber;
    }

    @JsonProperty("consignorConsigneeInfo")
    public ConsignorConsigneeInfo getConsignorConsigneeInfo() {
        return consignorConsigneeInfo;
    }

    @JsonProperty("consignorConsigneeInfo")
    public void setConsignorConsigneeInfo(ConsignorConsigneeInfo consignorConsigneeInfo) {
        this.consignorConsigneeInfo = consignorConsigneeInfo;
    }

    @JsonProperty("financialInfo")
    public FinancialInfo getFinancialInfo() {
        return financialInfo;
    }

    @JsonProperty("financialInfo")
    public void setFinancialInfo(FinancialInfo financialInfo) {
        this.financialInfo = financialInfo;
    }

    @JsonProperty("generalInformation")
    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    @JsonProperty("generalInformation")
    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    @JsonProperty("itemInformation")
    public List<ItemInformation> getItemInformation() {
        return itemInformation;
    }

    @JsonProperty("itemInformation")
    public void setItemInformation(List<ItemInformation> itemInformation) {
        this.itemInformation = itemInformation;
    }

    @JsonProperty("negativeList")
    public NegativeList getNegativeList() {
        return negativeList;
    }

    @JsonProperty("negativeList")
    public void setNegativeList(NegativeList negativeList) {
        this.negativeList = negativeList;
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
