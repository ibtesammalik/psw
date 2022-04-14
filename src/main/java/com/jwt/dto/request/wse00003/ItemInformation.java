
package com.jwt.dto.request.wse00003;

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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jwt.dto.request.DataSerializerUtils;

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
public class ItemInformation implements Serializable
{

    @JsonProperty("hsCode")
    private String hsCode;
    @JsonProperty("quantity")
    @JsonSerialize(using = DataSerializerUtils.class)
    private Double quantity;
    @JsonProperty("unitPrice")
    private Integer unitPrice;
    @JsonProperty("totalValue")
    private Integer totalValue;
    @JsonProperty("importValue")
    private Integer importValue;
    @JsonProperty("uom")
    private String uom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1943214004353588611L;

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

    @JsonProperty("importValue")
    public Integer getImportValue() {
        return importValue;
    }

    @JsonProperty("importValue")
    public void setImportValue(Integer importValue) {
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
