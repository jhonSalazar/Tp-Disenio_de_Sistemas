package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.RoundEnvironment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;

import Dispositivos.DispositivoInteligente;
import Repositorios.RepoClientes;
import Usuarios.Cliente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EstadoHogarController {

	
	public static ModelAndView show(Request req, Response res){		
		
		return new ModelAndView(null, "/estadoHogar.hbs");
	}

	
	public static ModelAndView showUltimoPeriodo(Request req, Response res){		
		
		String username = req.session().attribute("username");
		
		if(username==null)	
			return new ModelAndView(null,"/error.hbs");
		
		
		Map<String, List> model = new HashMap<String,List>();
		Cliente cliente= RepoClientes.getInstance().buscarPorUserName(username);
		
		List<Double>  consumos = new ArrayList<Double>();
		List<Double>  gastos = new ArrayList<Double>();
		
		int dias =LocalDateTime.now().getDayOfMonth();
		int mes  = LocalDateTime.now().getMonthValue();
		double semanas = dias/7.0;
		int primerDia = 1,septimoDia=7;
		if(semanas > 1)
		{
			for(int semana=1;semana<semanas;semana++)
			{				
				consumos.add( round(consumoPorFechas(cliente, mes, primerDia, septimoDia),2));
				gastos.add(round(gastoPorFechas(cliente, mes, primerDia, septimoDia),2));
				primerDia = septimoDia;
				septimoDia = septimoDia + 7 ;
				
						
				
			}
			if(dias>primerDia)
			{
				consumos.add(round(consumoPorFechas(cliente, mes, primerDia, dias),2));
				gastos.add(round(gastoPorFechas(cliente, mes, primerDia, dias),2));
			}
			
			
			
		}else {
			consumos.add(round(consumoPorFechas(cliente, mes, primerDia, LocalDateTime.now().getDayOfMonth()),2));
			gastos.add(round(gastoPorFechas(cliente, mes, primerDia, LocalDateTime.now().getDayOfMonth()),2));
			
		}
		
		consumos.forEach(c->System.out.println("Consumi : "+c));
		
		model.put("consumos", consumos);
		model.put("gastos",gastos);
		return new ModelAndView(model, "/ultimoPeriodo.hbs");
	}
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static ModelAndView showUltimasMediciones(Request req, Response res) {
	
	
		String username = req.session().attribute("username");
	
		if(username==null)	
			return new ModelAndView(null,"/error.hbs");			
	
		List<Double> consumosdelMesesKwh = new ArrayList<Double>();
		List<Double> consumosdelMesesPrecio = new ArrayList<Double>();
		Map<String, List> model = new HashMap<String,List>();
		
		Cliente cliente= RepoClientes.getInstance().buscarPorUserName(username);	
		
		consumosdelMesesKwh = calculoConsumos(cliente);
		consumosdelMesesPrecio =calculoGastoConsumos(cliente);
		
		System.out.println("Tamanio de consumo "+consumosdelMesesKwh.size());
		consumosdelMesesKwh.forEach(v->System.out.println("consumo :" +v));
		System.out.println("Tamanio de gasto "+consumosdelMesesPrecio.size());
		consumosdelMesesPrecio.forEach(v->System.out.println("gasto :" +v));
	
		model.put("consumosdelMesesKwh",consumosdelMesesKwh);
		model.put("consumosdelMesesPrecio",consumosdelMesesPrecio);
	
		return new ModelAndView(model, "/ultimasMediciones.hbs");
	}

	
		//se calcula el consumo total en todos los meses, devuelve la cantidad en kwh consumidas
		public static List<Double> calculoConsumos(Cliente cliente){
		
			double consumo;
			int mesActual;
			List<Double> consumosdelMesesKwh = new ArrayList<Double>();
			mesActual=LocalDateTime.now().getMonthValue();
			
			
			//se calcula desde el mes de enero hasta el mes actual- 1
			//ejemplo desde enero hasta octubre						
			for(int mes =1; mes <mesActual; mes++ )//calculo de meses 
			{			
				consumo=consumoPorFechas(cliente,mes);
				consumosdelMesesKwh.add(consumo);				
				consumo=0;			
			}	
		
			return consumosdelMesesKwh;	
		}
	
		
		//se calcula el gasto toal en todos los meses, devuelve la cantidad de pesos argentinos
		public static List<Double> calculoGastoConsumos(Cliente cliente){
		
			int mesActual;
			double gasto;
			List<Double> consumosdelMesPrecio = new ArrayList<Double>();
		    
			mesActual =LocalDateTime.now().getMonthValue();
		
			//se calcula desde el mes de enero hasta el mes actual- 1
			//ejemplo desde enero hasta octubre

			for(int mes =1; mes < mesActual ;mes++ ) 
			{	
				gasto=gastoPorFechas(cliente, mes);	
				consumosdelMesPrecio.add(gasto);				
				gasto=0;
			}	
		
			return consumosdelMesPrecio;
		
		}
		
		//se calcula el gasto en una determianda fecha de filtro, se devuelve el valor en pesos argentinos
		public static double gastoPorFechas(Cliente cliente, int mes) {
			
			LocalDateTime fechaDesde, fechaHasta;
			double gasto;
			fechaDesde = LocalDateTime.of(LocalDateTime.now().getYear(),mes,1,00,00);
			fechaHasta = LocalDateTime.of(LocalDateTime.now().getYear(),mes,28, 23,59);
			gasto=cliente.gastoTotal(fechaDesde,fechaHasta);
			
			
			return gasto;
		}
		
		//se calcula el consumo en una determianda fecha de filtro, se devuelve el valor en kwh consumida
		public static double consumoPorFechas(Cliente cliente, int mes) {
			
			LocalDateTime fechaDesde, fechaHasta;
			double consumo;
			fechaDesde = LocalDateTime.of(LocalDateTime.now().getYear(),mes,1,00,00);
			fechaHasta = LocalDateTime.of(LocalDateTime.now().getYear(),mes,28, 23,59);
			consumo=cliente.consumoTotalPeriodo(fechaDesde,fechaHasta);
			return consumo;
		}
		
		//se calcula el gasto en una determianda fecha de filtro, se devuelve el valor en pesos argentinos
				public static double gastoPorFechas(Cliente cliente, int mes, int diaInicio, int diaFin) {
					
					LocalDateTime fechaDesde, fechaHasta;
					double gasto;
					fechaDesde = LocalDateTime.of(LocalDateTime.now().getYear(),mes,diaInicio,00,00);
					fechaHasta = LocalDateTime.of(LocalDateTime.now().getYear(),mes,diaFin, 23,59);
					gasto=cliente.gastoTotal(fechaDesde,fechaHasta);
					
					
					return gasto;
				}
				
				//se calcula el consumo en una determianda fecha de filtro, se devuelve el valor en kwh consumida
				public static double consumoPorFechas(Cliente cliente, int mes,int diaInicio, int diaFin) {
					
					LocalDateTime fechaDesde, fechaHasta;
					double consumo;
					fechaDesde = LocalDateTime.of(LocalDateTime.now().getYear(),mes,diaInicio,00,00);
					fechaHasta = LocalDateTime.of(LocalDateTime.now().getYear(),mes,diaFin, 23,59);
					consumo=cliente.consumoTotalPeriodo(fechaDesde,fechaHasta);
					return consumo;
				}
		
		//se devuelve el consumo(kwh consumidas) para la ultima fecha desde el dia uni hasta el dia actual (fecha now)
		public  static double consumoPorFechasUltimoPeriodo(Cliente cliente, int mes) {
			
			LocalDateTime fechaDesde, fechaHasta;
			double consumo;
			fechaDesde = LocalDateTime.of(LocalDateTime.now().getYear(),mes,1,00,00);
			fechaHasta = LocalDateTime.now();
			consumo=cliente.consumoTotalPeriodo(fechaDesde,fechaHasta);
			return consumo;
		}
		
		//se devuelve el gasto (pesos argentino) para la ultima fecha desde el dia uni hasta el dia actual (fecha now)
		public  static double gastoPorFechasUltimoPeriodo(Cliente cliente, int mes) {
			
			LocalDateTime fechaDesde, fechaHasta;
			double gasto;
			fechaDesde = LocalDateTime.of(LocalDateTime.now().getYear(),mes,1,00,00);
			fechaHasta = LocalDateTime.now();
			gasto=cliente.gastoTotal(fechaDesde,fechaHasta);
			return gasto;
		}
		
		
		//calculamos el conusmo  ultimo periodo del cliente
		public static double calculoUltimoPeriodoConsumo(Cliente cliente){
			
			double consumo;
			consumo=consumoPorFechasUltimoPeriodo(cliente,LocalDateTime.now().getMonthValue() );			
			return consumo;
		
		}
		
		//calculamos el gasto en el ultimo periodo del cliente
		public static double calculoUltimoPeriodoGasto(Cliente cliente){
			
			double gasto;
			gasto=gastoPorFechasUltimoPeriodo(cliente,LocalDateTime.now().getMonthValue() );			
			
			return gasto;
		
		}
	
}
