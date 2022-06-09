package com.latter.thelatter;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;

public class Principal{

    ImageView background = new ImageView();
    ImageView player = new ImageView();
    ImageView enterFunc = new ImageView();
    ImageView enterFunc2 = new ImageView();

    public Group pOffice(){
        Group group = new Group();
        try{
            // add background
            FileInputStream input = new FileInputStream("prl.png");
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
            enterFunc2.setX(412);
            enterFunc2.setY(364);

            // adding player to screen
            group.getChildren().add(player);
            player.relocate(20, 330);

        } catch (IOException e){
        }

        return group;
    }

}
