package Utilitarios;

import java.io.IOException;
import java.time.LocalDate;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializador extends StdDeserializer<LocalDate> {
	
	
	 protected LocalDateDeserializador() {
	        super(LocalDate.class);
	    }

	    @Override
	    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
	        return LocalDate.parse(parser.readValueAs(String.class));
	    }
}
