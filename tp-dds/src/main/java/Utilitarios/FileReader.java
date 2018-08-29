package Utilitarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Excepciones.ExcepcionFileReader;

public class FileReader {

	
	public byte[] leerArchivo(String path) {
		
		byte[]	formatoJson = null;
		
		if(path.isEmpty()) {
			
			throw new ExcepcionFileReader("La Ruta del archivo esta vacia");
		}else
		
		
			try {
				formatoJson = Files.readAllBytes(Paths.get(path));
			} catch (IOException e) {
			
				throw new ExcepcionFileReader("Error de lectura en el archivo");
			}	
		
		return formatoJson;
	   }
				
}
