package com.jwt.dto.request;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DataSerializerUtils extends JsonSerializer<Double>  {

	

	

	@Override
	public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		DecimalFormat df = new DecimalFormat("####0.0000");
		gen.writeNumber(df.format(value));
		
	}

}
