package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class OptimizadorController {
	
	
public static ModelAndView show(Request req, Response res){		
		
		return new ModelAndView(null, "/optimizador.hbs");
	}
}
