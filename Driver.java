package com.latter.thelatter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class Driver extends Movement{

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
        // workplace screen
        Workplace w = new Workplace();
        Scene d1 = new Scene(w.office(), 512, 393);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(w.player, w.enterFunc, w.enterFunc2, "office");
            }
        };
        // boss' office screen
        Boss bo = new Boss();
        Scene p1 = new Scene(bo.bossO(), 512, 393);
        AnimationTimer bT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(bo.player, bo.enterFunc, bo.enterFunc2, "boss");
            }
        };

        // end screen
        EndScreen e = new EndScreen();
        Scene end = new Scene(e.endS(ebuttonM, ebuttonL, ebuttonR), 512, 393);

        // start the thing
        stage.setScene(ss);
        stage.setTitle("The Latter");
        stage.show();

        // ACTIONS
        /**
         * CREDITS:
         * <ul> 
         *     <li href="https://stackoverflow.com/questions/12804664/how-to-swap-screens-in-a-javafx-application-in-the-controller-class"> swapping screens part 1 </li>
         *     <li href="https://stackoverflow.com/questions/49287392/javafx-how-to-change-scene-using-a-scene-from-another-class"> swapping screens part 2 </li>
         *     <li href="https://stackoverflow.com/questions/36551431/can-you-write-two-different-java-fx-scenes-as-two-separate-classes"> swapping screens part 3 </li>
         *     <li href="https://stackoverflow.com/questions/43086875/javafx-8-on-button-click-show-other-scene"> swapping screens with buttons </li>
         *     <li href="https://stackoverflow.com/questions/26619566/javafx-stage-close-handler"> closing screen </li>
         *     <li href="https://www.cs.scranton.edu/~mccloske/courses/com_line_args_jGrasp.html"> running javaFX on jGRASP -command line arguments </li>
         *     <li href="https://stackoverflow.com/questions/54662129/javafx-11-javafx-runtime-components-are-missing"> running javaFX on jGRASP -compiler settings </li>
         */
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
                stage.setScene(d1);
                timer.start();
            }
        });

        // deficiency 1
        d1.setOnKeyPressed(new EventHandler<KeyEvent>() { //moves the character when the correct key is pressed
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean state = velStart(keyEvent);
                setVelocity();
                if (getClear() && state){ //just key for now, not checking location
                    timer.stop();
                    bT.start();
                    stage.setScene(p1);
                }
            }
        });
        d1.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
            }
        });

        // panic 1
        p1.setOnKeyPressed(new EventHandler<KeyEvent>() { //moves the character when the correct key is pressed
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean state = velStart(keyEvent);
                setVelocity();
                if (getClear() && state){ //just key for now, not checking location
                    stage.setScene(end);
                }
            }
        });
        p1.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
            }
        });


        // end screen
        /*
        YOU NEED TO FIND A WAY TO ACTUALLY RESTART ALL SCENES,
        SINCE MANY WILL BE IN THE STATE THEY WRE LEFT, WE DON'T
        WANT THAT
         */
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
