package Automatizaciones;

public class Condicion implements Expresion{
	int valorDerecha;
	private Operacion comparador;
	
	public Condicion(int _derecha,Operacion _operador) {
		this.valorDerecha = _derecha;
		this.comparador=_operador;
	}	
	
	@Override
	public boolean comparar(int valorDeSensor) {
		return comparador.
				comparar(valorDeSensor,this.valorDerecha);
	}	

}

