package Repositorios;

import Geoposicionamiento.Transformador;
import Usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import Dispositivos.DispositivoInteligente;

public class RepoTransformadores {

	private static RepoTransformadores instance = null;
	public static RepoTransformadores instancia = new RepoTransformadores();
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
			
	private RepoTransformadores() {
	}

	static RepoTransformadores getInstance() {
	  if (instance == null) {
			instance = new RepoTransformadores();
	  } 
	   return instance;
	 }

	public void insertarTransformador(Transformador unTransformador) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				entityManager.persist(unTransformador);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}
	
	public void actualizarTransformador(Transformador unTransformador) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				Integer id = entityManager.merge(unTransformador).getId();
				unTransformador.setId(id);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}

	public void eliminarTransformador(Transformador unTransformador) {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					entityManager.getTransaction().begin();
					entityManager.remove(unTransformador);
					entityManager.getTransaction().commit();
				} catch (PersistenceException e) {
					e.printStackTrace();
					entityManager.getTransaction().rollback();
					throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
				} finally {
					entityManager.close();
				}
	}
	
	@SuppressWarnings("unchecked")
	public List<Transformador> listarTransformadores() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.createQuery("from Transformador").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> clientesDelTransformador(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Cliente> clientes = entityManager
				.createQuery("from Cliente where transformador_id = :idTransformador")
			    .setParameter("idTransformador", id)
			    .getResultList();
		
		for(Cliente cliente : clientes) {
			
			List<DispositivoInteligente> dispositivos = cliente.DispositivosInteligenteDelCliente();
			
			List<Double> consumos = new ArrayList<>();
			
			for(DispositivoInteligente dispositivo : dispositivos) {
			
				Double consumoDI = (Double) entityManager
					.createQuery("select coalesce(sum(consumo),0) from ConsumoDispositivosInteligente " + 
					"where dispositivo_id = :idDispositivo ")
					.setParameter("idDispositivo", dispositivo.getId())
					.getSingleResult();
				
				consumos.add(consumoDI);
			}
			
			double consumoCliente = consumos.stream().mapToDouble(consumo -> consumo.longValue()).sum();
			cliente.setConsumo(consumoCliente);
		}
		return clientes;
	}
	
}
