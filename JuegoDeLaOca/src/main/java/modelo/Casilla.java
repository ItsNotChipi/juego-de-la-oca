package modelo;

import controladores.JuegoController;

public class Casilla {
	Estrategia estrategia;
	
	public Casilla(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	public void consecuencia(Jugador jugadorActual) {
		estrategia.consecuencia(jugadorActual);
	}
	
	public void continuarConsecuencia(Jugador jugadorActual) {
		estrategia.continuarConsecuencia(jugadorActual);
	}
	
	public void suscribir(JuegoController suscriptor) {
		estrategia.suscribir(suscriptor);
	}
	
	public Estrategia getEstrategia() {
		return estrategia;
	}

}
