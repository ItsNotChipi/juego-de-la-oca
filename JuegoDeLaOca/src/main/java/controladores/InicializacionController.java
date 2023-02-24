package controladores;

import java.io.IOException;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.JuegoDeLaOca;
import modelo.Jugador;
import javafx.scene.Node;

public class InicializacionController {

    @FXML
    private ListView<String> listaDeNombresJugadores;
    
    @FXML
    private Button continuarButton;

    @FXML
    private TextField nombreJugador;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Juego juego;
    
    // Creamos una alerta
    Alert a = new Alert(AlertType.NONE);
    
    public void cambiarAElegirPersonaje(MouseEvent event) throws IOException {
    	
    	if (listaDeNombresJugadores.getItems().size() < 2) {
    		
    		a.setAlertType(AlertType.WARNING);
    		a.setTitle("Mínima cantidad de jugadores");
    		a.setHeaderText("Cantidad mínima de jugadores no alcanzada!");
    		a.setContentText("El mínimo de jugadores es 2. Ingrese mas jugadores.");
    		a.show();
    		
    	} else {
			
    		juego = new Juego();
    		
    		for (int i = 0; i < listaDeNombresJugadores.getItems().size(); i++) {
    			Jugador nuevoJugador = new Jugador(listaDeNombresJugadores.getItems().get(i));
    			juego.getJugadores().add(nuevoJugador);
    		}
    		
    		
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("ElegirPersonaje.fxml"));
    			root = (Parent)loader.load();
    			
    			ElegirPersonajeController controller = loader.<ElegirPersonajeController>getController();
    			
    			controller.inhabitarOpciones();
    			controller.setJuego(juego);
    			
    			
    			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
		}
    }

    @FXML
    void agregarNombreJugador(MouseEvent event) {
    	
    	continuarButton.setDisable(false);
    	
    	if(existeJugador(nombreJugador.getText())) {
    		
    		a.setAlertType(AlertType.WARNING);
    		a.setTitle("Jugador existente");
    		a.setHeaderText("Jugador existente!");
    		a.setContentText("El jugador ingresado ya existe. Ingrese otro.");
    		a.show();
    		
    		nombreJugador.clear();
    		
    	}
    	else if(!(listaDeNombresJugadores.getItems().size() < 8)) {
    		
    		a.setAlertType(AlertType.WARNING);
    		a.setTitle("Limite de jugadores");
    		a.setHeaderText("Máximo de jugadores alcanzado!");
    		a.setContentText("El máximo de jugadores es 8!");
    		a.show();
    		
    		nombreJugador.clear();
			
		}
    	else {
    		listaDeNombresJugadores.getItems().add(nombreJugador.getText());
    		
    		nombreJugador.clear();
		}
    }
    
    boolean existeJugador (String nombreRepetido) {
    	for (int i = 0; i < listaDeNombresJugadores.getItems().size(); i++) {
    		if (listaDeNombresJugadores.getItems().get(i).equals(nombreRepetido)){
    			return true;
    		}
    	}
    	return false;
    }
    

    @FXML
    void eliminarNombreJugador(MouseEvent event) {
    	int idSeleccionado = listaDeNombresJugadores.getSelectionModel().getSelectedIndex();
    	listaDeNombresJugadores.getItems().remove(idSeleccionado);
    }

}
