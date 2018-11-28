package controllers;

import java.util.HashMap;
import java.util.Map;

import Repositorios.RepoAdministradores;
import Usuarios.Administrador;

import UtilitariosSpark.ValidadorSession;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginAdminController {

	private static final String SESSION_NAME = "username";
	
	public static ModelAndView show(Request req, Response res){
		
		if(req.session().attribute("username")!=null)
		{
				res.redirect("/homeAdmin");
				return null;
		}
		return new ModelAndView(null, "dashboardAdmin/loginAdmin.hbs");
	}
	
	@SuppressWarnings("unused")
	public static ModelAndView login(Request req, Response res) {
		
		String username = req.queryParams("usuarioID");
		String password = req.queryParams("password");
		
		Administrador unAdmin = RepoAdministradores.getInstance().buscarPorUsername(username);
		
		if(unAdmin == null)
			return new ModelAndView(null, "home/errorSesionAdmin.hbs");

		if( ValidadorSession.validarAdmin(unAdmin, username, password)) {
			req.session().attribute(SESSION_NAME, username);
			Map<String,String> model = new HashMap<String,String>();
			model.put("usuario",username);
			return new ModelAndView(model, "/dashboardAdmin/homeAdmin.hbs");
		}
		
		return new ModelAndView(null, "home/errorSesionAdmin.hbs");
		
	}
		
	public static ModelAndView salir(Request req, Response res) {
		
		req.session().removeAttribute(SESSION_NAME);
	    res.redirect("/");
	    return null;
	}
}
