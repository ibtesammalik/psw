
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
    "numberOfPackages",
    "packageType"
})
@Generated("jsonschema2pojo")
public class PackagesInformation implements Serializable
{

    @JsonProperty("numberOfPackages")
    private Double numberOfPackages;
    @JsonProperty("packageType")
    private String packageType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2090149729713117094L;

    @JsonProperty("numberOfPackages")
    public Double getNumberOfPackages() {
        return numberOfPackages;
    }

    @JsonProperty("numberOfPackages")
    public void setNumberOfPackages(Double numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    @JsonProperty("packageType")
    public String getPackageType() {
        return packageType;
    }

    @JsonProperty("packageType")
    public void setPackageType(String packageType) {
        this.packageType = packageType;
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
