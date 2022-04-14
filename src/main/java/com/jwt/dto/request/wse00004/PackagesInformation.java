
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
public class PackagesInformation implements Serializable
{

    @JsonProperty("numberOfPackages")
    private Integer numberOfPackages;
    @JsonProperty("packageType")
    private String packageType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1651131072605775770L;

    @JsonProperty("numberOfPackages")
    public Integer getNumberOfPackages() {
        return numberOfPackages;
    }

    @JsonProperty("numberOfPackages")
    public void setNumberOfPackages(Integer numberOfPackages) {
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
