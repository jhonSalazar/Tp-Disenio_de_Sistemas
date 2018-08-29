package Geoposicionamiento;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.uqbar.geodds.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ZonaGeografica {

//	@JsonFormat(shape = Shape.OBJECT)
	private Polygon zonaGeografica;
//	@JsonFormat(shape = Shape.OBJECT)
	private List<Transformador> transformadores = new ArrayList<Transformador>();
	
//	@JsonCreator
//	public ZonaGeografica(List<Pair<@JsonProperty("lat")double latitud, @JsonProperty("lon")double longitud>> puntos) {
//	public ZonaGeografica(List<Pair<Double, Double>> puntos) {
	public ZonaGeografica(List<Point> puntos) {
		zonaGeografica = new Polygon(puntos);
	}
	
	public Polygon getZonaGeografica() {
		return zonaGeografica;
	}
	
	public boolean tranformadorPerteneceALaZonaGeografica(Transformador unTransformador) {
		Point unaCoordenada = unTransformador.getCoordenada();
		return zonaGeografica.isInside(unaCoordenada);
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
