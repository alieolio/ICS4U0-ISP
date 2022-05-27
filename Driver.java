package com.latter.thelatter;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Driver extends Application{
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        //Scene scene = new Scene(root)
        
        //JUST COMMENT THE ONE YOU DON'T WANT OUT, I STILL HAVEN'T 
        // FIGURED OUT HOW TO SWITCH BETWEEN THEM YET
        
        startScreen s = new startScreen();
        s.start(stage);
        //while (s.start(stage) != -1){

        //}
        // for now it will just move to the next screen
        GenSelect g = new GenSelect();
        g.start(stage);

        //stage.setScene();
        //stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
