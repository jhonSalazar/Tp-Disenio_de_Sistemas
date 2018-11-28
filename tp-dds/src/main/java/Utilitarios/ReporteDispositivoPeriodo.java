package Utilitarios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import Dispositivos.DispositivoInteligente;
import Usuarios.Cliente;

public class ReporteDispositivoPeriodo implements WithGlobalEntityManager{
	
	LocalDateTime fechaDesde;
	LocalDateTime fechaHasta;
    Integer idCliente;
	
	Map<String, Double> resultadoReporte = new HashMap<>();
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
	
	public ReporteDispositivoPeriodo(LocalDateTime _fechaDesde, LocalDateTime _fechaHasta, Integer _idCliente) {
		fechaDesde = _fechaDesde;
		fechaHasta = _fechaHasta;
		idCliente = _idCliente;
	}
	
	// RESULTADO DE LA CONSULTA:
	// heladera 321
	// microondas 450
	// televisor 321

	public Map<String, Double> generarConsulta(){
		
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	Map<String, Double> consumoPorDispositivos = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	Cliente cliente = (Cliente) entityManager.createQuery("from Cliente where id = :idCliente").getSingleResult();
	
	List<DispositivoInteligente> listaDI = new ArrayList<DispositivoInteligente>();
	listaDI = cliente.DispositivosInteligenteDelCliente();

	for(DispositivoInteligente unDisp : listaDI) {
		double consumoDI = (double) entityManager
				.createQuery("select coalesce(sum(consumo),0) from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
				.setParameter("idDispositivo", unDisp.getId())
				.setParameter("fechaDesde", fechaDesde)
				.setParameter("fechaHasta", fechaHasta)
				.getSingleResult();
		
		Long periodosEncendidoDI1 = (Long) entityManager
				.createQuery("select count(dispositivo_id) from ConsumoDispositivosInteligente " + 
				"where dispositivo_id = :idDispositivo " +
				"and fechaDesde >= :fechaDesde and fechaHasta <= :fechaHasta")
			    .setParameter("idDispositivo", unDisp.getId())
			    .setParameter("fechaDesde", fechaDesde)
			    .setParameter("fechaHasta", fechaHasta)
			    .getSingleResult();
		
		double consumoPromedioDI = consumoDI/periodosEncendidoDI1;
		
		consumoPorDispositivos.put(unDisp.getNombre(),consumoPromedioDI);
	}		
			//TENER EN CUENTA QUE NO IMPORTA EL PERIODO, OSEA ES UN PROMEDIO DE TODO EL HISTORIAL DE CONSUMO DE ESE DISPOSITIVO PARA ESE USUARIO
			//HACER UNA ABSTRACCION QUE CALCULE PROMEDIOS EN CLIENTE		
	return consumoPorDispositivos;
  }


}
