/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 * <p>
 * Version 1 - 05.30.2022
 * Created working code for movement, however it is not smooth
 *
 * Version 2 - 05.30.2022
 * Made the movement fluid and 8 directional
 * <p>
 * Real code that moves the character around a console/screen
 *
 * @version 05.30.22
 * @author Artemis Chen and Alicia Chung
 */
package com.latter.thelatter;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Workplace{

    /** code taken and adapted from
     * <a href="https://gist.github.com/jewelsea/8321740">Response to a questions about sprite movement</a> (01/08/2013)
     * <a href="https://zetcode.com/javagames/movingsprites/">Moving sprites</a>
     */

    ImageView background = new ImageView();
    ImageView player = new ImageView();
    ImageView enterFunc = new ImageView();
    ImageView enterFunc2 = new ImageView();

    public Group office () {
        Group group = new Group();
        try {
            // add background
            FileInputStream bg = new FileInputStream("room 1.png");
            Image a1 = new Image(bg);
            background = new ImageView(a1);
            group.getChildren().add(background);
            // other graphics
            FileInputStream playerImage = new FileInputStream("player.png");
            Image image = new Image(playerImage);
            player.setImage(image);
            FileInputStream ent = new FileInputStream("enter button.png");
            Image p = new Image(ent);
            enterFunc.setImage(p);
            FileInputStream ent2 = new FileInputStream("enter button.png");
            Image p2 = new Image(ent2);
            enterFunc2.setImage(p2);
                
            group.getChildren().add(enterFunc);
            enterFunc.setVisible(false);
            enterFunc.setX(57);
            enterFunc.setY(0);

            group.getChildren().add(player);
            player.setX(237);
            player.setY(300);

        } catch (IOException e){

        }

        return group;
    }


}
