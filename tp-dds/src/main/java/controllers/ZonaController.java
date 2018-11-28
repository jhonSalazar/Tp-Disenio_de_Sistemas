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

public class ZonaController implements WithGlobalEntityManager, TransactionalOps{
	
	@SuppressWarnings("rawtypes")
	public static ModelAndView mostrar(Request req, Response res){
		Map<String, List> model = new HashMap<>();
		String id = req.queryParams("id");
		
		List<Cliente> clientes = RepoClientes.instancia.listar();
		List<Cliente> clientesZ = RepoZonasGeograficas.instancia.clientesDeLaZona(Long.parseLong(id));
		List<Transformador> transformadores = RepoTransformadores.instancia.listarTransformadores();
		List<ZonaGeografica> zonas = RepoZonasGeograficas.instancia.listarZonas();
		
		model.put("clientes", clientes);
		model.put("clientesZ", clientesZ);
		model.put("transformadores", transformadores);
		model.put("zonas", zonas);
		return new ModelAndView(model, "/consumoZona.hbs");
	}
	
}