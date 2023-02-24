package modelo;

import java.io.IOException;

import controladores.JuegoController;
import javafx.scene.paint.Color;

public class EstrategiaSuerte implements Estrategia {
	
	private Juego juego;
	private JuegoController suscriptor;

	public EstrategiaSuerte(Juego juego) {
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

		jugadorActual.cambiarPosicion(jugadorActual.tirarDado());
		suscriptor.setBitacora3(this, 0, "");
		
	}

	@Override
	public void suscribir(JuegoController suscriptor) {
		this.suscriptor = suscriptor;
	}
	
	@Override
	public Color getColor() {
		return(Color.rgb(229,204,255));
	}

	@Override
	public Estrategia getEstrategia() {
		return this;
	}



}
