package Geoposicionamiento;

import org.uqbar.geodds.*;

import javax.persistence.Embeddable;

@Embeddable
public class Punto extends Point{
	/**
	 * 
	 */

	private double longitud;
	private  double latitud;
	
	
	public Punto(double _latitud,double _longitud) {	
		super(_latitud, _longitud);
		this.longitud = _longitud;
		this.latitud=_latitud;
	}
	
	public Punto() {
		super(0, 0);
	}
	
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
}
