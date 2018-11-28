package Dispositivos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public enum Estado {
	AHORROENERGIA,
	APAGADO,
	ENCENDIDO;
	
	public Boolean estaApagado() {
		switch(this) {
		case ENCENDIDO:
			return false;
		case APAGADO:
			return true;
		case AHORROENERGIA:
			return false;
		}
		return null;
	}
	
	public Boolean estaEncendido() {
		switch(this) {
		case ENCENDIDO:
			return true;
		case APAGADO:
			return false;
		case AHORROENERGIA:
			return false;
		}
		return null;
	}
	
	public Boolean estaEnAhorroEnergia() {
		switch(this) {
		case ENCENDIDO:
			return false;
		case APAGADO:
			return false;
		case AHORROENERGIA:
			return true;
		}
		return null;
	}
	
	public void encender(DispositivoInteligente dispositivo, Fabricante fabricante, LocalDateTime fecha, ConsumoDispositivosInteligente consumo) {
		switch(this) {
		case ENCENDIDO:
			//ya esta encendido
			break;
		case APAGADO:
			dispositivo.setEstado(ENCENDIDO);
			consumo.setFechaDesde(fecha);
			fabricante.encender(dispositivo.getId(), fabricante);
			break;
		case AHORROENERGIA:
			dispositivo.setEstado(ENCENDIDO);
			consumo.setFechaDesde(fecha);
			fabricante.encender(dispositivo.getId(), fabricante);
			break;
		}
	}
	
	public void apagar(DispositivoInteligente dispositivo, Fabricante fabricante, LocalDateTime fecha, ConsumoDispositivosInteligente consumo) {
		switch(this) {
		case ENCENDIDO:
			dispositivo.setEstado(APAGADO);
			consumo.setFechaHasta(fecha);
			LocalDateTime periodoInicio= consumo.getFechaDesde();
			LocalDateTime periodoFin= consumo.getFechaHasta();
			int horasEncendido = (int) ChronoUnit.HOURS.between(periodoInicio, periodoFin);
			double consumoEncendido = dispositivo.consumoUltimasHoras(horasEncendido);
			consumo.setConsumo(consumoEncendido);
			dispositivo.agregarConsumoDispositivosInteligente(consumo);
			fabricante.apagar(dispositivo.getId(), fabricante);
			break;
		case APAGADO:
			//ya esta apagado
			break;
		case AHORROENERGIA:
			dispositivo.setEstado(APAGADO);
			consumo.setFechaHasta(fecha);
			LocalDateTime periodoInicio1= consumo.getFechaDesde();
			LocalDateTime periodoFin1= consumo.getFechaHasta();
			int horasAhorroEnergia = (int) ChronoUnit.HOURS.between(periodoInicio1, periodoFin1);
			double consumoAhorroEnergia = dispositivo.consumoUltimasHoras(horasAhorroEnergia);
			consumo.setConsumo(consumoAhorroEnergia);
			dispositivo.agregarConsumoDispositivosInteligente(consumo);
			fabricante.apagar(dispositivo.getId(), fabricante);
			break;
		}
	}
	
	public void ahorroEnergia(DispositivoInteligente dispositivo, Fabricante fabricante) {
		switch(this) {
		case ENCENDIDO:
			dispositivo.setEstado(AHORROENERGIA);
			fabricante.ahorroEnergia(dispositivo.getId(), fabricante);
			break;
		case APAGADO:
			//ya esta apagado
			break;
		case AHORROENERGIA:
			//ya esta en ahorro de energia
			break;
		}
	}
}
