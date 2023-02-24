package controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BienvenidaController {

    @FXML
    private Button instruccionesButton;

    @FXML
    private Button jugarButton;

    @FXML
    private Button salirButton;
    
    @FXML
    private AnchorPane bienvenidaScene;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    // Creamos una alerta
    Alert a = new Alert(AlertType.NONE);

    @FXML
    void cambiarAInicializacion(MouseEvent event) {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Inicializacion.fxml"));
    		root = (Parent)loader.load();
    		
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void cambiarAInstrucciones(MouseEvent event) {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Instrucciones.fxml"));
    		root = (Parent)loader.load();
    		
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void salirDelJuego(MouseEvent event) {
    	
    	a.setAlertType(AlertType.CONFIRMATION);
    	a.setTitle("Salir del juego");
    	a.setHeaderText("Salir del juego");
    	a.setContentText("Estas seguro que queres salir del juegazo?");
    	
    	if (a.showAndWait().get() == ButtonType.OK) {
    		
    		stage = (Stage) bienvenidaScene.getScene().getWindow();
    		System.out.println("Saliste exitosamente del programa!");
    		stage.close();
    		
		}
    	
    }

}
