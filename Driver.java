package com.latter.thelatter;

import javafx.application.Application;
import javafx.application.Platform;
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

        //set fixed size
        /*
        stage.setMaxWidth(512);
        stage.setMinWidth(512);
        stage.setMaxHeight(393);
        stage.setMinHeight(393);
        */

        // relevant buttons
        //start screen
        Button buttonM = new Button();
        Button buttonL = new Button();
        Button buttonR = new Button();
        //gender selection
        Button bc = new Button();

        // start screen
        startScreen s = new startScreen();
        Scene ss = new Scene(s.startS(buttonM, buttonL, buttonR), 512, 393);
        ss.getStylesheets().add(getClass().getResource("Start.css").toExternalForm());
        // gender selection screen
        GenSelect g = new GenSelect();
        Scene gs = new Scene(g.genSel(bc), 512, 393);
        gs.getStylesheets().add(getClass().getResource("GenSel.css").toExternalForm());

        // start the thing
        stage.setScene(ss);
        stage.setTitle("The Latter");
        stage.show();

        // actions in the start screen
        buttonR.setOnAction(e ->
                Platform.exit()
        );
        buttonM.setOnAction(e ->
                stage.setScene(gs)
        );
        // actions in the gender selection screen
        bc.setOnAction(e ->
                Platform.exit()
        );

        //while (s.start(stage) != -1){

        //}
        // for now it will just move to the next screen
        /*


        stage.setScene(gs);
        stage.setTitle("The Latter");
        stage.show();
        */

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
