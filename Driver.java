/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva V.
 * <p>
 * Version 1 - 05.27.2022
 *
 * Version 2 - 06.03.2022
 *
 * Version 3 - 06.10.2022
 * </p>
 * @version 06.10.2022
 * @author Jessica Chen
 */

package com.latter.thelatter;

import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Driver extends Movement {

    /*
        Variable Name   Type        Description
        count           int         Counts the number of questions asked
        question        int         The question number
        points          int         The points you have
     */

    //quiz question counter
    /**
     * The number of questions asked
     */
    int count = 0;
    /**
     * The question number
     */
    int question = 0;
    /**
     * The total amount of points
     */
    int points = 0;

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
        Scene ss = new Scene(s.screen(buttonM, buttonL, buttonR), 512, 393);
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
                movement(1, w.player, w.enterFunc, w.enterFunc2, w.viewF);
            }
        };
        // boss' office screen
        Boss bo = new Boss();
        Scene p1 = new Scene(bo.bossO(), 512, 393);
        AnimationTimer bT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(2, bo.player, bo.enterFunc, bo.enterFunc2, bo.enterFunc2);
            }
        };
        // schoolroom screen
        Classroom cl = new Classroom();
        Scene d2 = new Scene(cl.classR(), 512, 393);
        AnimationTimer oT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(3, cl.player, cl.enterFunc, cl.enterFunc2, cl.viewF);
            }
        };
        // principal's room screen
        Principal pl = new Principal();
        Scene p2 = new Scene(pl.pOffice(), 512, 393);
        AnimationTimer pT = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(4, pl.player, pl.enterFunc, pl.enterFunc2, pl.play);
            }
        };
        // ladder screen
        Ladder esc = new Ladder();
        Scene er = new Scene(esc.room(), 512, 393);
        AnimationTimer lA = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(5, esc.player, esc.enterFunc, esc.enterFunc2, esc.enterFunc2);
            }
        };

        // end screen
        EndScreen e = new EndScreen();
        Scene end = new Scene(e.endS(ebuttonM, ebuttonL, ebuttonR), 512, 393);

        // start the thing
        stage.setScene(ss);
        //stage.setScene(p1);
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
                if (keyEvent.getCode() == KeyCode.C) w.setInsOff();
                int state = velStart(keyEvent);
                setVelocity();
                if (clear && state == 0) { //just key for now, not checking location
                    timer.stop();
                    locX = 90;
                    locY = 300;
                    bo.player.relocate(90, 300);
                    bT.start();
                    stage.setScene(p1);
                } else if (state == 1) {
                    w.showF(oc);
                }
            }
        });
        d1.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
                if (factCheck) {
                    w.showF(oc);
                }
            }
        });

        // panic 1
        QuizQuestions qq = new QuizQuestions();
        p1.setOnKeyPressed(new EventHandler<KeyEvent>() { //moves the character when the correct key is pressed
            @Override
            public void handle(KeyEvent keyEvent) {
                int state = velStart(keyEvent);
                setVelocity();
                if (clear && state == 0 && bu == 2) { //just key for now, not checking location
                    locX = 20;
                    locY = 30;
                    cl.player.relocate(20, 30);
                    bT.stop();
                    oT.start();
                    stage.setScene(d2);
                } else if (clear && state == 0 && bu == 1) {
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
                if (keyEvent.getCode() == KeyCode.C) cl.setInsOff();
                int state = velStart(keyEvent);
                setVelocity();
                if (clear && state == 0 && bu == 2) { //just key for now, not checking location
                    oT.stop();
                    locX = 453;
                    locY = 30;
                    bo.player.relocate(453, 30);
                    bT.start();
                    stage.setScene(p1);
                } else if (clear && state == 0 && bu == 1) {
                    oT.stop();
                    locX = 20;
                    locY = 270;
                    pl.player.relocate(20, 270);
                    pT.start();
                    stage.setScene(p2);
                } else if (state == 1) {
                    cl.showF(oc);
                }
            }
        });
        d2.setOnKeyReleased(new EventHandler<KeyEvent>() { //stops the character when the correct key is released
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
                if (factCheck) {
                    cl.showF(oc);
                }
            }
        });

        // panic 2
        p2.setOnKeyPressed(new EventHandler<KeyEvent>() { //moves the character when the correct key is pressed
            @Override
            public void handle(KeyEvent keyEvent) {
                int state = velStart(keyEvent);
                setVelocity();
                if (clear && state == 0 && bu == 2) { //just key for now, not checking location
                    pT.stop();
                    locX = 455;
                    locY = 270;
                    cl.player.relocate(455, 270);
                    oT.start();
                    stage.setScene(d2);
                } else if (clear && state == 0 && bu == 1) {
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
                int state = velStart(keyEvent);
                setVelocity();
                if (clear && state == 0 && bu == 2) { //just key for now, not checking location
                    lA.stop();
                    locX = 455;
                    locY = 270;
                    pl.player.relocate(455, 270);
                    pT.start();
                    stage.setScene(p2);
                } else if (clear && state == 0 && bu == 1) {
                    lA.stop();
                    e.furtherR.setVisible(false);
                    e.canHelp.setVisible(false);
                    e.escaped.setVisible(true);
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
        // !!!!!!!!!!!!!!!!!!!!!!!!!! REMEMBER TO CHECK IF ALL SCENES RE RESET
        ebuttonM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(ss);
            }
        });
        end.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.C) {
                    if (e.escaped.isVisible()) {
                        e.escaped.setVisible(false);
                        e.canHelp.setVisible(true);
                    } else if (e.canHelp.isVisible()) {
                        e.canHelp.setVisible(false);
                        e.furtherR.setVisible(true);
                    }
                } else if (ke.getCode() == KeyCode.E) {
                    if (!e.escaped.isVisible() && !e.canHelp.isVisible()) {
                        e.furtherR.setVisible(false);
                        e.canHelp.setVisible(false);
                        e.escaped.setVisible(false);
                    }
                }
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

    // thing for quiz
    public void pickQuestion(Stage stage, Scene p1, boolean[] questionsAsked, ImageView questionImageView, ImageView questionImageView2, ImageView questionImageView3, ImageView questionImageView4, ImageView questionImageView5, ImageView questionImageView6, ImageView questionImageView7, ImageView correct1, ImageView correct2, ImageView correct3, ImageView incorrect) {
        question = (int) (Math.random() * 7);
        while (questionsAsked[question]) {
            question = (int) (Math.random() * 7);
        }
        if (question == 0 && !questionsAsked[0]) {
            questionImageView.setVisible(true);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
        } else if (question == 1 && !questionsAsked[1]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(true);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
        } else if (question == 2 && !questionsAsked[2]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(true);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
        } else if (question == 3 && !questionsAsked[3]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(true);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
        } else if (question == 4 && !questionsAsked[4]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(true);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
        } else if (question == 5 && !questionsAsked[5]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(true);
            questionImageView7.setVisible(false);
            answer(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
        } else if (question == 6 && !questionsAsked[6]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(true);
            answer(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
        }
        questionsAsked[question] = true;
    }

    public void answer(Stage stage, boolean[] questionsAsked, Scene p1, ImageView questionImageView, ImageView questionImageView2, ImageView questionImageView3, ImageView questionImageView4, ImageView questionImageView5, ImageView questionImageView6, ImageView questionImageView7, ImageView correct1, ImageView correct2, ImageView correct3, ImageView incorrect) {
        if (question == 0) {
            p1.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode().equals(KeyCode.DIGIT1)) {
                        points += 1;
                        questionImageView.setVisible(false);
                        correct1.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView.setVisible(false);
                        incorrect.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    }
                }
            });
        } else if (question == 1) {
            p1.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        points += 3;
                        questionImageView2.setVisible(false);
                        correct3.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        questionImageView2.setVisible(false);
                        incorrect.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    }
                }
            });
        } else if (question == 2) {
            p1.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode().equals(KeyCode.DIGIT2)) {
                        points += 2;
                        questionImageView3.setVisible(false);
                        correct2.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView3.setVisible(false);
                        incorrect.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    }
                }
            });
        } else if (question == 3) {
            p1.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        points += 1;
                        questionImageView4.setVisible(false);
                        correct1.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView4.setVisible(false);
                        incorrect.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    }
                }
            });
        } else if (question == 4) {
            p1.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        points += 1;
                        questionImageView5.setVisible(false);
                        correct1.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        questionImageView5.setVisible(false);
                        incorrect.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    }
                }
            });
        } else if (question == 5) {
            p1.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode().equals(KeyCode.DIGIT1)) {
                        points += 2;
                        questionImageView6.setVisible(false);
                        correct2.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView6.setVisible(false);
                        incorrect.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    }
                }
            });
        } else if (question == 6) {
            p1.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        points += 3;
                        questionImageView7.setVisible(false);
                        correct3.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        questionImageView7.setVisible(false);
                        incorrect.setVisible(true);
                        reset(stage, questionsAsked, p1, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    }
                }
            });
        }
    }

    public void reset(Stage stage, boolean[] questionsAsked, Scene p1, ImageView questionImageView, ImageView questionImageView2, ImageView questionImageView3, ImageView questionImageView4, ImageView questionImageView5, ImageView questionImageView6, ImageView questionImageView7, ImageView correct1, ImageView correct2, ImageView correct3, ImageView incorrect) {
        p1.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.C)) {
                    count++;
                    correct1.setVisible(false);
                    correct2.setVisible(false);
                    correct3.setVisible(false);
                    incorrect.setVisible(false);
                    if (count < 7)
                        pickQuestion(stage, p1, questionsAsked, questionImageView, questionImageView2, questionImageView3, questionImageView4, questionImageView5, questionImageView6, questionImageView7, correct1, correct2, correct3, incorrect);
                    if (count == 7) {
                        questionImageView.setVisible(false);
                        questionImageView2.setVisible(false);
                        questionImageView3.setVisible(false);
                        questionImageView4.setVisible(false);
                        questionImageView5.setVisible(false);
                        questionImageView6.setVisible(false);
                        questionImageView7.setVisible(false);
                        System.out.println("quiz ends");
                        stage.setScene(p1);
                    }
                }
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
