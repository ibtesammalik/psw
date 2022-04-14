
package com.jwt.dto.request.wse00004;

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

@Generated("jsonschema2pojo")
public class ItemInformation implements Serializable
{

    @JsonProperty("hsCode")
    private String hsCode;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("unitPrice")
    private Integer unitPrice;
    @JsonProperty("totalValue")
    private Integer totalValue;
    @JsonProperty("exportValue")
    private Integer exportValue;
    @JsonProperty("uom")
    private String uom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4509216786163568853L;

    @JsonProperty("hsCode")
    public String getHsCode() {
        return hsCode;
    }

    @JsonProperty("hsCode")
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("unitPrice")
    public Integer getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("unitPrice")
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonProperty("totalValue")
    public Integer getTotalValue() {
        return totalValue;
    }

    @JsonProperty("totalValue")
    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    @JsonProperty("exportValue")
    public Integer getExportValue() {
        return exportValue;
    }

    @JsonProperty("exportValue")
    public void setExportValue(Integer exportValue) {
        this.exportValue = exportValue;
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
