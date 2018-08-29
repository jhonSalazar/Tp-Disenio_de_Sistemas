package Dispositivos;

public interface Fabricante {
	public void encender(String idDispositivo, Fabricante fabricante);
	public void apagar(String idDispositivo, Fabricante fabricante);
	public void ahorroEnergia(String idDispositivo, Fabricante fabricante);
}
