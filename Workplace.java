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
    ImageView viewF = new ImageView();
    // fact screens
    ImageView f1 = new ImageView();
    ImageView f2 = new ImageView();
    ImageView f3 = new ImageView();
    ImageView f4 = new ImageView();
    ImageView f5 = new ImageView();

    /**
     * Debug variables
     */
    int a = 62, b = 68, c = 179, d=183;

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
            FileInputStream img = new FileInputStream("view_button.png");
            image = new Image(img);
            viewF.setImage(image);
            img = new FileInputStream("facts and questions/workplace 1.png");
            image = new Image(img);
            f1.setImage(image);
            img = new FileInputStream("facts and questions/workplace 2.png");
            image = new Image(img);
            f2.setImage(image);
            img = new FileInputStream("facts and questions/workplace 3.png");
            image = new Image(img);
            f3.setImage(image);
            img = new FileInputStream("facts and questions/workplace 4.png");
            image = new Image(img);
            f4.setImage(image);
            img = new FileInputStream("facts and questions/workplace 5.png");
            image = new Image(img);
            f5.setImage(image);



            group.getChildren().add(enterFunc);
            enterFunc.setVisible(false);
            enterFunc.setX(57);
            enterFunc.setY(0);

            group.getChildren().add(viewF);
            viewF.setVisible(false);
            viewF.relocate(0, 0);

            group.getChildren().add(player);
            player.setX(237);
            player.setY(300);

            group.getChildren().add(f1);
            f1.setVisible(false);
            f1.relocate(12, 12);
            group.getChildren().add(f2);
            f2.setVisible(false);
            f2.relocate(12, 12);
            group.getChildren().add(f3);
            f3.setVisible(false);
            f3.relocate(12, 12);
            group.getChildren().add(f4);
            f4.setVisible(false);
            f4.relocate(12, 12);
            group.getChildren().add(f5);
            f5.setVisible(false);
            f5.relocate(12, 12);


        } catch (IOException e){

        }

        return group;
    }
                
    public void showF (int fact, boolean check){
        switch (fact){
            case 1:
                f1.setVisible(true);
                break;
            case 2:
                f2.setVisible(true);
                break;
            case 3:
                f3.setVisible(true);
                break;
            case 4:
                f4.setVisible(true);
                break;
            case 5:
                f5.setVisible(true);
                break;
            default:
                f1.setVisible(false);
                f2.setVisible(false);
                f3.setVisible(false);
                f4.setVisible(false);
                f5.setVisible(false);
                break;
        }    
    }
}
