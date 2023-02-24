package modelo;

import controladores.JuegoController;
import javafx.scene.paint.Color;

public interface Estrategia {

	public void consecuencia(Jugador jugadorActual);
	
	public void continuarConsecuencia(Jugador jugadorActual);
	
	public void suscribir(JuegoController suscriptor);
		
	public Color getColor();

	public Estrategia getEstrategia();

}
