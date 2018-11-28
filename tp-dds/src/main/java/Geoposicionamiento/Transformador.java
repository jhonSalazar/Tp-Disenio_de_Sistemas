package Geoposicionamiento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.uqbar.geodds.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import Usuarios.Cliente;

@Entity
public class Transformador {
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Id
	@GeneratedValue
	private Integer id;
//	@JsonFormat(shape = Shape.OBJECT)
	
	
	@Embedded
	@JsonProperty("coordenadas")
	private Punto coordenadas;

//	@JsonFormat(shape = Shape.OBJECT)
	@OneToMany(fetch= FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="transformador_id")
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public Transformador() {}
//	@JsonCreator  @JsonProperty("lat") @JsonProperty("lon")
	
	public Transformador (double latitud, double longitud){
		coordenadas = new Punto(latitud,longitud);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public double cantidadEnergiaSuministrada(LocalDateTime periodoInicio, LocalDateTime periodoFin) {
		return clientes.stream()
			.mapToDouble(unCliente -> unCliente.consumoTotalPeriodo(periodoInicio, periodoFin)).sum();
	}
	
	public void agregarClientes(Cliente unCliente) {
	//Validar que este dentro de zona geografica
		clientes.add(unCliente);
	}
	
	public Point getCoordenada() {
		return coordenadas;
	}
	
	public double getLatitud() {
		return coordenadas.getLatitud();
	}
	
	public double getLongitud() {
		return coordenadas.getLongitud();
	}
	
	public int cantidadDeClientes() {
		return clientes.size();
	}
}
