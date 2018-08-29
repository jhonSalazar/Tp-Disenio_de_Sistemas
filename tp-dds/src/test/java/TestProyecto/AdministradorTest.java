package TestProyecto;


import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.Test;

import Usuarios.Administrador;
import Utilitarios.FechaDelSistema;
import Utilitarios.FileReader;
import Utilitarios.JsonParser;

import org.junit.Before;


public class AdministradorTest {

	Administrador adm;
	LocalDate fechaDeAlta;
	
	static String path_administrador = "./src/Administradores.json";
	byte[] formatoJsonAdmin;
	List<Administrador> listAdmin;
	JsonParser json = new JsonParser(); 
	FileReader leerArch = new FileReader();

	@Before
	public void Before() {
		
			
		fechaDeAlta = LocalDate.of(2017,5,12);

		adm = new Administrador("Pepe","Argento","Avenida de Mayo 567",fechaDeAlta);

	}
	@Before
	public void setUp() {

		/* Leemos el archivo en formato json y pasamos auna variable de tipo Byte[] */
		formatoJsonAdmin = leerArch.leerArchivo(path_administrador);

		/*
		 * invocamos el metodo para parsear el formto Json de una lista determinada Mas
		 * adelante podríamos parametrizar el tipo de lista
		 */

		listAdmin = json.fromJsonList(formatoJsonAdmin, Administrador.class);

	}

	@Test
	public void testMesesComoAdministrador() {
		FechaDelSistema fechaDelSistema = new FechaDelSistema();
		long valorEsperado = ChronoUnit.MONTHS.between(fechaDeAlta, fechaDelSistema.getFechaDelSistema());	
		assertEquals(valorEsperado, adm.cantidadDeMesesComoAdministrador(), 1.0);
	}

	
	@Test
	/*
	 * El siguiente Test representa la prueba de la cantidad de administradores, el
	 * usuario espera la cantidad de 3 administradores parseados desde el archivo en
	 * formato Json
	 */
	public void cantidadDeAdministadoresTest() {

		int cantidadDeAdministradores = 3;
		assertEquals(cantidadDeAdministradores, listAdmin.size());

	}

	/*
	 * El siguiente Test presenta la prueba de los atributos del primer Administrador, el
	 * usuario espera los siguientes atributos-valores: "nombre": "Gerardo",
	 * "apellido": "Gonzalez", "domicilio": "Boedo 460, Lomas de Zamora",
	 * "fechaDeAlta": "2018-02-02"
	 */

	@Test
	public void atributosDePrimerAdministradorTest() {

		String nombreEsperado = "Gerardo";
		String apellidoEsperado = "Gonzalez";
		String domicilioEsperado = "Boedo 460, Lomas de Zamora";
		LocalDate fechaDeAltaEsperada = LocalDate.of(2018, 2, 2);
		Administrador admin = listAdmin.get(0);

		assertEquals(nombreEsperado, admin.getNombre());
		assertEquals(apellidoEsperado, admin.getApellido());
		assertEquals(domicilioEsperado, admin.getDomicilio());
		assertEquals(fechaDeAltaEsperada, admin.getFechaDeAlta());
	}

}
