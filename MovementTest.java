/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 * <p>
 * Version 1 - 05.30.2022
 *
 * Real code that moves the character around a console/screen
 *
 * @version 05.30.22
 * @author Artemis Chen
 */
package com.latter.thelatter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;

import static javafx.scene.paint.Color.RED;

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
    Node player;

    private int locX, locY, velocityX, velocityY;

    private boolean moving;

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

        FileInputStream playerImage = new FileInputStream("player.png");
        Image a1 = new Image(playerImage);
        player = new ImageView(a1);
        Group t2 = new Group(player);

        Scene scene = new Scene(t2, LENGTH, WIDTH, RED);

        //moves the character when the correct key is pressed
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                velStart(keyEvent);
                movement();
            }
        });

        //stops the character when the correct key is released
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
                movement();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
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
                velocityY = -10;
                break;
            case S:
                velocityY = 10;
                break;
            case A:
                velocityX = -10;
                break;
            case D:
                velocityX = 10;
                break;
        }
    }

    /**
     *
     * Resets the movement speed back to 0 when key is released
     *
     * @param e The key released
     */

    public void velStop(KeyEvent e) {
        //resets velocity
        switch (e.getCode()) {
            case W:
                velocityY = 0;
                break;
            case S:
                velocityY = 0;
                break;
            case A:
                velocityX = 0;
                break;
            case D:
                velocityX = 0;
                break;
        }
    }

//    public boolean startMoving() {
//        if (KeyEvent.KEY_PRESSED.equals(true))
//            return true;
//        return false;
//    }

    /**
     *
     * Moves the character
     *
     */

    public void movement() {
//        if (startMoving())
        //ensures in bounds (not fully working)
            if (locX + velocityX >= 0 && locX + velocityX <= LENGTH /*subtract character width*/
                    && locY + velocityY >= 0 && locY + velocityY <= WIDTH /*subtract character length*/)
                player.relocate(locX += velocityX, locY += velocityY);
    }
}