package modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	
	private List<Jugador> jugadores;
	private Tablero tablero;
	private	int opcion;
	private int eleccion;
	
	public Juego() {
		jugadores = new ArrayList<Jugador>();
		tablero = new Tablero(this);
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	
	public Tablero getTablero() {
		return tablero;
	}

	public int getEleccion() {
		return eleccion;
	}

	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
}













