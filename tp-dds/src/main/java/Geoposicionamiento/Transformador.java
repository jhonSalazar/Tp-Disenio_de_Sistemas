package Geoposicionamiento;

import java.util.ArrayList;
import java.util.List;
import org.uqbar.geodds.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import Usuarios.Cliente;

public class Transformador {
//
//	@JsonFormat(shape = Shape.OBJECT)
	private Point coordenadas;
//	@JsonFormat(shape = Shape.OBJECT)
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
//	@JsonCreator  @JsonProperty("lat") @JsonProperty("lon")
	public Transformador (double latitud, double longitud){
		coordenadas = new Point(latitud,longitud);
	}
	
	public double cantidadEnergiaSuministrada() {
		return clientes.stream().mapToDouble(unCliente -> unCliente.consumoTotalporHora()).sum();
	}
	
	public void agregarClientes(Cliente unCliente) {
	//Validar que este dentro de zona geografica
		clientes.add(unCliente);
	}
	
	public Point getCoordenada() {
		return coordenadas;
	}
	
	public double getLatitud() {
		return coordenadas.getX();
	}
	
	public double getLongitud() {
		return coordenadas.getY();
	}
	
	public int cantidadDeClientes() {
		return clientes.size();
	}
}
