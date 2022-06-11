/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva V.
 * <p>
 * Version 1 - 05.27.2022
 * Added the background image for this class.
 * <p>
 * Version 2 - 06.03.2022
 * <p>
 * Version 3 - 06.10.2022
 * Added the final scenes to this class (i.e. ways you can help and resources).
 *
 * @version 06.10.2022
 * @author Alicia Chung
 */


package com.latter.thelatter;

import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.io.FileInputStream;


public class EndScreen {

    /*
        Variable Name   Type        Description
        escaped         ImageView   Final escape screen
        canHelp         ImageView   Screen that shows the ways you can help
        resources       ImageView   Screen that shows the resources you can use
     */

    /**
     * Final escape screen
     */
    public ImageView escaped = new ImageView();
    /**
     * Screen that shows the ways you can help
     */
    public ImageView canHelp = new ImageView();
    /**
     * Screen that shows the resources you can use
     */
    public ImageView furtherR = new ImageView();

    /**
     * Constructor for the end screen
     * @param buttonM Middle button
     * @param buttonL Left button
     * @param buttonR Right button
     * @return the group of the end screen
     */
    public Group endS(Button buttonM, Button buttonL, Button buttonR) {
        Group group = new Group();
        StackPane sp = new StackPane();

        try {
            // adding images
            FileInputStream input = new FileInputStream("endscreen.png");
            Image image = new Image(input);
            input = new FileInputStream("replay.png");
            Image bm = new Image(input);
            input = new FileInputStream("exitB2.png");
            Image br = new Image(input);
            input = new FileInputStream("credits.png");
            Image bl = new Image(input);
            FileInputStream notQ = new FileInputStream("escaped.png");
            Image eQ = new Image(notQ);
            escaped = new ImageView(eQ);
            FileInputStream yH = new FileInputStream("help.png");
            Image youHelp = new Image(yH);
            canHelp = new ImageView(youHelp);
            FileInputStream fR = new FileInputStream("resources further.png");
            Image r = new Image(fR);
            furtherR = new ImageView(r);

            // additional end stuff original settings
            escaped.setVisible(true);
            escaped.setX(12);
            escaped.setY(12);
            canHelp.setVisible(false);
            canHelp.setX(12);
            canHelp.setY(12);
            furtherR.setVisible(false);
            furtherR.setX(12);
            furtherR.setY(12);

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
                @Override
                public void handle(MouseEvent mouseEvent) {
                    buttonM.getGraphic().setEffect(hov);
                }
            });
            buttonM.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    buttonM.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                    buttonM.getGraphic().setEffect(norm);
                }
            });

            //left button - 'instructions' button
            buttonL.setGraphic(new ImageView(bl));
            buttonL.setTranslateY(297);
            buttonL.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
            buttonL.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    buttonL.getGraphic().setEffect(hov);
                    // change image colour thing here
                }
            });
            buttonL.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    buttonL.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
                    buttonL.getGraphic().setEffect(norm);
                }
            });

            //right button - 'exit' button
            buttonR.setGraphic(new ImageView(br));
            buttonR.setTranslateY(297);
            buttonR.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-radius: 0;" + "-fx-background-color: #18692e;");
            buttonR.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    buttonR.getGraphic().setEffect(hov);
                    // change image colour thing here
                }
            });
            buttonR.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
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

            group.getChildren().add(sp);
            group.getChildren().add(escaped);
            group.getChildren().add(canHelp);
            group.getChildren().add(furtherR);
            System.out.println(sp.toString());
            System.out.println(escaped.toString());
            System.out.println(canHelp.toString());
            System.out.println(furtherR.toString());
        } catch (IOException e) {
        }

        return group;
    }
}

