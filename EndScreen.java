/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 * Version 1 - 05.25.22
 * Copied code from start screen and adapted it for the end screen.
 *
 *
 *
 * @version 05.25.22
 * @author Alicia Chung & Artemis Chen & Jessica Chen
 */

package com.latter.thelatter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.IOException;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class EndScreen{

    //private Stage primaryStage1;
    //private Stage primaryStage2;

    public HBox endS(Button buttonM, Button buttonL, Button buttonR){
        StackPane sp = new StackPane();

        try{
            // adding images
            FileInputStream input = new FileInputStream("endscreen.png");
            Image image = new Image(input);
            input = new FileInputStream("replay.png");
            Image bm = new Image(input);
            input = new FileInputStream("exitB2.png");
            Image br = new Image(input);
            input = new FileInputStream("credits.png");
            Image bl = new Image(input);

            //adding image to background of console
            ImageView imageView = new ImageView(image);

            // shared ColorAdjust for when buttons are hovered
            ColorAdjust hov = new ColorAdjust();
            hov.setBrightness(0.2);
            // when normal
            ColorAdjust norm = new ColorAdjust();
            hov.setBrightness(-0.2);

            //middle button - 'restart' button
            buttonM.setGraphic(new ImageView(bm));
            buttonM.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
            buttonM.setTranslateY(280);
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
            buttonL.setGraphic(new ImageView(bl));
            buttonL.setTranslateY(297);
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
            buttonR.setGraphic(new ImageView(br));
            buttonR.setTranslateY(297);
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
            HBox hbox = new HBox(25);
            hbox.setTranslateX(45);
            hbox.getChildren().add(buttonL);
            hbox.getChildren().add(buttonM);
            hbox.getChildren().add(buttonR);

            /**
             * <a href="https://stackoverflow.com/questions/27912628/how-to-overlap-buttons-text-over-an-image-with-javafx-8 site </a> (01/12/2015)
             */
            sp.getChildren().addAll(imageView, hbox);
        }catch (IOException e){
        }

        HBox root = new HBox();
        root.getChildren().add(sp);

        return root;
    }


}

