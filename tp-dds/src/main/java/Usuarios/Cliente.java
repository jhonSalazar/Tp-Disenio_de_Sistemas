package Usuarios;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import static Valores.ValoresParaPuntaje.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import Automatizaciones.Sensor;
import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Usuarios.TipoDocumento;
import Utilitarios.LocalDateDeserializador;


@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	private String apellido;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	@Column(name="tipoDocumento",nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	private int numeroDocumento;
	private int telefono;
	private String domicilio;
	
	@Transient
	private Double consumo;
	
	private int puntajeCliente = PUNTAJE_INICIAL;
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="cliente_id")
	private List<Sensor> sensores = new ArrayList<Sensor>();
	
	@Column
	@JsonDeserialize(using = LocalDateDeserializador.class)
	private LocalDate fechaDeAlta;
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="cliente_id")
	private List<DispositivoEstandar> dispositivosEstandar = new ArrayList<DispositivoEstandar>();
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="cliente_id")
	private List<DispositivoInteligente> dispositivosInteligente = new ArrayList<DispositivoInteligente>();
	
	@Embedded
	@JsonProperty("categoria")
	Categoria categoria;
	
	public Cliente() {}
	public Cliente(String nombre, String apellido,TipoDocumento tipoDocumento,
			 int numeroDocumento,int telefono,String username,String password,
			 String domicilio ,LocalDate fechaDeAlta) {
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
	}
	
	@JsonCreator
	public Cliente(@JsonProperty("nombre") String _nombre, @JsonProperty("apellido") String _apellido,
			@JsonProperty("tipoDocumento") TipoDocumento _tipoDocumento,
			@JsonProperty("numeroDocumento") int _numeroDocumento, @JsonProperty("telefono") int _telefono,
			@JsonProperty("domicilio") String _domicilio, @JsonProperty("fechaDeAlta") LocalDate _fechaDeAlta) {

		this.nombre = _nombre;
		this.tipoDocumento = _tipoDocumento;
		this.numeroDocumento = _numeroDocumento;
		this.telefono = _telefono;
		this.apellido = _apellido;
		this.domicilio = _domicilio;
		this.fechaDeAlta = _fechaDeAlta;
		this.dispositivosEstandar = new ArrayList<DispositivoEstandar>();

	}

	@JsonFormat(shape = Shape.OBJECT)
	public List<DispositivoEstandar> getDispositivos() {

		return dispositivosEstandar;
	}
	
	public List<DispositivoEstandar> DispositivosEstandarDelCliente() {
		return dispositivosEstandar;
	}
	
	public List<DispositivoInteligente> DispositivosInteligenteDelCliente() {
		return dispositivosInteligente;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate get() {
		return fechaDeAlta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	
	public Double getConsumo() {
		return consumo;
	}
	
	public void agregarDispositivoEstandar(DispositivoEstandar dispositivo) {
		dispositivosEstandar.add(dispositivo);
	}
	
	public void quitarDispositivoEstandar(DispositivoEstandar dispositivo) {
		dispositivosEstandar.remove(dispositivo);
	}
	
	public void agregarDispositivoInteligente(DispositivoInteligente dispositivo) {
		dispositivosInteligente.add(dispositivo);
	}

	public void quitarDispositivoInteligente(DispositivoInteligente dispositivo) {
		dispositivosInteligente.remove(dispositivo);
	}

	public int cantidadTotalDispositivos() {
		if (dispositivosEstandar.isEmpty() && dispositivosInteligente.isEmpty()) {
			return 0;
		} else {
			return dispositivosEstandar.size() + dispositivosInteligente.size();
		}
	}

	// verifica si algun de sus dispositivos esta encendido
	public boolean algunDispositivoEncendido() {
		return dispositivosInteligente.stream().anyMatch(dispositivo -> dispositivo.estaEncendido());
	}

	// verifica si todos sus dispositivos estan encendidos
	public boolean todosDispositivosEncendidos() {
		return dispositivosInteligente.stream().allMatch(dispositivo -> dispositivo.estaEncendido());
	}

	// Solucion declarativa usando objetos bloques y mensajes de orden superior
	public long cantidadDispositivosEncendidos() {
		return dispositivosInteligente.stream().filter(dispositivo -> dispositivo.estaEncendido()).count();
	}

	// determina la dispositivos apagados
	public long cantidadDispositivosApagados() {
		return dispositivosInteligente.stream().filter(dispositivo -> !dispositivo.estaEncendido()).count();
	}

	// recategorizar al cliente
	public void recategorizar(Categoria _categoria) {
		this.categoria = _categoria;
	}
	
	public double consumoTotalPeriodo(LocalDateTime periodoInicio, LocalDateTime periodoFin) {
		return (consumoTotalDispositivosEstandarPeriodo(periodoInicio, periodoFin)
				+ consumoTotalDispositivosInteligentePeriodo(periodoInicio, periodoFin));	
	}
	
	public double consumoTotalDispositivosEstandar() { 
		return dispositivosEstandar.stream().mapToDouble(disp -> disp.consumoPorHora()).sum();
	}
	
	public double consumoTotalDispositivosEstandarPeriodo(LocalDateTime periodoInicio, LocalDateTime periodoFin) {
		int dias = (int) ChronoUnit.HOURS.between(periodoInicio, periodoFin);
		return (consumoTotalDispositivosEstandar() * dias);	
	}
	
	public double consumoTotalDispositivosInteligentePeriodo(LocalDateTime periodoInicio, LocalDateTime periodoFin) { 
		return dispositivosInteligente.stream()
				.mapToDouble(disp -> disp.consumoPeriodo(periodoInicio, periodoFin)).sum();
	}
	
	public void promedioConsumoTotalDispositivos() {
		
	}
	
	public void promedioConsumoTotalDI() {
		
	}
	
	public void promedioConsumaTotalDE() {
		
	}
	
	public double gastoTotal(LocalDateTime periodoInicio, LocalDateTime periodoFin) {
		double consumoDispositivos = this.consumoTotalPeriodo(periodoInicio, periodoFin);
		return categoria.consumoMensual(consumoDispositivos);
	}

	public void convertirDeEstandarAInteligente(DispositivoEstandar unDispositivoEstandar) {
		unDispositivoEstandar.convertirAInteligente();
		sumarPuntajeACliente(PUNTAJE_ESTANDAR_DI);
	}

	public void sumarPorDispositivoInteligente(DispositivoInteligente unDI) {
		unDI.sumarPuntajeporInteligente(this, PUNTAJE_DI);
	}

	// registrar dispositivo inteligente
	public void registrarDispositivoInteligente(DispositivoInteligente unDI) {
		dispositivosInteligente.add(unDI);
		sumarPuntajeACliente(PUNTAJE_DI);

	}

	public int getPuntajeCliente() {
		return puntajeCliente;
	}

	public void sumarPuntajeACliente(int puntajeCliente) {
		this.puntajeCliente += puntajeCliente;
	}
	
	public void instalarSensor(Sensor sensor) {
		sensores.add(sensor);
	}
	
}
