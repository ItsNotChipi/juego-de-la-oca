package modelo;

public class EstadoGano implements Estado{
	
	Jugador jugador;
	
	public EstadoGano(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public boolean jugar() {
		return false;
	}

	public boolean esGanador() {
		return true;
	}
	

}
