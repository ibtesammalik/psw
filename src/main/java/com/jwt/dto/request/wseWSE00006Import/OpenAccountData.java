
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
    "gdNumber"
  
})
@Generated("jsonschema2pojo")
public class OpenAccountData implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3450642171292786805L;

	@JsonProperty("gdNumber")
    private String gdNumber;
  
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
  

      
    @JsonProperty("gdNumber")
    public String getGdNumber() {
		return gdNumber;
	}

    @JsonProperty("gdNumber")
	public void setGdNumber(String gdNumber) {
		this.gdNumber = gdNumber;
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
