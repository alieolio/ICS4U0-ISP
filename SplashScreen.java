/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 * Version 1 - 05.27.22
 * Added the image for the splashscreen and a loading bar
 *
 * @version 05.27.22 - 1
 * @author Alicia Chung
 */
package com.latter.thelatter;

import javafx.application.Application;
import javafx.application.Preloader;

import javafx.scene.*;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.stage.Stage;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

/**
 * <a href="https://docs.oracle.com/javafx/2/deployment/preloaders.htm site </a> 
 */
public class SplashScreen extends Application {
    Stage stage;
    ProgressBar bar;
    public ImageView imageView;
    public Image image;

    private Scene createPreloaderScene() throws FileNotFoundException {
        bar = new ProgressBar();
        FileInputStream input = new FileInputStream("splash.png");
        image = new Image(input);
        imageView = new ImageView(image);
        BorderPane p = new BorderPane();

        p.getChildren().add(imageView);
        p.setBottom(bar);

        return new Scene(p, 1024, 786);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Splash Screen");
        stage.setScene(createPreloaderScene());
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}