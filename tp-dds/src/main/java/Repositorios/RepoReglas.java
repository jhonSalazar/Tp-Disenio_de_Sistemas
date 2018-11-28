package Repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import Automatizaciones.Regla;

public class RepoReglas {

	private static RepoReglas instance = null;
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
			
	private RepoReglas() {
	}

	static RepoReglas getInstance() {
	  if (instance == null) {
			instance = new RepoReglas();
	  } 
	   return instance;
	 }

	public void insertarRegla(Regla unaRegla) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				entityManager.persist(unaRegla);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}
	
	public void actualizarRegla(Regla unaRegla) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				Integer id = entityManager.merge(unaRegla).getId();
				unaRegla.setId(id);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}

	public void eliminarRegla(Regla unaRegla) {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					entityManager.getTransaction().begin();
					entityManager.remove(unaRegla);
					entityManager.getTransaction().commit();
				} catch (PersistenceException e) {
					e.printStackTrace();
					entityManager.getTransaction().rollback();
					throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
				} finally {
					entityManager.close();
				}
	}
	
	
}
