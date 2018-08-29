package Dispositivos;

public class EstadoApagado implements EstadoDispositivoInteligente {

	public Boolean estaEncendido() {
		return false;
	}
	
	public Boolean estaApagado() {
		return true;
	}
	
	public Boolean estaEnAhorroEnergia() {
		return false;
	}
	
	
	public void encender(DispositivoInteligente dispositivo, Fabricante fabricante) {
		dispositivo.setEstado(new EstadoEncendido());
		fabricante.encender(dispositivo.getIdDispositivo(), fabricante);
	}
	
	public void apagar(DispositivoInteligente dispositivo, Fabricante fabricante) {
		//ya esta apagado
	}
	
	public void ahorroEnergia(DispositivoInteligente dispositivo, Fabricante fabricante) {
		//ya esta apagado
	}
	
}
