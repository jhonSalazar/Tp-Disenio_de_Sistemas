package Dispositivos;

public interface EstadoDispositivoInteligente {
	
	Boolean estaApagado();
	Boolean estaEncendido();
	Boolean estaEnAhorroEnergia();
	
	void ahorroEnergia(DispositivoInteligente dispositivo, Fabricante fabricante);
	void encender(DispositivoInteligente dispositivo, Fabricante fabricante);
	void apagar(DispositivoInteligente dispositivo, Fabricante fabricante);
		
}