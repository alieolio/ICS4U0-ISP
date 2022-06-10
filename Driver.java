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
                movement(1, w.player, w.enterFunc, w.enterFunc2);
            }
        };
        // boss' office screen
        Boss bo = new Boss();
        Scene p1 = new Scene(bo.bossO(), 512, 393);
        AnimationTimer bT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(2, bo.player, bo.enterFunc, bo.enterFunc2);
            }
        };
        // schoolroom screen
        Classroom cl = new Classroom();
        Scene d2 = new Scene(cl.classR(), 512, 393);
        AnimationTimer oT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(3, cl.player, cl.enterFunc, cl.enterFunc2);
            }
        };
        // principal's room screen
        Principal pl = new Principal();
        Scene p2 = new Scene(pl.pOffice(), 512, 393);
        AnimationTimer pT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(4, pl.player, pl.enterFunc, pl.enterFunc2);
            }
        };
        // ladder screen
        Ladder esc = new Ladder();
        Scene er = new Scene(esc.room(), 512, 393);
        AnimationTimer lA = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(5, esc.player, esc.enterFunc, esc.enterFunc2);
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
                locX = 237;
                locY = 305;
                w.player.relocate(237, 300);
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
                if (clear && state){ //just key for now, not checking location
                    System.out.println("d1 b1 press e");
                    timer.stop();
                    locX = 90;
                    locY = 300;
                    bo.player.relocate(90, 300);
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
                if (clear && state && bu == 2){ //just key for now, not checking location
                    locX = 20;
                    locY = 30;
                    cl.player.relocate(20, 30);
                    bT.stop();
                    oT.start();
                    stage.setScene(d2);
                } else if (clear && state && bu == 1){
                    locX = 90;
                    locY = -3;
                    w.player.relocate(90, -3);
                    bT.stop();
                    timer.start();
                    stage.setScene(d1);
                }
            }
        });
        p1.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
            }
        });

        // deficiency 2
        d2.setOnKeyPressed(new EventHandler<KeyEvent>() { //moves the character when the correct key is pressed
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean state = velStart(keyEvent);
                setVelocity();
                if (clear && state && bu == 2){ //just key for now, not checking location
                    oT.stop();
                    locX = 453;
                    locY = 30;
                    bo.player.relocate(453, 30);
                    bT.start();
                    stage.setScene(p1);
                } else if (clear && state && bu == 1){
                    oT.stop();
                    locX = 20;
                    locY = 270;
                    pl.player.relocate(20, 270);
                    pT.start();
                    stage.setScene(p2);
                }
            }
        });
        d2.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
            }
        });

        // panic 2
        p2.setOnKeyPressed(new EventHandler<KeyEvent>() { //moves the character when the correct key is pressed
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean state = velStart(keyEvent);
                setVelocity();
                if (clear && state && bu == 2){ //just key for now, not checking location
                    pT.stop();
                    locX = 455;
                    locY = 270;
                    cl.player.relocate(455, 270);
                    oT.start();
                    stage.setScene(d2);
                } else if (clear && state && bu == 1){
                    pT.stop();
                    locX = 20;
                    locY = 270;
                    esc.player.relocate(20, 270);
                    lA.start();
                    stage.setScene(er);
                }
            }
        });
        p2.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
            }
        });

        // escape
        er.setOnKeyPressed(new EventHandler<KeyEvent>() { //moves the character when the correct key is pressed
            @Override
            public void handle(KeyEvent keyEvent) {
                boolean state = velStart(keyEvent);
                setVelocity();
                if (clear && state && bu == 2){ //just key for now, not checking location
                    lA.stop();
                    locX = 455;
                    locY = 270;
                    pl.player.relocate(455, 270);
                    pT.start();
                    stage.setScene(p2);
                } else if (clear && state && bu == 1){
                    lA.stop();
                    stage.setScene(end);
                }
            }
        });
        er.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
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
