/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva V.
 *
 * Version 1 - 05.27.2022
 *
 * Version 2 - 06.03.2022
 *
 * Version 3 - 06.09.2022
 * Added the pop-up screen when first entering the room
 *
 * @version 06.10.2022
 * @author Alicia Chung & Artemis Chen
 */

package com.latter.thelatter;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Classroom{

    /*
        Variable Name   Type        Description
        background       ImageView   The background of the scene
        player           ImageView   The player
        enterFunc        ImageView   The first entrance to the classroom
        enterFunc2       ImageView   The second entrance to the classroom
        viewFunc         ImageView   View the fact pop up
        f1               ImageView   Fact 1
        f2               ImageView   Fact 2
        f3               ImageView   Fact 3
        f4               ImageView   Fact 4
     */

    /** code taken and adapted from
     * <a href="https://gist.github.com/jewelsea/8321740">Response to a questions about sprite movement</a> (01/08/2013)
     * <a href="https://zetcode.com/javagames/movingsprites/">Moving sprites</a>
     */

    /**
     * The background of the scene
     */
    ImageView background = new ImageView();

    /**
     * The player
     */
    ImageView player = new ImageView();

    /**
     * The first entrance to the classroom
     */
    ImageView enterFunc = new ImageView();

    /**
     * The second entrance to the classroom
     */
    ImageView enterFunc2 = new ImageView();

    /**
     * The second pop up instruction screen
     */
    ImageView instructions2 = new ImageView();
    /**
     * View the fact pop up
     */
    ImageView viewF = new ImageView();
    // fact screens
    /**
     * Fact 1
     */
    ImageView f1 = new ImageView();
    /**
     * Fact 2
     */
    ImageView f2 = new ImageView();
    /**
     * Fact 3
     */
    ImageView f3 = new ImageView();
    /**
     * Fact 4
     */
    ImageView f4 = new ImageView();

    /**
     * Constructor for the classroom
     * @return the group of the classroom
     */
    public Group classR () {
        Group group = new Group();
        try {
            // add background
            FileInputStream bg = new FileInputStream("Class.png");
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
            FileInputStream instruc = new FileInputStream("part 2.png");
            Image i = new Image(instruc);
            instructions2 = new ImageView(i);
            FileInputStream img = new FileInputStream("view button.png");
            image = new Image(img);
            viewF.setImage(image);
            //fact dump
            img = new FileInputStream("education 1.png");
            image = new Image(img);
            f1.setImage(image);
            img = new FileInputStream("education 2.png");
            image = new Image(img);
            f2.setImage(image);
            img = new FileInputStream("education 3.png");
            image = new Image(img);
            f3.setImage(image);
            img = new FileInputStream("education 4.png");
            image = new Image(img);
            f4.setImage(image);

            // positioning enters
            group.getChildren().add(enterFunc);
            enterFunc.setVisible(false);
            enterFunc.setX(0);
            enterFunc.setY(-5);
            group.getChildren().add(enterFunc2);
            enterFunc2.setVisible(false);
            enterFunc2.setX(412);
            enterFunc2.setY(364);


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

            instructions2.setVisible(true);
            instructions2.setX(12);
            instructions2.setY(12);
            group.getChildren().add(instructions2);

        } catch (IOException e){

        }

        System.out.println("in classroom " + group.getChildren().toString());
        System.out.println();
        return group;
    }

    /**
     * Method to turn off the pop up screen
     */
    public void setInsOff() {
        instructions2.setVisible(false);
    }

    /**
     * method to show the facts
     * @param fact
     */
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
            default:
                f1.setVisible(false);
                f2.setVisible(false);
                f3.setVisible(false);
                f4.setVisible(false);
                break;
        }
    }
}
