package Repositorios;

import Usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;

public class RepoClientes {
	
	private static RepoClientes instance = null;
	public static RepoClientes instancia = new RepoClientes();
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
			
	private RepoClientes() {
			}

	public static RepoClientes getInstance() {
	  if (instance == null) {
			instance = new RepoClientes();
	  } 
	   return instance;
	 }

	public void insertarCliente(Cliente cliente) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				entityManager.persist(cliente);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}
	
	public void actualizarCliente(Cliente cliente) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
				entityManager.getTransaction().begin();
				Integer id = entityManager.merge(cliente).getId();
				cliente.setId(id);
				entityManager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
		} finally {
			entityManager.close();
		}
	}

		public void eliminarCliente(Cliente cliente) {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					entityManager.getTransaction().begin();
					entityManager.remove(cliente);
					entityManager.getTransaction().commit();
				} catch (PersistenceException e) {
					e.printStackTrace();
					entityManager.getTransaction().rollback();
					throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e);
				} finally {
					entityManager.close();
				}
			}
		
		
		public Cliente buscarPorUserName(String usuarioID) {
			
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return  (Cliente) entityManager.createQuery("FROM Cliente c WHERE c.username = :custName")
			    	.setParameter("custName", usuarioID).getSingleResult();
		}
		
		public List<Cliente> listar() {
			
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = entityManager.createQuery("from Cliente").getResultList();
			
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
		
		public Cliente buscarPorNombre(String nombre) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return  (Cliente) entityManager.createQuery("FROM Cliente c WHERE c.nombre = :nombre")
			    	.setParameter("nombre", nombre).getSingleResult();
		}
		
		public Cliente buscar(Integer id){
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return (Cliente) entityManager.find(Cliente.class, id);
		}
		
		@SuppressWarnings("unchecked")
		public List<DispositivoEstandar> dispositivosEstandarDelCliente(long id) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return entityManager.createQuery("from DispositivoEstandar where cliente_id = :idCliente")
				    .setParameter("idCliente", id)
				    .getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<DispositivoInteligente> dispositivosInteligenteDelCliente(long id) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return entityManager.createQuery("from DispositivoInteligente where cliente_id = :idCliente")
				    .setParameter("idCliente", id)
				    .getResultList();
		}

		public int idDelCliente(String username) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return (int) entityManager.createQuery("select id from Cliente where username = :username")
				    .setParameter("username", username)
				    .getSingleResult();
		}
		
}