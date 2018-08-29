package Optimizacion;


import java.util.List;
import Dispositivos.DispositivoInteligente;

public class PreparadorDeEcuaciones {
	
	
	
	/* se agregan todas las ecuaciones necesarias*/
	public double[] prepararEcuacion(List<DispositivoInteligente> dispositivos) 
	{		
			
			double[] ecuaciones = new double[dispositivos.size()];
										
			int cantidadEcuaciones =0;
			for (DispositivoInteligente dispositivoInteligente : dispositivos)
			{	/*Se pide luego el valor del consumio maximo o minimo*/
				ecuaciones[cantidadEcuaciones] = dispositivoInteligente.consumoPorHora();
				cantidadEcuaciones++;
			}
				
			return ecuaciones;		
	}
	
	
	
}
