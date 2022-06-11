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

    /*
        Variable Name            Type                        Purpose
        background               ImageView                   Storing background image
        player                   ImageView                   Storing character
        enterFunc                ImageView                   Storing enter pop up for door 1
        enterFunc2               ImageView                   Storing enter pop up for door 2
        instructions1            ImageView                   Storing image for room instructions
        viewF                    ImageView                   Storing view pop up for facts/quizzes
        f1                       ImageView                   Storing image for fact
        f2                       ImageView                   Storing image for fact
        f3                       ImageView                   Storing image for fact
        f4                       ImageView                   Storing image for fact
        f5                       ImageView                   Storing image for fact
    */
    
    ImageView background = new ImageView();
    ImageView player = new ImageView();
    ImageView enterFunc = new ImageView();
    ImageView enterFunc2 = new ImageView();
    ImageView instructions1 = new ImageView();
    ImageView viewF = new ImageView();
    // fact screens
    ImageView f1 = new ImageView();
    ImageView f2 = new ImageView();
    ImageView f3 = new ImageView();
    ImageView f4 = new ImageView();
    ImageView f5 = new ImageView();

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
            FileInputStream instruc = new FileInputStream("part 1.png");
            Image i = new Image(instruc);
            instructions1 = new ImageView(i);
            FileInputStream img = new FileInputStream("view button.png");
            image = new Image(img);
            viewF.setImage(image);
            //fact dump
            img = new FileInputStream("workplace 1.png");
            image = new Image(img);
            f1.setImage(image);
            img = new FileInputStream("workplace 2.png");
            image = new Image(img);
            f2.setImage(image);
            img = new FileInputStream("workplace 3.png");
            image = new Image(img);
            f3.setImage(image);
            img = new FileInputStream("workplace 4.png");
            image = new Image(img);
            f4.setImage(image);
            img = new FileInputStream("workplace 5.png");
            image = new Image(img);
            f5.setImage(image);

            // positioning enter
            group.getChildren().add(enterFunc);
            enterFunc.setVisible(false);
            enterFunc.setX(57);
            enterFunc.setY(0);

            // view facts notice
            group.getChildren().add(viewF);
            viewF.setVisible(false);
            viewF.relocate(0, 0);

            // adding player to screen
            group.getChildren().add(player);
            player.setX(237);
            player.setY(300);

            // facts to scren
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

            instructions1.setVisible(true);
            instructions1.setX(12);
            instructions1.setY(12);
            group.getChildren().add(instructions1);

        } catch (IOException e){

        }

        System.out.println("in workplace " + group.getChildren().toString());
        System.out.println();
        return group;
    }

    public void setInsOff() {
        instructions1.setVisible(false);
    }
    public void showF (int fact){
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

