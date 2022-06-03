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
import java.io.FileInputStream;
import java.io.*;

public class Boss extends Application{

    public void start (Stage primaryStage) throws Exception{
        //making console
        primaryStage.setTitle("Boss' Room");

        //adding image to background of console
        ImageView imageView = new ImageView();
        try {
            FileInputStream input = new FileInputStream("Boss.png");
            Image image = new Image(input);
            imageView.setImage(image);
        } catch (IOException e) {}

        //adding buttons and image to hbox to display
        StackPane sp = new StackPane();
        sp.getChildren().addAll(imageView);
        HBox root = new HBox();
        root.getChildren().add(sp);

        Scene scene = new Scene(root, 512, 393);
        primaryStage.setScene (scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}