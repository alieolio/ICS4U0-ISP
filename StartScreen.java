/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 * Version 1 - 05.20.22
 * Added the start screen to the console and made the buttons for it, however, was unable to overlap the buttons over the background image.
 *
 * Version 2 - 05.27.2022
 *
 * @version 05.27.22
 * @author Alicia Chung
 */
package com.latter.thelatter;
import javafx.application.Application;

import javafx.scene.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
public class StartScreen extends Stage {
    /**
     * This method draws and makes the screen for the start, instructions, and exit screen
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception{
        //making console
        primaryStage.setTitle("Starting Screen");

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
        ImageView imageView = new ImageView(image);

        // shared ColorAdjust for when buttons are hovered
        ColorAdjust hov = new ColorAdjust();
        hov.setBrightness(0.2);
        // when normal
        ColorAdjust norm = new ColorAdjust();
        hov.setBrightness(-0.2);

        //middle button - 'start' button
        Button buttonM = new Button();
        buttonM.setGraphic(new ImageView(sb));
        buttonM.setStyle("-fx-padding: 4 4 4 4;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
        // way to work with hovered effect here and not in a stylesheet
        buttonM.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                buttonM.getGraphic().setEffect(hov);
                // change image colour thing here
            }
        });
        buttonM.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                buttonM.setStyle("-fx-padding: 4 4 4 4;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                buttonM.getGraphic().setEffect(norm);
            }
        });

        /*
        -fx-padding: 4 4 4 4;
    -fx-background-radius: 0;
    -fx-background-color: #18692e;
         */

        //left button - 'instructions' button
        Button buttonL = new Button();
        buttonL.setGraphic(new ImageView(ib));
        buttonL.setTranslateY(20);
        buttonL.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                buttonL.getGraphic().setEffect(hov);
                // change image colour thing here
            }
        });
        buttonL.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                buttonL.setStyle("-fx-padding: 4 4 4 4;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                buttonL.getGraphic().setEffect(norm);
            }
        });

        //right button - 'exit' button
        Button buttonR = new Button();
        buttonR.setGraphic(new ImageView(eb));
        buttonR.setTranslateY(20);
        buttonR.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                buttonR.getGraphic().setEffect(hov);
                // change image colour thing here
            }
        });
        buttonR.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                buttonR.setStyle("-fx-padding: 4 4 4 4;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                buttonR.getGraphic().setEffect(norm);
            }
        });

        //adding buttons and image to hbox to display
        HBox hbox = new HBox(17);
        hbox.setTranslateX(30);
        hbox.setTranslateY(285);
        hbox.getChildren().add(buttonL);
        hbox.getChildren().add(buttonM);
        hbox.getChildren().add(buttonR);

        /**
         * <a href="https://stackoverflow.com/questions/27912628/how-to-overlap-buttons-text-over-an-image-with-javafx-8 site </a> (01/12/2015)
         */
        StackPane sp = new StackPane();
        sp.getChildren().addAll(imageView, hbox);

        HBox root = new HBox();
        root.getChildren().add(sp);

        Scene scene = new Scene(root, 512, 393);
        scene.getStylesheets().add(getClass().getResource("Start.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Main method to run the 'start' method
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}