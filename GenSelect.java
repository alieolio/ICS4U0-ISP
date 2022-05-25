/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 *
 *
 * @version 05.24.22
 * @author Jessica Chen
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

import java.io.File;
import java.io.FileInputStream;

/**
 * TO-DO / NOTES
 *   • enter won't do anything if you click it and no
 *     gender is selected
 *   • when you hover over a button the outline will
 *     change from light grey to dark green
 *   • when you select a gender (not just hover) the
 *     colour of the enter button will change (probably
 *     just get a more green tint and it will stay that
 *     way until another gender is selected or enter is
 *     selected
 */

public class GenSelect extends Application{
    /**
     * This method gives lets the user select a gender identity for the game
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception{
        //making console
        primaryStage.setTitle("The Latter");

        //adding images
        FileInputStream input = new FileInputStream("gensel.png");
        Image image = new Image(input);
        input = new FileInputStream("manB.png");
        Image man = new Image(input);
        input = new FileInputStream("womanB.png");
        Image woman = new Image(input);
        input = new FileInputStream("gqB.png");
        Image gq = new Image(input);
        input = new FileInputStream("gENTERB.png");
        Image end = new Image(input);


        //adding image to background of console
        ImageView iv = new ImageView(image);

        //so I can shift buttons together, based off of man button coordinates
        int x = 180;
        int y = 115;

        //top button - 'Man' button
        Button bm = new Button();
        bm.setGraphic(new ImageView(man));
        bm.setTranslateX(x);
        bm.setTranslateY(y);
        bm.setStyle(
                "-fx-background-color: lightgrey;" +
                "-fx-padding: 2 2 2 2;" +
                "-fx-background-radius: 0"
        );

        //middle button - 'woman' button
        Button bw = new Button();
        bw.setGraphic(new ImageView(woman));
        bw.setTranslateX(x);
        bw.setTranslateY(y+15);
        bw.setStyle(
                "-fx-background-color: lightgrey;" +
                "-fx-padding: 2 2 2 2;" +
                "-fx-background-radius: 0"
        );

        //bottom button - 'gender queer' button
        Button bgq = new Button();
        bgq.setGraphic(new ImageView(gq));
        bgq.setTranslateX(x);
        bgq.setTranslateY(y+15+15);
        bgq.setStyle(
                "-fx-background-color: lightgrey;" +
                "-fx-padding: 2 2 2 2;" +
                "-fx-background-radius: 0"
        );

        //bottom corner button - 'Enter' button
        Button bc = new Button();
        bc.setGraphic(new ImageView(end));
        bc.setTranslateX(x+200);
        bc.setTranslateY(y+10);
        bc.setStyle(
                "-fx-background-color: lightgrey;" +
                "-fx-padding: 2 2 2 2;" +
                "-fx-background-radius: 0"
        );

        //adding buttons and image to hbox to display
        VBox box = new VBox();
        box.getChildren().add(bm);
        box.getChildren().add(bw);
        box.getChildren().add(bgq);
        box.getChildren().add(bc);

        /**
         * <a href="https://stackoverflow.com/questions/27912628/how-to-overlap-buttons-text-over-an-image-with-javafx-8 site </a> (01/12/2015)
         */
        StackPane sp = new StackPane();
        sp.getChildren().addAll(iv, box);

        HBox root = new HBox();
        root.getChildren().add(sp);

        Scene scene = new Scene(root, 512, 393);

        primaryStage.setScene(scene);
        //fix the screen size
        primaryStage.setMinHeight(393);
        primaryStage.setMaxHeight(393);
        primaryStage.setMinWidth(512);
        primaryStage.setMaxWidth(512);
        //show
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
