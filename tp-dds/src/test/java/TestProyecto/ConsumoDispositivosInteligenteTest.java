package TestProyecto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.Fabricante;

public class ConsumoDispositivosInteligenteTest {
	
	DispositivoInteligente DI1,DI2,DI3;
	Estado encendido = Estado.ENCENDIDO;
	Estado ahorroEnergia = Estado.AHORROENERGIA;
	Estado apagado = Estado.APAGADO;
	Fabricante fabricanteSamsung, fabricanteLG;
	LocalDateTime fechaDesde1, fechaHasta1, fechaDesde2, fechaHasta2;
	ConsumoDispositivosInteligente consumoDI1, consumoDI2;
	
	@Before
	public void Before() {
		
		Fabricante fabricanteSamsung = new Fabricante("Samsung");
		Fabricante fabricanteLG = new Fabricante("LG");
		
		DI1 = new DispositivoInteligente("computadora", 100.0);
		DI1.setEstado(apagado);
		DI1.setFabricante(fabricanteSamsung);

		DI2 = new DispositivoInteligente("Lavarropas", 200.0);
		DI2.setEstado(ahorroEnergia);
		DI2.setFabricante(fabricanteLG);
				
		fechaDesde1 = LocalDateTime.of(2018,04,01, 12,00);
		fechaDesde2 = LocalDateTime.of(2018,04,01, 9,00);
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesde1, fechaHasta1);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesde2, fechaHasta2);
		
		DI1.encender(fechaDesde1, consumoDI1);
		DI2.encender(fechaDesde2, consumoDI2);
		
		fechaHasta1 = LocalDateTime.of(2018,04,01, 20,00);
		fechaHasta2 = LocalDateTime.of(2018,04,01, 21,00);
		
		DI1.apagar(fechaHasta1, consumoDI1);
		DI2.apagar(fechaHasta2, consumoDI2);
		
	}
	
	@Test
	public void testConsumoDelDispositivo1() {
		assertEquals(800.00,DI1.consumoPeriodo(fechaDesde1, fechaHasta1),1.0);
	}
	
	@Test
	public void testConsumoDelDispositivo2() {
		assertEquals(2400.00,DI2.consumoPeriodo(fechaDesde2, fechaHasta2),1.0);
	}
	
}
