package Geoposicionamiento;

import java.util.ArrayList;
import java.util.List;
import Geoposicionamiento.Punto;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.math3.util.Pair;
import org.uqbar.geodds.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class ZonaGeografica {
	

	@Id
	@GeneratedValue
	private int id;
//	@JsonFormat(shape = Shape.OBJECT)
	//@Transient
	//private Polygon zonaGeografica;
	
	@Embedded()
	private Area area;
//	@JsonFormat(shape = Shape.OBJECT)
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name="zona_id")
	private List<Transformador> transformadores = new ArrayList<Transformador>();
	
//	@JsonCreator
//	public ZonaGeografica(List<Pair<@JsonProperty("lat")double latitud, @JsonProperty("lon")double longitud>> puntos) {
//	public ZonaGeografica(List<Pair<Double, Double>> puntos) {
	
	public ZonaGeografica() {}
	public ZonaGeografica(List<Point> puntos) {
		this.area = new Area(puntos);
	}
	
	public Area getAreaGeografica() {
		return this.area;
	}
	
	public boolean tranformadorPerteneceALaZonaGeografica(Transformador unTransformador) {
		Point unaCoordenada = unTransformador.getCoordenada();
		return area.isInside(unaCoordenada);
	}
		
	public void agregarTransformadores(Transformador unTransformador) {
		transformadores.add(unTransformador);
	}
	
	public List<Transformador> getTransformadores() {
		return transformadores;
	}
	
	public double consumoTotalDeLaZona() {
		return transformadores.stream().mapToDouble(unTransformador -> unTransformador.cantidadEnergiaSuministrada()).sum();
	}
	
}
