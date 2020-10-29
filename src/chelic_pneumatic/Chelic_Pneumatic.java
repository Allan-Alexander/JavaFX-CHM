/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chelic_pneumatic;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author saji
 */
public class Chelic_Pneumatic extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("ChelicFXML.fxml"));
        Scene scene = new Scene(root, 1027, 757);
        Image image = new Image(getClass().getResourceAsStream("/chelic_pneumatic/Untitled.png"));
        primaryStage.getIcons().add(image);
        
       // primaryStage.setMaximized(true);
        primaryStage.setTitle("Chennai Hydro-Maatics");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
