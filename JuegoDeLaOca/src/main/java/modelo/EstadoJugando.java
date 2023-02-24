package modelo;

public class EstadoJugando implements Estado{
	
	Jugador jugador;
	
	public EstadoJugando(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public boolean jugar() {
		
		jugador.cambiarPosicion(jugador.tirarDado());
		return true;
		
	}

	public boolean esGanador() {
		return false;
	}	
}
