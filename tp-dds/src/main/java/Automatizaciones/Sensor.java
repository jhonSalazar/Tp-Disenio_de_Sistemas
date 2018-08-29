package Automatizaciones;

public class Sensor {
	private Regla regla;
	
	public void setRegla(Regla regla) {
		this.regla = regla;
	}
	
	public void notificarRegla() {
		regla.actualizar();
	}
	
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
