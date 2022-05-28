/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 * <p>
 * Version 1 - 05.27.2022
 * This code is reference and will most likely not be used in the final game.
 * The code is used to gain a further understanding of how to create character movement.
 * A new but similar movement system will likely be implemented in the future
 *
 * @version 05.27.22
 * @author Artemis Chen
 */
package com.latter.thelatter;

import javafx.animation.AnimationTimer;
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

public class Movement extends Application {

    /** code taken and adapted from <a href="https://gist.github.com/jewelsea/8321740">Response to a questions about sprite movement</a> (01/08/2013)*/

    /**
     * The length of the screen
     */
    final int LENGTH = 512;
    /**
     * The width of the screen
     */
    final int WIDTH = 393;
    /**
     * Determines the direction to move the sprite
     */
    private boolean up, down, left, right;
    /**
     * The sprite
     */
    Node player;

    /**
     * This method draws and makes a screen that contains a movable sprite
     *
     * @param primaryStage The stage that contains and draws sprites
     * @throws Exception Prevents crashes
     */

    public void start(Stage primaryStage) throws Exception {
        //making console
        primaryStage.setTitle("Movement test");

        //adding image to background of console
//        FileInputStream background = new FileInputStream("room 1.png");
//        Image image = new Image(background);
//        ImageView imageView = new ImageView(image);
//
//
//        Group test = new Group(imageView);

        FileInputStream playerImage = new FileInputStream("player.png");
        Image a1 = new Image(playerImage);
        player = new ImageView(a1);

        Group t2 = new Group(player);

        moveHeroTo(LENGTH / 2, WIDTH / 2);

        Scene scene = new Scene(t2, LENGTH, WIDTH, RED);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        up = true;
                        break;
                    case DOWN:
                        down = true;
                        break;
                    case LEFT:
                        left = true;
                        break;
                    case RIGHT:
                        right = true;
                        break;
                }
            }
        });


        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        up = false;
                        break;
                    case DOWN:
                        down = false;
                        break;
                    case LEFT:
                        left = false;
                        break;
                    case RIGHT:
                        right = false;
                        break;
                }
            }
        });


        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int len = 0, wid = 0;

                if (up) wid -= 10;
                if (down) wid += 10;
                if (right) len += 10;
                if (left) len -= 10;

                moveHeroBy(len, wid);
            }
        };
        timer.start();
    }

    /**
     * This method determines the amount to move the characters by
     *
     * @param dx the amount to move the character horizontally
     * @param dy the amount to move the character vertically
     */

    private void moveHeroBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = player.getBoundsInLocal().getWidth() / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        double x = cx + player.getLayoutX() + dx;
        double y = cy + player.getLayoutY() + dy;

        moveHeroTo(x, y);
    }

    /**
     * This method moves the character
     *
     * @param x x coordinate on screen
     * @param y y coordinate on screen
     */

    private void moveHeroTo(double x, double y) {
        final double cx = player.getBoundsInLocal().getWidth() / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= LENGTH &&
                y - cy >= 0 &&
                y + cy <= WIDTH) {
            player.relocate(x - cx, y - cy);
        }
    }

    /**
     * Main method to run the 'start' method
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
