package BaseDeDatosTest;

import java.nio.charset.StandardCharsets;

import javax.persistence.EntityManager;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import com.google.common.hash.Hashing;

import BaseDeDatos.ManagerDataBase;
import Usuarios.Administrador;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
	
	EntityManager entityManager = ManagerDataBase.getEntityManager();	
	@Test
	public void pruebaInsert() {
		
		entityManager.getTransaction().begin();
		Administrador admin = new Administrador("Administrador", "Isnardi Fisico", "Lugano","jsalazar",Hashing.sha256().hashString("Salazar1234", StandardCharsets.UTF_8).toString());
		entityManager.persist(admin);
		entityManager.getTransaction().commit();
		entityManager.close();
		ManagerDataBase.close();		
		System.out.println("Entity saved.");
				
	}

}
