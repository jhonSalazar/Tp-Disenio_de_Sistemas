package controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import Dispositivos.DispositivoInteligente;
import Optimizacion.Optimizador;
import Repositorios.RepoClientes;
import Usuarios.Cliente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class SimplexController {
	public static ModelAndView show(Request req, Response res) {
		
		Map<String, List> consumo = new HashMap<String, List>();
		String username = req.session().attribute("username");
		
		if(username ==null)
			 return new ModelAndView(null,"/error.hbs");
		
		Cliente cliente = RepoClientes.instancia.buscarPorUserName(username);
		List<DispositivoInteligente> dispositivosInteligentes = cliente.DispositivosInteligenteDelCliente();
		System.out.println(dispositivosInteligentes.size());
		Optimizador unOptimizador;
		unOptimizador = new Optimizador();
		
		double valor = unOptimizador.optimizar(dispositivosInteligentes,GoalType.MAXIMIZE);
		List<Double> calculos = new ArrayList<Double>();
		calculos.add(round(valor,2) );
		round(200.3456, 2);
		consumo.put("calculos", calculos);
		consumo.put("dispositivos", dispositivosInteligentes);
		return new ModelAndView(consumo, "/consumo.hbs");
	}
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
