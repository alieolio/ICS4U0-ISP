/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 * <p>
 * Version 1 - 05.30.2022
 * Created working code for movement, however it is not smooth
 * <p>
 * Version 2 - 05.30.2022
 * Made the movement fluid and 8 directional
 * <p>
 * Version 3 - 06.6.2022
 * Trial collision code added to movement (doesn't work)
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

    private final int SPEED = 5;

    private boolean movement = true;

    private int[] position = {0, 35, 0, 70};

    private int direction;

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

        Scene scene = new Scene(group, LENGTH, WIDTH);
        group.getChildren().add(player);


        //moves the character when the correct key is pressed
        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                velStart(keyEvent);
                setVelocity();

            }
        });

        //stops the character when the correct key is released
        scene.setOnKeyReleased(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                velStop(keyEvent);
                stopVelocity();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement(movement); 
            }
        };
        timer.start();
    }

    /**
     * Sets the movement SPEED when the correct key is pressed
     *
     * @param e The key pressed
     */

    public void velStart(KeyEvent e) {
        //sets the correct velocity

        collision(150, 150, 150, 150);


        switch (e.getCode()) {
            case W:
                if (!collision && oppUp) up = true;
                break;
            case S:
                if (!collision && oppDown) down = true;
                break;
            case A:
                if (!collision && oppLeft) left = true;
                break;
            case D:
                if (!collision && oppRight) right = true;
                break;
        }

        if (up) direction = 1;
        else if (down) direction = 2;
        else if (left) direction = 3;
        else if (right) direction = 4;
    }

    /**
     * Resets the movement SPEED back to 0 when key is released
     *
     * @param e The key released
     */

    public void velStop(KeyEvent e) {
        //resets velocity
        switch (e.getCode()) {
            case W:
                up = false;
                break;
            case S:
                down = false;
                break;
            case A:
                left = false;
                break;
            case D:
                right = false;
                break;
        }
    }

    public void setVelocity() {
        if (up) velocityY = -SPEED;
        if (down) velocityY = SPEED;
        if (right) velocityX = SPEED;
        if (left) velocityX = -SPEED;
    }

    public void stopVelocity() {
        if (!up) velocityY = 0;
        if (!down) velocityY = 0;
        if (!left) velocityX = 0;
        if (!right) velocityX = 0;
    }

    /**
     * Moves the character
     */

    public void movement(boolean m) {
        //ensures in bounds (not fully working)
        if (m)
            if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 /*subtract character width*/
                    && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55 /*subtract character length*/) {
                player.relocate(locX += velocityX, locY += velocityY);
                position[0] += velocityX;
                position[1] += velocityX;
                position[2] += velocityY;
                position[3] += velocityY;
            }
        for (int i : position)
            System.out.print(i + " ");
        System.out.println();
    }

    public void collision(int x, int y, int length, int width) {
//        switch (e.getCode()) {
//            case W:
//                int futurePosTop = (position[2] - SPEED);
//                int futurePosTop1 = (position[3] - SPEED);
//                if ((colYBottom <= futurePosTop || colXBottom <= futurePosTop1)&&
//                        (colYTop >= futurePosTop || colYTop >= futurePosTop1))
//                    movement = false;
//                collision = true;
//
//                if ((colYBottom <= futurePosTop || colXBottom <= futurePosTop1)&&
//                        (colYTop >= futurePosTop || colYTop >= futurePosTop1))
//                    movement = false;
//                break;
//            case S:
////                int futurePosBottom = (position[2] - SPEED);
////                int futurePosBottom1 = (position[3] - SPEED);
////                if (colYBottom <= futurePosBottom || colXBottom <= futurePosBottom1)
////                    down = false;
////                collision = true;
//                break;
//            case A:
//                break;
//            case D:
//                break;
//        }

        int futureLeft = (position[0] - SPEED);
        int futureRight = (position[1] - SPEED);
        int futureTop = (position[2] - SPEED);
        int futureBottom = (position[3] - SPEED);

//        if (((futurePosBottomRight > y|| futurePosBottomLeft > y) ) && ((futurePosBottomRight  < y + width|| futurePosBottomLeft < y + width)))
//            movement = false;

//general statement
//        if ((futureRight > x) && (futureLeft < x + length) && (futureBottom > y) && (futureTop < y + width))
//            movement = false;

        //top collision
//        if (((futureRight > x) && (futureLeft < x + length) && (futureBottom > y)) && (down)) {
//            down = false;
//            stopVelocity();
//        }

        //bottom collision
//        if (((futureRight > x) && (futureLeft < x + length) && (futureTop < y + width)) && (up)) {
//            up = false;
//            stopVelocity();
//        }

        boolean inBounds = (futureRight > x) && (futureLeft < x + length) && (futureBottom > y) && (futureTop < y + width);

        //use switch statement to reactivate movement in certain directions. ie if the direction is 1 then allow left right down to work

        //change where the collision detection is

        int blocked;

        if (!collision) {
            switch (direction) {
                case 1:
                    opposite();
                    if (inBounds && up) {
                        collisionStop();
                        collision = true;
                        oppUp = false;
                        up = false;
//                    velocityY = 0;
                    }
                    break;
                case 2:
                    opposite();
                    if (inBounds && down) {
                        collisionStop();
                        collision = true;
                        oppDown = false;
                        down = false;
//                    velocityY = 0;
                    }
                    break;
                case 3:
                    opposite();
                    if (inBounds && left) {
                        left = false;
                        collisionStop();
                        collision = true;
                        oppLeft = false;
//                    velocityX = 0;
                    }
                    break;
                case 4:
                    opposite();
                    if (inBounds && right) {
                        right = false;
                        collisionStop();
                        collision = true;
                        oppRight = false;
//                    velocityX = 0;
                    }
                    break;
            }
        } else if (collision) {
//            if (!up) {
//                if (inBounds) up = false;
//                else up = true;
//                setVelocity();
//                collision = false;
//            }
            switch (direction) {
                case 1:
                    opposite();
                    if (inBounds && !up) {
                        setVelocity();
                        collision = false;
                        oppUp = true;
                        up = true;
//                    velocityY = 0;
                        break;
                    }
                case 2:
                    opposite();
                    if (inBounds && !down) {
                        setVelocity();
                        collision = false;
                        oppDown = true;
                        down = true;
//                    velocityY = 0;
                        break;
                    }
                case 3:
                    opposite();
                    if (inBounds && !left) {
                        setVelocity();
                        collision = false;
                        oppLeft = true;
                        left = true;
//                    velocityX = 0;
                        break;
                    }
                case 4:
                    opposite();
                    if (inBounds && !right) {
                        setVelocity();
                        collision = false;
                        oppRight = true;
                        right = true;
//                    velocityX = 0;
                        break;
                    }
            }
        }


//bottom left or bottom right between top left and top right and

    }

    private void collisionStop() {
        if (!up) velocityY = 0;
        else if (!down) velocityY = 0;
        else if (!left) velocityX = 0;
        else if (!right) velocityX = 0;
    }

    boolean oppUp = true, oppDown = true, oppLeft = true, oppRight = true;

    public void opposite() {
//        if (up) {
//            oppDown = true;
//            oppUp = false;
//            if (collision) oppUp = true;
//            return;
//        }
//        if (down) {
//            oppUp = true;
//            oppDown = false;
//            if (collision) oppDown = true;
//            return;
//        }
//        if (left) {
//            oppRight = true;
//            oppLeft = false;
//            if (collision) oppLeft = true;
//            return;
//        }
//        if (right) {
//            oppLeft = true;
//            oppRight = false;
//            if (collision) oppRight = true;
//            return;
//        }
    }

    boolean collision = false;

    //public void;
}
