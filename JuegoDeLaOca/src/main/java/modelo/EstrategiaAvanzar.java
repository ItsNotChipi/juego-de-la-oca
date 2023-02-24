package modelo;

import java.io.IOException;

import controladores.JuegoController;
import javafx.scene.paint.Color;

public class EstrategiaAvanzar implements Estrategia {
	
	private Juego juego;
	private JuegoController suscriptor;

	public EstrategiaAvanzar(Juego juego) {
		this.juego = juego;
	}

	public void consecuencia(Jugador jugadorActual) {

		try {
			suscriptor.update(this, jugadorActual);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void continuarConsecuencia(Jugador jugadorActual) {
		
		if(juego.getOpcion() == 1) {
			avanzar3Casilleros(jugadorActual);
		}
		else {
			retrocederJugador();
		}
		suscriptor.setBitacora3(this, juego.getOpcion(), juego.getJugadores().get(juego.getEleccion()).getNombreJugador());		
	}

	private void avanzar3Casilleros(Jugador jugadorActual) {
		jugadorActual.cambiarPosicion(3);
	}
	
	private void retrocederJugador() {
		juego.getJugadores().get(juego.getEleccion()).cambiarPosicion(-3);
	}

	@Override
	public void suscribir(JuegoController suscriptor) {
		this.suscriptor = suscriptor;
	}
	
	@Override
	public Color getColor() {
		return(Color.rgb(204,255,255));
	}

	@Override
	public Estrategia getEstrategia() {
		return this;
	}


}
