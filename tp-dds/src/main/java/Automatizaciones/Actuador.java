package Automatizaciones;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import Dispositivos.DispositivoInteligente;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Actuador {
		
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
		
		public  LocalDate getFecha() {
			return null;};
		public  DispositivoInteligente getDisp() {
			return null;};
		public  boolean ejecutarAccion() {
			return false;}
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		};
	
}
