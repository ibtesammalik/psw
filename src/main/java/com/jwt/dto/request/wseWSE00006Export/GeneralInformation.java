
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
    "packagesInformation",
    "containerVehicleInformation",
    "netWeight",
    "grossWeight",
    "consignmentType",
    "portOfShipment",
    "placeOfDelivery",
    "portOfDischarge",
    "terminalLocation",
    "shippingLine"
})
@Generated("jsonschema2pojo")
public class GeneralInformation implements Serializable
{

    @JsonProperty("packagesInformation")
    private List<PackagesInformation> packagesInformation = null;
    @JsonProperty("containerVehicleInformation")
    private List<ContainerVehicleInformation> containerVehicleInformation = null;
    @JsonProperty("netWeight")
    private String netWeight;
    @JsonProperty("grossWeight")
    private String grossWeight;
    @JsonProperty("consignmentType")
    private String consignmentType;
    @JsonProperty("portOfShipment")
    private String portOfShipment;
    @JsonProperty("placeOfDelivery")
    private String placeOfDelivery;
    @JsonProperty("portOfDischarge")
    private String portOfDischarge;
    @JsonProperty("terminalLocation")
    private String terminalLocation;
    @JsonProperty("shippingLine")
    private String shippingLine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9183531324333800867L;

    @JsonProperty("packagesInformation")
    public List<PackagesInformation> getPackagesInformation() {
        return packagesInformation;
    }

    @JsonProperty("packagesInformation")
    public void setPackagesInformation(List<PackagesInformation> packagesInformation) {
        this.packagesInformation = packagesInformation;
    }

    @JsonProperty("containerVehicleInformation")
    public List<ContainerVehicleInformation> getContainerVehicleInformation() {
        return containerVehicleInformation;
    }

    @JsonProperty("containerVehicleInformation")
    public void setContainerVehicleInformation(List<ContainerVehicleInformation> containerVehicleInformation) {
        this.containerVehicleInformation = containerVehicleInformation;
    }

    @JsonProperty("netWeight")
    public String getNetWeight() {
        return netWeight;
    }

    @JsonProperty("netWeight")
    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    @JsonProperty("grossWeight")
    public String getGrossWeight() {
        return grossWeight;
    }

    @JsonProperty("grossWeight")
    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    @JsonProperty("consignmentType")
    public String getConsignmentType() {
        return consignmentType;
    }

    @JsonProperty("consignmentType")
    public void setConsignmentType(String consignmentType) {
        this.consignmentType = consignmentType;
    }

    @JsonProperty("portOfShipment")
    public String getPortOfShipment() {
        return portOfShipment;
    }

    @JsonProperty("portOfShipment")
    public void setPortOfShipment(String portOfShipment) {
        this.portOfShipment = portOfShipment;
    }

    @JsonProperty("placeOfDelivery")
    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    @JsonProperty("placeOfDelivery")
    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
    }

    @JsonProperty("portOfDischarge")
    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    @JsonProperty("portOfDischarge")
    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    @JsonProperty("terminalLocation")
    public String getTerminalLocation() {
        return terminalLocation;
    }

    @JsonProperty("terminalLocation")
    public void setTerminalLocation(String terminalLocation) {
        this.terminalLocation = terminalLocation;
    }

    @JsonProperty("shippingLine")
    public String getShippingLine() {
        return shippingLine;
    }

    @JsonProperty("shippingLine")
    public void setShippingLine(String shippingLine) {
        this.shippingLine = shippingLine;
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
