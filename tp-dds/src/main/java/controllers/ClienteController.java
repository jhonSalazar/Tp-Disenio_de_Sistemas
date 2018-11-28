package controllers;

import java.util.ArrayList;
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

public class ClienteController implements WithGlobalEntityManager, TransactionalOps{
	
	@SuppressWarnings("rawtypes")
	public static ModelAndView mostrar(Request req, Response res){
		Map<String, List> model = new HashMap<>();
		String nombre = req.queryParams("nombre");
		
		List<Cliente> cliente = new ArrayList<Cliente>();
		
		Cliente unCliente = RepoClientes.instancia.buscarPorNombre(nombre);
		cliente.add(unCliente);
		
		List<Cliente> clientes = RepoClientes.instancia.listar();
		List<Transformador> transformadores = RepoTransformadores.instancia.listarTransformadores();
		List<ZonaGeografica> zonas = RepoZonasGeograficas.instancia.listarZonas();
		
		model.put("cliente", cliente);
		model.put("clientes", clientes);
		model.put("transformadores", transformadores);
		model.put("zonas", zonas);
		return new ModelAndView(model, "/consumoCliente.hbs");
	}
	
}