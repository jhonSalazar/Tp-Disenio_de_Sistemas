
package TestProyecto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import Dispositivos.DispositivoEstandar;
import Excepciones.ExcepcionJsonParser;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;
import Utilitarios.FileReader;
import Utilitarios.JsonParser;

public class JsonParserTest {

	
	static String path_cliente1 = "./src/ClientesConError.json";
	static String path_cliente = "./src/Clientes.json";
	
	LocalDateTime fechaDesde,fechaHasta;
	DispositivoEstandar disp;
	byte[] formatoJson ;
	byte[] formatoJsonConError ;
	List<Cliente> clientes ;
	
	JsonParser json = new JsonParser();
	FileReader file = new FileReader();

	/* El siguiente Test cumple la funcion de probar el correcto funcionamiento de parsear un archivo  
	 * en formato Json y poder crear los objetos adecuadamente*/
	
	//variables pre seteadas
	@Before
	public void setUp() {
		
		/* Leemos el archivo en formato json y pasamos a una variable de tipo Byte[]*/
		formatoJson = file.leerArchivo(path_cliente);
		formatoJsonConError = file.leerArchivo(path_cliente1);
		
		/* invocamos el metodo para parsear el formto Json de una lista determinada 
		 * Mas adelante podríamos parametrizar el tipo de lista*/
		
		clientes = json.fromJsonList(formatoJson,Cliente.class);
		
	}
	
	@Test
	/* El sigueinte Test representa la prueba de la cantidad de clientes, 
	 * el usuario espera la cantidad dede 5 clientes parseados desde el archivo 
	 *  en formato Json  */
	public void cantidadDeClientesTest() {
	
		int cantidadDeClientes =5;
		assertEquals(cantidadDeClientes, clientes.size());
		
	}
	
	/* El sigueinte Test representa la prueba de la cantidad dispositivos totales 
	 * el usuario espera la cantidad dede 15 dispositivos
	 */
	@Test
	public void cantidadTotalDeDispositivosTest() {
		int cantidadDispositivosEsperado =15;
		int[] cantDispositivos = new int[1];
		clientes.forEach(cliente->{
									cantDispositivos[0] = cantDispositivos[0] +
									cliente.cantidadTotalDispositivos();
								   });
		
		assertEquals(cantidadDispositivosEsperado,cantDispositivos[0]);

	}
	
	/* El sigueinte Test representa el consumo total de todos los clientes 
	 * el usuario espera la cantidad dede 539.0 
	 */
	
	@Test
	public void consumoTotalTest() {
		fechaDesde = LocalDateTime.of(2018,11,01, 12,00);
		fechaHasta = LocalDateTime.of(2018,11,01, 21,00);
		double consumoTotalEsperado = 4851.0;
		double[] cantconsumoTotal = new double[1];
		clientes.forEach(cliente->{
									cantconsumoTotal[0] = cantconsumoTotal[0] +
									cliente.consumoTotalPeriodo(fechaDesde, fechaHasta);
								   });	
		//System.out.println(cantconsumoTotal[0]);
		assertEquals(consumoTotalEsperado,cantconsumoTotal[0],0.07);
		
	}
	
	@Test
	public void obtenerHorasEstimadas() {
		int esperado = 1;

		List<DispositivoEstandar> disps;
		Cliente martin = clientes.get(0);
		
		disps = martin.getDispositivos();
		
		disps.forEach(dispositivo->{
			dispositivo.getHorasEstimadas();
		});
		System.out.println(disps.get(0).getHorasEstimadas());
		assertEquals(esperado,disps.get(0).getHorasEstimadas());
	}
	
	/* El siguiente Test presenta la prueba delos aitrubos del primer cliente
	 * el usuario espera los siguientes atributos-valores:
	 * "nombre": "Jhon",
       "apellido": "Torres",
       "tipoDocumento": "DNI",
       "numeroDocumento": 91970764,
       "telefono": 1511454511,
       "domicilio": "Marte 1929, San Isidro",
       "fechaDeAlta":"2018-02-12" */
	
	@Test
	public void atributosDePrimerClienteTest() {
		String nombreEsperado = "Jhon";
		String apellidoEsperado ="Torres";
		TipoDocumento  tipoDocumentoEsperado = TipoDocumento.DNI;
		int numeroDocumentoEsperado =91970764 ;
		int telefonoEsperado = 1511454511;
		String domicilioEsperado = "Marte 1929, San Isidro";
		
		Cliente jhon = clientes.get(0);
		
		assertEquals(nombreEsperado,jhon.getNombre());
		assertEquals(apellidoEsperado,jhon.getApellido());
		assertEquals(tipoDocumentoEsperado,jhon.getTipoDocumento());
		assertEquals(numeroDocumentoEsperado,jhon.getNumeroDocumento());
		assertEquals(telefonoEsperado,jhon.getTelefono());
		assertEquals(domicilioEsperado,jhon.getDomicilio());
	}
	
	@Test 
	/* El sigueinte Test presenta la prueba del consumo total del Quinto cliente
	 * El usario espera el valor de 40.0*/
	public void consumoTotalDelQuintoClienteTest() {
		List<DispositivoEstandar> disps;
		double consumoEsperado=40.0;
		double[] consumo = new double[1];
		Cliente martin = clientes.get(0);
		
		disps = martin.getDispositivos();
		
		disps.forEach(dispositivo->{
			consumo[0] =+dispositivo.consumoPorHora();
		});
		
		assertEquals(consumoEsperado,consumo[0],0.07);
		
	}
		
	/* Test caso de lectura correcta del json */
	@Test
	public void testLecturaCorrectaDelJson() {
		file.leerArchivo(path_cliente);
	}
	
	/* Test para el caso en que el formato de json no este bien */
	@Test (expected = ExcepcionJsonParser.class)
	public void testLecturaIncorrectaDelArchivo() {
		json.fromJsonList(formatoJsonConError,Cliente.class);
	}
	
}

