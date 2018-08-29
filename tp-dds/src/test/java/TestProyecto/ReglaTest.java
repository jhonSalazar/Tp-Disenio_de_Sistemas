package TestProyecto;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import Automatizaciones.*;

public class ReglaTest {
	Condicion condicionTempMayorIgual;
	Sensor sensorTempe;
	
	@Before
	public void Before() {
		condicionTempMayorIgual = new Condicion(25,Operacion.MayorIgualque);
	}
	
	@Test
	public void evaluacionDeRegla() {	
		Regla reglaDeInvierno = Mockito.mock(Regla.class);
		reglaDeInvierno.setSensor(sensorTempe);
		Mockito.when(reglaDeInvierno.evaluar()).thenReturn(true);
	}
}
