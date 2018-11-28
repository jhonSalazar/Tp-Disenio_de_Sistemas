package BaseDeDatosTest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import BaseDeDatos.ManagerDataBase;
import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.Fabricante;

public class ConsumoDispositivosInteligentePersistenciaTest {
	
	DispositivoInteligente DI1,DI2;
	EntityManager entityManager =  ManagerDataBase.getEntityManager();
	Estado encendido = Estado.ENCENDIDO;
	Estado ahorroEnergia = Estado.AHORROENERGIA;
	Estado apagado = Estado.APAGADO;
	Fabricante fabricanteSamsung, fabricanteLG;
	LocalDateTime fechaDesde1, fechaHasta1, fechaDesde2, fechaHasta2;
	ConsumoDispositivosInteligente consumoDI1, consumoDI2;
	
	@Before
	public void setUp() throws Exception {
		
		Fabricante fabricanteSamsung = new Fabricante("Samsung");
		Fabricante fabricanteLG = new Fabricante("LG");
		
		DI1 = new DispositivoInteligente("computadora", 100.0);
		DI1.setEstado(apagado);
		DI1.setFabricante(fabricanteSamsung);

		DI2 = new DispositivoInteligente("Lavarropas", 200.0);
		DI2.setEstado(ahorroEnergia);
		DI2.setFabricante(fabricanteLG);
		
		fechaDesde1 = LocalDateTime.of(2018,04,01, 12,00);
		fechaDesde2 = LocalDateTime.of(2018,04,01, 9,00);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde2, fechaHasta2);
		
		DI1.encender(fechaDesde1, consumoDI1);
		DI2.encender(fechaDesde2, consumoDI2);
		
		fechaHasta1 = LocalDateTime.of(2018,04,01, 20,00);
		fechaHasta2 = LocalDateTime.of(2018,04,01, 21,00);
		
		DI1.apagar(fechaHasta1, consumoDI1);
		DI2.apagar(fechaHasta2, consumoDI2);
		
	}
	
	@Test
	public void test() {
		entityManager.getTransaction().begin();
		entityManager.persist(DI1);
		entityManager.persist(DI2);
		entityManager.persist(consumoDI1);
		entityManager.persist(consumoDI2);
		entityManager.getTransaction().commit();
		
		Integer idDispositivo1 = DI1.getId();
		Integer idDispositivo2 = DI2.getId();
		
		double consumoDI1 = (double) entityManager.createQuery("select consumo from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde = :fechaDesde " +
				"and fechaHasta = :fechaHasta " )
			    .setParameter("idDispositivo", idDispositivo1)
			    .setParameter("fechaDesde", fechaDesde1)
			    .setParameter("fechaHasta", fechaHasta1)
			    .getSingleResult();

		assertEquals(800.00,consumoDI1,1.0);
		
		double consumoDI2 = (double) entityManager.createQuery("select consumo from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde = :fechaDesde " +
				"and fechaHasta = :fechaHasta " )
			    .setParameter("idDispositivo", idDispositivo2)
			    .setParameter("fechaDesde", fechaDesde2)
			    .setParameter("fechaHasta", fechaHasta2)
			    .getSingleResult();

		assertEquals(2400.00,consumoDI2,1.0);
		
	}
	
}
