package TestProyecto;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.Fabricante;

public class DispositivoInteligenteTest {

	DispositivoInteligente dispositivoInteligente1;
	DispositivoInteligente dispositivoInteligente2;
	DispositivoInteligente dispositivoInteligente3;
	Estado encendido = Estado.ENCENDIDO;
	Estado apagado = Estado.APAGADO;
	Estado ahorroEnergia = Estado.AHORROENERGIA;
	
	Fabricante fabricante;
	LocalDateTime fechaDesde1, fechaHasta1, fechaDesde2, fechaHasta2, fechaDesde3, fechaHasta3;
	
	Fabricante fabricanteSamsung = mock(Fabricante.class);
	Fabricante fabricanteLG = mock(Fabricante.class);
	
	ConsumoDispositivosInteligente consumoDI1, consumoDI2, consumoDI3;
	
	@Before
	public void setUp() {
		
		dispositivoInteligente1 = new DispositivoInteligente("Dispositivo prueba A",100);
		dispositivoInteligente1.setEstado(apagado);
		dispositivoInteligente1.setFabricante(fabricanteSamsung);
		
		dispositivoInteligente2 = new DispositivoInteligente("Dispositivo prueba B",100);
		dispositivoInteligente2.setEstado(encendido);
		dispositivoInteligente2.setFabricante(fabricanteLG);
		
		dispositivoInteligente3 = new DispositivoInteligente("Dispositivo prueba C",100);
		dispositivoInteligente3.setEstado(ahorroEnergia);
		dispositivoInteligente3.setFabricante(fabricanteSamsung);
		
		fechaDesde1 = LocalDateTime.of(2018,4,01, 12,00);
		fechaHasta1 = LocalDateTime.of(2018,4,02, 12,00);
		fechaDesde2 = LocalDateTime.of(2018,6,01, 12,00);
		fechaHasta2 = LocalDateTime.of(2018,7,01, 12,00);
		fechaDesde3 = LocalDateTime.of(2018,10,01, 12,00);
		fechaHasta3 = LocalDateTime.of(2018,11,01, 12,00);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde2, fechaHasta2);
		consumoDI3 = new ConsumoDispositivosInteligente(fechaDesde3, fechaHasta3);
		
	}
	
	// Test apagar dispositivo estando apagado
			@Test
			public void testApagarEstandoApagadoApagado() {
				boolean esperado = true;
		       
		        assertEquals(esperado,dispositivoInteligente1.estaApagado());
			}
	
	// Test enceder dispositivo estando apagado
	@Test
	public void testEncenderEstandoApagado() {
		boolean esperado = true;
        dispositivoInteligente1.encender(fechaDesde1, consumoDI1);
        assertEquals(esperado,dispositivoInteligente1.estaEncendido());
	}

	// Test apagar dispositivo estando apagado
	@Test
	public void testApagarEstandoApagado() {
		boolean esperado = false;
        dispositivoInteligente1.apagar(fechaHasta1, consumoDI1);
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
        dispositivoInteligente2.encender(fechaDesde2, consumoDI2);
        assertEquals(esperado,dispositivoInteligente2.estaEncendido());
	}
	
	// Test apagar dispositivo estando encendido
	@Test
	public void testApagarEstandoEncendido() {
		boolean esperado = false;
        dispositivoInteligente2.apagar(fechaHasta2, consumoDI2);
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
        dispositivoInteligente3.encender(fechaDesde3, consumoDI3);
        assertEquals(esperado,dispositivoInteligente3.estaEncendido());
	}
	
	// Test apagar dispositivo estando en ahorro energia
	@Test
	public void testApagarEstandoEnAhorroEnergia() {
		boolean esperado = false;
        dispositivoInteligente3.apagar(fechaHasta3, consumoDI3);
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
		double esperado = 2400;
		dispositivoInteligente1.encender(fechaDesde1, consumoDI1);
		dispositivoInteligente1.apagar(fechaHasta1, consumoDI1);
        assertEquals(esperado,dispositivoInteligente1.consumoPeriodo(fechaDesde1, fechaHasta1),1.0);
	}
	
	//Tests Fabricantes
	
	// Test encedido fisico dispositivo fabricante Samsung cuando esta apagado
	@Test
	public void testEncenderDispositivoSamsungCuandoEstaApagado() {
		dispositivoInteligente1.encender(fechaDesde1, consumoDI1);
		Mockito.verify(fabricanteSamsung, Mockito.atLeast(1)).encender(dispositivoInteligente1.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente1.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente1.getId(), fabricanteSamsung);
	}
	
	// Test apagado fisico dispositivo fabricante Samsung cuando esta apagado
	@Test
	public void testApagarDispositivoSamsungCuandoEstaApagado() {
		dispositivoInteligente1.apagar(fechaHasta1, consumoDI1);
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente1.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente1.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente1.getId(), fabricanteSamsung);
	}
	
	// Test ahorro energia fisico dispositivo fabricante Samsung cuando esta apagado
	@Test
	public void testAhorroEnergiaDispositivoSamsungCuandoEstaApagado() {
		dispositivoInteligente1.ahorroEnergia();
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente1.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente1.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente1.getId(), fabricanteSamsung);
	}
	
	// Test apagado fisico dispositivo LG cuando estaba encendido
	@Test
	public void testApagarDispositivoLGCuandoEstaEncendido() {
		dispositivoInteligente2.apagar(fechaHasta2, consumoDI2);
		Mockito.verify(fabricanteLG, Mockito.atLeast(1)).apagar(dispositivoInteligente2.getId(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).encender(dispositivoInteligente2.getId(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).ahorroEnergia(dispositivoInteligente2.getId(), fabricanteLG);
	}
	
	// Test encendido fisico dispositivo LG cuando esta encendido
	@Test
	public void testEncenderDispositivoLGCuandoEstaEncendido() {
		dispositivoInteligente2.encender(fechaDesde2, consumoDI2);
		Mockito.verify(fabricanteLG, Mockito.never()).apagar(dispositivoInteligente2.getId(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).encender(dispositivoInteligente2.getId(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).ahorroEnergia(dispositivoInteligente2.getId(), fabricanteLG);
	}
	
	// Test ahorro energia fisico dispositivo LG cuando esta encendido
	@Test
	public void testAhorroEnergiaDispositivoLGCuandoEstaEncendido() {
		dispositivoInteligente2.ahorroEnergia();
		Mockito.verify(fabricanteLG, Mockito.never()).apagar(dispositivoInteligente2.getId(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.never()).encender(dispositivoInteligente2.getId(), fabricanteLG);
		Mockito.verify(fabricanteLG, Mockito.atLeast(1)).ahorroEnergia(dispositivoInteligente2.getId(), fabricanteLG);
	}
	
	// Test apagado fisico dispositivo Samsung cuando esta en ahorro energia
	@Test
	public void testApagarDispositivoSamsungCuandoEstaEnAhorroEnergia() {
		dispositivoInteligente3.apagar(fechaHasta3, consumoDI2);
		Mockito.verify(fabricanteSamsung, Mockito.atLeast(1)).apagar(dispositivoInteligente3.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente3.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente3.getId(), fabricanteSamsung);
	}
	
	// Test encendido fisico dispositivo Smasung cuando esta en ahorro energia
	@Test
	public void testEncenderDispositivoSamsungCuandoEstaEnAhorroEnergia() {
		dispositivoInteligente3.encender(fechaDesde3, consumoDI3);
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente3.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.atLeast(1)).encender(dispositivoInteligente3.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente3.getId(), fabricanteSamsung);
	}
	
	// Test ahorro energia fisico dispositivo Samsung cuando esta en ahorro energia
	@Test
	public void testAhorroEnergiaDispositivoSamsungCuandoEstaEnAhorroEnergia() {
		dispositivoInteligente3.ahorroEnergia();
		Mockito.verify(fabricanteSamsung, Mockito.never()).apagar(dispositivoInteligente3.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).encender(dispositivoInteligente3.getId(), fabricanteSamsung);
		Mockito.verify(fabricanteSamsung, Mockito.never()).ahorroEnergia(dispositivoInteligente3.getId(), fabricanteSamsung);
	}
	
}
