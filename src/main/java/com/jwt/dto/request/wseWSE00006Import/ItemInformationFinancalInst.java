
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
    "goodsDescription",
    "quantity",
    "uom",
    "countryOfOrigin",
    "sample",
    "sampleValue"
})
@Generated("jsonschema2pojo")
public class ItemInformationFinancalInst implements Serializable
{

    @JsonProperty("hsCode")
    private String hsCode;
    @JsonProperty("goodsDescription")
    private String goodsDescription;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("uom")
    private String uom;
    @JsonProperty("countryOfOrigin")
    private String countryOfOrigin;
    @JsonProperty("sample")
    private String sample;
    @JsonProperty("sampleValue")
    private String sampleValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8973193997870367755L;

    @JsonProperty("hsCode")
    public String getHsCode() {
        return hsCode;
    }

    @JsonProperty("hsCode")
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    @JsonProperty("goodsDescription")
    public String getGoodsDescription() {
        return goodsDescription;
    }

    @JsonProperty("goodsDescription")
    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("uom")
    public String getUom() {
        return uom;
    }

    @JsonProperty("uom")
    public void setUom(String uom) {
        this.uom = uom;
    }

    @JsonProperty("countryOfOrigin")
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @JsonProperty("countryOfOrigin")
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @JsonProperty("sample")
    public String getSample() {
        return sample;
    }

    @JsonProperty("sample")
    public void setSample(String sample) {
        this.sample = sample;
    }

    @JsonProperty("sampleValue")
    public String getSampleValue() {
        return sampleValue;
    }

    @JsonProperty("sampleValue")
    public void setSampleValue(String sampleValue) {
        this.sampleValue = sampleValue;
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
