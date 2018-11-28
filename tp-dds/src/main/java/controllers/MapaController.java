package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Geoposicionamiento.Transformador;
import Repositorios.RepoTransformadores;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MapaController {

public static ModelAndView show(Request req, Response res) {
	Map<String, List<Transformador>> model = new HashMap<>();
	List<Transformador> transformadores = RepoTransformadores.instancia.listarTransformadores();
	
	model.put("transformadores",transformadores);
	return new ModelAndView(model, "/mapa.hbs");
	}
}
