package Utilitarios;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Geoposicionamiento.Transformador;

public class ReporteTransformadorPeriodo implements WithGlobalEntityManager{
	
	LocalDateTime fechaDesde;
	LocalDateTime fechaHasta;
	
	Map<String, Double> resultadoReporte = new HashMap<>();
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
	
	public ReporteTransformadorPeriodo(LocalDateTime _fechaDesde, LocalDateTime _fechaHasta, int _idTransformador) {
		fechaDesde = _fechaDesde;
		fechaHasta = _fechaHasta;
	}
	
	// RESULTADO DE LA CONSULTA:
	// transf1 - 500000
	// transf2 - 12310
	// trans3 - 145000
	
	public Map<Integer, Double> generarConsulta(){
		
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	Map<Integer, Double> consumoTransformadores = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	List<Transformador> transformadores = entityManager.createQuery("from Transformador").getResultList();
	
	for(Transformador transf : transformadores) {		
		Double consumo = transf.cantidadEnergiaSuministrada(fechaDesde, fechaHasta);
		consumoTransformadores.put(transf.getId(),consumo);	
	}			
	
	return consumoTransformadores;
	
  }
	
}