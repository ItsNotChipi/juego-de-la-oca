package vistas;

import vistas.Posicion;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modelo.Jugador;

public class JugadorVista {
	
	Posicion posicionActual;
	Posicion posicionRelativa;
	
	Pane canvas;
	Label nombre;
	Color color;
	
	Circle icono;
	Circle circulo;
	
    
	public JugadorVista(Posicion posicion, Posicion posicionRelativa, Posicion posicionIcono, Pane canvas, Color color) {

        this.color = color;
        this.canvas = canvas;
        this.posicionRelativa = posicionRelativa;
        this.posicionActual = posicion;
        actualizarPosicion(posicion);
        
        icono = new Circle(8);
        icono.setCenterX(posicionIcono.getX());
        icono.setCenterY(posicionIcono.getY());
        icono.setStroke(Color.BLACK);
        icono.setFill(color);
        canvas.getChildren().add(icono);
        
        circulo = new Circle(5);
        circulo.setCenterX(posicion.getX());
        circulo.setCenterY(posicion.getY());
        circulo.setStroke(Color.BLACK);
        circulo.setFill(color);
        canvas.getChildren().add(circulo);
        
    }

    public void actualizarPosicion(Posicion posicionCasilla) {
    	
    	int nuevaCoordenadaX = posicionCasilla.getX() + posicionRelativa.getX();
    	int nuevaCoordenadaY = posicionCasilla.getY() + posicionRelativa.getY(); 
    	
    	posicionActual.setX(nuevaCoordenadaX);
    	posicionActual.setY(nuevaCoordenadaY);
    	
    }
    
    public void dibujar() {
    	
    	circulo.setCenterX(posicionActual.getX());
    	circulo.setCenterY(posicionActual.getY());
    	
    }
    
    public static Posicion obtenerPosicionRelativa(int indiceJugador) {
    	
    	List<Posicion> listaPosicionesRelativas = new ArrayList<Posicion>();
    	
    	listaPosicionesRelativas.add(new Posicion(8, 6));
    	listaPosicionesRelativas.add(new Posicion(24, 6));
    	listaPosicionesRelativas.add(new Posicion(8, 10));
    	listaPosicionesRelativas.add(new Posicion(24, 10));
    	listaPosicionesRelativas.add(new Posicion(8, 14));
    	listaPosicionesRelativas.add(new Posicion(24, 14));
    	listaPosicionesRelativas.add(new Posicion(8, 18));
    	listaPosicionesRelativas.add(new Posicion(24, 18));
    	
    	return listaPosicionesRelativas.get(indiceJugador);
    }
    
    public static Posicion obtenerPosicionIcono(int indiceJugador) {
    	
    	List<Posicion> listaPosicionesIcono = new ArrayList<Posicion>();
    	
    	listaPosicionesIcono.add(new Posicion(55, 114));
    	listaPosicionesIcono.add(new Posicion(55, 154));
    	listaPosicionesIcono.add(new Posicion(55, 194));
    	listaPosicionesIcono.add(new Posicion(55, 234));
    	listaPosicionesIcono.add(new Posicion(55, 274));
    	listaPosicionesIcono.add(new Posicion(55, 314));
    	listaPosicionesIcono.add(new Posicion(55, 354));
    	listaPosicionesIcono.add(new Posicion(55, 394));
    	
    	return listaPosicionesIcono.get(indiceJugador);
    }

}
