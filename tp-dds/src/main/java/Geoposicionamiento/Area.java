package Geoposicionamiento;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

@Embeddable
public class Area extends Polygon {
		
	public List<Punto> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Punto> coordenadas) {
		this.coordenadas = coordenadas;
	}

	@ElementCollection
	private List <Punto> coordenadas;
	
	public Area() {}
	
	public Area(List<Point> puntos) {
		
		super( puntos);
			
	}	
}
