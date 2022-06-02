/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 * <p>
 * Version 1 - 05.30.2022
 * <p>
 * Real code that moves the character around a console/screen
 *
 * @version 05.30.22
 * @author Artemis Chen
 */
package com.latter.thelatter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class MovementTest extends Application {

    /** code taken and adapted from
     * <a href="https://gist.github.com/jewelsea/8321740">Response to a questions about sprite movement</a> (01/08/2013)
     * <a href="https://zetcode.com/javagames/movingsprites/">Moving sprites</a>
     */


    /**
     * The length of the screen
     */
    final int LENGTH = 512;
    /**
     * The width of the screen
     */
    final int WIDTH = 393;

    /**
     * The sprite
     */
    ImageView player;

    ImageView background;

    private int locX, locY, velocityX, velocityY;

    private boolean up, down, left, right;

    private Scene scene;

    private int speed = 5;

    /**
     * Main method to run the 'start' method
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * This method draws and makes a screen that contains a movable sprite
     *
     * @param primaryStage The stage that contains and draws sprites
     * @throws Exception Prevents crashes
     */

    public void start(Stage primaryStage) throws Exception {
        //sets up the console and the screen
        primaryStage.setTitle("Movement test");

        FileInputStream bg = new FileInputStream("room 1.png");
        Image a1 = new Image(bg);
        background = new ImageView(a1);

        FileInputStream playerImage = new FileInputStream("player.png");
        Image image = new Image(playerImage);
        player = new ImageView(image);
        Group group = new Group(background);

        scene = new Scene(group, LENGTH, WIDTH);
        group.getChildren().add(player);


        //moves the character when the correct key is pressed
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                velStart(keyEvent);
                setVelocity();
            }
        });

        //stops the character when the correct key is released
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement();
            }
        };
        timer.start();
    }

    /**
     * Sets the movement speed when the correct key is pressed
     *
     * @param e The key pressed
     */

    public void velStart(KeyEvent e) {
        //sets the correct velocity
        switch (e.getCode()) {
            case W:
                up = true;
                break;
            case S:
                down = true;
                break;
            case A:
                left = true;
                break;
            case D:
                right = true;
                break;
        }
    }

    /**
     * Resets the movement speed back to 0 when key is released
     *
     * @param e The key released
     */

    public void velStop(KeyEvent e) {
        //resets velocity
        switch (e.getCode()) {
            case W:
                up = false;
                velocityY = 0;
                break;
            case S:
                down = false;
                velocityY = 0;
                break;
            case A:
                left = false;
                velocityX = 0;
                break;
            case D:
                right = false;
                velocityX = 0;
                break;
        }
    }

    public void setVelocity() {
        if (up) velocityY = -speed;
        if (down) velocityY = speed;
        if (right) velocityX = speed;
        if (left) velocityX = -speed;
    }

    /**
     * Moves the character
     */

    public void movement() {
        //ensures in bounds (not fully working)
        if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 /*subtract character width*/
                && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55 /*subtract character length*/)
            player.relocate(locX += velocityX, locY += velocityY);
    }
}
