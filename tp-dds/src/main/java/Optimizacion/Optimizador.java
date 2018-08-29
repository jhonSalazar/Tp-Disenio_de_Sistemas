package Optimizacion;

import java.util.Collection;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import Dispositivos.DispositivoInteligente;

public class Optimizador {

	private PreparadorDeEcuaciones preparadorEcuaciones;
	private PreparadorDeRestricciones preparadorRestricciones;
	
	public Optimizador() {
		preparadorEcuaciones = new PreparadorDeEcuaciones();
		preparadorRestricciones = new PreparadorDeRestricciones();
	}
	/*Recibe la lista de dispositivos y un tipo (enum) 
	 * de calculo (maximo o minimo)*/
	public double optimizar (List<DispositivoInteligente> dispositivos,  GoalType tipoCalculo) {
		
		double[] ecuaciones;
		PointValuePair resultado;
		Collection<LinearConstraint> restricciones;
		ecuaciones 	  = preparadorEcuaciones.prepararEcuacion(dispositivos);
		restricciones = preparadorRestricciones.prepararRestricciones(dispositivos);		
		LinearObjectiveFunction simpleFuncion =  new LinearObjectiveFunction(ecuaciones, 0);
		NonNegativeConstraint SoloPpositivos = new NonNegativeConstraint(true);		
		resultado = resolverEcuacion(tipoCalculo, SoloPpositivos, restricciones, simpleFuncion);			
		return resultado.getValue();
	}
 		
	public PointValuePair resolverEcuacion(GoalType tipo, NonNegativeConstraint restricionSigno,
										   Collection<LinearConstraint> restricciones,
										   LinearObjectiveFunction simpleFuncion)
	{	
		PointValuePair resultado ;
		resultado = new SimplexSolver().optimize(simpleFuncion,
		        new LinearConstraintSet(restricciones),restricionSigno,tipo);
		
		return resultado;
	}
 
 	
}



