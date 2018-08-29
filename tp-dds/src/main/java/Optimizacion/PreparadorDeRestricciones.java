package Optimizacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;

import Dispositivos.DispositivoInteligente;

public class PreparadorDeRestricciones {
	
	public Collection<LinearConstraint> prepararRestricciones(List<DispositivoInteligente> dispositivos) 
	{	
		Collection<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
        int contador = 0;
		for (DispositivoInteligente dispositivoInteligente : dispositivos)
		{	
			double[] a = new double[contador+1];
			a[contador] =1;			
			restricciones.add(new LinearConstraint(
					a , 
					       		Relationship.LEQ,dispositivoInteligente.getConsumoMensualMaximo()));	
			
			restricciones.add(new LinearConstraint(
					a, 
								Relationship.GEQ,dispositivoInteligente.getConsumoMensualMinimo()));							
			contador++;											
		}
		return restricciones;
	}	
}
