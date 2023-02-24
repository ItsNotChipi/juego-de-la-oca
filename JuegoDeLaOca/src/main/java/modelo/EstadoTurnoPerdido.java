package modelo;

public class EstadoTurnoPerdido implements Estado{

	Jugador jugador;
	
	public EstadoTurnoPerdido(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public boolean jugar() {
		jugador.cambiarEstado(new EstadoJugando(jugador));
		return false;
	}

	public boolean esGanador() {
		return false;
	}

}
