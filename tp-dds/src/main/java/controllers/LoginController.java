package controllers;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import com.google.common.hash.Hashing;

import BaseDeDatos.ManagerDataBase;
import Repositorios.RepoClientes;
import Usuarios.Cliente;
import UtilitariosSpark.ValidadorSession;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class LoginController {

	private static final String SESSION_NAME = "username";
	
	public static ModelAndView show(Request req, Response res){
		
		if(req.session().attribute("username")!=null)
		{
				res.redirect("/cliente");
				return null;
		}
		return new ModelAndView(null, "home/login.hbs");
	}
	
	public static ModelAndView login(Request req, Response res) {
		
		String username = req.queryParams("usuarioID");
		String password = req.queryParams("password");
	
		Cliente cliente= RepoClientes.getInstance().buscarPorUserName(username);
		
		if(cliente ==null)
			return new ModelAndView(null, "home/errorSesion.hbs");

		if( ValidadorSession.validarSessionCliente(cliente, username, password)) {
			req.session().attribute(SESSION_NAME, username);
			Map<String,String> model = new HashMap<String,String>();
			model.put("usuario",username);
			return new ModelAndView(model, "/clienteInicio.hbs");
		}
		
		return new ModelAndView(null, "home/errorSesion.hbs");
		
	}
	
public static ModelAndView salir(Request req, Response res) {
		
	req.session().removeAttribute(SESSION_NAME);
    res.redirect("/");
    return null;
	}
}
