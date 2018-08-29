package TestProyecto;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Automatizaciones.*;

public class CondicionTest {
	Condicion condicionMayorIgual,condicionMayor,condicionIgual,condicionMenorIgual, condicionMenor;
	
	@Before
	public void Before() {
		condicionMayorIgual = new Condicion(7,Operacion.MayorIgualque);
		condicionMayor = new Condicion(8,Operacion.Mayorque);
		condicionIgual = new Condicion(2,Operacion.igual);
		condicionMenorIgual = new Condicion(15,Operacion.MenorIgualque);
		condicionMenor = new Condicion(3,Operacion.Menorque);
	}

	@Test
	public void testCondicionMayorIgual(){
		assertEquals(true, condicionMayorIgual.comparar(10));
	}
	
	@Test
	public void testCondicionMayor() {
		assertEquals(true, condicionMayor.comparar(9));
	}
	
	@Test
	public void testCondicionIgual() {
		assertEquals(true, condicionIgual.comparar(2));
	}
	
	@Test
	public void testCondicionMenorIgual() {
		assertEquals(true, condicionMenorIgual.comparar(13));
	}
	
	@Test
	public void testCondicionMenor() {
		assertEquals(true, condicionMenor.comparar(1));
	}
	
}
