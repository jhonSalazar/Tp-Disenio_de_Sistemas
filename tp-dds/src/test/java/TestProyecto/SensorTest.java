package TestProyecto;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Automatizaciones.Sensor;

public class SensorTest {
	Sensor sensor;
	
	@Before
	public void Before() {
	   sensor = Mockito.mock(Sensor.class);
	}
	
	@Test
	public void sensorTemperaturaTest() {
		Mockito.when(sensor.getTemperatura()).thenReturn(31);
	}
	
	
	@Test
	public void sensorMovimientoTest() {
		Mockito.when(sensor.getMovimiento()).thenReturn(10);
	}
	
	
	@Test
	public void sensorLuzTest() {
		Mockito.when(sensor.getLuz()).thenReturn(45);
	}
	
	
	@Test
	public void sensorHumedadTest() {
		Mockito.when(sensor.getHumedad()).thenReturn(20);
	}
	
}
