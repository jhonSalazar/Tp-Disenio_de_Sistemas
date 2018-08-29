package Dispositivos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DispositivoEstandar {

		private String nombre;
		private int horasEstimadas;
		double potencia;
		private double consumoMensualMinimo;	
		private double consumoMensualMaximo;
		private boolean bajoConsumo;
		
		
		@JsonCreator
		public DispositivoEstandar(@JsonProperty("nombre") String _nombre,
				@JsonProperty("horasEstimadas") int _horasEstimadas, @JsonProperty("potencia") Double _potencia) {

			this.nombre = _nombre;
			this.horasEstimadas = _horasEstimadas;
			this.potencia = _potencia;

		}
		
		public DispositivoEstandar(String nombre, double potencia,double consumoMensualMinimo, double consumoMensualMaximo,boolean bajoConsumo) {
			this.nombre = nombre; 
			this.potencia = potencia;
			this.consumoMensualMinimo=consumoMensualMinimo;
			this.consumoMensualMaximo=consumoMensualMaximo;
			this.bajoConsumo=bajoConsumo;
	}
		
		public DispositivoEstandar(String nombre, double potencia) {
			this.nombre = nombre; 
			this.potencia = potencia;
	}

		public DispositivoInteligente convertirAInteligente() {
			return new DispositivoInteligente(nombre, potencia);
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double consumoPorHora() {
			return potencia;
		}

		public void setPotencia(double potencia) {
			this.potencia = potencia;
		}

		public int getHorasEstimadas() {
			return horasEstimadas;
		}
		
		public double consumoTotal() {
			return horasEstimadas * potencia;
		}

}
