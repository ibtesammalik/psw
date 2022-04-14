
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
public class FinancialInstrument implements Serializable
{

    @JsonProperty("exporterIban")
    private String exporterIban;
    @JsonProperty("modeOfPayment")
    private String modeOfPayment;
    @JsonProperty("finInsUniqueNumber")
    private String finInsUniqueNumber;
    @JsonProperty("finInsConsumedValue")
    private Double finInsConsumedValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1814916626322229691L;

    @JsonProperty("exporterIban")
    public String getExporterIban() {
        return exporterIban;
    }

    @JsonProperty("exporterIban")
    public void setExporterIban(String exporterIban) {
        this.exporterIban = exporterIban;
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

    @JsonProperty("finInsConsumedValue")
    public Double getFinInsConsumedValue() {
		return finInsConsumedValue;
	}

    @JsonProperty("finInsConsumedValue")
	public void setFinInsConsumedValue(Double finInsConsumedValue) {
		this.finInsConsumedValue = finInsConsumedValue;
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
