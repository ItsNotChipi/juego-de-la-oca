package modelo;

public class Jugador {
	
	Estado estado;
	String nombre;
	int posicion;
	
	public Jugador(String nombre) {
		estado = new EstadoJugando(this);
		this.nombre = nombre;
		posicion = 0;
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	public String getNombreJugador() {
		return nombre;
	}
	
	public void setPosicion(int nuevaPosicion) {
		posicion = nuevaPosicion;
	}

	public boolean jugar() {
		return estado.jugar();
	}
	
	public boolean esGanador() {
		return estado.esGanador();
	}
	
	public int tirarDado() {
		return (int) (Math.random() * 6 + 1);
	}
	
	public void cambiarPosicion(int dados) {
		if ((posicion + dados) < 0) {
			posicion = 0;
		}
		
		else if ((posicion + dados) > 63){
			posicion = 63 - (posicion + dados - 63);
		}
		
		else {
			posicion += dados;			
		}
	}
	
	public void cambiarEstado(Estado nuevoEstado) {
		estado = nuevoEstado;
	}
	
}
