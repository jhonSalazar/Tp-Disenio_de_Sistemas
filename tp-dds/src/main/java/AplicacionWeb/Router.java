package AplicacionWeb;
import static spark.Spark.exception;

import com.google.gson.Gson;

import UtilitariosSpark.BooleanHelper;
import UtilitariosSpark.HandlebarsTemplateEngineBuilder;
import controllers.*;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class Router {

	public static void configure() {
		
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();
		
		Spark.staticFiles.location("/public");						
		
		Spark.before((request, response) -> {
			 System.out.println("request:" +  request);
			});
		
		Spark.get("/", HomeController::home, engine);
		Spark.get("/login", LoginController::show, engine);
		Spark.get("/loginAdmin", LoginAdminController::show, engine);
		Spark.get("/homeAdmin", HomeAdminController::show, engine);
		Spark.get("/cliente", HomeUsuarioController::show, engine);
		Spark.get("/salir", LoginController::salir, engine);	
		Spark.get("/mapa", MapaController::show, engine);
		Spark.get("/nuevo", JsonController::show);
		Spark.get("/cliente/consumoOptimizado", SimplexController::show,engine);
		Spark.get("/altaDispositivos", AltaDispAdminController::show,engine);
		Spark.get("/admin/consumosClientes", ConsumoClientesController::listar,engine);
		Spark.get("/admin/consumos/clientes", ClienteController::mostrar,engine);
		Spark.get("/admin/consumos/transformadores", TransformadorController::mostrar,engine);
		Spark.get("/admin/consumos/zonas", ZonaController::mostrar,engine);
		
		Spark.get("/reportes", ReportesAdminController::show,engine);		
		
		Spark.get("/cliente/consultas", ConsultasController::show,engine);
		Spark.get("/cliente/estadoHogar", EstadoHogarController::show,engine);
		Spark.get("/cliente/dispositivos/estadoHogar/ultimasMediciones",EstadoHogarController::showUltimasMediciones,engine);
		Spark.get("/cliente/dispositivos/estadoHogar/ultimoPeriodo",EstadoHogarController::showUltimoPeriodo,engine);
		
		Spark.get("/cliente/optimizacion", OptimizadorController::show,engine);
		Spark.get("/cliente/dispositivos", DispositivosController::show,engine);
		Spark.get("/cliente/dispositivos/inteligentes", DispositivosController::showInteligente,engine);	
		Spark.get("/cliente/dispositivos/estandares", DispositivosController::showEstandar,engine);	
		Spark.get("/cliente/dispositivos/inteligentes/encendido", DispositivosController::showEncendido,engine);	
		Spark.get("/cliente/dispositivos/inteligentes/apagado", DispositivosController::showApagado,engine);
		Spark.get("/cliente/dispositivos/inteligentes/ahorroEnergia", DispositivosController::showAhorroEnergia,engine);
		
		Spark.post("/login", LoginController::login, engine);
		Spark.get("/cliente/consultas/porPeriodo", ConsultasController::showFiltros,engine);
		Spark.post("/loginAdmin", LoginAdminController::login, engine);
		
		Spark.after((request, response) -> {
		    response.header("Content-Encoding", "gzip");
		});
		
		exception(IllegalArgumentException.class, (e, req, res) -> {
			Gson gson = new Gson();
			res.status(400);
			res.body(gson.toJson(new ResponseError(e)));
		});
		
	}
}
