package TestProyecto;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.FabricanteLG;
import Funcionalidades.Categorizador;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

import org.junit.Before;

public class ClienteTest {

	DispositivoEstandar disEstandar1, disEstandar2;
	DispositivoInteligente disInteligente1, disInteligente2;
	Cliente cliente;
	
	Estado encendido = Estado.ENCENDIDO;
	Estado apagado = Estado.APAGADO;
	FabricanteLG fabricanteLG;
	ConsumoDispositivosInteligente consumoDI1, consumoDI2;
	LocalDateTime fechaDesde,fechaHasta;
	
	@Before
	public void Before() {
		TipoDocumento tipo = TipoDocumento.DNI;
		
		fabricanteLG = new FabricanteLG("LG");
		
		disEstandar1 = new DispositivoEstandar("Heladera", 2, 300.0);
		disEstandar2 = new DispositivoEstandar("lavarropas", 3, 150.0);

		disInteligente1 = new DispositivoInteligente("computadora", 100.0);
		disInteligente1.setEstado(apagado);
		disInteligente1.setFabricante(fabricanteLG);

		disInteligente2 = new DispositivoInteligente("computadora", 200.0);
		disInteligente2.setEstado(apagado);
		disInteligente2.setFabricante(fabricanteLG);
		
		fechaDesde = LocalDateTime.of(2018,11,01, 12,00);
		fechaHasta = LocalDateTime.of(2018,11,01, 21,00);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		
		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);
		Categoria esperado = Categorizador.getInstance().R3;

		cliente = new Cliente("Gabriel", "Figueroa", tipo, 33501713, 2222, "Azopardo 3636", fechaDeAlta);

		cliente.setCategoria(esperado);
		cliente.agregarDispositivoEstandar(disEstandar1);
		cliente.agregarDispositivoEstandar(disEstandar2);
		cliente.agregarDispositivoInteligente(disInteligente1);
		cliente.agregarDispositivoInteligente(disInteligente2);
		
		disInteligente1.encender(fechaDesde, consumoDI1);
		disInteligente1.apagar(fechaHasta, consumoDI1);
		disInteligente2.encender(fechaDesde, consumoDI2);
		disInteligente2.apagar(fechaHasta, consumoDI2);

	}

	@Test
	public void testCantDispositivosEncendidos() {
		int esperado = 0;
		assertEquals(esperado, cliente.cantidadDispositivosEncendidos());
	}

	@Test
	public void testCantDispositivosApagados() {
		int esperado = 2;
		assertEquals(esperado, cliente.cantidadDispositivosApagados());
	}

	@Test
	public void testCantDispositivos() {
		int esperado = 4;
		assertEquals(esperado, cliente.cantidadTotalDispositivos());
	}

	@Test
	public void testTodosDispositivosEncendidos() {
		Boolean esperado = false;
		assertEquals("No estan todos encendidos", esperado, cliente.todosDispositivosEncendidos());
	}

	@Test
	public void testAlgunDispositivoEstaEncendido() {
		Boolean esperado = false;
		assertEquals("Si hay algun dispositivo todos encendido", esperado, cliente.algunDispositivoEncendido());
	}

	@Test
	public void testConsumoTotalDelClienteEnUnPeriodo() {
		assertEquals(6750.0, cliente.consumoTotalPeriodo(fechaDesde, fechaHasta), 1.0);

	}
	
	@Test
	public void testRecategorizarYConsumoMensual() {
		double esperado = 6751.0;

		Categoria categ = new Categoria(1, 1, 1, 1);
		cliente.recategorizar(categ);

		assertEquals(esperado, cliente.gastoTotal(fechaDesde, fechaHasta), 1.0);

	}

	// test suma puntaje por convertir de estandar a inteligente 1 dispositivo
	@Test
	public void testPuntajeACliente() {
		int esperado = 10;
		cliente.convertirDeEstandarAInteligente(disEstandar1);

		assertEquals(esperado, cliente.getPuntajeCliente());

	}

	// test suma puntaje registrando dos dispositivos inteligente
	@Test
	public void testPuntajeAClienteSumandoDosDI() {
		int esperado = 30;

		cliente.registrarDispositivoInteligente(disInteligente1);
		cliente.registrarDispositivoInteligente(disInteligente2);

		assertEquals(esperado, cliente.getPuntajeCliente());

	}

	// test suma puntaje por convertir de estandar a inteligente 2 dispositivos
	@Test
	public void testPuntajeAClienteDI() {
		int esperado = 20;

		cliente.convertirDeEstandarAInteligente(disEstandar1);
		cliente.convertirDeEstandarAInteligente(disEstandar2);

		assertEquals(esperado, cliente.getPuntajeCliente());

	}
}
