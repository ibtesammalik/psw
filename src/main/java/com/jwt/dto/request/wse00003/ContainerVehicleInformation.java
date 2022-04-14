
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

@JsonInclude(JsonInclude.Include.NON_NULL)

@Generated("jsonschema2pojo")
public class ContainerVehicleInformation implements Serializable
{

    @JsonProperty("containerOrTruckNumber")
    private String containerOrTruckNumber;
    @JsonProperty("sealNumber")
    private String sealNumber;
    @JsonProperty("containerType")
    private String containerType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3210187713450399936L;

    @JsonProperty("containerOrTruckNumber")
    public String getContainerOrTruckNumber() {
        return containerOrTruckNumber;
    }

    @JsonProperty("containerOrTruckNumber")
    public void setContainerOrTruckNumber(String containerOrTruckNumber) {
        this.containerOrTruckNumber = containerOrTruckNumber;
    }

    @JsonProperty("sealNumber")
    public String getSealNumber() {
        return sealNumber;
    }

    @JsonProperty("sealNumber")
    public void setSealNumber(String sealNumber) {
        this.sealNumber = sealNumber;
    }

    @JsonProperty("containerType")
    public String getContainerType() {
        return containerType;
    }

    @JsonProperty("containerType")
    public void setContainerType(String containerType) {
        this.containerType = containerType;
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
