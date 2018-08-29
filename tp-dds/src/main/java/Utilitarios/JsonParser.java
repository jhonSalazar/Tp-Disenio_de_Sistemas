package Utilitarios;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import Excepciones.ExcepcionJsonParser;

public class JsonParser {
	
	private ObjectMapper objectMapper;
	
	
	/* JsonLoader()
	 * inicializa el Mapper*/
	public JsonParser() {
		this.objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
	
	/*toJson(Object object)
	 * para posibles salidas de archivos Json*/
	public String toJson(Object object) {
		try {
			String jsonString = this.objectMapper.writeValueAsString(object);
			return jsonString;
		} catch (JsonProcessingException e) {
			throw new ExcepcionJsonParser("Error  de formato Json");
		}
	}
	
	
	/* fromJson(byte[] json, Class<T> typeReference) 
	 * devuevle un objecto Java **
	 * desde un formato Json    **/
	public <T> T fromJson(byte[] json, Class<T> typeReference) {
		try {
			return this.objectMapper.readValue(json, typeReference);
		} catch (IOException e) {

			throw new ExcepcionJsonParser("Error  de formato Json");		}
	}
	
	
	
	/** fromJsonList(byte[] json, Class<T> typeReference)	  *********
	 ** devuelve una lista de un objetos dede un formato Json  *********
	 **  podríamos parametrizarlo el tipo de lista  			  *********
	 **	para hacerlo mas dinámico                    		  ********/
	public  <typeReference, T> List<typeReference>
			fromJsonList(byte[] json, Class<T> typeReference) {
	try{
			List <typeReference>  list= this.objectMapper.readValue(json, 
					TypeFactory.defaultInstance().
					constructCollectionType(List.class,
							typeReference));
			 return  list ;
		} catch (IOException e) {

			throw new ExcepcionJsonParser("Error  de formato Json");		}
	 }
}
