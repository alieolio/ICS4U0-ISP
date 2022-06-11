package com.latter.thelatter;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import java.io.FileInputStream;
import java.io.IOException;

public class Ladder{
    /*
        Variable Name            Type                        Purpose
        background               ImageView                   Setting the background image of the ladder room
        player                   ImageView                   Storing the image of the player (character)
        enterFunc                ImageView                   Storing the image for pop up image that tells user how to enter a room
        enterFunc2               ImageView                   Storing the image for pop up image that tells user how to enter a room (different coordinates to enterFunc)
         */
    ImageView background = new ImageView();
    ImageView player = new ImageView();
    ImageView enterFunc = new ImageView();
    ImageView enterFunc2 = new ImageView();

    public Group room(){
        Group group = new Group();
        try{
            // add background
            FileInputStream input = new FileInputStream("ldr.png");
            Image image = new Image(input);
            background.setImage(image);
            group.getChildren().add(background);
            // other graphics
            FileInputStream playerImage = new FileInputStream("player.png");
            image = new Image(playerImage);
            player.setImage(image);
            FileInputStream ent = new FileInputStream("enter button.png");
            Image p = new Image(ent);
            enterFunc.setImage(p);
            FileInputStream ent2 = new FileInputStream("enter button.png");
            Image p2 = new Image(ent2);
            enterFunc2.setImage(p2);

            // positioning enters
            group.getChildren().add(enterFunc);
            enterFunc.setVisible(false);
            enterFunc.setX(0);
            enterFunc.setY(364);

            group.getChildren().add(enterFunc2);
            enterFunc2.setVisible(false);
            enterFunc2.setX(30);
            enterFunc2.setY(10);

            // adding player to screen
            group.getChildren().add(player);
            player.relocate(20, 330);

        } catch (IOException e){
        }

        return group;
    }

}
