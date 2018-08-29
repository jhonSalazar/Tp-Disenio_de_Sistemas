package Automatizaciones;

import java.util.ArrayList;
import java.util.List;

public class Regla {
	
	private Sensor sensor;
	private List<Actuador> actuadores = new ArrayList<Actuador>();
	private Condicion condicion;

	public Regla(Sensor sensor, Condicion _condicion) {
		
		this.sensor = sensor;
		this.condicion = _condicion;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public List<Actuador> getActuador() {
		return actuadores;
	}
	
	public void setActuador(Actuador actuador) {
		actuadores.add(actuador);
	}
	
	public int actualizar() {
		return sensor.getMedicion();	
	}
	
	public boolean evaluar() {
		return condicion.comparar(this.actualizar());
		
	}
	
	public void ejecutar(){
		if (this.evaluar()){
			actuadores.forEach(actuador -> actuador.ejecutarAccion());
		}
	}

}	
