package BaseDeDatosTest;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import BaseDeDatos.ManagerDataBase;
import Funcionalidades.Categorizador;
import Geoposicionamiento.Punto;
import Geoposicionamiento.ZonaGeografica;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;
import Repositorios.RepoClientes;

public class RepoClienteTest {
	
	RepoClientes clienteDAO = RepoClientes.getInstance();
	EntityManager entityManager = ManagerDataBase.getEntityManager();
	ZonaGeografica zona1,zonaNueva;
	List<Point> puntos,puntosNuevos;
	Punto point1, point2, point3;
	
	@Before
	public void begin(){
		TipoDocumento tipo = TipoDocumento.DNI;
		Categoria esperado = Categorizador.getInstance().R3;
		
		Cliente cliente = new Cliente("Martin", "Isnardi", tipo, 1, 1, "Lomas de Zamora", LocalDate.now());
		
		cliente.setCategoria(esperado);
		
		clienteDAO.insertarCliente(cliente);
	}
	
	@Test
	public void InsertarCliente(){

		
	}
	
	@After
	public void after(){
		
	}

}
