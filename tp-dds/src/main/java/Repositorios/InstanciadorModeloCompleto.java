package Repositorios;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.geodds.Point;

import com.google.common.hash.Hashing;
import Dispositivos.ConsumoDispositivosInteligente;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;
import Dispositivos.FabricanteLG;
import Dispositivos.FabricanteSamsung;
import Funcionalidades.Categorizador;
import Funcionalidades.Dispositivizador;
import Geoposicionamiento.Punto;
import Geoposicionamiento.Transformador;
import Geoposicionamiento.ZonaGeografica;
import Usuarios.Administrador;
import Usuarios.Categoria;
import Usuarios.Cliente;
import Usuarios.TipoDocumento;

public class InstanciadorModeloCompleto {
	
	public  static void  init() {
		DispositivoInteligente disInteligente1, disInteligente2,disInteligente3,disInteligente4;
		DispositivoInteligente disInteligente5,disInteligente6,disInteligente7,disInteligente8;
		ConsumoDispositivosInteligente consumoDI1,consumoDI2,consumoDI3,consumoDI4,consumoDI5,consumoDI6,consumoDI7,consumoDI8,consumoDI9,consumoDI10,consumoDI11;
		ConsumoDispositivosInteligente consumoDI12,consumoDI13,consumoDI14,consumoDI15,consumoDI16,consumoDI17,consumoDI18,consumoDI19,consumoDI20,consumoDI21,consumoDI22;
		ConsumoDispositivosInteligente consumoDI23,consumoDI24,consumoDI25,consumoDI26,consumoDI27,consumoDI28,consumoDI29,consumoDI30,consumoDI31,consumoDI32,consumoDI33;
		ConsumoDispositivosInteligente consumoDI34,consumoDI35,consumoDI36,consumoDI37,consumoDI38,consumoDI39,consumoDI40,consumoDI41,consumoDI42,consumoDI43,consumoDI44;
		ConsumoDispositivosInteligente consumoDI45,consumoDI46,consumoDI47,consumoDI48,consumoDI49,consumoDI50,consumoDI51,consumoDI52,consumoDI53,consumoDI54,consumoDI55;
		ConsumoDispositivosInteligente consumoDI56,consumoDI57,consumoDI58,consumoDI59,consumoDI60,consumoDI61,consumoDI62,consumoDI63,consumoDI64,consumoDI65,consumoDI66;
		ConsumoDispositivosInteligente consumoDI67,consumoDI68,consumoDI69,consumoDI70,consumoDI71,consumoDI72,consumoDI73,consumoDI74,consumoDI75,consumoDI76,consumoDI77;
		ConsumoDispositivosInteligente consumoDI78,consumoDI79,consumoDI80,consumoDI81,consumoDI82,consumoDI83,consumoDI84,consumoDI85,consumoDI86,consumoDI87,consumoDI88;
		ConsumoDispositivosInteligente consumoDI89,consumoDI90,consumoDI91,consumoDI92;
		LocalDateTime fechaDesdeEnero,fechaDesdeFebrero,fechaDesdeMarzo,fechaDesdeAbril,fechaDesdeMayo,fechaDesdeJunio;
		LocalDateTime fechaDesdeJulio,fechaDesdeAgosto,fechaDesdeSeptiembre,fechaDesdeOctubre,fechaDesdeNoviembre;
		LocalDateTime fechaHastaEnero,fechaHastaFebrero,fechaHastaMarzo,fechaHastaAbril,fechaHastaMayo,fechaHastaJunio;
		LocalDateTime fechaHastaJulio,fechaHastaAgosto,fechaHastaSeptiembre,fechaHastaOctubre,fechaHastaNoviembre;
		Estado apagado = Estado.APAGADO;
		FabricanteLG fabricanteLG;
		FabricanteSamsung fabricanteSamsung;
		List<Point> puntos1, puntos2;
		ZonaGeografica zona1, zona2;
		Transformador transformador1, transformador2,transformador3;
		Punto punto1, punto2, punto3, punto4, punto5, punto6;

		fabricanteLG = new FabricanteLG("LG");
		fabricanteSamsung = new FabricanteSamsung("Samsung");
		
		disInteligente1 = Dispositivizador.getInstance().LavarropaAuto;
		disInteligente1.setEstado(apagado);
		
		disInteligente2 = Dispositivizador.getInstance().TVLED40;
		disInteligente2.setEstado(apagado);
		
		disInteligente3 = Dispositivizador.getInstance().AireAcondicionado3500;
		disInteligente3.setEstado(apagado);
		
		disInteligente4 = Dispositivizador.getInstance().TVLED32;
		disInteligente4.setEstado(apagado);
		
		disInteligente5 = Dispositivizador.getInstance().TVLED24;
		disInteligente5.setEstado(apagado);
		
		disInteligente6 = Dispositivizador.getInstance().LamparaHalogena40;
		disInteligente6.setEstado(apagado);
		
		disInteligente7 = Dispositivizador.getInstance().LamparaHalogena60;
		disInteligente7.setEstado(apagado);
		
		disInteligente8 = Dispositivizador.getInstance().Lampara11W;
		disInteligente8.setEstado(apagado);
		
		disInteligente1.setFabricante(fabricanteLG);
		disInteligente2.setFabricante(fabricanteLG);
		disInteligente3.setFabricante(fabricanteSamsung);
		disInteligente4.setFabricante(fabricanteSamsung);
		disInteligente5.setFabricante(fabricanteLG);
		disInteligente6.setFabricante(fabricanteLG);
		disInteligente7.setFabricante(fabricanteSamsung);
		disInteligente8.setFabricante(fabricanteSamsung);
		
		fechaDesdeEnero = LocalDateTime.of(2018,1,01, 00,00);
		fechaHastaEnero = LocalDateTime.of(2018,1,31, 21,00);
		fechaDesdeFebrero = LocalDateTime.of(2018,2,01, 00,00);
		fechaHastaFebrero = LocalDateTime.of(2018,2,28, 21,00);
		fechaDesdeMarzo = LocalDateTime.of(2018,3,01, 00,00);
		fechaHastaMarzo = LocalDateTime.of(2018,3,31, 21,00);
		fechaDesdeAbril = LocalDateTime.of(2018,4,01, 00,00);
		fechaHastaAbril = LocalDateTime.of(2018,4,30, 21,00);
		fechaDesdeMayo = LocalDateTime.of(2018,5,01, 00,00);
		fechaHastaMayo = LocalDateTime.of(2018,5,31, 21,00);
		fechaDesdeJunio = LocalDateTime.of(2018,6,01, 00,00);
		fechaHastaJunio = LocalDateTime.of(2018,6,30, 21,00);
		fechaDesdeJulio = LocalDateTime.of(2018,7,01, 00,00);
		fechaHastaJulio = LocalDateTime.of(2018,7,31, 21,00);
		fechaDesdeAgosto = LocalDateTime.of(2018,8,01, 00,00);
		fechaHastaAgosto = LocalDateTime.of(2018,8,31, 21,00);
		fechaDesdeSeptiembre = LocalDateTime.of(2018,9,01, 00,00);
		fechaHastaSeptiembre = LocalDateTime.of(2018,9,30, 21,00);
		fechaDesdeOctubre = LocalDateTime.of(2018,10,01, 00,00);
		fechaHastaOctubre = LocalDateTime.of(2018,10,31, 21,00);
		fechaDesdeNoviembre = LocalDateTime.of(2018,11,01, 00,00);
		fechaHastaNoviembre = LocalDateTime.now();
		
		consumoDI1 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI2 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI3 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI4 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI5 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI6 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI7 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI8 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI9 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI10 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI11 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI12 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI13 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI14 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI15 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI16 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI17 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI18 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI19 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI20 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI21 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI22 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI23 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI24 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI25 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI26 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI27 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI28 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI29 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI30 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI31 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI32 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI33 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI34 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI35 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI36 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI37 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI38 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI39 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI40 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI41 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI42 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI43 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI44 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI45 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI46 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI47 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI48 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI49 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI50 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI51 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI52 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI53 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI54 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI55 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI56 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI57 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI58 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI59 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI60 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI61 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI62 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI63 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI64 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI65 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI66 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI67 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI68 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI69 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI70 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI71 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI72 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI73 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI74 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI75 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI76 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI77 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI78 = new ConsumoDispositivosInteligente(fechaDesdeEnero, fechaHastaEnero);
		consumoDI79 = new ConsumoDispositivosInteligente(fechaDesdeFebrero, fechaHastaFebrero);
		consumoDI80 = new ConsumoDispositivosInteligente(fechaDesdeMarzo, fechaHastaMarzo);
		consumoDI81 = new ConsumoDispositivosInteligente(fechaDesdeAbril, fechaHastaAbril);
		consumoDI82 = new ConsumoDispositivosInteligente(fechaDesdeMayo, fechaHastaMayo);
		consumoDI83 = new ConsumoDispositivosInteligente(fechaDesdeJunio, fechaHastaJunio);
		consumoDI84 = new ConsumoDispositivosInteligente(fechaDesdeJulio, fechaHastaJulio);
		consumoDI85 = new ConsumoDispositivosInteligente(fechaDesdeAgosto, fechaHastaAgosto);
		consumoDI86 = new ConsumoDispositivosInteligente(fechaDesdeSeptiembre, fechaHastaSeptiembre);
		consumoDI87 = new ConsumoDispositivosInteligente(fechaDesdeOctubre, fechaHastaOctubre);
		consumoDI88 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		consumoDI89 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		consumoDI90 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		consumoDI91 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		consumoDI92 = new ConsumoDispositivosInteligente(fechaDesdeNoviembre, fechaHastaNoviembre);
		
		disInteligente1.encender(fechaDesdeEnero, consumoDI1);
		disInteligente1.apagar(fechaHastaEnero, consumoDI1);
		disInteligente1.encender(fechaDesdeFebrero, consumoDI2);
		disInteligente1.apagar(fechaHastaFebrero, consumoDI2);
		disInteligente1.encender(fechaDesdeMarzo, consumoDI3);
		disInteligente1.apagar(fechaHastaMarzo, consumoDI3);
		disInteligente1.encender(fechaDesdeAbril, consumoDI4);
		disInteligente1.apagar(fechaHastaAbril, consumoDI4);
		disInteligente1.encender(fechaDesdeMayo, consumoDI5);
		disInteligente1.apagar(fechaHastaMayo, consumoDI5);
		disInteligente1.encender(fechaDesdeJunio, consumoDI6);
		disInteligente1.apagar(fechaHastaJunio, consumoDI6);
		disInteligente1.encender(fechaDesdeJulio, consumoDI7);
		disInteligente1.apagar(fechaHastaJulio, consumoDI7);
		disInteligente1.encender(fechaDesdeAgosto, consumoDI8);
		disInteligente1.apagar(fechaHastaAgosto, consumoDI8);
		disInteligente1.encender(fechaDesdeSeptiembre, consumoDI9);
		disInteligente1.apagar(fechaHastaSeptiembre, consumoDI9);
		disInteligente1.encender(fechaDesdeOctubre, consumoDI10);
		disInteligente1.apagar(fechaHastaOctubre, consumoDI10);
		disInteligente1.encender(fechaDesdeNoviembre, consumoDI11);
		disInteligente1.apagar(fechaHastaNoviembre, consumoDI11);
		
		disInteligente2.encender(fechaDesdeEnero, consumoDI12);
		disInteligente2.apagar(fechaHastaEnero, consumoDI12);
		disInteligente2.encender(fechaDesdeFebrero, consumoDI13);
		disInteligente2.apagar(fechaHastaFebrero, consumoDI13);
		disInteligente2.encender(fechaDesdeMarzo, consumoDI14);
		disInteligente2.apagar(fechaHastaMarzo, consumoDI14);
		disInteligente2.encender(fechaDesdeAbril, consumoDI15);
		disInteligente2.apagar(fechaHastaAbril, consumoDI15);
		disInteligente2.encender(fechaDesdeMayo, consumoDI16);
		disInteligente2.apagar(fechaHastaMayo, consumoDI16);
		disInteligente2.encender(fechaDesdeJunio, consumoDI17);
		disInteligente2.apagar(fechaHastaJunio, consumoDI17);
		disInteligente2.encender(fechaDesdeJulio, consumoDI18);
		disInteligente2.apagar(fechaHastaJulio, consumoDI18);
		disInteligente2.encender(fechaDesdeAgosto, consumoDI19);
		disInteligente2.apagar(fechaHastaAgosto, consumoDI19);
		disInteligente2.encender(fechaDesdeSeptiembre, consumoDI20);
		disInteligente2.apagar(fechaHastaSeptiembre, consumoDI20);
		disInteligente2.encender(fechaDesdeOctubre, consumoDI21);
		disInteligente2.apagar(fechaHastaOctubre, consumoDI21);
		disInteligente2.encender(fechaDesdeNoviembre, consumoDI22);
		disInteligente2.apagar(fechaHastaNoviembre, consumoDI22);
		
		disInteligente3.encender(fechaDesdeEnero, consumoDI23);
		disInteligente3.apagar(fechaHastaEnero, consumoDI23);
		disInteligente3.encender(fechaDesdeFebrero, consumoDI24);
		disInteligente3.apagar(fechaHastaFebrero, consumoDI24);
		disInteligente3.encender(fechaDesdeMarzo, consumoDI25);
		disInteligente3.apagar(fechaHastaMarzo, consumoDI25);
		disInteligente3.encender(fechaDesdeAbril, consumoDI26);
		disInteligente3.apagar(fechaHastaAbril, consumoDI26);
		disInteligente3.encender(fechaDesdeMayo, consumoDI27);
		disInteligente3.apagar(fechaHastaMayo, consumoDI27);
		disInteligente3.encender(fechaDesdeJunio, consumoDI28);
		disInteligente3.apagar(fechaHastaJunio, consumoDI28);
		disInteligente3.encender(fechaDesdeJulio, consumoDI29);
		disInteligente3.apagar(fechaHastaJulio, consumoDI29);
		disInteligente3.encender(fechaDesdeAgosto, consumoDI30);
		disInteligente3.apagar(fechaHastaAgosto, consumoDI30);
		disInteligente3.encender(fechaDesdeSeptiembre, consumoDI31);
		disInteligente3.apagar(fechaHastaSeptiembre, consumoDI31);
		disInteligente3.encender(fechaDesdeOctubre, consumoDI32);
		disInteligente3.apagar(fechaHastaOctubre, consumoDI32);
		disInteligente3.encender(fechaDesdeNoviembre, consumoDI33);
		disInteligente3.apagar(fechaHastaNoviembre, consumoDI33);
		
		disInteligente4.encender(fechaDesdeEnero, consumoDI34);
		disInteligente4.apagar(fechaHastaEnero, consumoDI34);
		disInteligente4.encender(fechaDesdeFebrero, consumoDI35);
		disInteligente4.apagar(fechaHastaFebrero, consumoDI35);
		disInteligente4.encender(fechaDesdeMarzo, consumoDI36);
		disInteligente4.apagar(fechaHastaMarzo, consumoDI36);
		disInteligente4.encender(fechaDesdeAbril, consumoDI37);
		disInteligente4.apagar(fechaHastaAbril, consumoDI37);
		disInteligente4.encender(fechaDesdeMayo, consumoDI38);
		disInteligente4.apagar(fechaHastaMayo, consumoDI38);
		disInteligente4.encender(fechaDesdeJunio, consumoDI39);
		disInteligente4.apagar(fechaHastaJunio, consumoDI39);
		disInteligente4.encender(fechaDesdeJulio, consumoDI40);
		disInteligente4.apagar(fechaHastaJulio, consumoDI40);
		disInteligente4.encender(fechaDesdeAgosto, consumoDI41);
		disInteligente4.apagar(fechaHastaAgosto, consumoDI41);
		disInteligente4.encender(fechaDesdeSeptiembre, consumoDI42);
		disInteligente4.apagar(fechaHastaSeptiembre, consumoDI42);
		disInteligente4.encender(fechaDesdeOctubre, consumoDI43);
		disInteligente4.apagar(fechaHastaOctubre, consumoDI43);
		disInteligente4.encender(fechaDesdeNoviembre, consumoDI44);
		disInteligente4.apagar(fechaHastaNoviembre, consumoDI44);
		
		disInteligente5.encender(fechaDesdeEnero, consumoDI45);
		disInteligente5.apagar(fechaHastaEnero, consumoDI45);
		disInteligente5.encender(fechaDesdeFebrero, consumoDI46);
		disInteligente5.apagar(fechaHastaFebrero, consumoDI46);
		disInteligente5.encender(fechaDesdeMarzo, consumoDI47);
		disInteligente5.apagar(fechaHastaMarzo, consumoDI47);
		disInteligente5.encender(fechaDesdeAbril, consumoDI48);
		disInteligente5.apagar(fechaHastaAbril, consumoDI48);
		disInteligente5.encender(fechaDesdeMayo, consumoDI49);
		disInteligente5.apagar(fechaHastaMayo, consumoDI49);
		disInteligente5.encender(fechaDesdeJunio, consumoDI50);
		disInteligente5.apagar(fechaHastaJunio, consumoDI50);
		disInteligente5.encender(fechaDesdeJulio, consumoDI51);
		disInteligente5.apagar(fechaHastaJulio, consumoDI51);
		disInteligente5.encender(fechaDesdeAgosto, consumoDI52);
		disInteligente5.apagar(fechaHastaAgosto, consumoDI52);
		disInteligente5.encender(fechaDesdeSeptiembre, consumoDI53);
		disInteligente5.apagar(fechaHastaSeptiembre, consumoDI53);
		disInteligente5.encender(fechaDesdeOctubre, consumoDI54);
		disInteligente5.apagar(fechaHastaOctubre, consumoDI54);
		disInteligente5.encender(fechaDesdeNoviembre, consumoDI55);
		disInteligente5.apagar(fechaHastaNoviembre, consumoDI55);
		
		disInteligente6.encender(fechaDesdeEnero, consumoDI56);
		disInteligente6.apagar(fechaHastaEnero, consumoDI56);
		disInteligente6.encender(fechaDesdeFebrero, consumoDI57);
		disInteligente6.apagar(fechaHastaFebrero, consumoDI57);
		disInteligente6.encender(fechaDesdeMarzo, consumoDI58);
		disInteligente6.apagar(fechaHastaMarzo, consumoDI58);
		disInteligente6.encender(fechaDesdeAbril, consumoDI59);
		disInteligente6.apagar(fechaHastaAbril, consumoDI59);
		disInteligente6.encender(fechaDesdeMayo, consumoDI60);
		disInteligente6.apagar(fechaHastaMayo, consumoDI60);
		disInteligente6.encender(fechaDesdeJunio, consumoDI61);
		disInteligente6.apagar(fechaHastaJunio, consumoDI61);
		disInteligente6.encender(fechaDesdeJulio, consumoDI62);
		disInteligente6.apagar(fechaHastaJulio, consumoDI62);
		disInteligente6.encender(fechaDesdeAgosto, consumoDI63);
		disInteligente6.apagar(fechaHastaAgosto, consumoDI63);
		disInteligente6.encender(fechaDesdeSeptiembre, consumoDI64);
		disInteligente6.apagar(fechaHastaSeptiembre, consumoDI64);
		disInteligente6.encender(fechaDesdeOctubre, consumoDI65);
		disInteligente6.apagar(fechaHastaOctubre, consumoDI65);
		disInteligente6.encender(fechaDesdeNoviembre, consumoDI66);
		disInteligente6.apagar(fechaHastaNoviembre, consumoDI66);
		
		disInteligente7.encender(fechaDesdeEnero, consumoDI67);
		disInteligente7.apagar(fechaHastaEnero, consumoDI67);
		disInteligente7.encender(fechaDesdeFebrero, consumoDI68);
		disInteligente7.apagar(fechaHastaFebrero, consumoDI68);
		disInteligente7.encender(fechaDesdeMarzo, consumoDI69);
		disInteligente7.apagar(fechaHastaMarzo, consumoDI69);
		disInteligente7.encender(fechaDesdeAbril, consumoDI70);
		disInteligente7.apagar(fechaHastaAbril, consumoDI70);
		disInteligente7.encender(fechaDesdeMayo, consumoDI71);
		disInteligente7.apagar(fechaHastaMayo, consumoDI71);
		disInteligente7.encender(fechaDesdeJunio, consumoDI72);
		disInteligente7.apagar(fechaHastaJunio, consumoDI72);
		disInteligente7.encender(fechaDesdeJulio, consumoDI73);
		disInteligente7.apagar(fechaHastaJulio, consumoDI73);
		disInteligente7.encender(fechaDesdeAgosto, consumoDI74);
		disInteligente7.apagar(fechaHastaAgosto, consumoDI74);
		disInteligente7.encender(fechaDesdeSeptiembre, consumoDI75);
		disInteligente7.apagar(fechaHastaSeptiembre, consumoDI75);
		disInteligente7.encender(fechaDesdeOctubre, consumoDI76);
		disInteligente7.apagar(fechaHastaOctubre, consumoDI76);
		disInteligente7.encender(fechaDesdeNoviembre, consumoDI77);
		disInteligente7.apagar(fechaHastaNoviembre, consumoDI77);
		
		disInteligente8.encender(fechaDesdeEnero, consumoDI78);
		disInteligente8.apagar(fechaHastaEnero, consumoDI78);
		disInteligente8.encender(fechaDesdeFebrero, consumoDI79);
		disInteligente8.apagar(fechaHastaFebrero, consumoDI79);
		disInteligente8.encender(fechaDesdeMarzo, consumoDI80);
		disInteligente8.apagar(fechaHastaMarzo, consumoDI80);
		disInteligente8.encender(fechaDesdeAbril, consumoDI81);
		disInteligente8.apagar(fechaHastaAbril, consumoDI81);
		disInteligente8.encender(fechaDesdeMayo, consumoDI82);
		disInteligente8.apagar(fechaHastaMayo, consumoDI82);
		disInteligente8.encender(fechaDesdeJunio, consumoDI83);
		disInteligente8.apagar(fechaHastaJunio, consumoDI83);
		disInteligente8.encender(fechaDesdeJulio, consumoDI84);
		disInteligente8.apagar(fechaHastaJulio, consumoDI84);
		disInteligente8.encender(fechaDesdeAgosto, consumoDI85);
		disInteligente8.apagar(fechaHastaAgosto, consumoDI85);
		disInteligente8.encender(fechaDesdeSeptiembre, consumoDI86);
		disInteligente8.apagar(fechaHastaSeptiembre, consumoDI86);
		disInteligente8.encender(fechaDesdeOctubre, consumoDI87);
		disInteligente8.apagar(fechaHastaOctubre, consumoDI87);
		disInteligente8.encender(fechaDesdeNoviembre, consumoDI88);
		disInteligente8.apagar(fechaHastaNoviembre, consumoDI88);
		
		disInteligente1.encender(fechaDesdeNoviembre, consumoDI89);
		disInteligente2.encender(fechaDesdeNoviembre, consumoDI90);
		disInteligente3.encender(fechaDesdeNoviembre, consumoDI91);
		disInteligente4.encender(fechaDesdeNoviembre, consumoDI92);
		disInteligente2.ahorroEnergia();
		disInteligente4.ahorroEnergia();
		
		TipoDocumento tipo = TipoDocumento.DNI;
		LocalDate fechaDeAlta = LocalDate.of(2018, 2, 1);
		
		Cliente cliente1 = new Cliente("jhon","salazar",tipo, 1, 1,"jhon12",Hashing.sha256()
				  .hashString("salazar", StandardCharsets.UTF_8)
				  .toString(), "Azopardo 3636", fechaDeAlta);//password = salazar, userID = jhon12
		
		Cliente cliente2 = new Cliente("jorge","muhsisoglu",tipo, 33457756, 45551234,"jorge87",Hashing.sha256()
				.hashString("jorge", StandardCharsets.UTF_8)
				.toString(),"Falsa 1234", fechaDeAlta);//password = jorge, userID = jorge87
		
		Cliente cliente3 = new Cliente("martin","isnardi",tipo, 33501813, 45559876,"martin23",Hashing.sha256()
				.hashString("martin", StandardCharsets.UTF_8)
				.toString(),"Sarandi 3636", fechaDeAlta);//password = martin, userID = martin23
		
		Cliente cliente4 = new Cliente("pepe","argento",tipo, 39501713, 45551597,"pepe67",Hashing.sha256()
				.hashString("pepito", StandardCharsets.UTF_8)
				.toString(),"Malabia 1614", fechaDeAlta);//password = pepito, userID = pepe67
		
		

		Categoria categoriaR2 = Categorizador.getInstance().R2;
		Categoria categoriaR3 = Categorizador.getInstance().R3;
		
		cliente1.setCategoria(categoriaR2);
		cliente2.setCategoria(categoriaR3);
		cliente3.setCategoria(categoriaR2);
		cliente4.setCategoria(categoriaR3);
		
		cliente1.agregarDispositivoInteligente(disInteligente1);
		cliente1.agregarDispositivoInteligente(disInteligente2);
		
		cliente2.agregarDispositivoInteligente(disInteligente3);
		cliente2.agregarDispositivoInteligente(disInteligente4);

		cliente3.agregarDispositivoInteligente(disInteligente5);
		cliente3.agregarDispositivoInteligente(disInteligente6);
		
		cliente4.agregarDispositivoInteligente(disInteligente7);
		cliente4.agregarDispositivoInteligente(disInteligente8);
		
		transformador1 = new Transformador(-34.598494, -58.420186);
		transformador2 = new Transformador(-34.659438, -58.4704135);
		transformador3 = new Transformador(-34.582965, -58.381756);
		
		transformador1.agregarClientes(cliente1);
		transformador1.agregarClientes(cliente2);
		transformador2.agregarClientes(cliente3);
		transformador3.agregarClientes(cliente4);

		punto1 = new Punto(2.55, 23.98);
		punto2 = new Punto(2.58, 24.97);
		punto3 = new Punto(2.95, 24.92);
		punto4 = new Punto(2.33, 23.70);
		punto5 = new Punto(2.75, 24.95);
		punto6 = new Punto(2.67, 24.88);
		
		puntos1 = new ArrayList<Point>();
		puntos2 = new ArrayList<Point>();
		
		puntos1.add(punto1);
		puntos1.add(punto2);
		puntos1.add(punto3);
		
		puntos2.add(punto4);
		puntos2.add(punto5);
		puntos2.add(punto6);
		
		zona1 = new ZonaGeografica(puntos1);
		zona2 = new ZonaGeografica(puntos2);
		
		zona1.agregarTransformadores(transformador1);
		zona1.agregarTransformadores(transformador2);
		zona2.agregarTransformadores(transformador3);
		
		RepoZonasGeograficas.getInstance().insertarZona(zona1);
		RepoZonasGeograficas.getInstance().insertarZona(zona2);

		
		Administrador adminJhon = new Administrador("Jhon","Salazar","Azopardo 3636","jsalazar",Hashing.sha256().hashString("Salazar1234", StandardCharsets.UTF_8).toString());	
		Administrador adminJorge = new Administrador("Jorge","Muhsisoglu","Falsa 1234","jmuhsisoglu",Hashing.sha256().hashString("Muhsisoglu1234", StandardCharsets.UTF_8).toString());
		Administrador adminMartin = new Administrador("Martin","Isnardi","Sarandi 1234","misnardi",Hashing.sha256().hashString("Isnardi1234", StandardCharsets.UTF_8).toString());
		
		RepoAdministradores.getInstance().insertarAdmin(adminJhon);
		RepoAdministradores.getInstance().insertarAdmin(adminJorge);
		RepoAdministradores.getInstance().insertarAdmin(adminMartin);
		
	}
	
}
