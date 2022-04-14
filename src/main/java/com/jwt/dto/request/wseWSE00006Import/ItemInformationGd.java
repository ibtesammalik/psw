
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
    "hsCode",
    "quantity",
    "unitPrice",
    "totalValue",
    "importValue",
    "uom"
})
@Generated("jsonschema2pojo")
public class ItemInformationGd implements Serializable
{

    @JsonProperty("hsCode")
    private String hsCode;
    @JsonProperty("quantity")
    private Double quantity;
    @JsonProperty("unitPrice")
    private Double unitPrice;
    @JsonProperty("totalValue")
    private Double totalValue;
    @JsonProperty("importValue")
    private Double importValue;
    @JsonProperty("uom")
    private String uom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4773734300231638830L;

    @JsonProperty("hsCode")
    public String getHsCode() {
        return hsCode;
    }

    @JsonProperty("hsCode")
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    @JsonProperty("quantity")
    public Double getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("unitPrice")
    public Double getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("unitPrice")
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonProperty("totalValue")
    public Double getTotalValue() {
        return totalValue;
    }

    @JsonProperty("totalValue")
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @JsonProperty("importValue")
    public Double getImportValue() {
        return importValue;
    }

    @JsonProperty("importValue")
    public void setImportValue(Double importValue) {
        this.importValue = importValue;
    }

    @JsonProperty("uom")
    public String getUom() {
        return uom;
    }

    @JsonProperty("uom")
    public void setUom(String uom) {
        this.uom = uom;
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
