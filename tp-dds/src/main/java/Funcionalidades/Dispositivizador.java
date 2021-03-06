package Funcionalidades;

import Dispositivos.DispositivoEstandar;
import Dispositivos.DispositivoInteligente;
import Dispositivos.Estado;

import static Valores.ValoresParaDispositivos.*;


public class Dispositivizador {


public static Dispositivizador dispositivizador = new Dispositivizador ();
	
	private Dispositivizador() {}; 
	
	public static Dispositivizador getInstance() {
		return dispositivizador;
	}
	
	Estado encendido = Estado.ENCENDIDO;
	
	public DispositivoInteligente AireAcondicionado3500 = new DispositivoInteligente(
				AIREACONDICIONADO_3500_CALORIAS_NOMBRE,
				AIREACONDICIONADO_3500_CALORIAS_CONSUMO,
				encendido,
				AIREACONDICIONADO_CONSUMO_MENSUAL_MINIMO, 
				AIREACONDICIONADO_CONSUMO_MENSUAL_MAXIMO,
				AIREACONDICIONADO_3500_CALORIAS_ESBAJOCONSUMO);
	
	public DispositivoInteligente AireAcondicionado2200 = new DispositivoInteligente(
			AIREACONDICIONADO_2200_CALORIAS_NOMBRE,
			AIREACONDICIONADO_2200_CALORIAS_CONSUMO,
			encendido,
			AIREACONDICIONADO_CONSUMO_MENSUAL_MINIMO, 
			AIREACONDICIONADO_CONSUMO_MENSUAL_MAXIMO,
			AIREACONDICIONADO_2200_CALORIAS_ESBAJOCONSUMO);

	public DispositivoEstandar TVTubo21 = new DispositivoEstandar(
			TELEVISOR_TUBO_21_PULGADAS_NOMBRE,
			TELEVISOR_TUBO_21_PULGADAS_CONSUMO,
			TELEVISOR_CONSUMO_MENSUAL_MINIMO, 
			TELEVISOR_CONSUMO_MENSUAL_MAXIMO,
			TELEVISOR_TUBO_21_PULGADAS_ESBAJOCONSUMO);
		
	public DispositivoEstandar TVTubo29A34 = new DispositivoEstandar(
			TELEVISOR_TUBO_29_A_34_PULGADAS_NOMBRE,
			TELEVISOR_TUBO_29_A_34_PULGADAS_CONSUMO,
			TELEVISOR_CONSUMO_MENSUAL_MINIMO, 
			TELEVISOR_CONSUMO_MENSUAL_MAXIMO,
			TELEVISOR_TUBO_29_A_34_PULGADAS_ESBAJOCONSUMO);
	
	
	public DispositivoEstandar TVLCD40 = new DispositivoEstandar(
			TELEVISOR_LCD_40_PULGADAS_NOMBRE,
			TELEVISOR_LCD_40_PULGADAS_CONSUMO,
			TELEVISOR_CONSUMO_MENSUAL_MINIMO, 
			TELEVISOR_CONSUMO_MENSUAL_MAXIMO,
			TELEVISOR_LCD_40_PULGADAS_ESBAJOCONSUMO);
	
	public DispositivoInteligente TVLED24 = new DispositivoInteligente(
			TELEVISOR_LED_24_PULGADAS_NOMBRE,
			TELEVISOR_LED_24_PULGADAS_CONSUMO,
			encendido,
			TELEVISOR_CONSUMO_MENSUAL_MINIMO, 
			TELEVISOR_CONSUMO_MENSUAL_MAXIMO,
			TELEVISOR_LED_24_PULGADAS_ESBAJOCONSUMO);
	
	public DispositivoInteligente TVLED32 = new DispositivoInteligente(
			TELEVISOR_LED_32_PULGADAS_NOMBRE,
			TELEVISOR_LED_32_PULGADAS_CONSUMO,
			encendido,
			TELEVISOR_CONSUMO_MENSUAL_MINIMO, 
			TELEVISOR_CONSUMO_MENSUAL_MAXIMO,
			TELEVISOR_LED_32_PULGADAS_ESBAJOCONSUMO);
	
	public DispositivoInteligente TVLED40 = new DispositivoInteligente(
			TELEVISOR_LED_40_PULGADAS_NOMBRE,
			TELEVISOR_LED_40_PULGADAS_CONSUMO,
			encendido, TELEVISOR_CONSUMO_MENSUAL_MINIMO, 
			TELEVISOR_CONSUMO_MENSUAL_MAXIMO,
			TELEVISOR_LED_40_PULGADAS_ESBAJOCONSUMO);
	
	public DispositivoEstandar LavarropaAutoConCalentamiento = new DispositivoEstandar(
			LAVARROPAS_AUTOMATICO_5KG_CONCALENTAMIENTODEAGUA_NOMBRE,
			LAVARROPAS_AUTOMATICO_5KG_CONCALENTAMIENTODEAGUA_CONSUMO,
			LAVARROPAS_CONSUMO_MENSUAL_MINIMO, 
			LAVARROPAS_CONSUMO_MENSUAL_MAXIMO,
			LAVARROPAS_AUTOMATICO_5KG_CONCALENTAMIENTODEAGUA_ESBAJOCONSUMO);
	
	public DispositivoInteligente LavarropaAuto = new DispositivoInteligente(
			LAVARROPAS_AUTOMATICO_5KG_NOMBRE,
			LAVARROPAS_AUTOMATICO_5KG_CONSUMO,
			encendido, LAVARROPAS_CONSUMO_MENSUAL_MINIMO, 
			LAVARROPAS_CONSUMO_MENSUAL_MAXIMO,
			LAVARROPAS_AUTOMATICO_5KG_ESBAJOCONSUMO);
	
	public DispositivoEstandar LavarropaSemiAuto = new DispositivoEstandar(
			LAVARROPAS_SEMIAUTOMATICO_5KG_NOMBRE,
			LAVARROPAS_SEMIAUTOMATICO_5KG_CONSUMO,
			LAVARROPAS_CONSUMO_MENSUAL_MINIMO, 
			LAVARROPAS_CONSUMO_MENSUAL_MAXIMO,
			LAVARROPAS_SEMIAUTOMATICO_5KG_ESBAJOCONSUMO);
	
	public DispositivoEstandar VentiladorDePie = new DispositivoEstandar(
			VENTILADOR_DEPIE_NOMBRE,
			VENTILADOR_DEPIE_CONSUMO,
			VENTILADOR_CONSUMO_MENSUAL_MINIMO, 
			VENTILADOR_CONSUMO_MENSUAL_MAXIMO,
			VENTILADOR_DEPIE_ESBAJOCONSUMO);
	
	public DispositivoInteligente VentiladoDeTecho = new DispositivoInteligente(
			VENTILADOR_DETECHO_NOMBRE,
			VENTILADOR_DETECHO_CONSUMO,
			encendido, VENTILADOR_CONSUMO_MENSUAL_MINIMO, 
			VENTILADOR_CONSUMO_MENSUAL_MAXIMO,
			VENTILADOR_DETECHO_ESBAJOCONSUMO);
	
	public DispositivoInteligente LamparaHalogena40 = new DispositivoInteligente(
			LAMPARA_HALOGENA_40W_NOMBRE,
			LAMPARA_HALOGENA_40W_CONSUMO,
			encendido,
			LAMPARA_CONSUMO_MENSUAL_MINIMO, 
			LAMPARA_CONSUMO_MENSUAL_MAXIMO,
			LAMPARA_HALOGENA_40W_ESBAJOCONSUMO);
	
	public DispositivoInteligente LamparaHalogena60 = new DispositivoInteligente(
			LAMPARA_HALOGENA_60W_NOMBRE,
			LAMPARA_HALOGENA_60W_CONSUMO,
			encendido,
			LAMPARA_CONSUMO_MENSUAL_MINIMO, 
			LAMPARA_CONSUMO_MENSUAL_MAXIMO,
			LAMPARA_HALOGENA_60W_ESBAJOCONSUMO);
	
	public DispositivoInteligente LamparaHalogena100 = new DispositivoInteligente(
			LAMPARA_HALOGENA_100W_NOMBRE,
			LAMPARA_HALOGENA_100W_CONSUMO,
			encendido,
			LAMPARA_CONSUMO_MENSUAL_MINIMO, 
			LAMPARA_CONSUMO_MENSUAL_MAXIMO,
			LAMPARA_HALOGENA_100W_ESBAJOCONSUMO);
	
	public DispositivoInteligente Lampara11W = new DispositivoInteligente(
			LAMPARA_11W_NOMBRE,
			LAMPARA_11W_CONSUMO,
			encendido,
			LAMPARA_CONSUMO_MENSUAL_MINIMO, 
			LAMPARA_CONSUMO_MENSUAL_MAXIMO,
			LAMPARA_11W_ESBAJOCONSUMO);
	
	public DispositivoInteligente Lampara15W = new DispositivoInteligente(
			LAMPARA_15W_NOMBRE,
			LAMPARA_15W_CONSUMO,
			encendido,
			LAMPARA_CONSUMO_MENSUAL_MINIMO, 
			LAMPARA_CONSUMO_MENSUAL_MAXIMO,
			LAMPARA_15W_ESBAJOCONSUMO);
		
	public DispositivoInteligente Lampara20W = new DispositivoInteligente(
			LAMPARA_20W_NOMBRE,
			LAMPARA_20W_CONSUMO,
			encendido,
			LAMPARA_CONSUMO_MENSUAL_MINIMO, 
			LAMPARA_CONSUMO_MENSUAL_MAXIMO,
			LAMPARA_20W_ESBAJOCONSUMO);
	
	
	public DispositivoInteligente PCDeEscritorio = new DispositivoInteligente(
			COMPUTADORA_DEESCRITORIO_NOMBRE,
			COMPUTADORA_DEESCRITORIO_CONSUMO,
			encendido,
			COMPUTADORA_CONSUMO_MENSUAL_MINIMO, 
			COMPUTADORA_CONSUMO_MENSUAL_MAXIMO,
			COMPUTADORA_DEESCRITORIO_ESBAJOCONSUMO);
	
	public DispositivoEstandar Microondas = new DispositivoEstandar(
			MICROONDAS_CONVENCIONAL_NOMBRE,
			MICROONDAS_CONVENCIONAL_CONSUMO,
			MICROONDAS_CONSUMO_MENSUAL_MINIMO, 
			MICROONDAS_CONSUMO_MENSUAL_MAXIMO,
			MICROONDAS_CONVENCIONAL_ESBAJOCONSUMO);
		


	public DispositivoEstandar Plancha = new DispositivoEstandar(
			PLANCHA_VAPOR_NOMBRE,
			PLANCHA_VAPOR_CONSUMO,
			PLANCHA_CONSUMO_MENSUAL_MINIMO, 
			PLANCHA_CONSUMO_MENSUAL_MAXIMO,
			MICROONDAS_CONVENCIONAL_ESBAJOCONSUMO);
		
	
}
