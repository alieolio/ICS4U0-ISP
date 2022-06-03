/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva V.
 *
 * Gender selection screen to choose the gender of your character
 * As of version 1.0.0, graphics are complete but other than the
 * garphics the buttons do not do anything.
 *
 * @version 1.0.0
 * @author Jessica Chen
 */
package com.latter.thelatter;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * TO-DO / NOTES
 *   • Hold value of gender selected, this has to be accessible
 *     other classes
 */

public class GenSelect{
   public VBox genSel(Button bc, Button bm, Button bw, Button bgq){
       /**
        * <a href="https://stackoverflow.com/questions/27912628/how-to-overlap-buttons-text-over-an-image-with-javafx-8 site </a> (01/12/2015)
        */
       StackPane sp = new StackPane();

       try{
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
           /** credits for <a href= "https://jenkov.com/tutorials/javafx/togglebutton.html"> ToggleButton </a> */
           bm.setGraphic(new ImageView(man));
           bm.setTranslateX(x);
           bm.setTranslateY(y);

           //middle button - 'woman' button
           bw.setGraphic(new ImageView(woman));
           bw.setTranslateX(x);
           bw.setTranslateY(y+15);

           //bottom button - 'gender queer' button
           bgq.setGraphic(new ImageView(gq));
           bgq.setTranslateX(x);
           bgq.setTranslateY(y+15+15);

           //bottom corner button - 'Enter' button
           bc.setGraphic(new ImageView(end));
           bc.setTranslateX(x+200);
           bc.setTranslateY(y+30);
           //disabled (to be enabled when a gender is selected)
           bc.setDisable(true);

           //stuff for buttons
           // choosing a gender
           // printing the gender is just for a visual cue
           // that you clicked the button
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
           
           sp.getChildren().addAll(iv, box);
       } catch (IOException e){
       }

       VBox vb = new VBox();
       vb.getChildren().add(sp);

       return vb;

       //Scene scene = new Scene(root, 512, 393);

       //get styles
       /**
        *   credits for everything learned about styles:
        *   <ul>
        *      <li href = "https://stackoverflow.com/questions/50210697/how-to-remove-the-rounded-corners-from-javafx-buttons"> Rectangular Buttons (2018) </li>
        *      <li href = "https://stackoverflow.com/questions/4619899/difference-between-a-views-padding-and-margin"> Make padding work with design (2011) </li>
        *      <li href = "https://examples.javacodegeeks.com/desktop-java/javafx/javafx-css-tutorial/"> CSS here and in a stylesheet (05/05/2016) </li>
        *      <li href = "https://www.vojtechruzicka.com/javafx-css/"> Setting Classes (10/10/2019) </li>
        *   </ul>
        */
       //scene.getStylesheets().add(getClass().getResource("GenSel.css").toExternalForm());
   }
}
