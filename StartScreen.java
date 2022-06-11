/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 * Version 1 - 05.20.22
 * Added the start screen to the console and made the buttons for it, however, was unable to overlap the buttons over the background image.
 *
 * Version 2 - 05.21.2022
 *
 * @version 05.20.22
 * @author Alicia Chung
 */
package com.latter.thelatter;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.event.EventHandler;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StartScreen{

    /*
        Variable Name            Type                        Purpose
        bg                       ImageView                   Storing splash image
        bgCircle                 ImageView                   Storing png for splash screen
        bgText                   ImageView                   Storing splash text
        image                    Image                       Storing splash background image
        pt                       ParallelTransition          Variable for transition of splash screen
    */

    public ImageView bg = new ImageView();
    public ImageView bgCircle = new ImageView();
    public ImageView bgText = new ImageView();
    public Image image;
    ParallelTransition pt = new ParallelTransition();

    /**
     * splash screen, simple animation that automatically
     * transitions to the start screen.
     *
     * @return StackPane with all components for the scene
     */
    public StackPane screen(Button bM, Button bL, Button bR){
        /**
         * credits for animation
         * https://edencoding.com/javafxanimation-transitions-timelines-and-animation-timers/
         * https://www.genuinecoder.com/javafx-animation-tutorial/
         * https://www.youtube.com/watch?v=CtLHgu978gM
         */
        StackPane sp = new StackPane();

        // get relevant images
        try {
            FileInputStream input = new FileInputStream("splashBg.png");
            image = new Image(input);
            bg.setImage(image);
            input = new FileInputStream("splashCircle.png");
            image = new Image(input);
            bgCircle.setImage(image);
            image = new Image(new File("splashTxt.gif").toURI().toString());
            bgText.setImage(image);
        } catch (IOException e) {
        }

        Node r = new Rectangle(30, 30, Color.rgb(32, 89, 173));
        //r.setFill(Color.rgb(32, 89, 173));
        r.setTranslateY(190);
        r.setTranslateX(-290);


        sp.getChildren().add(bg);
        sp.getChildren().add(bgCircle);
        bgCircle.setTranslateY(bgCircle.getY()-55);
        sp.getChildren().add(bgText);
        bgText.setTranslateY(bgText.getY()+90);
        bgText.setVisible(false);
        sp.getChildren().add(r);

        Duration d1 = Duration.millis(13000);
        ScaleTransition bar = new ScaleTransition(d1, r);
        bar.setByX(80);
        bar.setInterpolator(Interpolator.EASE_BOTH);
        bar.setOnFinished(Event ->{
            System.out.println("bar finished");
        });

        //rotate transition
        Duration d2 = Duration.millis(1700);
        RotateTransition rt = new RotateTransition(d2, bgCircle);
        rt.setByAngle(360);
        //rt.setAutoReverse(true);
        rt.setCycleCount(5);
        rt.setOnFinished(Event ->{
            bgText.setVisible(true);
        });

        //transition.play();
        // first parallel
        pt = new ParallelTransition(bar, rt);
        pt.play();
        pt.setOnFinished(Event ->{
            sp.getChildren().add(startS(bM, bL, bR));
        });

        return sp;
    }
    public HBox startS(Button buttonM, Button buttonL, Button buttonR){
        HBox hbox = new HBox(17);
        ImageView imageView = new ImageView();
        try{
            /**
             * credits:
             * changing based on pseudoclass here (not in a stylesheet)
             *      https://stackoverflow.com/questions/13074459/javafx-2-and-css-pseudo-classes-setting-hover-attributes-in-setstyle-method
             */

            //adding images
            FileInputStream input = new FileInputStream("startscreen.png");
            Image image = new Image(input);
            input = new FileInputStream("STARTB.png");
            Image sb = new Image(input);
            input = new FileInputStream("instrB.png");
            Image ib = new Image(input);
            input = new FileInputStream("exitB1.png");
            Image eb = new Image(input);

            //adding image to background of console
            imageView.setImage(image);

            // shared ColorAdjust for when buttons are hovered
            ColorAdjust hov = new ColorAdjust();
            hov.setBrightness(0.2);
            // when normal
            ColorAdjust norm = new ColorAdjust();
            hov.setBrightness(-0.2);

            //middle button - 'start' button
            buttonM.setGraphic(new ImageView(sb));
            buttonM.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
            // way to work with hovered effect here and not in a stylesheet
            buttonM.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonM.getGraphic().setEffect(hov);
                }
            });
            buttonM.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonM.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                    buttonM.getGraphic().setEffect(norm);
                }
            });

            //left button - 'instructions' button
            buttonL.setGraphic(new ImageView(ib));
            buttonL.setTranslateY(20);
            buttonL.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
            buttonL.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonL.getGraphic().setEffect(hov);
                    // change image colour thing here
                }
            });
            buttonL.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonL.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                    buttonL.getGraphic().setEffect(norm);
                }
            });

            //right button - 'exit' button
            buttonR.setGraphic(new ImageView(eb));
            buttonR.setTranslateY(20);
            buttonR.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
            buttonR.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonR.getGraphic().setEffect(hov);
                    // change image colour thing here
                }
            });
            buttonR.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonR.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                    buttonR.getGraphic().setEffect(norm);
                }
            });

            //adding buttons and image to hbox to display
            hbox.setTranslateX(30);
            hbox.setTranslateY(285);
            hbox.getChildren().add(buttonL);
            hbox.getChildren().add(buttonM);
            hbox.getChildren().add(buttonR);
        } catch(IOException e){
        }

        /**
         * <a href="https://stackoverflow.com/questions/27912628/how-to-overlap-buttons-text-over-an-image-with-javafx-8 site </a> (01/12/2015)
         */
        StackPane sp = new StackPane();
        sp.getChildren().addAll(imageView, hbox);

        HBox root = new HBox();
        root.getChildren().add(sp);

        return root;
    }
}
