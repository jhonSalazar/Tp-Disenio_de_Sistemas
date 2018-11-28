package controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeUsuarioController {
	public static ModelAndView show(Request req, Response res){
		
		String username = req.session().attribute("username");
		
		Map<String,String> model = new HashMap<String,String>();
		model.put("usuario",username);
		return new ModelAndView(null, "/clienteInicio.hbs");
	}
	
}
