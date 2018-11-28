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

public class CasoDePrueba2 {
	
	DispositivoInteligente dispositivo;
	EntityManager entityManager =  ManagerDataBase.getEntityManager();
	Estado apagado = Estado.APAGADO;
	Fabricante fabricanteLG;
	LocalDateTime fechaDesde1, fechaHasta1, fechaDesde2, fechaHasta2;
	ConsumoDispositivosInteligente consumoDI1, consumoDI2;
	
	@Before
	public void setUp() throws Exception {
		
		fabricanteLG = new Fabricante("LG");
		
		dispositivo = new DispositivoInteligente("TV",100.0);	
		dispositivo.setEstado(apagado);
		dispositivo.setFabricante(fabricanteLG);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		
		fechaDesde1 = LocalDateTime.of(2018,11,01, 12,00);
		fechaHasta1 = LocalDateTime.of(2018,11,01, 20,00);
		
		fechaDesde2 = LocalDateTime.of(2018,11,02, 9,00);
		fechaHasta2 = LocalDateTime.of(2018,11,02, 21,00);
		
	}

	@Test
	public void test() {
		String nombreEsperado = "TV LG";
		
		entityManager.getTransaction().begin();
		entityManager.persist(dispositivo);
		dispositivo.encender(fechaDesde1, consumoDI1);
		dispositivo.apagar(fechaHasta1, consumoDI1);
		entityManager.persist(consumoDI1);
		entityManager.getTransaction().commit();

		entityManager.getTransaction().begin();
		dispositivo.encender(fechaDesde2, consumoDI2);
		dispositivo.apagar(fechaHasta2, consumoDI2);
		entityManager.persist(consumoDI2);
		entityManager.getTransaction().commit();
		
		Integer idDispositivo = dispositivo.getId();

		LocalDateTime desdeEncendido1 = (LocalDateTime) entityManager
				.createQuery("select fechaDesde from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde = :fechaDesde1")
			    .setParameter("idDispositivo", idDispositivo)
			    .setParameter("fechaDesde1", fechaDesde1)
			    .getSingleResult();
		
		LocalDateTime hastaEncendido1 = (LocalDateTime) entityManager
				.createQuery("select fechaHasta from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo "+
				"and fechaHasta = :fechaHasta1")
			    .setParameter("idDispositivo", idDispositivo)
				.setParameter("fechaHasta1", fechaHasta1)
			    .getSingleResult();
		
		LocalDateTime desdeEncendido2 = (LocalDateTime) entityManager
				.createQuery("select fechaDesde from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde = :fechaDesde2")
			    .setParameter("idDispositivo", idDispositivo)
			    .setParameter("fechaDesde2", fechaDesde2)
			    .getSingleResult();
		
		LocalDateTime hastaEncendido2 = (LocalDateTime) entityManager
				.createQuery("select fechaHasta from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaHasta = :fechaHasta2")
			    .setParameter("idDispositivo", idDispositivo)
				.setParameter("fechaHasta2", fechaHasta2)
			    .getSingleResult();
		
		dispositivo =entityManager.find(DispositivoInteligente.class,new Integer(1));
		
		entityManager.getTransaction().begin();
		dispositivo.setNombre("TV LG");
		entityManager.getTransaction().commit();
		
		DispositivoInteligente dispositivo2 =entityManager.find(DispositivoInteligente.class,new Integer(1));
		assertEquals(nombreEsperado, dispositivo2.getNombre());
		
		System.out.println(dispositivo.getNombre()+" estuvo encendido en los siguientes periodos:");
		System.out.println("Desde: "+desdeEncendido1+" Hasta: "+hastaEncendido1);
		System.out.println("Desde: "+desdeEncendido2+" Hasta: "+hastaEncendido2);
		
	}

}
