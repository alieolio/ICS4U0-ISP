package com.latter.thelatter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Driver extends Application{
    public void start(Stage stage) throws Exception {

        // BUTTONS
        // start screen
        Button buttonM = new Button();
        Button buttonL = new Button();
        Button buttonR = new Button();
        // instruction
        Button b = new Button();
        // gender selection
        Button bc = new Button();
        Button bm = new Button();
        Button bw = new Button();
        Button bgq = new Button();
        // end screen
        Button ebuttonM = new Button();
        Button ebuttonL = new Button();
        Button ebuttonR = new Button();

        // SCREENS
        // start screen
        StartScreen s = new StartScreen();
        Scene ss = new Scene(s.startS(buttonM, buttonL, buttonR), 512, 393);
        //ss.getStylesheets().add(getClass().getResource("Start.css").toExternalForm());
        // instructions
        Instructions i = new Instructions();
        Scene is = new Scene(i.instr(b), 512, 393);
        is.getStylesheets().add(getClass().getResource("instr.css").toExternalForm());
        // gender selection screen
        GenSelect g = new GenSelect();
        Scene gs = new Scene(g.genSel(bc, bm, bw, bgq), 512, 393);
        gs.getStylesheets().add(getClass().getResource("GenSel.css").toExternalForm());
        // end screen
        EndScreen e = new EndScreen();
        Scene end = new Scene(e.endS(ebuttonM, ebuttonL, ebuttonR), 512, 393);

        // start the thing
        stage.setScene(ss);
        stage.setTitle("The Latter");
        stage.show();

        // ACTIONS
        // start screen
        buttonM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // reset gender selection screen
                bc.setDisable(true);
                bm.getStyleClass().clear();
                bm.getStyleClass().add("button");
                bw.getStyleClass().clear();
                bw.getStyleClass().add("button");
                bgq.getStyleClass().clear();
                bgq.getStyleClass().add("button");
                // go to gender selection screen
                stage.setScene(gs);
            }
        });
        buttonL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(is);
            }
        });
        // instructions screen
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(ss);
            }
        });

        // gender selection screen
        bc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(end);
            }
        });
        // end screen
        ebuttonM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(ss);
            }
        });

        // exit actions
        buttonR.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        ebuttonR.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });


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
