package Dispositivos;

public class EstadoAhorroEnergia implements EstadoDispositivoInteligente {
	
	public Boolean estaEncendido() {
		return true;
	}
	
	
	public Boolean estaApagado() {
		return false;
	}
	
	
	public Boolean estaEnAhorroEnergia() {
		return true;
	}
	

	public void encender(DispositivoInteligente dispositivo, Fabricante fabricante) {
		dispositivo.setEstado(new EstadoEncendido());
		fabricante.encender(dispositivo.getIdDispositivo(), fabricante);
	}
	
	public void apagar(DispositivoInteligente dispositivo, Fabricante fabricante) {
		dispositivo.setEstado(new EstadoApagado());
		fabricante.apagar(dispositivo.getIdDispositivo(), fabricante);
	}
	
	public void ahorroEnergia(DispositivoInteligente dispositivo, Fabricante fabricante) {
		//ya esta en ahorro de energia
	}

}
