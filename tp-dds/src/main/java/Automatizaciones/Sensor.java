package Automatizaciones;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Sensor {
	
	@Id
	@GeneratedValue
	private int id;
	
	//se arregla listado de reglas en Sensor --modificado por Jhon Salazar 09 09 2018
	
	@OneToMany(fetch=FetchType.LAZY,cascade =CascadeType.PERSIST)
	@JoinColumn(name = "sensor_id")
	private List<Regla> reglas = new ArrayList<Regla>();
	
	public List<Regla> getReglas() {
		return reglas;
	}

	public void addRegla(Regla regla) {
		reglas.add(regla);
	}
	
	public void setReglas(List<Regla> reglas) {
		this.reglas = reglas;
	}


	public Sensor() {}
	
	
	public int getTemperatura() {	
		return 31;
	}
	
	public int  getMovimiento () {
		return 10;
	}
	
	public int  getLuz() {		
	 return 45;
	}
	
	public int getHumedad() {
		
		return 20;
	}
	public int getMedicion() {
		return 10;
	}
}
