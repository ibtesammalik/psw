
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
    "bdaUniqueIdNumber",
    "gdNumber",
    "iban",
    "importerNtn",
    "importerName",
    "bdaDate",
    "modeOfPayment",
    "finInsUniqueNumber",
    "bdaInformation"
})
@Generated("jsonschema2pojo")
public class BankAdviceInfo implements Serializable
{

    @JsonProperty("bdaUniqueIdNumber")
    private String bdaUniqueIdNumber;
    @JsonProperty("gdNumber")
    private List<String> gdNumber = null;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("importerNtn")
    private String importerNtn;
    @JsonProperty("importerName")
    private String importerName;
    @JsonProperty("bdaDate")
    private String bdaDate;
    @JsonProperty("modeOfPayment")
    private String modeOfPayment;
    @JsonProperty("finInsUniqueNumber")
    private String finInsUniqueNumber;
    @JsonProperty("bdaInformation")
    private BdaInformation bdaInformation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4621161113533652464L;

    @JsonProperty("bdaUniqueIdNumber")
    public String getBdaUniqueIdNumber() {
        return bdaUniqueIdNumber;
    }

    @JsonProperty("bdaUniqueIdNumber")
    public void setBdaUniqueIdNumber(String bdaUniqueIdNumber) {
        this.bdaUniqueIdNumber = bdaUniqueIdNumber;
    }

    @JsonProperty("gdNumber")
    public List<String> getGdNumber() {
        return gdNumber;
    }

    @JsonProperty("gdNumber")
    public void setGdNumber(List<String> gdNumber) {
        this.gdNumber = gdNumber;
    }

    @JsonProperty("iban")
    public String getIban() {
        return iban;
    }

    @JsonProperty("iban")
    public void setIban(String iban) {
        this.iban = iban;
    }

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

    @JsonProperty("bdaDate")
    public String getBdaDate() {
        return bdaDate;
    }

    @JsonProperty("bdaDate")
    public void setBdaDate(String bdaDate) {
        this.bdaDate = bdaDate;
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

    @JsonProperty("bdaInformation")
    public BdaInformation getBdaInformation() {
        return bdaInformation;
    }

    @JsonProperty("bdaInformation")
    public void setBdaInformation(BdaInformation bdaInformation) {
        this.bdaInformation = bdaInformation;
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
