package BaseDeDatosTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import BaseDeDatos.ManagerDataBase;
import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.Fabricante;
import Dispositivos.FabricanteLG;
import Dispositivos.FabricanteSamsung;
import Funcionalidades.Categorizador;
import Geoposicionamiento.Punto;
import Geoposicionamiento.Transformador;
import Geoposicionamiento.ZonaGeografica;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class CasoDePrueba5 {
	
	List<Point> puntos;
	ZonaGeografica zona;
	Transformador transformador1, transformador2;
	DispositivoEstandar DE1,DE2,DE3,DE4;
	DispositivoInteligente DI1,DI2,DI3,DI4,DI5;
	Cliente cliente1, cliente2,cliente3,cliente4;
	Estado apagado = Estado.APAGADO;
	Estado encendido = Estado.ENCENDIDO;
	Fabricante fabricanteSamsung, fabricanteLG;
	LocalDateTime fechaDesde,fechaHasta,fechaDesde1,fechaHasta1,fechaDesde2,fechaHasta2;
	ConsumoDispositivosInteligente consumoDI1,consumoDI2,consumoDI3,consumoDI4,consumoDI5,consumoDI6;
	Punto point1, point2, point3;
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
		
		DI4 = new DispositivoInteligente("Licuadora", 100.0);
		DI4.setEstado(apagado);
		DI4.setFabricante(fabricanteLG);
		
		DI5 = new DispositivoInteligente("Pecera", 500.0);
		DI5.setEstado(apagado);
		DI5.setFabricante(fabricanteLG);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI3 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI4 = new ConsumoDispositivosInteligente(fechaDesde, fechaHasta);
		consumoDI5 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		consumoDI6 = new ConsumoDispositivosInteligente(fechaDesde2, fechaHasta2);
		
		fechaDesde = LocalDateTime.of(2018,11,01, 12,00);
		fechaHasta = LocalDateTime.of(2018,11,01, 21,00);
		fechaDesde1 = LocalDateTime.of(2018,11,02, 8,00);
		fechaHasta1 = LocalDateTime.of(2018,11,02, 12,00);
		fechaDesde2 = LocalDateTime.of(2018,11,03, 10,00);
		fechaHasta2 = LocalDateTime.of(2018,11,03, 12,00);
		
		TipoDocumento tipo = TipoDocumento.DNI;
		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);
		Categoria esperado = Categorizador.getInstance().R3;
		cliente1 = new Cliente("Gabriel", "Figueroa", tipo, 39501713, 2222, "Azopardo 3636", fechaDeAlta);
		cliente2 = new Cliente("Martin", "Isnardi", tipo, 33501813, 2222, "Sarandi 3636", fechaDeAlta);
		cliente3 = new Cliente("Fede", "Perez", tipo, 39501713, 2222, "Azopardo 3636", fechaDeAlta);
		cliente4 = new Cliente("Jorge", "Muhsisoglu", tipo, 33457756, 2222, "Falsa 1234", fechaDeAlta);
		
		cliente1.setCategoria(esperado);
		cliente2.setCategoria(esperado);
		cliente3.setCategoria(esperado);
		cliente4.setCategoria(esperado);
		
		cliente1.agregarDispositivoEstandar(DE1);
		cliente1.agregarDispositivoInteligente(DI1);
		
		cliente2.agregarDispositivoEstandar(DE2);
		cliente2.agregarDispositivoInteligente(DI2);

		cliente3.agregarDispositivoEstandar(DE3);
		cliente3.agregarDispositivoInteligente(DI3);
		
		cliente4.agregarDispositivoInteligente(DI4);
		cliente4.agregarDispositivoInteligente(DI5);
		
		transformador1 = new Transformador(23.23, 234.9);
		transformador2 = new Transformador(21.98, 234.9);
		
		transformador1.agregarClientes(cliente1);
		transformador1.agregarClientes(cliente2);
						
		transformador2.agregarClientes(cliente3);
		transformador2.agregarClientes(cliente4);

		point1 = new Punto(2.55, 23.98);
		point2 = new Punto(2.58, 24.97);
		point3 = new Punto(2.95, 24.92);
		
		puntos = new ArrayList<Point>();
		
		puntos.add(point1);
		puntos.add(point2);
		puntos.add(point3);
		
		zona = new ZonaGeografica(puntos);
		
		zona.agregarTransformadores(transformador1);
		zona.agregarTransformadores(transformador2);
		
	}

	@Test
	public void test() {
		entityManager.getTransaction().begin();
		entityManager.persist(zona);
		entityManager.persist(cliente1);
		entityManager.persist(cliente2);
		entityManager.persist(cliente3);
		entityManager.persist(cliente4);
		entityManager.persist(DE1);
		entityManager.persist(DE2);
		entityManager.persist(DE3);
		entityManager.persist(DI1);
		entityManager.persist(DI2);
		entityManager.persist(DI3);
		entityManager.persist(DI4);
		entityManager.persist(DI5);
		DI1.encender(fechaDesde, consumoDI1);
		DI1.apagar(fechaHasta, consumoDI1);
		DI2.encender(fechaDesde, consumoDI2);
		DI2.apagar(fechaHasta, consumoDI2);
		DI3.encender(fechaDesde, consumoDI3);
		DI3.apagar(fechaHasta, consumoDI3);
		DI4.encender(fechaDesde, consumoDI4);
		DI4.apagar(fechaHasta, consumoDI4);
		
		DI1.encender(fechaDesde1, consumoDI5);
		DI1.apagar(fechaHasta1, consumoDI5);
		DI1.encender(fechaDesde2, consumoDI6);
		DI1.apagar(fechaHasta2, consumoDI6);
		
		entityManager.persist(consumoDI1);
		entityManager.persist(consumoDI2);
		entityManager.persist(consumoDI3);
		entityManager.persist(consumoDI4);
		entityManager.persist(transformador1);
		entityManager.persist(transformador2);
		entityManager.getTransaction().commit();
		
		Integer idDispositivo1 = DI1.getId();
		
		@SuppressWarnings("unchecked")
		List<DispositivoInteligente> dispInteligenteCliente4 = entityManager
				.createQuery("from DispositivoInteligente " +
				"where cliente_id = :idCliente ")
				.setParameter("idCliente", cliente4.getId())
				.getResultList();
		
		List<Double> consumos = new ArrayList<>();
		
		for(DispositivoInteligente dispositivo : dispInteligenteCliente4) {
			double consumoDI = (double) entityManager
					.createQuery("select coalesce(sum(consumo),0) from ConsumoDispositivosInteligente " + 
					"where dispositivo_id = :idDispositivo " +
					"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
					.setParameter("idDispositivo", dispositivo.getId())
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta2)
					.getSingleResult();
			consumos.add(consumoDI);
		}
		
		double consumoDICliente4 = consumos.stream().mapToDouble(consumo -> consumo.longValue()).sum();
		
		double consumoTotalCliente4 = consumoDICliente4
				+ cliente4.consumoTotalDispositivosEstandarPeriodo(fechaDesde,fechaHasta2);
		
		assertEquals(900.0, consumoTotalCliente4, 1.0);
		
		System.out.println("Consumo Total del Cliente "+cliente4.getNombre()+" en el periodo "+fechaDesde+" al "+fechaHasta2+":");
		System.out.println(consumoTotalCliente4+" kWh");
		
		double consumoDI1 = (double) entityManager
				.createQuery("select coalesce(sum(consumo),0.0) from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta2")
			    .setParameter("idDispositivo", idDispositivo1)
			    .setParameter("fechaDesde", fechaDesde)
			    .setParameter("fechaHasta2", fechaHasta2)
			    .getSingleResult();
		
		Long periodosEncendidoDI1 = (Long) entityManager
				.createQuery("select coalesce(count(dispositivo_id),0) from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta2")
			    .setParameter("idDispositivo", idDispositivo1)
			    .setParameter("fechaDesde", fechaDesde)
			    .setParameter("fechaHasta2", fechaHasta2)
			    .getSingleResult();
		
		double consumoPromedioDI1 = consumoDI1/periodosEncendidoDI1;
		
		assertEquals(500.0, consumoPromedioDI1, 1.0);
		
		System.out.println("Consumo promedio del dispositivo "+DI1.getNombre()+" en el periodo "+fechaDesde+" al "+fechaHasta2+":");
		System.out.println(consumoPromedioDI1+" kWh");
		
		@SuppressWarnings("unchecked")
		List<Cliente> clientesTransformador2 = entityManager
			.createQuery("from Cliente where transformador_id = :idTransformador2")
			.setParameter("idTransformador2", transformador2.getId())
			.getResultList();
		
		List<Double> consumosTransformador2 = new ArrayList<>();
		List<Double> periodosTransformador2 = new ArrayList<>();
		
		for(Cliente cliente : clientesTransformador2) {
			
			@SuppressWarnings("unchecked")
			List<DispositivoInteligente> dispositivosInteligente = entityManager
				.createQuery("from DispositivoInteligente " +
				"where cliente_id = :idCliente ")
				.setParameter("idCliente", cliente.getId())
				.getResultList();
			
			List<Double> consumosCliente = new ArrayList<>();
			List<Long> periodos = new ArrayList<>();
			
			for(DispositivoInteligente dispositivo : dispositivosInteligente) {
				
				double consumoDI = (double) entityManager
					.createQuery("select coalesce(sum(consumo),0.0) from ConsumoDispositivosInteligente " + 
					"where dispositivo_id = :idDispositivo " +
					"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
					.setParameter("idDispositivo", dispositivo.getId())
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta2)
					.getSingleResult();
			
				consumosCliente.add(consumoDI);
				
				Long periodosEncendidoDI = (Long) entityManager
						.createQuery("select coalesce(count(dispositivo_id),0) from ConsumoDispositivosInteligente " + 
						"where dispositivo_id = :idDispositivo " +
						"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
						.setParameter("idDispositivo", dispositivo.getId())
					    .setParameter("fechaDesde", fechaDesde)
					    .setParameter("fechaHasta", fechaHasta2)
					    .getSingleResult();
				
				periodos.add(periodosEncendidoDI);
			}
			double consumosDICliente = consumosCliente.stream().mapToDouble(consumo -> consumo.longValue()).sum();
			double consumosDECliente = cliente.consumoTotalDispositivosEstandarPeriodo(fechaDesde,fechaHasta2);
			
			consumosTransformador2.add(consumosDICliente);
			consumosTransformador2.add(consumosDECliente);
			
			Long cantidadDispositivosEstandarCliente = (long) cliente.DispositivosEstandarDelCliente().size();
			periodos.add(cantidadDispositivosEstandarCliente);
			
			double periodosCliente = periodos.stream().mapToDouble(consumo -> consumo.longValue()).sum();
			periodosTransformador2.add(periodosCliente);
		
		}
		
		double consumoTransformador2 = consumosTransformador2.stream().mapToDouble(consumo -> consumo.longValue()).sum();
		double periodoTransformador2 = periodosTransformador2.stream().mapToDouble(consumo -> consumo.longValue()).sum();
		
		double consumoPromedioTransformador2 = consumoTransformador2/periodoTransformador2;
		
		assertEquals(4900.0, consumoPromedioTransformador2, 1.0);
		
		System.out.println("Consumo promedio del Transformador 2 en el periodo "+fechaDesde+" al "+fechaHasta2+":");
		System.out.println(consumoPromedioTransformador2+" kWh");
		
		Cliente unClienteT2 = (Cliente) entityManager.createQuery("from Cliente " + 
				"where transformador_id = :idTransformador2 ")
				.setParameter("idTransformador2", transformador2.getId())
			    .getResultList().get(1);
		
		DispositivoInteligente undispInteligenteClienteT2 = (DispositivoInteligente) entityManager
				.createQuery("from DispositivoInteligente " + 
				"where cliente_id = :idCliente")
				.setParameter("idCliente", unClienteT2.getId())
				.getResultList().get(0);
		
		undispInteligenteClienteT2.setPotencia(10000.0);
		
		entityManager.getTransaction().begin();
		undispInteligenteClienteT2.encender(fechaDesde, consumoDI3);
		undispInteligenteClienteT2.apagar(fechaHasta, consumoDI3);
		entityManager.persist(undispInteligenteClienteT2);
		entityManager.persist(consumoDI3);
		entityManager.getTransaction().commit();
		
		List<Double> consumosT2 = new ArrayList<>();
		List<Double> periodosT2 = new ArrayList<>();
		
		for(Cliente cliente : clientesTransformador2) {
			
			@SuppressWarnings("unchecked")
			List<DispositivoInteligente> dispositivos = entityManager
				.createQuery("from DispositivoInteligente " +
				"where cliente_id = :idCliente ")
				.setParameter("idCliente", cliente.getId())
				.getResultList();
			
			List<Double> consumosCliente = new ArrayList<>();
			List<Long> periodos = new ArrayList<>();
			
			for(DispositivoInteligente dispositivo : dispositivos) {
				
				double consumoDI = (double) entityManager
					.createQuery("select coalesce(sum(consumo),0.0) from ConsumoDispositivosInteligente " + 
					"where dispositivo_id = :idDispositivo " +
					"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
					.setParameter("idDispositivo", dispositivo.getId())
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta2)
					.getSingleResult();
			
				consumosCliente.add(consumoDI);
				
				Long periodosEncendidoDI = (Long) entityManager
						.createQuery("select coalesce(count(dispositivo_id),0) from ConsumoDispositivosInteligente " + 
						"where dispositivo_id = :idDispositivo " +
						"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
						.setParameter("idDispositivo", dispositivo.getId())
					    .setParameter("fechaDesde", fechaDesde)
					    .setParameter("fechaHasta", fechaHasta2)
					    .getSingleResult();
				
				periodos.add(periodosEncendidoDI);
			}
			
			double consumosDICliente = consumosCliente.stream().mapToDouble(consumo -> consumo.longValue()).sum();
			double consumosDECliente = cliente.consumoTotalDispositivosEstandarPeriodo(fechaDesde,fechaHasta2);
			
			consumosT2.add(consumosDICliente);
			consumosT2.add(consumosDECliente);
			
			Long cantidadDispositivosEstandarCliente = (long) cliente.DispositivosEstandarDelCliente().size();
			periodos.add(cantidadDispositivosEstandarCliente);
			
			double periodosCliente = periodos.stream().mapToDouble(consumo -> consumo.longValue()).sum();
			periodosT2.add(periodosCliente);
			
		}
		
		double consumoT2 = consumosT2.stream().mapToDouble(consumo -> consumo.longValue()).sum();
		double periodoT2 = periodosT2.stream().mapToDouble(consumo -> consumo.longValue()).sum();
		
		double nuevoConsumoPromedioT2 = consumoT2/periodoT2;
		
		assertEquals(31900.0, nuevoConsumoPromedioT2, 1.0);
		
		System.out.println("Nuevo Consumo promedio del Transformador 2: "+nuevoConsumoPromedioT2+" kWh");
		
	}

}
