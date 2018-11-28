package Repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Dispositivos.DispositivoInteligente;

public class RepoDispositivoInteligente implements WithGlobalEntityManager{

	public static RepoDispositivoInteligente instancia = new RepoDispositivoInteligente();
	private static RepoDispositivoInteligente instance = null;
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
			
	private RepoDispositivoInteligente() {
	}

	static RepoDispositivoInteligente getInstance() {
	  if (instance == null) {
			instance = new RepoDispositivoInteligente();
	  } 
	   return instance;
	 }

	public void insertarDispInteligente(DispositivoInteligente unDispositivo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				entityManager.persist(unDispositivo);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}
	
	public void actualizarDispInteligente(DispositivoInteligente unDispositivo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				Integer id = entityManager.merge(unDispositivo).getId();
				unDispositivo.setId(id);
				entityManager.getTransaction().commit();			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}

	public void eliminarDispInteligente(DispositivoInteligente unDispositivo) {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					entityManager.getTransaction().begin();
					entityManager.remove(unDispositivo);
					entityManager.getTransaction().commit();
				} catch (PersistenceException e) {
					e.printStackTrace();
					entityManager.getTransaction().rollback();
					throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
				} finally {
					entityManager.close();
				}
	}	
	
	public List<DispositivoInteligente> listar() {
		return entityManager().createQuery("from DispositivoInteligente", DispositivoInteligente.class)
			.getResultList();
	}
	
}
