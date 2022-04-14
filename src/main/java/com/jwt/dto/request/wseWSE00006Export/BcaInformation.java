
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
    "bcaEventName",
    "eventDate",
    "runningSerialNumber",
    "swiftReference",
    "billNumber",
    "billDated",
    "billAmount",
    "invoiceNumber",
    "invoiceDate",
    "invoiceAmount"
})
@Generated("jsonschema2pojo")
public class BcaInformation implements Serializable
{

    @JsonProperty("bcaEventName")
    private String bcaEventName;
    @JsonProperty("eventDate")
    private String eventDate;
    @JsonProperty("runningSerialNumber")
    private String runningSerialNumber;
    @JsonProperty("swiftReference")
    private String swiftReference;
    @JsonProperty("billNumber")
    private String billNumber;
    @JsonProperty("billDated")
    private String billDated;
    @JsonProperty("billAmount")
    private Double billAmount;
    @JsonProperty("invoiceNumber")
    private String invoiceNumber;
    @JsonProperty("invoiceDate")
    private String invoiceDate;
    @JsonProperty("invoiceAmount")
    private Double invoiceAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6062173120112773279L;

    @JsonProperty("bcaEventName")
    public String getBcaEventName() {
        return bcaEventName;
    }

    @JsonProperty("bcaEventName")
    public void setBcaEventName(String bcaEventName) {
        this.bcaEventName = bcaEventName;
    }

    @JsonProperty("eventDate")
    public String getEventDate() {
        return eventDate;
    }

    @JsonProperty("eventDate")
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @JsonProperty("runningSerialNumber")
    public String getRunningSerialNumber() {
        return runningSerialNumber;
    }

    @JsonProperty("runningSerialNumber")
    public void setRunningSerialNumber(String runningSerialNumber) {
        this.runningSerialNumber = runningSerialNumber;
    }

    @JsonProperty("swiftReference")
    public String getSwiftReference() {
        return swiftReference;
    }

    @JsonProperty("swiftReference")
    public void setSwiftReference(String swiftReference) {
        this.swiftReference = swiftReference;
    }

    @JsonProperty("billNumber")
    public String getBillNumber() {
        return billNumber;
    }

    @JsonProperty("billNumber")
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    @JsonProperty("billDated")
    public String getBillDated() {
        return billDated;
    }

    @JsonProperty("billDated")
    public void setBillDated(String billDated) {
        this.billDated = billDated;
    }

    @JsonProperty("billAmount")
    public Double getBillAmount() {
        return billAmount;
    }

    @JsonProperty("billAmount")
    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
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

    @JsonProperty("invoiceAmount")
    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    @JsonProperty("invoiceAmount")
    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
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
