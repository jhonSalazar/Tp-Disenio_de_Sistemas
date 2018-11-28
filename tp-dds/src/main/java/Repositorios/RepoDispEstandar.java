package Repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Dispositivos.DispositivoEstandar;

public class RepoDispEstandar implements WithGlobalEntityManager{

	public static RepoDispEstandar instancia = new RepoDispEstandar();	
	private static RepoDispEstandar instance = null;
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
			
	private RepoDispEstandar() {
	}

	static RepoDispEstandar getInstance() {
	  if (instance == null) {
			instance = new RepoDispEstandar();
	  } 
	   return instance;
	 }

	public void insertarDispEstandar(DispositivoEstandar unDispositivo) {
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
	
	public void actualizarDispEstandar(DispositivoEstandar unDispositivo) {
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

	public void eliminarDispEstandar(DispositivoEstandar unDispositivo) {
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
	
	public List<DispositivoEstandar> listar() {
		return entityManager().createQuery("from DispositivoEstandar", DispositivoEstandar.class)
			.getResultList();
	}
	
}
