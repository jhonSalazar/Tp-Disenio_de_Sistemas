package TestProyecto;

import org.junit.Test;

import Excepciones.ExcepcionFileReader;
import Utilitarios.FileReader;

public class FileReaderTest {

	static String path_archivo = "./src/AdministradoresConErr.json";
	static String path_archivo1 = "./src/Administradores.json";
	static String path_archivo2 = "./src/AdministradoresConError.json";
	FileReader file = new FileReader();
	
	/* Test cuando no ecnuetra el archivo en el path */
	@Test (expected = ExcepcionFileReader.class)
	public void testArchivoNoEncontrado() {
		file.leerArchivo(path_archivo);
	}
	
	/* Test caso de lectura correcta del archivo */
	@Test
	public void testLecturaArchivoBienConfgurado() {
		file.leerArchivo(path_archivo1);
	}
	
	/* Test para el caso en que el archivo no este bien */
	@Test 
	public void testLecturaArchivoMalConfigurado() {
		file.leerArchivo(path_archivo2);
	}
	
}
