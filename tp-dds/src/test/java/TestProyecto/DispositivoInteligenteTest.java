package TestProyecto;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import Dispositivos.DispositivoInteligente;
import Dispositivos.EstadoAhorroEnergia;
import Dispositivos.EstadoApagado;
import Dispositivos.EstadoDispositivoInteligente;
import Dispositivos.EstadoEncendido;
import Dispositivos.Fabricante;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class DispositivoInteligenteTest {

	DispositivoInteligente dispositivoInteligente1;
	DispositivoInteligente dispositivoInteligente2;
	DispositivoInteligente dispositivoInteligente3;
	EstadoDispositivoInteligente estado;
	Fabricante fabricante;
	LocalDate fechaInicio;
	LocalDate fechaFin;
	Cliente cliente;
	
	Fabricante fabricanteSamsung = mock(Fabricante.class);
	Fabricante fabricanteLG = mock(Fabricante.class);
	
	@Before
	public void setUp() {
		
		dispositivoInteligente1 = new DispositivoInteligente("Dispositivo prueba A",100);
		dispositivoInteligente1.setEstado(new EstadoApagado());
		dispositivoInteligente1.setIdDispositivo("11111");
		dispositivoInteligente1.setFabricante(fabricanteSamsung);
		
		dispositivoInteligente2 = new DispositivoInteligente("Dispositivo prueba B",100);
		dispositivoInteligente2.setEstado(new EstadoEncendido());
		dispositivoInteligente2.setIdDispositivo("22222");
		dispositivoInteligente2.setFabricante(fabricanteLG);
		
		dispositivoInteligente3 = new DispositivoInteligente("Dispositivo prueba C",100);
		dispositivoInteligente3.setEstado(new EstadoAhorroEnergia());
		dispositivoInteligente3.setIdDispositivo("33333");
		dispositivoInteligente3.setFabricante(fabricanteSamsung);
		
		fechaInicio = LocalDate.of(2018,4,01);
		fechaFin = LocalDate.of(2018,5,01);
		
		TipoDocumento tipo = TipoDocumento.DNI;
		LocalDate fechaDeAlta = LocalDate.of(2018,2,1);	
		cliente = new Cliente("Gabriel", "Figueroa", tipo, 33501713, 2222, "Azopardo 3636", fechaDeAlta);
		
	}
	
	// Test enceder dispositivo estando apagado
	@Test
	public void testEncenderEstandoApagado() {
		boolean esperado = true;
        dispositivoInteligente1.encender();
        assertEquals(esperado,dispositivoInteligente1.estaEncendido());
	}

	// Test apagar dispositivo estando apagado
	@Test
	public void testApagarEstandoApagado() {
		boolean esperado = false;
        dispositivoInteligente1.apagar();
        assertEquals(esperado,dispositivoInteligente1.estaEncendido());
	}
	
	// Test poner el dispositivo en ahorro energia estando apagado
	@Test
	public void testAhorroEnergiaEstandoApagado() {
		boolean esperado = false;
        dispositivoInteligente1.ahorroEnergia();
        assertEquals(esperado,dispositivoInteligente1.estaEnAhorroEnergia());
	}
	
	// Test enceder dispositivo estando encendido
	@Test
	public void testEncenderEstandoEncendido() {
		boolean esperado = true;
        dispositivoInteligente2.encender();
        assertEquals(esperado,dispositivoInteligente2.estaEncendido());
	}
	
	// Test apagar dispositivo estando encendido
	@Test
	public void testApagarEstandoEncendido() {
		boolean esperado = false;
        dispositivoInteligente2.apagar();
        assertEquals(esperado,dispositivoInteligente2.estaEncendido());
	}
	
	// Test poner el dispositivo en ahorro energia estando encendido
	@Test
	public void testAhorroEnergiaEstandoEncendido() {
		boolean esperado = true;
        dispositivoInteligente2.ahorroEnergia();
        assertEquals(esperado,dispositivoInteligente2.estaEnAhorroEnergia());
	}
	
	// Test enceder dispositivo estando en ahorro energia
	@Test
	public void testEncenderEstandoEnAhorroEnergia() {
		boolean esperado = true;
        dispositivoInteligente3.encender();
        assertEquals(esperado,dispositivoInteligente3.estaEncendido());
	}
	
	// Test apagar dispositivo estando en ahorro energia
	@Test
	public void testApagarEstandoEnAhorroEnergia() {
		boolean esperado = false;
        dispositivoInteligente3.apagar();
        assertEquals(esperado,dispositivoInteligente3.estaEncendido());
	}
	
	// Test poner el dispositivo en ahorro energia estando en ahorro energia
	@Test
	public void testAhorroEnergiaEstandoEnAhorroEnergia() {
		boolean esperado = true;
        dispositivoInteligente3.ahorroEnergia();
        assertEquals(esperado,dispositivoInteligente3.estaEnAhorroEnergia());
	}
		
	@Test
	public void testConsumoEnUltimasNHoras() {
		double esperado = 500;
        assertEquals(esperado,dispositivoInteligente1.consumoUltimasHoras(5),1.0);
	}
	
	@Test
	public void testConsumoPorPeriodo() {
		double esperado = 3000;
        assertEquals(esperado,dispositivoInteligente1.consumoPeriodo(fechaInicio, fechaFin),1.0);
	}
	
	//Tests Fabricantes
	
	// Test encedido fisico dispositivo fabricante Samsung cuando esta apagado
	@Test
	public void testEncenderDispositivoSamsungCuandoEstaApagado() {
		dispositivoInteligente1.encender();
		Mockito.verify(fabricanteSamsung, Mockito.atLeast(1)).encender(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
	}
	
	// Test apagado fisico dispositivo fabricante Samsung cuando esta apagado
	@Test
	public void testApagarDispositivoSamsungCuandoEstaApagado() {
		dispositivoInteligente1.apagar();
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
	}
	
	// Test ahorro energia fisico dispositivo fabricante Samsung cuando esta apagado
	@Test
	public void testAhorroEnergiaDispositivoSamsungCuandoEstaApagado() {
		dispositivoInteligente1.ahorroEnergia();
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente1.getIdDispositivo(), fabricanteSamsung);
	}
	
	// Test apagado fisico dispositivo LG cuando estaba encendido
	@Test
	public void testApagarDispositivoLGCuandoEstaEncendido() {
		dispositivoInteligente2.apagar();
		Mockito.verify(fabricanteLG, Mockito.atLeast(1)).apagar(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).encender(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).ahorroEnergia(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
	}
	
	// Test encendido fisico dispositivo LG cuando esta encendido
	@Test
	public void testEncenderDispositivoLGCuandoEstaEncendido() {
		dispositivoInteligente2.encender();
		Mockito.verify(fabricanteLG, Mockito.never()).apagar(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).encender(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).ahorroEnergia(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
	}
	
	// Test ahorro energia fisico dispositivo LG cuando esta encendido
	@Test
	public void testAhorroEnergiaDispositivoLGCuandoEstaEncendido() {
		dispositivoInteligente2.ahorroEnergia();
		Mockito.verify(fabricanteLG, Mockito.never()).apagar(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).encender(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.atLeast(1)).ahorroEnergia(dispositivoInteligente2.getIdDispositivo(), fabricanteLG);
	}
	
	// Test apagado fisico dispositivo Samsung cuando esta en ahorro energia
	@Test
	public void testApagarDispositivoSamsungCuandoEstaEnAhorroEnergia() {
		dispositivoInteligente3.apagar();
		Mockito.verify(fabricanteSamsung, Mockito.atLeast(1)).apagar(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
	}
	
	// Test encendido fisico dispositivo Smasung cuando esta en ahorro energia
	@Test
	public void testEncenderDispositivoSamsungCuandoEstaEnAhorroEnergia() {
		dispositivoInteligente3.encender();
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.atLeast(1)).encender(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
	}
	
	// Test ahorro energia fisico dispositivo Samsung cuando esta en ahorro energia
	@Test
	public void testAhorroEnergiaDispositivoSamsungCuandoEstaEnAhorroEnergia() {
		dispositivoInteligente3.ahorroEnergia();
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente3.getIdDispositivo(), fabricanteSamsung);
	}
	
}
