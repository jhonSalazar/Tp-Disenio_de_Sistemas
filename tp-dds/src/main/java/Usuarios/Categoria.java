package Usuarios;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Categoria {

	private double cargoFijo;		
	private double cargoVariable;
	private double consumoMaximo;
	private double consumoMinimo;
	
	public Categoria() {}
	
	public Categoria (
			 @JsonProperty("cargoFijo")double _consumoMinimo,
			 @JsonProperty("cargoVariable")double _consumoMaximo,
			 @JsonProperty("consumoMaximo")double _cargoFijo,
			 @JsonProperty("consumoMinimo")double _cargoVariable) {

		this.cargoFijo= _cargoFijo;
		this.cargoVariable= _cargoVariable;
		this.consumoMaximo=_consumoMaximo;
		this.consumoMinimo=_consumoMinimo;
	}
	
	  public double consumoMensual(double consumoDispositivos) {
		  return cargoFijo + (consumoDispositivos * cargoVariable);
	  }
	
	  public boolean correspondeCategoria (double consumo) {
		  return consumoMinimo<consumo && consumo<=consumoMaximo;
	  }


}
