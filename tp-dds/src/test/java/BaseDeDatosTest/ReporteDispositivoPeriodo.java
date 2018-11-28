package BaseDeDatosTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import BaseDeDatos.ManagerDataBase;
import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.Fabricante;
import Dispositivos.FabricanteLG;
import Dispositivos.FabricanteSamsung;
import Funcionalidades.Categorizador;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class ReporteDispositivoPeriodo {

	DispositivoEstandar DE1,DE2,DE3;
	DispositivoInteligente DI1,DI2,DI3;
	Cliente cliente;
	Estado apagado = Estado.APAGADO;
	Estado encendido = Estado.ENCENDIDO;
	Fabricante fabricanteSamsung, fabricanteLG;
	LocalDateTime fechaDesde,fechaHasta,fechaDesde1,fechaHasta1,fechaDesde2,fechaHasta2;
	ConsumoDispositivosInteligente consumoDI1,consumoDI2,consumoDI3,consumoDI4,consumoDI5,consumoDI6,consumoDI7;
	Map<String, Double> consumoPorDispositivos = new HashMap<>();
	EntityManager entityManager = ManagerDataBase.getEntityManager();
	
	@Before
	public void setUp() throws Exception {
		fabricanteSamsung = new FabricanteSamsung("samsung");
		fabricanteLG = new FabricanteLG("LG");
		
		DE1 = new DispositivoEstandar("Heladera", 24, 5000.00);
		DE2 = new DispositivoEstandar("Lampara velador", 3, 50.00);
		DE3 = new DispositivoEstandar("Cargador", 3, 100.00);

		DI1 = new DispositivoInteligente("computadora", 100.0);
		DI1.setEstado(apagado);
		DI1.setFabricante(fabricanteSamsung);

		DI2 = new DispositivoInteligente("Lavarropas", 200.0);
		DI2.setEstado(apagado);
		DI2.setFabricante(fabricanteSamsung);
		
		DI3 = new DispositivoInteligente("Cafetera", 1000.0);
		DI3.setEstado(apagado);
		DI3.setFabricante(fabricanteLG);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI3 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI4 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		consumoDI5 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		consumoDI6 = new ConsumoDispositivosInteligente(fechaDesde2, fechaHasta2);
		consumoDI7 = new ConsumoDispositivosInteligente(fechaDesde2, fechaHasta2);
		
		fechaDesde = LocalDateTime.of(2018,11,01, 12,00);
		fechaHasta = LocalDateTime.of(2018,11,01, 21,00);
		fechaDesde1 = LocalDateTime.of(2018,11,02, 8,00);
		fechaHasta1 = LocalDateTime.of(2018,11,02, 12,00);
		fechaDesde2 = LocalDateTime.of(2018,11,03, 10,00);
		fechaHasta2 = LocalDateTime.of(2018,11,03, 12,00);
		
		TipoDocumento tipo = TipoDocumento.DNI;
		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);
		Categoria esperado = Categorizador.getInstance().R3;
		cliente = new Cliente("Jorge", "Muhsisoglu", tipo, 33457756, 2222, "Falsa 1234", fechaDeAlta);
		
		cliente.setCategoria(esperado);
		
		cliente.agregarDispositivoEstandar(DE1);
		cliente.agregarDispositivoEstandar(DE2);
		cliente.agregarDispositivoEstandar(DE3);
		cliente.agregarDispositivoInteligente(DI1);
		cliente.agregarDispositivoInteligente(DI2);
		cliente.agregarDispositivoInteligente(DI3);
		
		
	}
	
	@Test
	public void test() {
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.persist(DE1);
		entityManager.persist(DE2);
		entityManager.persist(DE3);
		entityManager.persist(DI1);
		entityManager.persist(DI2);
		entityManager.persist(DI3);
		DI1.encender(fechaDesde, consumoDI1);
		DI1.apagar(fechaHasta, consumoDI1);
		DI2.encender(fechaDesde, consumoDI2);
		DI2.apagar(fechaHasta, consumoDI2);
		DI3.encender(fechaDesde, consumoDI3);
		DI3.apagar(fechaHasta, consumoDI3);
		
		DI1.encender(fechaDesde1, consumoDI4);
		DI1.apagar(fechaHasta1, consumoDI4);
		DI2.encender(fechaDesde1, consumoDI5);
		DI2.apagar(fechaHasta1, consumoDI5);
		
		DI1.encender(fechaDesde2, consumoDI6);
		DI1.apagar(fechaHasta2, consumoDI6);
		DI3.encender(fechaDesde2, consumoDI7);
		DI3.apagar(fechaHasta2, consumoDI7);
		
		entityManager.persist(consumoDI1);
		entityManager.persist(consumoDI2);
		entityManager.persist(consumoDI3);
		entityManager.persist(consumoDI4);
		entityManager.persist(consumoDI5);
		entityManager.persist(consumoDI6);
		entityManager.persist(consumoDI7);
		entityManager.getTransaction().commit();
		
		Cliente cliente = (Cliente) entityManager.createQuery("from Cliente").getSingleResult();
		
		List<DispositivoInteligente> dispInteligente = cliente.DispositivosInteligenteDelCliente();
		
		for(DispositivoInteligente dispositivo : dispInteligente) {
			
			double consumoDI = (double) entityManager
					.createQuery("select coalesce(sum(consumo),0) from ConsumoDispositivosInteligente " + 
					"where dispositivo_id = :idDispositivo " +
					"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
					.setParameter("idDispositivo", dispositivo.getId())
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta2)
					.getSingleResult();
			
			Long periodosEncendidoDI1 = (Long) entityManager
					.createQuery("select count(dispositivo_id) from ConsumoDispositivosInteligente " + 
					"where dispositivo_id = :idDispositivo " +
					"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
				    .setParameter("idDispositivo", dispositivo.getId())
				    .setParameter("fechaDesde", fechaDesde)
				    .setParameter("fechaHasta", fechaHasta2)
				    .getSingleResult();
			
			double consumoPromedioDI = consumoDI/periodosEncendidoDI1;
			
			consumoPorDispositivos.put(dispositivo.getNombre(),consumoPromedioDI);
			
		}
		System.out.println("Consumo Promedio por Dispositivo");
		System.out.println("Periodo: "+fechaDesde+" al "+fechaHasta2);
		System.out.println("Dispositivo Consumo");
		for(Map.Entry<String, Double> consumo : consumoPorDispositivos.entrySet()) {
			System.out.println(consumo.getKey()+" "+consumo.getValue());
		}
		
	}

}
