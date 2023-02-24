package controladores;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ResultadosController {

    @FXML
    private Button exitButton;

    @FXML
    private Label ganadorLabel;
    
    @FXML
    private AnchorPane resultadosPane;
    
    // Creamos una alerta
    Alert a = new Alert(AlertType.NONE);
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void setGanador(String ganador) {
    	ganadorLabel.setText("HA GANADO " + ganador + "!");
    }
    
    @FXML
    void salirDelJuego(MouseEvent event) {
    	
    	a.setAlertType(AlertType.CONFIRMATION);
    	a.setTitle("Salir del juego");
    	a.setHeaderText("Salir del juego");
    	a.setContentText("Estas seguro que queres salir del juego?");
    	
    	if (a.showAndWait().get() == ButtonType.OK) {
    		
    		stage = (Stage) resultadosPane.getScene().getWindow();
    		stage.close();
    		
		}
    	
    }
}
