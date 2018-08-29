package TestProyecto;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import Geoposicionamiento.Transformador;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.EstadoEncendido;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class TransformadorTest {
	
	Transformador transformador1,transformador2;
	DispositivoEstandar DE1,DE2,DE3,DE4;
	DispositivoInteligente DI1,DI2,DI3,DI4,DI5;
	Cliente cliente1, cliente2;
	Boolean encendido = true;
	Boolean apagado = false;

	@Before
	public void Before() {
		
		transformador1 = new Transformador(2, 234.9);

		TipoDocumento tipo = TipoDocumento.DNI;

		DE1 = new DispositivoEstandar("Heladera", 2, 235.00);
		DE2 = new DispositivoEstandar("Lampara velador", 3, 15.00);
		DE3 = new DispositivoEstandar("Lampara auxiliar", 2, 20.00);
		DE4 = new DispositivoEstandar("Cargador", 3, 100.00);

		DI1 = new DispositivoInteligente("computadora", 100.0);
		DI1.setEstado(new EstadoEncendido());

		DI2 = new DispositivoInteligente("Lavarropas", 200.0);
		DI2.setEstado(new EstadoEncendido());
		
		DI3 = new DispositivoInteligente("Cafetera", 1000.0);
		DI3.setEstado(new EstadoEncendido());
		
		DI4 = new DispositivoInteligente("Licuadora", 100.0);
		DI4.setEstado(new EstadoEncendido());
		
		DI5 = new DispositivoInteligente("Pecera", 600.0);
		DI5.setEstado(new EstadoEncendido());

		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);

		cliente1 = new Cliente("Gabriel", "Figueroa", tipo, 39501713, 2222, "Azopardo 3636", fechaDeAlta);
		cliente2 = new Cliente("Martin", "Isnardi", tipo, 33501813, 2222, "Sarandi 3636", fechaDeAlta);

		cliente1.agregarDispositivoEstandar(DE1);
		cliente1.agregarDispositivoEstandar(DE2);
		cliente1.agregarDispositivoInteligente(DI1);
		cliente1.agregarDispositivoInteligente(DI2);
		cliente1.agregarDispositivoEstandar(DE3);
		cliente1.agregarDispositivoEstandar(DE4);
		cliente1.agregarDispositivoInteligente(DI3);
		cliente1.agregarDispositivoInteligente(DI4);
		cliente1.agregarDispositivoInteligente(DI5);
		
		cliente2.agregarDispositivoEstandar(DE1);
		cliente2.agregarDispositivoEstandar(DE2);
		cliente2.agregarDispositivoInteligente(DI1);
		cliente2.agregarDispositivoInteligente(DI2);
		cliente2.agregarDispositivoEstandar(DE3);
		cliente2.agregarDispositivoEstandar(DE4);
		cliente2.agregarDispositivoInteligente(DI3);
		cliente2.agregarDispositivoInteligente(DI4);
		cliente2.agregarDispositivoInteligente(DI5);

		transformador1.agregarClientes(cliente1);
		transformador1.agregarClientes(cliente2);
	}
	
	@Test
	public void testCantDeClientes() {
		int esperado = 2;
		assertEquals(esperado,transformador1.cantidadDeClientes());
	}
	
	@Test
	public void testConsumoTotal() {
		assertEquals(4740.00,transformador1.cantidadEnergiaSuministrada(),1.0);
	}
	
}
