package modelo;

import java.io.IOException;

import controladores.JuegoController;
import javafx.scene.paint.Color;

public class EstrategiaSwap implements Estrategia {
	
	private Juego juego;
	private JuegoController suscriptor;

	public EstrategiaSwap(Juego juego) {
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
		int posicion1 = jugadorActual.getPosicion();
		Jugador jugador = juego.getJugadores().get(juego.getEleccion());
		
		jugadorActual.setPosicion(jugador.getPosicion());
		jugador.setPosicion(posicion1);
		
		suscriptor.setBitacora3(this, 0, juego.getJugadores().get(juego.getEleccion()).getNombreJugador());
	}

	@Override
	public void suscribir(JuegoController suscriptor) {
		this.suscriptor = suscriptor;
	}
	
	@Override
	public Color getColor() {
		return(Color.rgb(204,229,255));
	}

	@Override
	public Estrategia getEstrategia() {
		return this;
	}


}