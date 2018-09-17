package BaseDeDatosTest;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import BaseDeDatos.ManagerDataBase;
import Optimizacion.Optimizador;
import Usuarios.Cliente;

public class ReporteHogarPeriodo {
	EntityManager entityManagar = ManagerDataBase.getEntityManager();
	
	@Test
	public void test() {
		Cliente cliente = entityManagar.find(Cliente.class, new Integer(1));
		System.out.println(cliente.consumoTotalporHoraEstandar() + cliente.consumoTotalporHoraInteligente());
		
	}

}
