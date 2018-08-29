package Usuarios;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import Utilitarios.FechaDelSistema;
import Utilitarios.LocalDateDeserializador;

@Entity
public class Administrador {
	
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String apellido;
	private String domicilio;

	@JsonDeserialize(using = LocalDateDeserializador.class)
	private LocalDate fechaDeAlta;
	
	public Administrador(String _nombre, String _apellido, String _domicilio) {
		this.nombre =_nombre;
		this.apellido=_apellido;
		this.domicilio = _domicilio;
	}
	
	public Administrador() {
		
	}
	
	
	@JsonCreator
	public Administrador(@JsonProperty("nombre") String _nombre, @JsonProperty("apellido") String _apellido,
			@JsonProperty("domicilio") String _domicilio, @JsonProperty("fechaDeAlta") LocalDate _fechaDeAlta) {

		this.nombre = _nombre;
		this.apellido = _apellido;
		this.domicilio = _domicilio;
		this.fechaDeAlta = _fechaDeAlta;
	}

	public long cantidadDeMesesComoAdministrador() {
		FechaDelSistema fecha = new FechaDelSistema();	
		return fecha.mesesDeDiferenciaCon(fechaDeAlta);
	}
	
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

}
