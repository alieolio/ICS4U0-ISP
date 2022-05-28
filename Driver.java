/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva V.
 * 
 * Driver Class
 * As of version 1.0.0, screens are displayed from here,
 * but there is currently no code for moving between them.
 *
 * @version 1.0.0
 * @author Jessica Chen
 */

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
    /**
     * This method shows the screns
     * 
     * @param stage where things are displayed
     * @throws Exception
     */
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
     * launched through deployment artifacts
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
