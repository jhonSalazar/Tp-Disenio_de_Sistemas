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


@Entity
public class ZonaGeografica {
	

	@Id
	@GeneratedValue
	private Integer id;
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
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public double consumoTotalDeLaZona(LocalDateTime periodoInicio, LocalDateTime periodoFin) {
		return transformadores.stream()
			.mapToDouble(unTransformador -> unTransformador.cantidadEnergiaSuministrada(periodoInicio, periodoFin)).sum();
	}
	
}
