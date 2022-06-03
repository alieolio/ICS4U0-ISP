package com.latter.thelatter;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.IOException;

public class Instructions {
    public StackPane instr(Button b){
        StackPane sp = new StackPane();

        try{
            //get images
            FileInputStream input = new FileInputStream("instructions.png");
            Image image = new Image(input);
            input = new FileInputStream("instrback.png");
            Image back = new Image(input);

            //adding image to background of console
            ImageView iv = new ImageView(image);

            //button
            b.setGraphic(new ImageView(back));
            b.setTranslateX(195);
            b.setTranslateY(172);
            
            sp.getChildren().addAll(iv, b);
        } catch (IOException e){
        }

        return sp;
    }
}
