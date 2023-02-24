package modelo;

import java.io.IOException;

import controladores.JuegoController;
import javafx.scene.paint.Color;

public class EstrategiaNormal implements Estrategia {
	
	private Juego juego;
	private JuegoController suscriptor;

	public EstrategiaNormal(Juego juego) {
		this.juego = juego;
	}

	public void consecuencia(Jugador jugadorActual) {
		
		if(jugadorActual.getPosicion() == 63) {
			jugadorActual.cambiarEstado(new EstadoGano(jugadorActual));
		}
		
		try {
			suscriptor.update(this, jugadorActual);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void suscribir(JuegoController suscriptor) {
		this.suscriptor = suscriptor;
	}

	@Override
	public void continuarConsecuencia(Jugador jugadorActual) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Color getColor() {
		return(Color.rgb(255,255,204));
	}

	@Override
	public Estrategia getEstrategia() {
		return this;
	}
	
	

}
