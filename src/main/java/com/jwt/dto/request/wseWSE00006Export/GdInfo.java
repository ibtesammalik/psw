
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
    "gdNumber",
    "gdStatus",
    "consignmentCategory",
    "gdType",
    "collectorate",
    "blAwbNumber",
    "blAwbDate",
    "virAirNumber",
    "consignorConsigneeInfo",
    "financialInformation",
    "generalInformation",
    "itemInformation"
})
@Generated("jsonschema2pojo")
public class GdInfo implements Serializable
{

    @JsonProperty("gdNumber")
    private String gdNumber;
    @JsonProperty("gdStatus")
    private String gdStatus;
    @JsonProperty("consignmentCategory")
    private String consignmentCategory;
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
    @JsonProperty("financialInformation")
    private FinancialInformation financialInformation;
    @JsonProperty("generalInformation")
    private GeneralInformation generalInformation;
    @JsonProperty("itemInformation")
    private List<ItemInformationGd> itemInformation = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 434959342293409741L;

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

    @JsonProperty("financialInformation")
    public FinancialInformation getFinancialInformation() {
        return financialInformation;
    }

    @JsonProperty("financialInformation")
    public void setFinancialInformation(FinancialInformation financialInformation) {
        this.financialInformation = financialInformation;
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
    public List<ItemInformationGd> getItemInformation() {
        return itemInformation;
    }

    @JsonProperty("itemInformation")
    public void setItemInformation(List<ItemInformationGd> itemInformation) {
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
