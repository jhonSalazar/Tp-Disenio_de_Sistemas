package Dispositivos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import Usuarios.Cliente;

@Entity
public class DispositivoInteligente {
	
	
	@Id
	@GeneratedValue
	private int id;
	@Transient
	private EstadoDispositivoInteligente estado;
	private double potencia;
	private String nombre;
	@Transient
	private Fabricante fabricante;
	private String idDispositivo;
	private double consumoMensualMinimo;	
	private double consumoMensualMaximo;
	private boolean bajoConsumo;
	
	public DispositivoInteligente() {}
	public DispositivoInteligente(String nombre, double potencia,double consumoMensualMinimo, double consumoMensualMaximo,boolean bajoConsumo) {
		this.nombre = nombre; 
		this.potencia = potencia;
		this.estado = new EstadoEncendido();
		this.consumoMensualMinimo=consumoMensualMinimo;
		this.consumoMensualMaximo=consumoMensualMaximo;
		this.bajoConsumo=bajoConsumo;
		
	}
	
	public DispositivoInteligente(String nombre, double potencia) {
		this.nombre = nombre; 
		this.potencia = potencia;
		
	}
	
	public double getConsumoMensualMinimo(){
		return consumoMensualMinimo;
	}
	
	public double getConsumoMensualMaximo(){
		return consumoMensualMaximo;
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void setEstado(EstadoDispositivoInteligente estado) {
		this.estado = estado;
	}
	
	public String getIdDispositivo() {
		return idDispositivo;
	}
		
	public Boolean estaEncendido() {
		return estado.estaEncendido();
	}
	
	public Boolean estaApagado() {
		return estado.estaApagado();
	}
	
	public Boolean estaEnAhorroEnergia() {
		return estado.estaEnAhorroEnergia();
	}
	
	public void encender() {
		estado.encender(this, fabricante);
	}
	
	public void apagar() {
		estado.apagar(this, fabricante);
	}
	
	public void ahorroEnergia () {
		estado.ahorroEnergia(this, fabricante);
	}	
	public double consumoPorHora() {	
		return this.potencia;
	}
		
	public double consumoUltimasHoras (int n) {
		return potencia*n;	
	}
		
	public double consumoPeriodo (LocalDate periodoInicio, LocalDate periodoFin) {
		return potencia*((ChronoUnit.DAYS.between(periodoInicio, periodoFin)));
	}
	
	public void sumarPuntajeporInteligente(Cliente cliente,int puntaje)
	{
		cliente.sumarPuntajeACliente(puntaje);
	}
	
	public void aumentarPotencia() {
		this.potencia = potencia + 1;
	}
	
	public void bajarPotencia() {
		this.potencia = potencia - 1;
	}
	
}
