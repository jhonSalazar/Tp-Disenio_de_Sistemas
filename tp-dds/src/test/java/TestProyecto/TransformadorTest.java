package TestProyecto;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Geoposicionamiento.Transformador;
import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.FabricanteLG;
import Funcionalidades.Categorizador;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class TransformadorTest {
	
	Transformador transformador1,transformador2;
	DispositivoEstandar DE1,DE2,DE3,DE4;
	DispositivoInteligente DI1,DI2,DI3,DI4,DI5;
	Cliente cliente1, cliente2;
	Estado encendido = Estado.ENCENDIDO;
	Estado apagado = Estado.APAGADO;
	LocalDateTime fechaDesde,fechaHasta;
	ConsumoDispositivosInteligente consumoDI1,consumoDI2,consumoDI3;
	FabricanteLG fabricanteLG;
	
	@Before
	public void Before() {
		
		transformador1 = new Transformador(2, 234.9);
		
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
		
		fechaDesde = LocalDateTime.of(2018,11,01, 12,00);
		fechaHasta = LocalDateTime.of(2018,11,01, 21,00);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI3 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		
		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);
		TipoDocumento tipo = TipoDocumento.DNI;
		Categoria esperado = Categorizador.getInstance().R3;
		
		cliente1 = new Cliente("Jorge", "Muhsisoglu", tipo, 33457756, 2222, "Falsa 1234", fechaDeAlta);
		cliente2 = new Cliente("Martin", "Isnardi", tipo, 33501813, 2222, "Sarandi 3636", fechaDeAlta);

		cliente1.setCategoria(esperado);
		cliente1.agregarDispositivoEstandar(DE1);
		cliente1.agregarDispositivoEstandar(DE2);
		cliente1.agregarDispositivoInteligente(DI1);
		cliente1.agregarDispositivoInteligente(DI3);
		
		cliente2.setCategoria(esperado);
		cliente2.agregarDispositivoEstandar(DE3);
		cliente2.agregarDispositivoEstandar(DE4);
		cliente2.agregarDispositivoInteligente(DI2);
		cliente2.agregarDispositivoInteligente(DI3);

		transformador1.agregarClientes(cliente1);
		transformador1.agregarClientes(cliente2);
		
		DI1.encender(fechaDesde, consumoDI1);
		DI1.apagar(fechaHasta, consumoDI1);
		DI2.encender(fechaDesde, consumoDI2);
		DI2.apagar(fechaHasta, consumoDI2);
		
	}
	
	@Test
	public void testCantDeClientes() {
		int esperado = 2;
		assertEquals(esperado,transformador1.cantidadDeClientes());
	}
	
	@Test
	public void testConsumoTotalEnUnPeriodo() {
		assertEquals(6615.0,transformador1.cantidadEnergiaSuministrada(fechaDesde,fechaHasta),1.0);
	}
	
}
