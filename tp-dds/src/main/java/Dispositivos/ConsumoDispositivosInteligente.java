package Dispositivos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConsumoDispositivosInteligente {

	@Id
	@GeneratedValue
	private Integer id;
	private LocalDateTime fechaDesde;
	private LocalDateTime fechaHasta;
	private double consumo;
	
	public ConsumoDispositivosInteligente() {}
	
	public ConsumoDispositivosInteligente(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}
	
	public LocalDateTime getFechaDesde() {
		return fechaDesde;
	}
	
	public void setFechaDesde(LocalDateTime fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	
	public LocalDateTime getFechaHasta() {
		return fechaHasta;
	}
	
	public void setFechaHasta(LocalDateTime fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	
	public double getConsumo() {
		return consumo;
	}
	
}
