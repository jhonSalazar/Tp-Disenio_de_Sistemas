package Repositorios;

import Usuarios.Administrador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class RepoAdministradores {
		
		private static RepoAdministradores instance = null;
		private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
				
		private RepoAdministradores() {
				}

		public static RepoAdministradores getInstance() {
		  if (instance == null) {
				instance = new RepoAdministradores();
		  } 
		   return instance;
		 }

		public void insertarAdmin(Administrador unAdministrador) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			try {
					entityManager.getTransaction().begin();
					entityManager.persist(unAdministrador);
					entityManager.getTransaction().commit();
				
			} catch (PersistenceException e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
			} finally {
				entityManager.close();
			}
		}
		
		public void actualizarAdmin(Administrador unAdministrador) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			try {
					entityManager.getTransaction().begin();
					Integer id = entityManager.merge(unAdministrador).getId();
					unAdministrador.setId(id);
					entityManager.getTransaction().commit();
				
			} catch (PersistenceException e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
			} finally {
				entityManager.close();
			}
		}

		public void eliminarAdmin(Administrador unAdministrador) {
					EntityManager entityManager = entityManagerFactory.createEntityManager();
					try {
						entityManager.getTransaction().begin();
						entityManager.remove(unAdministrador);
						entityManager.getTransaction().commit();
					} catch (PersistenceException e) {
						e.printStackTrace();
						entityManager.getTransaction().rollback();
						throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
					} finally {
						entityManager.close();
					}
		}
		
		public Administrador buscarPorUsername(String username) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return  (Administrador) entityManager.createQuery("FROM Administrador c WHERE c.username = :adminID")
			    	.setParameter("adminID", username).getSingleResult();
		}

	}
