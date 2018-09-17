package Automatizaciones;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import Dispositivos.DispositivoInteligente;

@Entity
public class ActuadorApagar extends Actuador{
	
	
	public ActuadorApagar() {}
	
	@Override
	public LocalDate getFecha() {
 		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DispositivoInteligente getDisp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ejecutarAccion() {
		// TODO Auto-generated method stub
		return false;
	}

}
