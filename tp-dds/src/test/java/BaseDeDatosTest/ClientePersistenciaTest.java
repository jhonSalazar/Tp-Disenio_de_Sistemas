package BaseDeDatosTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import BaseDeDatos.ManagerDataBase;
import Funcionalidades.Categorizador;
import Geoposicionamiento.Area;
import Geoposicionamiento.Punto;
import Geoposicionamiento.Transformador;
import Geoposicionamiento.ZonaGeografica;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class ClientePersistenciaTest {
	
	EntityManager entityManager = ManagerDataBase.getEntityManager();
	ZonaGeografica zona1,zonaNueva;
	List<Point> puntos,puntosNuevos;
	Punto point1, point2, point3;
	
	@Before
	public void begin(){
		
	}
	
	@Test
	public void InsertarCliente(){
		int id1,id2;
		id1=1;id2=1;
		TipoDocumento tipo = TipoDocumento.DNI;
		Cliente cliente = new 
		Cliente("Gabriel", "Figueroa", tipo, 1, 1, "Lomas de Zamora", LocalDate.now());
		Categoria esperado = Categorizador.getInstance().R3;
		cliente.setCategoria(esperado);

		/*inicio de persistencia de zona1*/
		Transformador tranformador = new Transformador(1,3);		
		tranformador.agregarClientes(cliente);	
		point1 = new Punto(2.55, 23.98);	
		puntos = new ArrayList<Point>();
		puntos.add(point1);
		zona1 = new ZonaGeografica(puntos);
		zona1.agregarTransformadores(tranformador);
		
		entityManager.getTransaction().begin();
		entityManager.persist(zona1);
		entityManager.getTransaction().commit();
		
		/*Fin de persistencia de zona1*/
		
		ZonaGeografica zona1Recuperada = entityManager.find(ZonaGeografica.class, new Integer(1));
		
		List<Transformador> transformadoresRecuperadosZona1 = zona1Recuperada.getTransformadores();
		
		Transformador transformadorRecuperadoZona1 = transformadoresRecuperadosZona1.get(0);
		
		List<Cliente> clientesRecuperadosZona1 = transformadorRecuperadoZona1.getClientes();
		
		
		Cliente clienteRecuperado = clientesRecuperadosZona1.get(0);
		System.out.println("El cliente: "+clienteRecuperado.getNombre()
		+" Esta en la zona latitud= "+ transformadorRecuperadoZona1.getLatitud() +"Longitud= "+ transformadorRecuperadoZona1.getLongitud());
		
		
		
		
		
		double latitudEsperada=4.0,longitudEsperada=7.0;
		
		Transformador tranformadorNuevo = new Transformador(4,7);
		tranformadorNuevo.agregarClientes(clienteRecuperado);
		point2 = new Punto(10.58, 18.97);
		puntosNuevos = new ArrayList<Point>();
		puntosNuevos.add(point2);
		zonaNueva = new ZonaGeografica(puntosNuevos);
		zonaNueva.agregarTransformadores(tranformadorNuevo);
		
		entityManager.getTransaction().begin();
		entityManager.persist(zonaNueva);
		entityManager.getTransaction().commit();		
		
		
		ZonaGeografica zona1Recuperada2 = entityManager.find(ZonaGeografica.class, new Integer(2));
		
		List<Transformador> transformadoresRecuperadosZona2 = zona1Recuperada2.getTransformadores();
		
		Transformador transformadorRecuperadoZona2 = transformadoresRecuperadosZona2.get(0);
		
		List<Cliente> clientesRecuperadosZona2 = transformadorRecuperadoZona2.getClientes();
		Cliente clienteRecuperado2 = clientesRecuperadosZona2.get(0);
		
		
		System.out.println("El cliente: "+clienteRecuperado2.getNombre()
		+" Esta en la nueva zona latitud= "+ transformadorRecuperadoZona2.getLatitud() +"Longitud= "+ transformadorRecuperadoZona2.getLongitud());
		
		
		
		assertEquals(latitudEsperada, transformadorRecuperadoZona2.getLatitud(),0.1);
		assertEquals(longitudEsperada, transformadorRecuperadoZona2.getLongitud(),0.1);
		//entityManager.getTransaction().rollback();
		//entityManager.clear();
	}
	
	@After
	public void after(){
		
	}

}
