package UtilitariosSpark;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import Usuarios.Administrador;
import Usuarios.Cliente;

public class ValidadorSession {
	
	public static boolean validarSessionCliente(Cliente cliente,String username, String password )
	{	
		String passwordFront =  Hashing.sha256()
				  .hashString(password, StandardCharsets.UTF_8)
				  .toString();
		
		return (cliente.getUsername().equals(username) && passwordFront.equals(cliente.getPassword()));
	}
	
	public static boolean validarAdmin(Administrador unAdmin,String username, String password )
	{	
		String passwordFront =  Hashing.sha256()
				  .hashString(password, StandardCharsets.UTF_8)
				  .toString();
		
		return (unAdmin.getUsername().equals(username) && passwordFront.equals(unAdmin.getPassword()));
	}
	
}
