package Repositorios;

import Geoposicionamiento.Transformador;
import Geoposicionamiento.ZonaGeografica;
import Usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import Dispositivos.DispositivoInteligente;

public class RepoZonasGeograficas {
	
	private static RepoZonasGeograficas instance = null;
	public static RepoZonasGeograficas instancia = new RepoZonasGeograficas();
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
			
	private RepoZonasGeograficas () {
	}

	static RepoZonasGeograficas getInstance() {
	  if (instance == null) {
			instance = new RepoZonasGeograficas ();
	  } 
	   return instance;
	 }

	public void insertarZona(ZonaGeografica unaZona) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				entityManager.persist(unaZona);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}
	
	public void actualizarZona(ZonaGeografica unaZona) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				Integer id = entityManager.merge(unaZona).getId();
				unaZona.setId(id);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}

	public void eliminarZona(ZonaGeografica unaZona) {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					entityManager.getTransaction().begin();
					entityManager.remove(unaZona);
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
	public List<ZonaGeografica> listarZonas() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.createQuery("from ZonaGeografica").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> clientesDeLaZona(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Transformador> transformadores = entityManager
				.createQuery("from Transformador where zona_id = :idZona")
			    .setParameter("idZona", id)
			    .getResultList();
		
		List<Cliente> clientesTransformadores = new ArrayList<>();
		
		for(Transformador transfo : transformadores) {
			
			List<Cliente> clientes = entityManager.
					createQuery("from Cliente where transformador_id = :idTransformador")
				    .setParameter("idTransformador", transfo.getId())
				    .getResultList();
			
			for(Cliente cliente : clientes) {
				
				List<DispositivoInteligente> dispositivos = cliente.DispositivosInteligenteDelCliente();
				List<Double> consumos = new ArrayList<>();
				
				for(DispositivoInteligente dispositivo : dispositivos) {
					
					Double consumoDI = (Double) entityManager
						.createQuery("select coalesce(sum(consumo),0) from ConsumoDispositivosInteligente" + 
							" where dispositivo_id = :idDispositivo ")
						.setParameter("idDispositivo", dispositivo.getId())
						.getSingleResult();
					
					consumos.add(consumoDI);
				}
				
				double consumoCliente = consumos.stream().mapToDouble(consumo -> consumo.longValue()).sum();
				cliente.setConsumo(consumoCliente);
				
				clientesTransformadores.add(cliente);
			}
		}
		return clientesTransformadores;
	}
	
}
