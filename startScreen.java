/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 * @version 05.20.22
 * @author Alicia Chung
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
public class startScreen extends Application {
    /**
     * This method draws and makes the screen for the start, instructions, and exit screen
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception{
        //making console
        primaryStage.setTitle("Starting Screen");

        //adding image to background of console
        FileInputStream input = new FileInputStream("logo (1).png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        //middle button - 'start' button
        Button buttonM = new Button("Start");
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        buttonM.setFont(font);
        buttonM.setTranslateX(184);
        buttonM.setTranslateY(280);
        //buttonM.setContentDisplay(ContentDisplay.BOTTOM);

        //left button - 'instructions' button
        Button buttonL = new Button("Instructions");
        Font font2 = Font.font("Courier New", FontWeight.BOLD, 17);
        buttonL.setFont(font2);
        buttonL.setTranslateX(-140);
        buttonL.setTranslateY(297);

        //right button - 'exit' button
        Button buttonR = new Button("Exit");
        Font font3 = Font.font("Courier New", FontWeight.BOLD, 27);
        buttonR.setFont(font3);
        buttonR.setTranslateX(72);
        buttonR.setTranslateY(290);

        //adding buttons and image to hbox to display
        HBox hbox = new HBox();
        //hbox.getChildren().add(imageView);
        hbox.getChildren().add(buttonM);
        hbox.getChildren().add(buttonL);
        hbox.getChildren().add(buttonR);

        Scene scene = new Scene(hbox, 512, 393);
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
