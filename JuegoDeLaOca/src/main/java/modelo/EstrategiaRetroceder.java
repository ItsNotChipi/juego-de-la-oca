package modelo;

import java.io.IOException;

import controladores.JuegoController;
import javafx.scene.paint.Color;

public class EstrategiaRetroceder implements Estrategia {
	
	private Juego juego;
	private JuegoController suscriptor;

	public EstrategiaRetroceder(Juego juego) {
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
			retrocederCasilleros(jugadorActual);
		}
		else {
			perderTurno(jugadorActual);
		}		
		suscriptor.setBitacora3(this, juego.getOpcion(), "");
		
	}
	
	private void retrocederCasilleros(Jugador jugadorActual) {
		jugadorActual.cambiarPosicion( - (jugadorActual.tirarDado()));
	}
	
	private void perderTurno(Jugador jugadorActual) {
		jugadorActual.cambiarEstado(new EstadoTurnoPerdido(jugadorActual));
	}

	@Override
	public void suscribir(JuegoController suscriptor) {
		this.suscriptor = suscriptor;
	}

	@Override
	public Color getColor() {
		return(Color.rgb(255,229,204));
	}

	@Override
	public Estrategia getEstrategia() {
		return this;
	}


}
