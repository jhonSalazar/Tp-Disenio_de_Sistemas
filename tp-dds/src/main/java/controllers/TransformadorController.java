package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import Geoposicionamiento.Transformador;
import Geoposicionamiento.ZonaGeografica;
import Repositorios.RepoClientes;
import Repositorios.RepoTransformadores;
import Repositorios.RepoZonasGeograficas;
import Usuarios.Cliente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class TransformadorController implements WithGlobalEntityManager, TransactionalOps{
	
	@SuppressWarnings("rawtypes")
	public static ModelAndView mostrar(Request req, Response res){
		Map<String, List> model = new HashMap<>();
		String id = req.queryParams("id");
		
		List<Cliente> clientes = RepoClientes.instancia.listar();
		List<Cliente> clientesT = RepoTransformadores.instancia.clientesDelTransformador(Long.parseLong(id));
		List<Transformador> transformadores = RepoTransformadores.instancia.listarTransformadores();
		List<ZonaGeografica> zonas = RepoZonasGeograficas.instancia.listarZonas();
		
		model.put("clientes", clientes);
		model.put("clientesT", clientesT);
		model.put("transformadores", transformadores);
		model.put("zonas", zonas);
		return new ModelAndView(model, "/consumoTransformador.hbs");
	}
	
}