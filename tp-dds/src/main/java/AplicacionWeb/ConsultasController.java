package AplicacionWeb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.Fabricante;
import Dispositivos.FabricanteLG;
import Funcionalidades.Categorizador;
import Repositorios.RepoClientes;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ConsultasController {
	
public static ModelAndView show(Request req, Response res){		
		
		String username = req.session().attribute("username");
		
		Map<String,String> model = new HashMap<String,String>();
		model.put("usuario",username);
		return new ModelAndView(model, "/consultas.hbs");
	}

	public static ModelAndView showFiltros(Request req, Response res){		
		
		String username = req.session().attribute("username");
		if(username==null)	
			 return new ModelAndView(null,"/error.hbs");
		
		System.out.println(req.queryParams("desde") +"::"+req.queryParams("hasta"));
		
		Map<String,String> model = new HashMap<String,String>();
		String desde =req.queryParams("desde");
		String hasta =req.queryParams("hasta");
		LocalDateTime fechaDesde,fechaHasta;
		
		desde = desde + " 00:00";
		hasta = hasta + " 00:00";
		String now = "2016-11-09 10:30";

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	         fechaDesde = LocalDateTime.parse(desde, formatter);
	         fechaHasta = LocalDateTime.parse(hasta, formatter);
		
		
		Cliente cliente = RepoClientes.getInstance().buscarPorUserName(username);
		double valor = cliente.consumoTotalPeriodo(fechaDesde, fechaHasta);
		
		System.out.println(valor);
		model.put("respuesta", Double.toString(valor));
		return new ModelAndView(model, "/respuestaDispositivo.hbs");
	}
}
