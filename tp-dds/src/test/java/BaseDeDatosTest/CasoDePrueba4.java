package BaseDeDatosTest;

import static org.junit.Assert.*;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;

import BaseDeDatos.ManagerDataBase;
import Geoposicionamiento.Transformador;
import Utilitarios.FileReader;
import Utilitarios.JsonParser;

public class CasoDePrueba4 {
	
	EntityManager entityManager = ManagerDataBase.getEntityManager();
	
	@Test
	public void test() {
		long anterior,actual;
		String path_tranformador = "./src/transformadorUnitario.json";
		
		byte[] formatoJson ;		
		JsonParser json = new JsonParser();
		FileReader file = new FileReader();
		
		formatoJson = file.leerArchivo(path_tranformador);
		Transformador transformador = json.fromJson(formatoJson, Transformador.class);
		
		@SuppressWarnings("unchecked")
		List<Transformador> transformadores = entityManager.createQuery("from Transformador").getResultList();
		anterior =transformadores.size();
		
		entityManager.getTransaction().begin();
		entityManager.persist(transformador);
		entityManager.getTransaction().commit();
		
		@SuppressWarnings("unchecked")
		List<Transformador> transformadores2 = entityManager.createQuery("from Transformador").getResultList();
		actual = transformadores2.size();
		
		assertEquals(anterior + 1, actual);
	}

}
