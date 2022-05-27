/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 * @version 05.27.22
 * @author Jessica Chen
 */
package com.latter.thelatter;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

/**
 * TO-DO / NOTES
 *   • format the sources correctly
 *   • enter won't do anything if you click/hover on it and no
 *     gender is selected
 *   • when you select a gender (not just hover) the
 *     colour of the enter button will change (probably
 *     just get a more green tint and dark green outline
 *     stays) and it will stay that way until another
 *     gender is selected or enter is selected
 */

public class GenSelect extends Stage{
    /**
     * This method gives lets the user select a gender identity for the game
     * @param primaryStage
     * @throws Exception
     */
     public void start(Stage primaryStage) throws Exception{
     //public GenSelect{
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
        /** credits for ToggleButton https://jenkov.com/tutorials/javafx/togglebutton.html */
        Button bm = new Button();
        bm.setGraphic(new ImageView(man));
        bm.setTranslateX(x);
        bm.setTranslateY(y);

        //middle button - 'woman' button
        Button bw = new Button();
        bw.setGraphic(new ImageView(woman));
        bw.setTranslateX(x);
        bw.setTranslateY(y+15);

        //bottom button - 'gender queer' button
        Button bgq = new Button();
        bgq.setGraphic(new ImageView(gq));
        bgq.setTranslateX(x);
        bgq.setTranslateY(y+15+15);

        //bottom corner button - 'Enter' button
        Button bc = new Button();
        bc.setGraphic(new ImageView(end));
        bc.setTranslateX(x+200+5);
        bc.setTranslateY(y+5);
        //disabled (permanently for now, will eventually
        // be enabled when a gender is selected)
        bc.setDisable(true);

        //stuff for buttons
        // choosing a gender
        bm.setOnAction(value -> {
           System.out.println("man");
           bc.setDisable(false);
           bm.getStyleClass().add("ch");
           bw.getStyleClass().clear();
           bw.getStyleClass().add("button");
           bgq.getStyleClass().clear();
           bgq.getStyleClass().add("button");
        });
        bw.setOnAction(value -> {
           System.out.println("woman");
           bc.setDisable(false);
           bm.getStyleClass().clear();
           bm.getStyleClass().add("button");
           bw.getStyleClass().add("ch");
           bgq.getStyleClass().clear();
           bgq.getStyleClass().add("button");
        });
        bgq.setOnAction(value -> {
           System.out.println("gender queer");
           bc.setDisable(false);
           bm.getStyleClass().clear();
           bm.getStyleClass().add("button");
           bw.getStyleClass().clear();
           bw.getStyleClass().add("button");
           bgq.getStyleClass().add("ch");
        });
        //enter goes to next screen

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

        //get styles
        // you still have to fix the credits format
        /**
         *   credits for everything I learned about styles:
         *   https://stackoverflow.com/questions/50210697/how-to-remove-the-rounded-corners-from-javafx-buttons
         *   https://stackoverflow.com/questions/4619899/difference-between-a-views-padding-and-margin
         *   https://examples.javacodegeeks.com/desktop-java/javafx/javafx-css-tutorial/
         *   https://www.vojtechruzicka.com/javafx-css/ (setting classes)
         *   https://stackoverflow.com/questions/30273020/style-pressed-button-in-javafx (when clicked)
         */
        scene.getStylesheets().add(getClass().getResource("GenSel.css").toExternalForm());

        primaryStage.setScene(scene);
        //fix the screen size
        primaryStage.setMinHeight(393);
        primaryStage.setMaxHeight(393);
        primaryStage.setMinWidth(512);
        primaryStage.setMaxWidth(512);
        //show
        primaryStage.show();

    }
}
