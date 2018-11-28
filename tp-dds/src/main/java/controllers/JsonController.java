package controllers;

import java.time.LocalDate;

import com.google.gson.Gson;

import Usuarios.Cliente;
import Usuarios.TipoDocumento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class JsonController {

	public static String show(Request req, Response res) {
		res.status(200);
		res.type("application/json");
		Gson gson = new Gson();
		//String valor = 
		return  gson.toJson(new Cliente("Jhon", "Salazar",
		    					TipoDocumento.DNI,
		    					33501713, 2222, 
		    					"Azopardo 3636", 
		    					LocalDate.of(2018, 2, 1)));
		
	//	return new ModelAndView(null, valor);
	}
}
