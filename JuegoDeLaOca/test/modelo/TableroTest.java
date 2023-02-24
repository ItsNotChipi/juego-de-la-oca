package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {
	
	Juego juego = new Juego();
	
	@Test
	public void seInicializoElTableroCon64Casillas() {
		Tablero tablero = new Tablero(juego);
		
		assertEquals(tablero.getTablero().size(), 64);
	}

}