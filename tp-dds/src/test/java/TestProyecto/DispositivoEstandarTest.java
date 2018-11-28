package TestProyecto;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import Dispositivos.DispositivoEstandar;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

import org.junit.Before;

public class DispositivoEstandarTest {
	

	DispositivoEstandar dis ;
	Boolean encendido = true;
	Cliente cliente;
	
	@Before
	public void Before() {
		
	 dis = new DispositivoEstandar("Heladera",2,234.9);	
	TipoDocumento tipo = TipoDocumento.DNI;
	LocalDate fechaDeAlta = LocalDate.of(2018,2,1);	
	cliente = new Cliente("Gabriel", "Figueroa", tipo, 33501713, 2222, "Azopardo 3636", fechaDeAlta);
		
	}

	//calculo realizando KwH (234.9) y horassEstimadas(2) del dispositivos.
	@Test
	public void testConsumoPorHora() {
		double esperado = 469.8;
		assertEquals(esperado,dis.consumoTotalPorDia(),1.0);
	}
	
	@Test
	public void pruebaLista() {
		cliente.agregarDispositivoEstandar(dis);
		assertEquals(1,cliente.cantidadTotalDispositivos());
		
		
	}

}
