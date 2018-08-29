package Utilitarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FechaDelSistema {
	
	private LocalDate fechaDeAlta;
	
	public FechaDelSistema() {
		fechaDeAlta = LocalDate.now();
	}
	public LocalDate getFechaDelSistema() {
		return fechaDeAlta;
	}
	public long mesesDeDiferenciaCon(LocalDate fecha) {
		return ChronoUnit.MONTHS.between(fecha, this.getFechaDelSistema());
	}
}
