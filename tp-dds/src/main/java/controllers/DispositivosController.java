package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Repositorios.RepoClientes;
import Usuarios.Cliente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class DispositivosController {

	public static ModelAndView show(Request req, Response res){
		
	    String username = req.session().attribute("username");
		
	    if(username==null)	
			 return new ModelAndView(null,"/error.hbs");			
		
		Cliente cliente= RepoClientes.getInstance().buscarPorUserName(username);
		
		Map<String, List<DispositivoInteligente>> model = new HashMap<>();
		
		// llamar al repo para cargar dispositivos
		List<DispositivoInteligente> dispositivos = cliente.DispositivosInteligenteDelCliente();
		
		model.put("dispositivos",dispositivos);
		return new ModelAndView(model,"/dispositivos.hbs");
		
	}
	
	public static ModelAndView showInteligente(Request req, Response res){
		
		if(req.session().attribute("username")==null)	
			return new ModelAndView(null,"/error.hbs");
		
		Map<String, List<DispositivoInteligente>> model = new HashMap<>();
		String username = req.session().attribute("username");
		Cliente cliente = RepoClientes.instancia.buscarPorUserName(username);
		
		List<DispositivoInteligente> dispositivosInteligentes = cliente.DispositivosInteligenteDelCliente();
		model.put("dispositivosInteligente", dispositivosInteligentes);
		
		return new ModelAndView(model, "/dispositivos.hbs");
		
	}

	public static ModelAndView showEstandar(Request req, Response res){
	
		if(req.session().attribute("username")==null)	
			return new ModelAndView(null,"/error.hbs");
		
		Map<String, List<DispositivoEstandar>> model = new HashMap<>();
		String username = req.session().attribute("username");
		int id = RepoClientes.instancia.idDelCliente(username);
		
		List<DispositivoEstandar> dispositivosEstandar = RepoClientes.instancia.dispositivosEstandarDelCliente(id);
		
		model.put("dispositivosEstandar",dispositivosEstandar);
		return new ModelAndView(model, "/dispositivos.hbs");
	
	}
	
	public static ModelAndView showEncendido(Request req, Response res){
		
		String username = req.session().attribute("username");
		if(username==null)	
			 return new ModelAndView(null,"/error.hbs");
		
		
		
		Map<String, List<DispositivoInteligente>> model = new HashMap<>();
		
		
		
		Cliente cliente = RepoClientes.getInstance().buscarPorUserName(username);
		

		// llamar al repo para cargar dispositivos
		List<DispositivoInteligente> dispositivos = cliente.DispositivosInteligenteDelCliente();
		
		List<DispositivoInteligente> dispositivos2 =
		dispositivos.stream().filter(dispositivo->dispositivo.estaEncendido()).collect(Collectors.toList());
		
		model.put("dispositivosInteligente",dispositivos2);
		System.out.println("encendidos "+dispositivos2.size());
		return new ModelAndView(model, "/dispositivos.hbs");
		
	}
	
	public static ModelAndView showApagado(Request req, Response res){
		
		String username = req.session().attribute("username");
		if(username==null)	
			 return new ModelAndView(null,"/error.hbs");
		
		Map<String, List<DispositivoInteligente>> model = new HashMap<>();
		
		Cliente cliente = RepoClientes.getInstance().buscarPorUserName(username);
		
		// llamar al repo para cargar dispositivos
		List<DispositivoInteligente> dispositivos = cliente.DispositivosInteligenteDelCliente();;
		
		List<DispositivoInteligente> dispositivos2 =
				dispositivos.stream().filter(dispositivo->dispositivo.estaApagado()).collect(Collectors.toList());
		
		dispositivos2.forEach(dis-> System.out.println(dis.getNombre()));
		
		model.put("dispositivosInteligente",dispositivos2);
		
		System.out.println("apagados "+dispositivos2.size());
		return new ModelAndView(model, "/dispositivos.hbs");
		
	}
	
	
	public static ModelAndView showAhorroEnergia(Request req, Response res){
		
		String username = req.session().attribute("username");
		if(username==null)	
			 return new ModelAndView(null,"/error.hbs");
		
		Map<String, List<DispositivoInteligente>> model = new HashMap<>();
		
		Cliente cliente = RepoClientes.getInstance().buscarPorUserName(username);
		
		// llamar al repo para cargar dispositivos
		List<DispositivoInteligente> dispositivos = cliente.DispositivosInteligenteDelCliente();;
		
		List<DispositivoInteligente> dispositivos2 =
				dispositivos.stream().filter(dispositivo->dispositivo.estaEnAhorroEnergia()).collect(Collectors.toList());
		
		dispositivos2.forEach(dis-> System.out.println(dis.getNombre()));
		
		model.put("dispositivosInteligente",dispositivos2);
		
		System.out.println("apagados "+dispositivos2.size());
		return new ModelAndView(model, "/dispositivos.hbs");
		
	}
	
}
