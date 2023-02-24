package controladores;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("Bienvenida.fxml"));
	   		Scene scene = new Scene(root);
	   			   		
	   		stage.setScene(scene);
	   		stage.show();
	   		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    public static void main(String[] args) {
        launch();
    }

}