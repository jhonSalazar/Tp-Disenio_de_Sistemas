package BaseDeDatosTest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import BaseDeDatos.ManagerDataBase;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.EstadoEncendido;
import Funcionalidades.Categorizador;
import Geoposicionamiento.Transformador;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;
import Utilitarios.FileReader;
import Utilitarios.JsonParser;

public class TransformadorPersistenciaTest {
	
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
		System.out.println(anterior);

			entityManager.getTransaction().begin();
			entityManager.persist(transformador);
			entityManager.getTransaction().commit();
				
			List<Transformador> transformadores2 = entityManager.createQuery("from Transformador").getResultList();
			actual = transformadores2.size();
			System.out.println(actual);

			assertEquals(anterior + 1, actual);
	}

}
