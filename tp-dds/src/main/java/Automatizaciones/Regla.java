package Automatizaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Regla {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Transient
	private Sensor sensor;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "regla_id")
	private List<Actuador> actuadores = new ArrayList<Actuador>();
	
	@ElementCollection
	private  List<Condicion> condiciones= new ArrayList<Condicion>(); 
	
	public Regla() {}
	
	public Regla(Sensor sensor, List<Condicion>  _condicion) {	
		this.sensor = sensor;
		this.condiciones = _condicion;
	}
	
	public List<Condicion> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}

	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}

	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public List<Actuador> getActuadores() {
		return actuadores;
	}
	
	public void addActuador(Actuador actuador) {
		actuadores.add(actuador);
	}
	
	public void addCondicion(Condicion actuador) {
		condiciones.add(actuador);
	}
	
	public int actualizar() {
		return sensor.getMedicion();	
	}
	
	public boolean evaluar() {
		for (Condicion condicion : condiciones) {
			if(condicion.comparar(this.actualizar())) {
				return true;
			}
			
		}	
		return false;
	}
	
	public void ejecutar(){
		if (this.evaluar())
		{
			actuadores.forEach(actuador -> actuador.ejecutarAccion());
		}
	}

}	
