package modelo;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Tablero {
	// Constantes
	static final int CANTIDAD_DE_CASILLAS = 64;
	static final int CANTIDAD_DE_CASILLAS_NORMALES = 34;
	static final int CANTIDAD_DE_CASILLAS_AVANZAR = 10;
	static final int CANTIDAD_DE_CASILLAS_RETROCEDER = 10;
	static final int CANTIDAD_DE_CASILLAS_SWAP = 5;
	static final int CANTIDAD_DE_CASILLAS_SUERTE = 5;
	
	private List<Casilla> tablero;
	
	public Tablero(Juego juego) {
		tablero = new ArrayList<Casilla>();
		inicializarTablero(juego);
	}
	
	public List<Casilla> getTablero(){
		return tablero;
	}

	public void inicializarTablero(Juego juego) {
		
		inicializarUnTipoDeCasilla(CANTIDAD_DE_CASILLAS_NORMALES, new EstrategiaNormal(juego));
		inicializarUnTipoDeCasilla(CANTIDAD_DE_CASILLAS_AVANZAR, new EstrategiaAvanzar(juego));
		inicializarUnTipoDeCasilla(CANTIDAD_DE_CASILLAS_RETROCEDER, new EstrategiaRetroceder(juego));
		inicializarUnTipoDeCasilla(CANTIDAD_DE_CASILLAS_SWAP, new EstrategiaSwap(juego));
		inicializarUnTipoDeCasilla(CANTIDAD_DE_CASILLAS_SUERTE, new EstrategiaSuerte(juego));
		
		Collections.shuffle(tablero);
		
		tablero.set(0, new Casilla(new EstrategiaNormal(juego)));
		tablero.set(63, new Casilla(new EstrategiaNormal(juego)));
		
	}
	
	private void inicializarUnTipoDeCasilla(int cantidadDeCasillas, Estrategia tipoDeEstrategia) {
		
		for (int i = 0; i < cantidadDeCasillas; i++) {
			tablero.add(new Casilla(tipoDeEstrategia));
		}
	}
	
	
	public void accionCasilla(int posicion, Jugador jugadorActual) {
		tablero.get(posicion).consecuencia(jugadorActual);
	}

}
