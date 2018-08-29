package Automatizaciones;

import java.time.LocalDate;
import Dispositivos.DispositivoInteligente;

public interface Actuador {
	
	public LocalDate getFecha();
	public DispositivoInteligente getDisp();
	public boolean ejecutarAccion();

	
}
