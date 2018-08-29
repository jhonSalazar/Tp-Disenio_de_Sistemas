package BaseDeDatosTest;

import javax.persistence.EntityManager;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import BaseDeDatos.EntityDB;
import Usuarios.Administrador;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
	
	EntityManager entityManager = EntityDB.getEntityManager();	
	@Test
	public void pruebaInsert() {
		
		entityManager.getTransaction().begin();
		Administrador admin = new Administrador("Jhon", "Salazar", "Lugano");
		entityManager.persist(admin);
		entityManager.getTransaction().commit();
		entityManager.close();
		EntityDB.close();		
		System.out.println("Entity saved.");
				
	}
	
	
	@Test
	public void pruebaFind() {
		
		entityManager.getTransaction().begin();
		Administrador admin = entityManager.find(Administrador.class, new Integer(1));
		System.out.println("Nombre:"+ admin.getNombre()+", Domicilio:"+ admin.getDomicilio());
		EntityDB.close();
				
	}
	
	
	@Test
	public void pruebaUpdate() {
		
		EntityManager entityManager = EntityDB.getEntityManager();	
		Administrador admin = entityManager.find(Administrador.class, new Integer(2));
		System.out.println("Nombre:"+ admin.getNombre()+", Domiclio:"+ admin.getDomicilio());
		
		//actualizamos el registro
		entityManager.getTransaction().begin();
		admin.setNombre("Jorge");
		entityManager.getTransaction().commit();
		admin = entityManager.find(Administrador.class, new Integer(1));
		entityManager.close();
		EntityDB.close();				
		System.out.println("Name:"+ admin.getNombre()+", Domicilio:"+ admin.getDomicilio());
		System.out.println("actualizado.");
				
	}
	
	
	
	/* prueba por default no borrrar por el momento
	@Test
	public void contextUp() {
		assertNotNull(entityManager());
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		withTransaction(() -> {});
	}*/
	
}
