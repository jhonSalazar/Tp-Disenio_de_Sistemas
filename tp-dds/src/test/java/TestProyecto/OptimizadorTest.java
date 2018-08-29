package TestProyecto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Dispositivos.DispositivoInteligente;
import Funcionalidades.Categorizador;
import Funcionalidades.Dispositivizador;
import Usuarios.Categoria;
import Optimizacion.Optimizador;
import org.junit.Before;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;


public class OptimizadorTest {

	List<DispositivoInteligente> dispositivos1;
	List<DispositivoInteligente> dispositivos2;
	List<DispositivoInteligente> dispositivos3;
	List<DispositivoInteligente> dispositivos4;
	Optimizador unOptimizador;

	
	
	@Before
	public void Before () {

		dispositivos1 = new ArrayList<DispositivoInteligente>();
		dispositivos1.add(Dispositivizador.getInstance().LavarropaAuto);
		dispositivos1.add(Dispositivizador.getInstance().Lampara15W);
		dispositivos1.add(Dispositivizador.getInstance().TVLED40);
		dispositivos1.add(Dispositivizador.getInstance().LamparaHalogena60);
			
		dispositivos2 = new ArrayList<DispositivoInteligente>();
		dispositivos2.add(Dispositivizador.getInstance().LavarropaAuto);
		dispositivos2.add(Dispositivizador.getInstance().PCDeEscritorio);
		dispositivos2.add(Dispositivizador.getInstance().Lampara20W);
		dispositivos2.add(Dispositivizador.getInstance().VentiladoDeTecho);
	
		
		dispositivos3 = new ArrayList<DispositivoInteligente>();
		dispositivos3.add(Dispositivizador.getInstance().AireAcondicionado3500);
		dispositivos3.add(Dispositivizador.getInstance().AireAcondicionado2200);
		dispositivos3.add(Dispositivizador.getInstance().TVLED40);
		dispositivos3.add(Dispositivizador.getInstance().PCDeEscritorio);
		
		
		dispositivos4 = new ArrayList<DispositivoInteligente>();
		dispositivos4.add(Dispositivizador.getInstance().Lampara20W);
		dispositivos4.add(Dispositivizador.getInstance().LamparaHalogena40);
		dispositivos4.add(Dispositivizador.getInstance().TVLED40);
		dispositivos4.add(Dispositivizador.getInstance().LavarropaAuto);				
		unOptimizador = new Optimizador();	
	}
	
	//para constatar los resultados se utilizo la pagina web ingenieria-industrial.net/software/jsimplex
	
	@Test
	public void BuscaElValorOpitimoDispInteligentes1() {
		GoalType maximo = GoalType.MAXIMIZE;
		double valorEsperado = 61.05;
		double maximoValorOptimo = unOptimizador.optimizar(dispositivos1,maximo);
		assertEquals(valorEsperado, maximoValorOptimo,0.01);	
	}
	
	@Test
	public void BuscaElValorOptimoDispInteligentes2() {
		GoalType  maximo = GoalType.MAXIMIZE;
		double valorEsperado = 178.05;
		double maximoValorOptimo =unOptimizador.optimizar(dispositivos2,maximo);
		assertEquals(valorEsperado, maximoValorOptimo,0.01);	
	}
	
	@Test
	public void BuscaElValorOptimoDispInteligentes3() {
		GoalType  maximo = GoalType.MAXIMIZE;
		double valorEsperado = 1118.16;
		double maximoValorOptimo =unOptimizador.optimizar(dispositivos3,maximo);
		assertEquals(valorEsperado, maximoValorOptimo,0.01);	
	}
	
	
	@Test
	public void BuscaElValorOptimoDispInteligentes4() {
		GoalType  maximo = GoalType.MAXIMIZE;
		double valorEsperado = 444;
		double maximoValorOptimo =unOptimizador.optimizar(dispositivos4,maximo);
		assertNotEquals(valorEsperado, maximoValorOptimo,0.01);	
	}
	
	
	
	
}
