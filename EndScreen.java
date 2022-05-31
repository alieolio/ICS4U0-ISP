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
 * @author Alicia Chung & Artemis Chen
 */

package com.latter.thelatter;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class EndScreen extends Application {

    private Stage primaryStage1;
    private Stage primaryStage2;

    public void start(Stage primaryStage) throws Exception{
        //making console
        primaryStage.setTitle("Ending Screen");

        //adding image to background of console
        FileInputStream input = new FileInputStream("endscreen.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        //middle button - 'start' button
        Button buttonM = new Button("Replay");
        Font font = Font.font("Courier New", FontWeight.BOLD, 35);
        buttonM.setFont(font);
        buttonM.setTranslateY(280);
        //buttonM.setContentDisplay(ContentDisplay.BOTTOM);

        //left button - 'instructions' button
        Button buttonL = new Button("Credits");
        Font font2 = Font.font("Courier New", FontWeight.BOLD, 20);
        buttonL.setFont(font2);
        buttonL.setTranslateY(297);

        //right button - 'exit' button
        Button buttonR = new Button("Exit");
        Font font3 = Font.font("Courier New", FontWeight.BOLD, 25);
        buttonR.setFont(font3);
        buttonR.setTranslateY(290);

        //adding buttons and image to hbox to display
        HBox hbox = new HBox(17);
        hbox.setTranslateX(45);
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

