package Utilitarios;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import Usuarios.Cliente;

public class ReporteHogarPeriodo implements WithGlobalEntityManager{
	
	LocalDateTime fechaDesde;
	LocalDateTime fechaHasta;
	Integer idCliente;
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
	
	public ReporteHogarPeriodo(LocalDateTime _fechaDesde, LocalDateTime _fechaHasta) {
		fechaDesde = _fechaDesde;
		fechaHasta = _fechaHasta;
	}
	
	public ReporteHogarPeriodo(LocalDateTime _fechaDesde, LocalDateTime _fechaHasta, Integer _idCliente) {
		fechaDesde = _fechaDesde;
		fechaHasta = _fechaHasta;
		idCliente = _idCliente;
		
	}
	
	// RESULTADO DE LA CONSULTA:
	// CLIENTE PEREZ - 1900KWH
	// CLIENTE GOMEZ - 893KWH
	// CLIENTE RODRIGUEZ - 1100KWH
	
	public Map<String, Double> generarConsulta(){
		
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	Map<String, Double> consumoClientes = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	List<Cliente> clientes = entityManager.createQuery("from Cliente").getResultList();
	
	for(Cliente cliente : clientes) {		
		Double consumo = cliente.consumoTotalPeriodo(fechaDesde, fechaHasta);
		consumoClientes.put(cliente.getNombre(),consumo);	
	}			
	return consumoClientes;
  }
	
}	