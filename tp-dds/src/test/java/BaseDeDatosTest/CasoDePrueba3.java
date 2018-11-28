package BaseDeDatosTest;
import static org.junit.Assert.*;

import java.util.List;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import Automatizaciones.ActuadorApagar;
import Automatizaciones.Condicion;
import Automatizaciones.Operacion;
import Automatizaciones.Regla;
import Automatizaciones.Sensor;
import BaseDeDatos.ManagerDataBase;

public class CasoDePrueba3 {
	EntityManager entityManager = ManagerDataBase.getEntityManager();
	Condicion condicionTempMayorIgual;
	Condicion condicionTempMenorIgual;
	Sensor sensorTempe; 
	ActuadorApagar actuadorApagar;
	List<Condicion> condiciones;
	Regla reglaDeInvierno;
	@Before
	public void setUp() throws Exception {
		
		condicionTempMayorIgual = new Condicion(25,Operacion.MayorIgualque);	
		condicionTempMenorIgual = new Condicion(21,Operacion.MenorIgualque);
		actuadorApagar = new ActuadorApagar();
		
	}

	@Test
	public void test() {
		
		sensorTempe = new Sensor();
		
		reglaDeInvierno =new Regla();
		
		//reglaDeInvierno.addActuador(actuadorApagar);
		reglaDeInvierno.addCondicion(condicionTempMayorIgual);
		reglaDeInvierno.addCondicion(condicionTempMenorIgual);
		sensorTempe.addRegla(reglaDeInvierno);
		
		entityManager.getTransaction().begin();
		entityManager.persist(sensorTempe);
		entityManager.getTransaction().commit();
		
		Sensor sensorRecuperado = entityManager.find(Sensor.class, new Integer(1));
		Regla reglaRecuperada = sensorRecuperado.getReglas().get(0);
		Condicion condicionReucperada = reglaRecuperada.getCondiciones().get(0);
		
		entityManager.getTransaction().begin();
		condicionReucperada.setComparador(Operacion.Menorque);
		condicionReucperada.setValorDerecha(6);
		entityManager.getTransaction().commit();
		
		Sensor sensorRecuperado2 = entityManager.find(Sensor.class, new Integer(1));
		Regla reglaRecuperada2 = sensorRecuperado2.getReglas().get(0);
		Condicion condicionRecuperada2 = reglaRecuperada2.getCondiciones().get(0);
		
		int valorEsperado = 6;
		
		assertEquals(valorEsperado, condicionRecuperada2.getValorDerecha());
	}

}
