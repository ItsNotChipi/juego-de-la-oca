package controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InstruccionesController {

    @FXML
    private Button regresarButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void cambiarABienvenida(MouseEvent event) {

    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Bienvenida.fxml"));
    		root = (Parent)loader.load();
    		
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

}
