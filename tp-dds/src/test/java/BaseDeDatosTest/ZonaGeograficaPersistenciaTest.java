package BaseDeDatosTest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import BaseDeDatos.ManagerDataBase;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.EstadoEncendido;
import Funcionalidades.Categorizador;
import Geoposicionamiento.Punto;
import Geoposicionamiento.Transformador;
import Geoposicionamiento.ZonaGeografica;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class ZonaGeograficaPersistenciaTest {
	
	List<Point> puntos;
	ZonaGeografica zona1;
	Transformador transformador1, transformador2;
	DispositivoEstandar DE1,DE2,DE3,DE4;
	DispositivoInteligente DI1,DI2,DI3,DI4,DI5;
	Cliente cliente1, cliente2,cliente3,cliente4;
	Boolean encendido = true;
	Boolean apagado = false;
	Punto point1, point2, point3;
	EntityManager entityManager = ManagerDataBase.getEntityManager();
	@Before
	public void setUp() throws Exception {
		DE1 = new DispositivoEstandar("Heladera", 2, 235.00);
		DE2 = new DispositivoEstandar("Lampara velador", 3, 15.00);
		DE3 = new DispositivoEstandar("Lampara auxiliar", 2, 20.00);
		DE4 = new DispositivoEstandar("Cargador", 3, 100.00);

		DI1 = new DispositivoInteligente("computadora", 100.0);
		DI1.setEstado(new EstadoEncendido());

		DI2 = new DispositivoInteligente("Lavarropas", 200.0);
		DI2.setEstado(new EstadoEncendido());
		
		DI3 = new DispositivoInteligente("Cafetera", 1000.0);
		DI3.setEstado(new EstadoEncendido());
		
		DI4 = new DispositivoInteligente("Licuadora", 100.0);
		DI4.setEstado(new EstadoEncendido());
		
		DI5 = new DispositivoInteligente("Pecera", 600.0);
		DI5.setEstado(new EstadoEncendido());
		
		TipoDocumento tipo = TipoDocumento.DNI;
		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);
		Categoria esperado = Categorizador.getInstance().R3;
		cliente1 = new Cliente("Gabriel", "Figueroa", tipo, 39501713, 2222, "Azopardo 3636", fechaDeAlta);
		cliente2 = new Cliente("Martin", "Isnardi", tipo, 33501813, 2222, "Sarandi 3636", fechaDeAlta);
		cliente3 = new Cliente("Fede", "Perez", tipo, 39501713, 2222, "Azopardo 3636", fechaDeAlta);
		cliente4 = new Cliente("Jorge", "Gomez", tipo, 33501813, 2222, "Sarandi 3636", fechaDeAlta);
		
		cliente1.setCategoria(esperado);
		cliente2.setCategoria(esperado);
		cliente3.setCategoria(esperado);
		cliente4.setCategoria(esperado);
		
		
		cliente1.agregarDispositivoEstandar(DE1);
		cliente1.agregarDispositivoEstandar(DE2);
		cliente1.agregarDispositivoInteligente(DI1);
		cliente1.agregarDispositivoInteligente(DI2);
		cliente1.agregarDispositivoEstandar(DE3);
		cliente1.agregarDispositivoEstandar(DE4);
		cliente1.agregarDispositivoInteligente(DI3);
		cliente1.agregarDispositivoInteligente(DI4);
		cliente1.agregarDispositivoInteligente(DI5);
		
		cliente2.agregarDispositivoEstandar(DE1);
		cliente2.agregarDispositivoEstandar(DE2);
		cliente2.agregarDispositivoInteligente(DI1);
		cliente2.agregarDispositivoInteligente(DI2);
		cliente2.agregarDispositivoEstandar(DE3);
		cliente2.agregarDispositivoEstandar(DE4);
		cliente2.agregarDispositivoInteligente(DI3);
		cliente2.agregarDispositivoInteligente(DI4);
		cliente2.agregarDispositivoInteligente(DI5);

		cliente3.agregarDispositivoEstandar(DE1);
		cliente3.agregarDispositivoEstandar(DE2);
		cliente3.agregarDispositivoInteligente(DI1);
		cliente3.agregarDispositivoInteligente(DI2);
		cliente3.agregarDispositivoEstandar(DE3);
		cliente3.agregarDispositivoEstandar(DE4);
		cliente3.agregarDispositivoInteligente(DI3);
		cliente3.agregarDispositivoInteligente(DI4);
		cliente3.agregarDispositivoInteligente(DI5);
		
		cliente4.agregarDispositivoEstandar(DE1);
		cliente4.agregarDispositivoEstandar(DE2);
		cliente4.agregarDispositivoInteligente(DI1);
		cliente4.agregarDispositivoInteligente(DI2);
		cliente4.agregarDispositivoEstandar(DE3);
		cliente4.agregarDispositivoEstandar(DE4);
		cliente4.agregarDispositivoInteligente(DI3);
		cliente4.agregarDispositivoInteligente(DI4);
		cliente4.agregarDispositivoInteligente(DI5);
		
		transformador1 = new Transformador(23.23, 234.9);
		transformador2 = new Transformador(21.98, 234.9);
		
		transformador1.agregarClientes(cliente1);
		transformador1.agregarClientes(cliente2);
						
		transformador2.agregarClientes(cliente3);
		transformador2.agregarClientes(cliente4);

		point1 = new Punto(2.55, 23.98);
		point2 = new Punto(2.58, 24.97);
		point3 = new Punto(2.95, 24.92);
		
		puntos = new ArrayList<Point>();
		
		puntos.add(point1);
		puntos.add(point2);
		puntos.add(point3);
		
		zona1 = new ZonaGeografica(puntos);
		
		zona1.agregarTransformadores(transformador1);
		zona1.agregarTransformadores(transformador2);
		
		entityManager.getTransaction().begin();
		entityManager.persist(zona1);
		entityManager.getTransaction().commit();
		
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
