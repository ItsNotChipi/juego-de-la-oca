package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTest {
	Jugador jugador = new Jugador("Carlitos");

	@Test
	public void avanzaTresPosiciones() {

		jugador.setPosicion(10);
		jugador.cambiarPosicion(3);
		
		assertEquals(jugador.posicion, 10 + 3);
	}
	
	@Test
	public void retrocedeTresPosiciones() {
		jugador.setPosicion(10);
		jugador.cambiarPosicion(-3);
		
		assertEquals(jugador.posicion, 10 - 3);
	}
	
	@Test
	public void noRetrocedeMasDeLaPosicionCero() {
		jugador.setPosicion(3);
		jugador.cambiarPosicion(-6);
		
		assertEquals(jugador.getPosicion(),0);
	}
	
	@Test
	public void retrocedeACero() {
		jugador.setPosicion(3);
		jugador.cambiarPosicion(-3);
		
		assertEquals(jugador.getPosicion(), 0);
	}
	
	@Test
	public void rebotaCorrectamente() {
		jugador.setPosicion(60);
		jugador.cambiarPosicion(5);
		
		assertEquals(jugador.getPosicion(), 61);
	}
	
	@Test
	public void llegaAlFinalDelTablero() {
		jugador.setPosicion(60);
		jugador.cambiarPosicion(3);
		
		assertEquals(jugador.getPosicion(), 63);
	}
	
	@Test
	public void resultadoDeTirarDadosEntreUnoYSeis() {
		int tirada = jugador.tirarDado();
		
		if ((tirada < 1) || (tirada > 6)) {
			fail("El numero aleatorio se encuentra fuera del rango.");
		}
	}
	
}