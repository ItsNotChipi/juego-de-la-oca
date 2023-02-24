package controladores;

import vistas.Posicion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import modelo.Casilla;
import modelo.EstadoGano;
import modelo.Estrategia;
import modelo.EstrategiaAvanzar;
import modelo.EstrategiaNormal;
import modelo.EstrategiaRetroceder;
import modelo.EstrategiaSuerte;
import modelo.EstrategiaSwap;
import modelo.Juego;
import modelo.Jugador;
import vistas.JugadorVista;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class JuegoController {
	
	private Juego juego;
	private List<JugadorVista> listaDeJugadoresVista;
	private List<ImageView> listaDeImageViewPatosTurnos;
    private List<Label> listaDeLabelDeJugadores;
    private List<Shape> listaDeCasillas;
    private List<Color> listaDeColores;
    
    @FXML
    private Label numeroDado;
    private int posicionInicial;
    
    private int i;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
	
	@FXML
	private Label Jugador1;
	@FXML
	private Label Jugador2;
	@FXML
	private Label Jugador3;
	@FXML
	private Label Jugador4;
	@FXML
	private Label Jugador5;
	@FXML
	private Label Jugador6;
	@FXML
	private Label Jugador7;
	@FXML
	private Label Jugador8;
	
	@FXML
    private ImageView pato1;
    @FXML
    private ImageView pato2;
    @FXML
    private ImageView pato3;
    @FXML
    private ImageView pato4;
    @FXML
    private ImageView pato5;
    @FXML
    private ImageView pato6;
    @FXML
    private ImageView pato7;
    @FXML
    private ImageView pato8;

    @FXML
    private Rectangle casilla0;
    @FXML
    private Rectangle casilla1;
    @FXML
    private Rectangle casilla2;
    @FXML
    private Rectangle casilla3;
    @FXML
    private Rectangle casilla4;
    @FXML
    private Rectangle casilla5;
    @FXML
    private Rectangle casilla6;
    @FXML
    private Rectangle casilla7;
    @FXML
    private Rectangle casilla8;
    @FXML
    private Rectangle casilla9;
    @FXML
    private Rectangle casilla10;
    @FXML
    private Arc casilla11;
    @FXML
    private Rectangle casilla12;
    @FXML
    private Rectangle casilla13;
    @FXML
    private Rectangle casilla14;
    @FXML
    private Rectangle casilla15;
    @FXML
    private Rectangle casilla16;
    @FXML
    private Rectangle casilla17;
    @FXML
    private Rectangle casilla18;
    @FXML
    private Rectangle casilla19;
    @FXML
    private Rectangle casilla20;
    @FXML
    private Rectangle casilla21;
    @FXML
    private Arc casilla22;
    @FXML
    private Rectangle casilla23;
    @FXML
    private Rectangle casilla24;
    @FXML
    private Rectangle casilla25;
    @FXML
    private Rectangle casilla26;
    @FXML
    private Rectangle casilla27;
    @FXML
    private Rectangle casilla28;
    @FXML
    private Rectangle casilla29;
    @FXML
    private Rectangle casilla30;
    @FXML
    private Rectangle casilla31;
    @FXML
    private Rectangle casilla32;
    @FXML
    private Arc casilla33;
    @FXML
    private Rectangle casilla34;
    @FXML
    private Rectangle casilla35;
    @FXML
    private Rectangle casilla36;
    @FXML
    private Rectangle casilla37;
    @FXML
    private Rectangle casilla38;
    @FXML
    private Rectangle casilla39;
    @FXML
    private Rectangle casilla40;
    @FXML
    private Arc casilla41;
    @FXML
    private Rectangle casilla42;
    @FXML
    private Rectangle casilla43;
    @FXML
    private Rectangle casilla44;
    @FXML
    private Rectangle casilla45;
    @FXML
    private Rectangle casilla46;
    @FXML
    private Rectangle casilla47;
    @FXML
    private Rectangle casilla48;
    @FXML
    private Arc casilla49;
    @FXML
    private Rectangle casilla50;
    @FXML
    private Rectangle casilla51;
    @FXML
    private Rectangle casilla52;
    @FXML
    private Rectangle casilla53;
    @FXML
    private Arc casilla54;
    @FXML
    private Rectangle casilla55;
    @FXML
    private Rectangle casilla56;
    @FXML
    private Rectangle casilla57;
    @FXML
    private Rectangle casilla58;
    @FXML
    private Arc casilla59;
    @FXML
    private Rectangle casilla60;
    @FXML
    private Arc casilla61;
    @FXML
    private Rectangle casilla62;
    @FXML
    private Rectangle casilla63;
    
    @FXML
    private Circle JugadorAmarillo;
    @FXML
    private Circle JugadorCeleste;
    @FXML
    private Circle JugadorRojo;
    @FXML
    private Circle JugadorRosa;
    @FXML
    private Circle JugadorVerde;
    @FXML
    private Circle JugadorVioleta;
    @FXML
    private Circle JugadorVerdeAgua;
    @FXML
    private Circle JugadorNaranja;
    
    private int dado;
    
    @FXML
    private ListView<String> bitacoraListView;
    
    @FXML
    private Label JugadorActual;

    @FXML
    private Button Comencemos;
        
    @FXML
    private Button enterButton;
    
    @FXML
    private AnchorPane juegoScene;
    
    @FXML
    private Button arrojarDadosButton;
    
    @FXML
    private Label casillaLabel;
    
    @FXML
    private TextArea consignaTextArea;
    
    @FXML
    private ChoiceBox<String> opcionChoiceBox;
    
    @FXML
    private ChoiceBox<String> eleccionChoiceBox;
    
    @FXML
    private Button salirButton;
    
    @FXML
    private Button okButton;
    
    private String[] vecOpciones = {"1", "2"};
    
    private List<String> listaNombreJugadores;
    
    private Jugador jugadorActual;
    
    private Estrategia estrategiaActual;
    
    private int numeroTurno;
    
    private String nombreJugadorElegido;
    
    @FXML
    private TextArea bitacoraTexto;
    
    private int posicionAntesDeSuerte;
	
	private void suscribirseCasillas() {
		for (Casilla casilla : juego.getTablero().getTablero()) {
			casilla.suscribir(this);
		}
	}
	
	private void juegoFinalizado() {
		casillaLabel.setVisible(true);
		casillaLabel.setText("HA GANADO " + jugadorActual.getNombreJugador());
		arrojarDadosButton.setDisable(true);
		salirButton.setVisible(true);
		actualizarBitacora2("Final");
	}
	
	public void update(EstrategiaNormal estrategia, Jugador jugadorActual) throws IOException {
		this.estrategiaActual = estrategia;
		this.jugadorActual = jugadorActual;
		
		casillaLabel.setText("Has caído en una casilla NORMAL!");
		actualizarBitacora2("Normal");
		
		if (jugadorActual.esGanador() || jugadorActual.getPosicion() == 63) {
			juegoFinalizado();
		}
		
		cambiarPatitos();
		
		
		bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Esta es la casilla mas aburrida, no tendras ninguna consecuencia" + "\n" + "El proximo jugador es : " + juego.getJugadores().get(i).getNombreJugador());
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
	}
	
	public void update(EstrategiaAvanzar estrategia, Jugador jugadorActual) throws IOException {
		this.estrategiaActual = estrategia;
		this.jugadorActual = jugadorActual;
		arrojarDadosButton.setDisable(true);
		actualizarBitacora2("Avanzar");
		elegirOpcionAvanzar();
	}

	public void update(EstrategiaRetroceder estrategia, Jugador jugadorActual) throws IOException {
		this.estrategiaActual = estrategia;
		this.jugadorActual = jugadorActual;
		arrojarDadosButton.setDisable(true);
		actualizarBitacora2("Retroceder");
		posicionInicial = jugadorActual.getPosicion();
		elegirOpcionRetroceder();
    	eleccionChoiceBox.setVisible(false);
	}
	
	public void update(EstrategiaSuerte estrategia, Jugador jugadorActual) throws IOException {
		this.estrategiaActual = estrategia;
		this.jugadorActual = jugadorActual;
		mostrarEscenaSuerte();
		actualizarBitacora2("Suerte");
		posicionInicial = jugadorActual.getPosicion();
	}
	
	public void update(EstrategiaSwap estrategia, Jugador jugadorActual) throws IOException {
		this.estrategiaActual = estrategia;
		this.jugadorActual = jugadorActual;
		arrojarDadosButton.setDisable(true);
		actualizarBitacora2("Swap");
		elegirEleccionSwap();
	}
	
	private void cambiarPatitos() {
		
		listaDeImageViewPatosTurnos.get(i).setVisible(false);
		
		i++;
		
		if (i == juego.getJugadores().size()) {
			i = 0;
		}
		
		listaDeImageViewPatosTurnos.get(i).setVisible(true);
		JugadorActual.setText(juego.getJugadores().get(i).getNombreJugador());
	}
	
	void actualizarBitacora1() {
		
		numeroTurno++;
		
		bitacoraTexto.setText(bitacoraTexto.getText() + "\n\n" + "Es el turno n° " + numeroTurno + " de : " + jugadorActual.getNombreJugador() + "\nSe encuentra en la casilla " + jugadorActual.getPosicion());
		
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
}

	private void actualizarBitacora2(String tipoDeCasilla) {
		
		if(tipoDeCasilla.equals("Perdio el turno")) {
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + tipoDeCasilla);
		}
		else if(tipoDeCasilla.equals("final")) {
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "HA GANADO !!!!!!!!!! ");
		}
		else {
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Arroja el dado y salio el " + (calcularDados()) + "\nAvanza hasta la casilla " + jugadorActual.getPosicion() + " de tipo " + tipoDeCasilla);
		}
		
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
	}
	
	public void setBitacora3(EstrategiaAvanzar avanza , int opcionElegida, String jugadorSeleccionado) {
		
		
		if(opcionElegida == 2) {		
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Has elegido la opcion 2, el jugador " + jugadorSeleccionado + " retrocedera 3 espacios");
		}
		else {
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Has elegido la opcion 1, avanzaras 3 casilleros" + "\nTu posicion actual es " + jugadorActual.getPosicion());
		}
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
		
	}
	
	public void setBitacora3(EstrategiaRetroceder retrocede, int opcionElegida, String jugadorSeleccionado) {
		
		if(opcionElegida == 1) {	
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Has elegido la opcion 1, tiraste el dado y retrocederas " + (posicionInicial - jugadorActual.getPosicion()) + " casilleros \nTu posicion actual es " + jugadorActual.getPosicion() );
			numeroDado.setText(String.valueOf((posicionInicial - jugadorActual.getPosicion())));
		}
		else {			
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Has elegido la opcion 2, perderas el proximo turno");
		}	
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
		
	}
	
	public void setBitacora3(EstrategiaSwap swap , int opcionElegida, String jugadorSeleccionado) {
		
		bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Intercambiaras posiciones con " + jugadorSeleccionado + "\nTu nueva posicion es " + jugadorActual.getPosicion());
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
	}
	
	public void setBitacora3(EstrategiaSuerte suerte , int opcionElegida, String jugadorSeleccionado) {
		bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Vuelves a arrojar el dado y el resultado fue " + calcularDados() + "\nTu nueva posicion es  " + jugadorActual.getPosicion());
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
	}
	
	public int calcularDados() {
		if((jugadorActual.getPosicion() - posicionInicial) <= 0) {
			return((63 - posicionInicial) + (63 - jugadorActual.getPosicion()));
		}
		else {
			return (jugadorActual.getPosicion() - posicionInicial);
		}
	}
	
	@FXML
    void procesarOk(MouseEvent event) {
		
		if(estrategiaActual.getColor().equals(Color.rgb(255,229,204))  ) {
			eleccionChoiceBox.setVisible(false);
		}
		
		if((opcionChoiceBox.isVisible() && opcionChoiceBox.getSelectionModel().isEmpty()) || (eleccionChoiceBox.isVisible() && eleccionChoiceBox.getSelectionModel().isEmpty())) {
		}
		else {
			
			if (!(opcionChoiceBox.isVisible()) && !(eleccionChoiceBox.isVisible())) {
				
				// Caso de casilla suerte, quiero que no entre en los otros casos
				
			} else if (!(opcionChoiceBox.isVisible())) {
				
				juego.setOpcion(2);
				
				String nombreJugadorElegido = eleccionChoiceBox.getValue();
				int k = 0;
	    		
	    		while (!juego.getJugadores().get(k).getNombreJugador().equals(nombreJugadorElegido)) {
					k++;
				}

	    		juego.setEleccion(k);
	    		
			} else if (opcionChoiceBox.getValue().equals("1")) {
				
				juego.setOpcion(1);
				
			} else if (opcionChoiceBox.getValue().equals("2")) {
				
				juego.setOpcion(2);
				String nombreJugadorElegido = eleccionChoiceBox.getValue();
				if (nombreJugadorElegido != null) {				
					int k = 0;
					
					while (!juego.getJugadores().get(k).getNombreJugador().equals(nombreJugadorElegido)) {
						k++;
					}
					
					juego.setEleccion(k);
				}
				
			}	
			
			casillaLabel.setVisible(false);
			consignaTextArea.setVisible(false);
			opcionChoiceBox.setVisible(false);
			eleccionChoiceBox.setValue(null);
			eleccionChoiceBox.setVisible(false);
			okButton.setVisible(false);
			arrojarDadosButton.setDisable(false);
			
			estrategiaActual.continuarConsecuencia(jugadorActual);
			juego.setOpcion(0);
			juego.setEleccion(0);
			actualizarPosicionListaJugadorVista();
			
			if (!eleccionChoiceBox.getItems().contains(jugadorActual.getNombreJugador())) {
				eleccionChoiceBox.getItems().add(jugadorActual.getNombreJugador());
			}
			
			if (jugadorActual.getPosicion() == 63) {
				juegoFinalizado();
			}
			
			cambiarPatitos();
			
			bitacoraTexto.setText(bitacoraTexto.getText() + "\n\n" + "El proximo jugador es : " + juego.getJugadores().get(i).getNombreJugador());
			bitacoraTexto.setScrollTop(Double.MAX_VALUE);
			bitacoraTexto.appendText("");
			
			opcionChoiceBox.getSelectionModel().clearSelection();
		}
		
    }
	
	@FXML
    void procesarSalir(MouseEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
	
	private void elegirOpcionAvanzar() throws IOException {
		
		casillaLabel.setText("Has caído en una casilla AVANZAR!");
		consignaTextArea.setText("Tenes 2 opciones:\n1- Avanzar 3 casilleros.\n2 - Elegir otro jugador para que los retroceda.\n\nSeleccioná debajo tu opcion:");
		
    	consignaTextArea.setVisible(true);
    	opcionChoiceBox.setVisible(true);
    	okButton.setVisible(true);
    	
    	eleccionChoiceBox.getItems().remove(jugadorActual.getNombreJugador());
    	
    	opcionChoiceBox.getSelectionModel().selectedItemProperty().addListener(
    			(ObservableValue<? extends String> ov, String oldVal, String newVal) -> {
    				if(newVal == null) {	
    				}
    				else if (newVal.equals("1")) {
    					eleccionChoiceBox.setVisible(false);
    				}
    				if(newVal == null) {	
    				}
    				else if (newVal.equals("2")) {
    					eleccionChoiceBox.setVisible(true);	
    				}
    			}
    	);
    	if(juego.getJugadores().size() <= 2) {
    		if(juego.getJugadores().get(0) == jugadorActual) {
    			eleccionChoiceBox.setValue(juego.getJugadores().get(1).getNombreJugador());
    		}
    		else {
    			eleccionChoiceBox.setValue(juego.getJugadores().get(0).getNombreJugador());
    		}
    	}
	}

    private void elegirOpcionRetroceder() throws IOException {
    	
    	casillaLabel.setText("Has caído en una casilla RETROCEDER!");
		consignaTextArea.setText("Tenes 2 opciones:\n1- Tirar los dados nuevamente y retroceder esa cantidad.\n2 - Perder el siguiente turno.\n\nSeleccioná debajo tu opcion:");
		
		consignaTextArea.setVisible(true);
    	opcionChoiceBox.setVisible(true);
    	okButton.setVisible(true);
    }
    
    private void elegirEleccionSwap() throws IOException {
    	
    	casillaLabel.setText("Has caído en una casilla SWAP!");
		consignaTextArea.setText("Tenes que elegir un jugador con quien quieras cambiar posiciones.");
		
		eleccionChoiceBox.getItems().remove(jugadorActual.getNombreJugador());
		
    	consignaTextArea.setVisible(true);
    	eleccionChoiceBox.setVisible(true);
    	okButton.setVisible(true);
    	
    	opcionChoiceBox.getSelectionModel().selectedItemProperty().addListener(
    			(ObservableValue<? extends String> ov, String oldVal, String newVal) -> {
    				if(newVal == null) {	
    				}
    				else if (newVal.equals("1")) {
    					eleccionChoiceBox.setVisible(false);
    				}
    				if(newVal == null) {	
    				}
    				else if (newVal.equals("2")) {
    					eleccionChoiceBox.setVisible(true);	
    				}
    			}
    	);
    	
    	if(juego.getJugadores().size() <= 2) {
    		if(juego.getJugadores().get(0) == jugadorActual) {
    			eleccionChoiceBox.setValue(juego.getJugadores().get(1).getNombreJugador());
    		}
    		else {
    			eleccionChoiceBox.setValue(juego.getJugadores().get(0).getNombreJugador());
    		}
    	} 
    }
    
    private void mostrarEscenaSuerte() throws IOException {
    	
    	casillaLabel.setText("Has caído en una casilla SUERTE!");
		consignaTextArea.setText("Por arte de magia podes volver a tirar los dados!");
    	
		arrojarDadosButton.setDisable(true);
		consignaTextArea.setVisible(true);
		okButton.setVisible(true);
    }
    
    private void mostrarEscenaPerderTurno() throws IOException {
    	
    	casillaLabel.setText("El jugador " + jugadorActual.getNombreJugador() + " ha perdido el turno.");
    	
    	bitacoraTexto.setText(bitacoraTexto.getText() + "\n" + "Perdio el turno");
		bitacoraTexto.setScrollTop(Double.MAX_VALUE);
		bitacoraTexto.appendText("");
    }
    
    public JuegoController() {	
    	i = 0;
    	posicionInicial = 0;
    	numeroTurno = 0;
    	nombreJugadorElegido = "-";
    	posicionAntesDeSuerte = 0;
    }

	public void setJuego(Juego juego) {
		this.juego = new Juego();
		this.juego = juego;
	}
	
	public void setListaDeColores(List<Color> lista) {
	    listaDeColores = new ArrayList<>();
	    listaDeColores = lista;
	}
	
	public void setListaJugadoresVista() {
		
		listaDeJugadoresVista = new ArrayList<JugadorVista>();
		Posicion posicionInicial = posicionACoordenadas(0); // me da las coordenadas de la casilla 0
		
		for (int i = 0; i < juego.getJugadores().size(); i++) {
			listaDeJugadoresVista.add(new JugadorVista(posicionInicial, JugadorVista.obtenerPosicionRelativa(i), JugadorVista.obtenerPosicionIcono(i), juegoScene, listaDeColores.get(i)));
		}
		
	}
	
	public void setColoresCasillas() {

		for (int j = 0; j < 64; j++) {
			listaDeCasillas.get(j).setFill(juego.getTablero().getTablero().get(j).getEstrategia().getColor());
		}
	}
	
	public void setJuegoController() {

		suscribirseCasillas();
		setlistaDeLabelDeJugadores();
    	setListaDeImageViewPatosTurnos();
    	setListaDeCasillas();
    	listaDeImageViewPatosTurnos.get(0).setVisible(true);
    	listaNombreJugadores = new ArrayList<>();
    	setListaJugadoresVista();
    	opcionChoiceBox.getItems().addAll(vecOpciones);
    	consignaTextArea.setEditable(false);
    	setColoresCasillas();
    	
    	for (int j = 0; j < juego.getJugadores().size(); j++) {
				listaNombreJugadores.add(juego.getJugadores().get(j).getNombreJugador());
    	}
    	
    	eleccionChoiceBox.getItems().addAll(listaNombreJugadores);
    	JugadorActual.setText(juego.getJugadores().get(0).getNombreJugador());
	}
	
	private Posicion posicionACoordenadas(int posicion) {
		Posicion coordenadas = new Posicion((int)listaDeCasillas.get(posicion).getLayoutX(), (int)listaDeCasillas.get(posicion).getLayoutY());
		return coordenadas;
	}

	public void inicializarNombresJugadores() {
		for (int i = 0; i < juego.getJugadores().size(); i++) {
			listaDeLabelDeJugadores.get(i).setText(juego.getJugadores().get(i).getNombreJugador());
		}
		
		for (int i = juego.getJugadores().size(); i < 8; i++ ) {
			listaDeLabelDeJugadores.get(i).setText("");
		}
	}
	
	public void inicializacionTurnosImagenPato() {
		for(int i = 0; i < 8; i++) {
			listaDeImageViewPatosTurnos.get(i).setVisible(false);
		}
	}
	
	private void actualizarPosicionListaJugadorVista() {
		for (int j = 0; j < listaDeJugadoresVista.size(); j++) {
			listaDeJugadoresVista.get(j).actualizarPosicion(posicionACoordenadas(juego.getJugadores().get(j).getPosicion()));
			listaDeJugadoresVista.get(j).dibujar();
		}
	}
		
	@FXML
    void arrojarDados(MouseEvent event) throws IOException {
		
		casillaLabel.setVisible(true);
		consignaTextArea.setVisible(false);
		
		jugadorActual = juego.getJugadores().get(i);
		posicionInicial = jugadorActual.getPosicion();
		
		actualizarBitacora1();
		
		// Juega en modelo
		if (jugadorActual.jugar()) {
			
			cambiarLabelNumeroDado();
			
			// Actualiza visual
			listaDeJugadoresVista.get(i).actualizarPosicion(posicionACoordenadas(jugadorActual.getPosicion()));
			listaDeJugadoresVista.get(i).dibujar();
						
			// Consecuencia en modelo
			juego.getTablero().accionCasilla(jugadorActual.getPosicion(), jugadorActual);

		}
		else {
			mostrarEscenaPerderTurno();
			cambiarPatitos();
		}
		
    }
	
	public void cambiarLabelNumeroDado() {
		numeroDado.setText(String.valueOf(calcularDados()));
	}
	
	public void setListaDeImageViewPatosTurnos () {
		
		listaDeImageViewPatosTurnos = new ArrayList<ImageView>();
		
		listaDeImageViewPatosTurnos.add(pato1);
		listaDeImageViewPatosTurnos.add(pato2);
		listaDeImageViewPatosTurnos.add(pato3);
		listaDeImageViewPatosTurnos.add(pato4);
		listaDeImageViewPatosTurnos.add(pato5);
		listaDeImageViewPatosTurnos.add(pato6);
		listaDeImageViewPatosTurnos.add(pato7);
		listaDeImageViewPatosTurnos.add(pato8);
		
		inicializacionTurnosImagenPato();
		
	}
	
	public void setlistaDeLabelDeJugadores () {
		
		listaDeLabelDeJugadores = new ArrayList<Label>();
		
		listaDeLabelDeJugadores.add(Jugador1);
		listaDeLabelDeJugadores.add(Jugador2);
		listaDeLabelDeJugadores.add(Jugador3);
		listaDeLabelDeJugadores.add(Jugador4);
		listaDeLabelDeJugadores.add(Jugador5);
		listaDeLabelDeJugadores.add(Jugador6);
		listaDeLabelDeJugadores.add(Jugador7);
		listaDeLabelDeJugadores.add(Jugador8);

		inicializarNombresJugadores();
	}
	
	public void setListaDeCasillas() {
		
		listaDeCasillas = new ArrayList<Shape>();
		
		listaDeCasillas.add(casilla0);
		listaDeCasillas.add(casilla1);
		listaDeCasillas.add(casilla2);
		listaDeCasillas.add(casilla3);
		listaDeCasillas.add(casilla4);
		listaDeCasillas.add(casilla5);
		listaDeCasillas.add(casilla6);
		listaDeCasillas.add(casilla7);
		listaDeCasillas.add(casilla8);
		listaDeCasillas.add(casilla9);
		
		listaDeCasillas.add(casilla10);
		listaDeCasillas.add(casilla11);
		listaDeCasillas.add(casilla12);
		listaDeCasillas.add(casilla13);
		listaDeCasillas.add(casilla14);
		listaDeCasillas.add(casilla15);
		listaDeCasillas.add(casilla16);
		listaDeCasillas.add(casilla17);
		listaDeCasillas.add(casilla18);
		listaDeCasillas.add(casilla19);
		
		listaDeCasillas.add(casilla20);
		listaDeCasillas.add(casilla21);
		listaDeCasillas.add(casilla22);
		listaDeCasillas.add(casilla23);
		listaDeCasillas.add(casilla24);
		listaDeCasillas.add(casilla25);
		listaDeCasillas.add(casilla26);
		listaDeCasillas.add(casilla27);
		listaDeCasillas.add(casilla28);
		listaDeCasillas.add(casilla29);
		
		listaDeCasillas.add(casilla30);
		listaDeCasillas.add(casilla31);
		listaDeCasillas.add(casilla32);
		listaDeCasillas.add(casilla33);
		listaDeCasillas.add(casilla34);
		listaDeCasillas.add(casilla35);
		listaDeCasillas.add(casilla36);
		listaDeCasillas.add(casilla37);
		listaDeCasillas.add(casilla38);
		listaDeCasillas.add(casilla39);
		
		listaDeCasillas.add(casilla40);
		listaDeCasillas.add(casilla41);
		listaDeCasillas.add(casilla42);
		listaDeCasillas.add(casilla43);
		listaDeCasillas.add(casilla44);
		listaDeCasillas.add(casilla45);
		listaDeCasillas.add(casilla46);
		listaDeCasillas.add(casilla47);
		listaDeCasillas.add(casilla48);
		listaDeCasillas.add(casilla49);
		
		listaDeCasillas.add(casilla50);
		listaDeCasillas.add(casilla51);
		listaDeCasillas.add(casilla52);
		listaDeCasillas.add(casilla53);
		listaDeCasillas.add(casilla54);
		listaDeCasillas.add(casilla55);
		listaDeCasillas.add(casilla56);
		listaDeCasillas.add(casilla57);
		listaDeCasillas.add(casilla58);
		listaDeCasillas.add(casilla59);
		
		listaDeCasillas.add(casilla60);
		listaDeCasillas.add(casilla61);
		listaDeCasillas.add(casilla62);
		listaDeCasillas.add(casilla63);
	}
}