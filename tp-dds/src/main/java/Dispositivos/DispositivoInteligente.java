package Dispositivos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import Usuarios.Cliente;

@Entity
public class DispositivoInteligente {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="estado",nullable=false)
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	private double potencia;
	private String nombre;
	@Transient
	private Fabricante fabricante;
	private double consumoMensualMinimo;	
	private double consumoMensualMaximo;
	private boolean bajoConsumo;
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="dispositivo_id")
	private List<ConsumoDispositivosInteligente> consumoDispositivos = new ArrayList<ConsumoDispositivosInteligente>();
	
	public DispositivoInteligente() {}
	public DispositivoInteligente(String nombre, double potencia, Estado estado,
			double consumoMensualMinimo, double consumoMensualMaximo,boolean bajoConsumo) {
		this.nombre = nombre; 
		this.potencia = potencia;
		this.estado = estado;
		this.consumoMensualMinimo=consumoMensualMinimo;
		this.consumoMensualMaximo=consumoMensualMaximo;
		this.bajoConsumo=bajoConsumo;
		
	}
	
	public DispositivoInteligente(String nombre, double potencia) {
		this.nombre = nombre; 
		this.potencia = potencia;
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public double getPotencia() {
		return potencia;
	}
	
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
	public boolean isBajoConsumo() {
		return bajoConsumo;
	}
	
	public List<ConsumoDispositivosInteligente> getConsumoDispositivosInteligente(){
		return consumoDispositivos;
	}
	
	public void agregarConsumoDispositivosInteligente(ConsumoDispositivosInteligente consumoDispositivo) {
		consumoDispositivos.add(consumoDispositivo);
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
	
	public void encender(LocalDateTime fechaDesde, ConsumoDispositivosInteligente consumo) {
		estado.encender(this, fabricante, fechaDesde, consumo);
	}
	
	public void apagar(LocalDateTime fechaHasta, ConsumoDispositivosInteligente consumo) {
		estado.apagar(this, fabricante, fechaHasta, consumo);
	}
	
	public void ahorroEnergia() {
		estado.ahorroEnergia(this, fabricante);
	}	
	public double consumoPorHora() {	
		return this.potencia;
	}
		
	public double consumoUltimasHoras(int n) {
		return potencia*n;	
	}
		
	public double consumoPeriodo(LocalDateTime periodoInicio, LocalDateTime periodoFin) {	
		double valor = consumoDispositivos.stream()
				.filter(consumo -> (periodoInicio.compareTo(consumo.getFechaDesde())>=0)  
					&&	(periodoFin.compareTo(consumo.getFechaHasta()) >= 0))
				.mapToDouble(consumo -> consumo.getConsumo()).sum();		
		return valor;
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
