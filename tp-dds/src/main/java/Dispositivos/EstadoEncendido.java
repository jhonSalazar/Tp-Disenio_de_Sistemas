package Dispositivos;

public class EstadoEncendido implements EstadoDispositivoInteligente {
	
	public Boolean estaEncendido() {
		return true;
	}
		
	public Boolean estaApagado() {
		return false;
	}
		
	public Boolean estaEnAhorroEnergia() {
		return false;
	}
	
	
	public void encender(DispositivoInteligente dispositivo, Fabricante fabricante) {
		//ya esta encendido
	}
	
	public void apagar(DispositivoInteligente dispositivo, Fabricante fabricante) {
		dispositivo.setEstado(new EstadoApagado());
		fabricante.apagar(dispositivo.getIdDispositivo(), fabricante);
	}
	
	public void ahorroEnergia(DispositivoInteligente dispositivo, Fabricante fabricante) {
		dispositivo.setEstado(new EstadoAhorroEnergia());
		fabricante.ahorroEnergia(dispositivo.getIdDispositivo(), fabricante);
	}
		
}
