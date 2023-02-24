package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import modelo.Juego;

public class ElegirPersonajeController {
	
	private List<Color> listaDeColoresDeJugadores;
	int i;
	
	private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Juego juego;
	
	@FXML
	private Label nombreDeJugador;
	
	@FXML
    private Button seleccionButton;
	
	@FXML
    private Button jugarButton;

	@FXML
    private Button Amarillo;
    @FXML
    private Button Celeste;
    @FXML
    private Button Naranja;
    @FXML
    private Button Rojo;
    @FXML
    private Button Rosa;
    @FXML
    private Button Verde;
    @FXML
    private Button VerdeAgua;
    @FXML
    private Button Violeta;

    @FXML
    private Circle JugadorAmarillo;
    @FXML
    private Circle JugadorCeleste;
    @FXML
    private Circle JugadorNaranja;
    @FXML
    private Circle JugadorRojo;
    @FXML
    private Circle JugadorRosa;
    @FXML
    private Circle JugadorVerde;
    @FXML
    private Circle JugadorVerdeAgua;
    @FXML
    private Circle JugadorVioleta;
	
	public void setJuego(Juego juego) {
		this.juego = new Juego();
		this.juego = juego;
		listaDeColoresDeJugadores = new ArrayList<Color>();
	}
	
	public void mostrarNombreDeJugador(MouseEvent event) {
		i = 0;
		siguienteJugador();
		habilitarOpciones();
		seleccionButton.setDisable(true);
	}

    @FXML
    void seleccionarRosa(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("0xD31FB8"));
    	Rosa.setDisable(true);
    	siguienteJugador();
    }

    @FXML
    void seleccionarRojo(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("0xF80000"));
    	Rojo.setDisable(true);
    	siguienteJugador();
    }

    @FXML 
    void seleccionarVerde(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("0x63CD63"));
    	Verde.setDisable(true);
    	siguienteJugador();
    }

    @FXML
    void seleccionarCeleste(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("0x59D6FC"));
    	Celeste.setDisable(true);
    	siguienteJugador();
    }

    @FXML
    void seleccionarVioleta(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("0x580F90"));
    	Violeta.setDisable(true);
    	siguienteJugador();
    }

    @FXML
    void seleccionarVerdeAgua(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("0x155736"));
    	VerdeAgua.setDisable(true);
    	siguienteJugador();
    }

    @FXML
    void seleccionarAmarillo(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("0xF8FF6E"));
    	Amarillo.setDisable(true);
    	siguienteJugador();
    }

    @FXML
    void seleccionarNaranja(MouseEvent event) {
    	listaDeColoresDeJugadores.add(Color.web("FF9500"));
    	Naranja.setDisable(true);
    	siguienteJugador();
    }
    
    void siguienteJugador() {
   
    	if(i == juego.getJugadores().size()) {
    		inhabitarOpciones();
    		jugarButton.setDisable(false);
    		nombreDeJugador.setText("A jugar!");
    	}
    	else {
    		nombreDeJugador.setText("Elije color: " + juego.getJugadores().get(i).getNombreJugador());
    		i++;
    	}
    }
    
    public void cambiarAJuego(MouseEvent event) throws IOException {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Juego.fxml"));
    		root = (Parent)loader.load();
    		
    		JuegoController controller = loader.<JuegoController>getController();
    		
    		controller.setJuego(juego);
    		controller.setListaDeColores(listaDeColoresDeJugadores);
    		controller.setJuegoController();
    		
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    void inhabitarOpciones() {
    	Amarillo.setDisable(true);
    	Celeste.setDisable(true);
    	Naranja.setDisable(true);
    	Rojo.setDisable(true);
    	Rosa.setDisable(true);
    	Verde.setDisable(true);
    	VerdeAgua.setDisable(true);
    	Violeta.setDisable(true);
    }
    
    void habilitarOpciones() {
    	Amarillo.setDisable(false);
    	Celeste.setDisable(false);
    	Naranja.setDisable(false);
    	Rojo.setDisable(false);
    	Rosa.setDisable(false);
    	Verde.setDisable(false);
    	VerdeAgua.setDisable(false);
    	Violeta.setDisable(false);
    }
}

