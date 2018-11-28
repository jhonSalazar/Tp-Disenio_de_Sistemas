package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ReportesAdminController {

	public static ModelAndView show(Request req, Response res){
		return new ModelAndView(null, "/reportes.hbs");
		
	}
	
}
