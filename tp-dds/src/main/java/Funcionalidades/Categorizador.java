package Funcionalidades;

import java.util.List;
import java.util.stream.Collectors;

import Usuarios.Categoria;

import static Valores.ValoresParaCategorias.*;

import java.util.Arrays;

public class Categorizador {

	public static Categorizador categorizador = new Categorizador ();
	
	private Categorizador () {}; 
	
	public static Categorizador getInstance() {
		return categorizador;
	}
	
	public Categoria R1 = new Categoria(R1_CONSUMO_MINIMO, R1_CONSUMO_MAXIMO, R1_CARGO_FIJO, R1_CARGO_VARIABLE);
	public Categoria R2 = new Categoria(R2_CONSUMO_MINIMO, R2_CONSUMO_MAXIMO, R2_CARGO_FIJO, R2_CARGO_VARIABLE);
	public Categoria R3 = new Categoria(R3_CONSUMO_MINIMO, R3_CONSUMO_MAXIMO, R3_CARGO_FIJO, R3_CARGO_VARIABLE);
	public Categoria R4 = new Categoria(R4_CONSUMO_MINIMO, R4_CONSUMO_MAXIMO, R4_CARGO_FIJO, R4_CARGO_VARIABLE);
	public Categoria R5 = new Categoria(R5_CONSUMO_MINIMO, R5_CONSUMO_MAXIMO, R5_CARGO_FIJO, R5_CARGO_VARIABLE);
	public Categoria R6 = new Categoria(R6_CONSUMO_MINIMO, R6_CONSUMO_MAXIMO, R6_CARGO_FIJO, R6_CARGO_VARIABLE);
	public Categoria R7 = new Categoria(R7_CONSUMO_MINIMO, R7_CONSUMO_MAXIMO, R7_CARGO_FIJO, R7_CARGO_VARIABLE);
	public Categoria R8 = new Categoria(R8_CONSUMO_MINIMO, R8_CONSUMO_MAXIMO, R8_CARGO_FIJO, R8_CARGO_VARIABLE);
	public Categoria R9 = new Categoria(R9_CONSUMO_MINIMO, R9_CONSUMO_MAXIMO, R9_CARGO_FIJO, R9_CARGO_VARIABLE);
	
	private List<Categoria> categorias = Arrays.asList(R1,R2,R3,R4,R5,R6,R7,R8,R9);
	
	public Categoria categoriaSegunConsumo (double consumoMensual) {
		return categorias.stream().filter(categoria -> categoria.correspondeCategoria(consumoMensual)).collect(Collectors.toList()).get(0);
	}
		
}
	
	
	
	
	
	
	
	
	

