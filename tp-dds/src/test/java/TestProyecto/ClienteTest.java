package TestProyecto;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.EstadoApagado;
import Dispositivos.EstadoEncendido;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

import org.junit.Before;

public class ClienteTest {

	DispositivoEstandar disEstandar1, disEstandar2;
	DispositivoInteligente disInteligente1, disInteligente2;
	Cliente cliente;
	Boolean encendido = true;
	Boolean apagado = false;

	@Before
	public void Before() {
		TipoDocumento tipo = TipoDocumento.DNI;

		disEstandar1 = new DispositivoEstandar("Heladera", 2, 234.9);
		disEstandar2 = new DispositivoEstandar("cocina", 3, 150.0);

		disInteligente1 = new DispositivoInteligente("computadora", 100.0);
		disInteligente1.setEstado(new EstadoEncendido());

		disInteligente2 = new DispositivoInteligente("computadora", 160.0);
		disInteligente2.setEstado(new EstadoApagado());

		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);

		cliente = new Cliente("Gabriel", "Figueroa", tipo, 33501713, 2222, "Azopardo 3636", fechaDeAlta);

		cliente.agregarDispositivoEstandar(disEstandar1);
		cliente.agregarDispositivoEstandar(disEstandar2);
		cliente.agregarDispositivoInteligente(disInteligente1);
		cliente.agregarDispositivoInteligente(disInteligente2);
	}

	@Test
	public void testCantDispositivosEncendidos() {
		int esperado = 1;
		assertEquals(esperado, cliente.cantidadDispositivosEncendidos());
	}

	@Test
	public void testCantDispositivosApagados() {
		int esperado = 1;
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
		Boolean esperado = true;
		assertEquals("Si hay algun dispositivo todos encendido", esperado, cliente.algunDispositivoEncendido());
	}

	@Test
	public void consumoDeDispTotalPorHora() {

		assertEquals(484.9, cliente.consumoTotalporHora(), 1.0);

	}

	@Test
	public void testRecategorizarYConsumoMensual() {
		double esperado = 484.9;

		Categoria categ = new Categoria(1, 1, 1, 1);
		cliente.recategorizar(categ);

		assertEquals(esperado, cliente.gastoTotal(), 1.0);

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
