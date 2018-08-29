package TestProyecto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Funcionalidades.Categorizador;
import Usuarios.Categoria;

public class CategorizadorTest {

	@Test
	public void CategoriaSegunConsumoMensual() {
		Categoria esperado = Categorizador.getInstance().R3;
		assertEquals(esperado, Categorizador.getInstance().categoriaSegunConsumo(350));
	}

	// se decide probar consumos limites de una categoria puntual
	// se prueba consumo minimo para la categoria puntual.
	@Test
	public void CategoriaEvaludaConsumoMensualMinimo() {
		Categoria esperadoMinimo = Categorizador.getInstance().R2;
		assertEquals(esperadoMinimo, Categorizador.getInstance().categoriaSegunConsumo(151));
	}

	// se prueba consumo maximo permitido para la categoria puntual.
	@Test
	public void CategoriaEvaludaConsumoMensualMaximo() {
		Categoria esperadoMaximo = Categorizador.getInstance().R2;
		assertEquals(esperadoMaximo, Categorizador.getInstance().categoriaSegunConsumo(325));
	}
}
