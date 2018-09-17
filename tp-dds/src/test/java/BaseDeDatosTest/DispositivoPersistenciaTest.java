package BaseDeDatosTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import BaseDeDatos.ManagerDataBase;
import Dispositivos.DispositivoEstandar;
import Funcionalidades.Categorizador;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class DispositivoPersistenciaTest {
	
	DispositivoEstandar dispositivo ;
	EntityManager entityManager =  ManagerDataBase.getEntityManager();
	Boolean encendido = true;
	Cliente cliente;
	@Before
	public void setUp() throws Exception {
			
		dispositivo = new DispositivoEstandar("TV",2,234.9);	
		TipoDocumento tipo = TipoDocumento.DNI;
		LocalDate fechaDeAlta = LocalDate.of(2018,2,1);	
		cliente = new Cliente("Jorge", "Figueroa", tipo, 33501713, 2222, "Azopardo 3636", fechaDeAlta);
		Categoria categoria = Categorizador.getInstance().R3;
		cliente.setCategoria(categoria);
		cliente.agregarDispositivoEstandar(dispositivo);
	}

	@Test
	public void test() {
		String nombreEsperado = "Cocina";
		
		entityManager.getTransaction().begin();	
		entityManager.persist(cliente);
		entityManager.persist(dispositivo);
		entityManager.getTransaction().commit();
		
		dispositivo =entityManager.find(DispositivoEstandar.class,new Integer(1));
		
		//Fata listar el intervalo que estuvo encendido 
		entityManager.getTransaction().begin();
		dispositivo.setNombre("Cocina");
		entityManager.getTransaction().commit();
		
		DispositivoEstandar dispositivo2 =entityManager.find(DispositivoEstandar.class,new Integer(1));
		assertEquals(nombreEsperado, dispositivo2.getNombre());

		
	}

}
