package TestProyecto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.FabricanteLG;
import Funcionalidades.Categorizador;
import Geoposicionamiento.Punto;
import Geoposicionamiento.Transformador;
import Geoposicionamiento.ZonaGeografica;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class ZonaGeograficaTest {
	
	List<Point> puntos;
	ZonaGeografica zona1;
	Transformador transformador1, transformador2;
	DispositivoEstandar DE1,DE2,DE3,DE4;
	DispositivoInteligente DI1,DI2,DI3,DI4,DI5;
	Cliente cliente1, cliente2,cliente3,cliente4;
	Estado encendido = Estado.ENCENDIDO;
	Estado apagado = Estado.APAGADO;
	LocalDateTime fechaDesde,fechaHasta;
	Punto point1, point2, point3;
	FabricanteLG fabricanteLG;
	ConsumoDispositivosInteligente consumoDI1,consumoDI2,consumoDI3,consumoDI4;
	
	@Before
	public void Before() {
		
		fabricanteLG = new FabricanteLG("LG");
		
		DE1 = new DispositivoEstandar("Heladera", 2, 300.00);
		DE2 = new DispositivoEstandar("Lampara velador", 3, 15.00);
		DE3 = new DispositivoEstandar("Lampara auxiliar", 2, 20.00);
		DE4 = new DispositivoEstandar("Cargador", 3, 100.00);

		DI1 = new DispositivoInteligente("computadora", 100.0);
		DI1.setEstado(apagado);
		DI1.setFabricante(fabricanteLG);

		DI2 = new DispositivoInteligente("Lavarropas", 200.0);
		DI2.setEstado(apagado);
		DI2.setFabricante(fabricanteLG);
		
		DI3 = new DispositivoInteligente("Cafetera", 1000.0);
		DI3.setEstado(apagado);
		DI3.setFabricante(fabricanteLG);
		
		DI4 = new DispositivoInteligente("Licuadora", 100.0);
		DI4.setEstado(apagado);
		DI4.setFabricante(fabricanteLG);
		
		DI5 = new DispositivoInteligente("Pecera", 500.0);
		DI5.setEstado(apagado);
		DI5.setFabricante(fabricanteLG);
		
		fechaDesde = LocalDateTime.of(2018,11,01, 12,00);
		fechaHasta = LocalDateTime.of(2018,11,01, 21,00);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI3 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI4 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		
		TipoDocumento tipo = TipoDocumento.DNI;
		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);
		Categoria esperado = Categorizador.getInstance().R3;

		cliente1 = new Cliente("Gabriel", "Figueroa", tipo, 39501713, 2222, "Azopardo 3636", fechaDeAlta);
		cliente2 = new Cliente("Martin", "Isnardi", tipo, 33501813, 2222, "Sarandi 3636", fechaDeAlta);
		cliente3 = new Cliente("Fede", "Perez", tipo, 39501713, 2222, "Azopardo 3636", fechaDeAlta);
		cliente4 = new Cliente("Jorge", "Muhsisoglu", tipo, 33457756, 2222, "Falsa 1234", fechaDeAlta);
		
		cliente1.setCategoria(esperado);
		cliente1.agregarDispositivoEstandar(DE1);
		cliente1.agregarDispositivoInteligente(DI1);
		
		cliente2.setCategoria(esperado);
		cliente2.agregarDispositivoEstandar(DE2);
		cliente2.agregarDispositivoInteligente(DI2);

		cliente3.setCategoria(esperado);
		cliente3.agregarDispositivoEstandar(DE3);
		cliente3.agregarDispositivoInteligente(DI3);
		
		cliente4.setCategoria(esperado);
		cliente4.agregarDispositivoEstandar(DE4);
		cliente4.agregarDispositivoInteligente(DI4);
		cliente4.agregarDispositivoInteligente(DI5);
		
		transformador1 = new Transformador(23.23, 234.9);
		transformador2 = new Transformador(21.98, 234.9);
		
		transformador1.agregarClientes(cliente1);
		transformador1.agregarClientes(cliente2);
						
		transformador2.agregarClientes(cliente3);
		transformador2.agregarClientes(cliente4);

		point1 = new Punto(2.55, 23.98);
		point2 = new Punto(2.58, 24.97);
		point3 = new Punto(2.95, 24.92);
		
		puntos = new ArrayList<Point>();
		
		puntos.add(point1);
		puntos.add(point2);
		puntos.add(point3);
		
		zona1 = new ZonaGeografica(puntos);
		
		zona1.agregarTransformadores(transformador1);
		zona1.agregarTransformadores(transformador2);
		
		DI1.encender(fechaDesde, consumoDI1);
		DI1.apagar(fechaHasta, consumoDI1);
		DI2.encender(fechaDesde, consumoDI2);
		DI2.apagar(fechaHasta, consumoDI2);
		DI3.encender(fechaDesde, consumoDI3);
		DI3.apagar(fechaHasta, consumoDI3);
		DI4.encender(fechaDesde, consumoDI4);
		DI4.apagar(fechaHasta, consumoDI4);
		
	}
	
	@Test
	public void testConsumoTotalDeLaZonaEnUnPeriodo() {
		assertEquals(16515.00,zona1.consumoTotalDeLaZona(fechaDesde,fechaHasta),1.0);
	}
	
}




