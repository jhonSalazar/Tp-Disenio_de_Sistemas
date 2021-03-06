package Automatizaciones;

import javax.persistence.Embeddable;

@Embeddable
public class Condicion implements Expresion{
	int valorDerecha;
	private Operacion comparador;
	
	public int getValorDerecha() {
		return valorDerecha;
	}
	public void setValorDerecha(int valorDerecha) {
		this.valorDerecha = valorDerecha;
	}
	public Operacion getComparador() {
		return comparador;
	}
	public void setComparador(Operacion comparador) {
		this.comparador = comparador;
	}
	public Condicion() {}
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

