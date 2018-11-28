package Repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import Dispositivos.Fabricante;

public class RepoFabricantes {

	private static RepoFabricantes instance = null;
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
			
	private RepoFabricantes() {
	}

	static RepoFabricantes getInstance() {
	  if (instance == null) {
			instance = new RepoFabricantes();
	  } 
	   return instance;
	 }

	public void insertarFabricante(Fabricante unFabricante) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				entityManager.persist(unFabricante);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}
	
	public void actualizarFabricante(Fabricante unFabricante) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				Integer id = entityManager.merge(unFabricante).getId();
				unFabricante.setId(id);
				entityManager.getTransaction().commit();			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}

	public void eliminarFabricante(Fabricante unFabricante) {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					entityManager.getTransaction().begin();
					entityManager.remove(unFabricante);
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
