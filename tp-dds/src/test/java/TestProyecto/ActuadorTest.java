package TestProyecto;


import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Automatizaciones.Actuador;
import Dispositivos.DispositivoInteligente;

public class ActuadorTest {
	
	@Before
	public void Before() {
	}
	
	@Test
	public void testSubirVolumen() {
		Actuador actuadorSubirVolumen  = Mockito.mock(Actuador.class);
		Mockito.when(actuadorSubirVolumen.ejecutarAccion()).thenReturn(true);
	}
	
	@Test
	//el actuador quiere obtener el dispositivo inteligente
	public void testObtenerDisp() {
		DispositivoInteligente dispTv;
		Actuador actuadorSubirVolumen  = Mockito.mock(Actuador.class);
		
		dispTv = new DispositivoInteligente("tv 47 pulg",120);
		
		Mockito.when(actuadorSubirVolumen.getDisp()).thenReturn(dispTv);
	}
	
	@Test
	//se intenta apagar un dispositivo samsung
	public void testApagarDisp() {
		Actuador actuadorApagar  = Mockito.mock(Actuador.class);		
		Mockito.when(actuadorApagar.ejecutarAccion()).thenReturn(false);
	}
	
	@Test
	//obtener fecha
	public void testobtenerFecha() {
		LocalDate fecha = LocalDate.of(2017,5,12);
		Actuador actua  = Mockito.mock(Actuador.class);		
		
		Mockito.when(actua.getFecha()).thenReturn(fecha);
	}
	

}