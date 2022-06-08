/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 wit Krasteva V.
 *
 * <p>
 * Version 1 - 05.30.2022
 * Created working code for movement, however it is not smooth
 * </p>
 *
 * <p>
 * Version 2 - 05.30.2022
 * Made the movement fluid and 8 directional
 * </p>
 *
 * <p>
 * Version 3 - 06.6.2022
 * Trial collision code added to movement (doesn't work)
 * </p>
 *
 * <p>
 * Version 4 - 06.7.2022
 * Finished collision (now fully functional)
 * </p>
 *
 * <p>
 * Real code that moves the character around a console/screen
 * </p>
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
import javafx.scene.shape.Rectangle;
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

    /**
     * The background
     */
    ImageView background;

    ImageView enterFunc;
    ImageView enterFunc2;
    ImageView instructions1;

    /**
     * Location of the sprite
     */
    private int locX, locY;

    /**
     * Velocity of the sprite
     */
    private int velocityX, velocityY;

    /**
     * Direction of the movement
     */
    private boolean up, down, left, right;
    private boolean check = true;

    /**
     * Speed of the sprite
     */
    private final int SPEED = 5;

    /**
     * Environment of the screen
     */
    private Scene scene;

    /**
     * Debug variables
     */
    int a = 62, b = 68, c = 179, d=183;

    /**
     * Hit box of the sprite
     */
    Rectangle rectangle = new Rectangle(26, 25);

    /**
     * Debug rectangle for checking hit box
     */
    Rectangle checker = new Rectangle(a, b, c, d);

    /**
     * Ability to move in a certain direction
     */
    private boolean canMoveUp = true, canMoveDown = true, canMoveLeft = true, canMoveRight = true;

    /**
     * Remembering a collision
     */
    private boolean collided;

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

        //creates background
        FileInputStream bg = new FileInputStream("room 1.png");
        Image a1 = new Image(bg);
        background = new ImageView(a1);

        //creates sprite
        FileInputStream playerImage = new FileInputStream("player.png");
        Image image = new Image(playerImage);
        player = new ImageView(image);

        //creates group containing background and hit boxes
        Group group = new Group(background);
        group.getChildren().add(rectangle);
        group.getChildren().add(checker);


//added stuff start --------------------------------------------------------------------
//        FileInputStream ent = new FileInputStream("enter button.png");
//        Image p = new Image(ent);
//        enterFunc = new ImageView(p);
//        enterFunc.setVisible(false);
//        enterFunc.setX(57);
//        enterFunc.setY(0);

//        FileInputStream ent2 = new FileInputStream("enter2.png");
//        Image p2 = new Image(ent2);
//        enterFunc2 = new ImageView(p2);
//        enterFunc2.setVisible(false);
//        enterFunc2.setX(206);
//        enterFunc2.setY(368);
//
//        FileInputStream instruc = new FileInputStream("part 1.png");
//        Image i = new Image(instruc);
//        instructions1 = new ImageView(i);
//        instructions1.setVisible(check);
//        instructions1.setX(12);
//        instructions1.setY(12);
        //added stuff end --------------------------------------------------------------------

        //creates scene and adds sprite to group
        scene = new Scene(group, LENGTH, WIDTH);
        group.getChildren().add(player);

//        group.getChildren().add(enterFunc);
//        group.getChildren().add(enterFunc2);
//        group.getChildren().add(instructions1);


        //activates movement
        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                velStart(keyEvent);
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

        //runs the scene
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                movement();
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
        //sets the movement variables to true if possible
        switch (e.getCode()) {
            case W:
                if (canMoveUp) {
                    up = true;
                    canMoveDown = true;
                }
                break;
            case S:
                if (canMoveDown) {
                    down = true;
                    canMoveUp = true;
                }
                break;
            case A:
                if (canMoveLeft) {
                    left = true;
                    canMoveRight = true;
                }
                break;
            case D:
                if (canMoveRight) {
                    right = true;
                    canMoveLeft = true;
                }
                break;
        }
    }

    /**
     * Resets the movement SPEED back to 0 when key is released
     *
     * @param e The key released
     */

    public void velStop(KeyEvent e) {
        //sets movement variables to false
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

    /**
     * Changes the velocity of the sprite either left, right, up, or down
     */

    public void setVelocity() {
        if (up) velocityY = -SPEED;
        if (down) velocityY = SPEED;
        if (right) velocityX = SPEED;
        if (left) velocityX = -SPEED;
    }

    /**
     * Stops the velocity of the sprite
     */

    public void stopVelocity() {
        if (!up) velocityY = 0;
        if (!down) velocityY = 0;
        if (!left) velocityX = 0;
        if (!right) velocityX = 0;
    }

    /**
     * Moves the character
     */

    public void movement() {
        //ensures that the sprite is in bounds
        if ((up || down || left || right))
            if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55) {
                //detects collision and prevents sprite from moving if there is collision
                collision(62, 68, 179, 183);
                //moves sprite
                player.relocate(locX += velocityX, locY += velocityY);
                //moves the hit box of sprite
                rectangle.setX(locX + 5);
                rectangle.setY(locY + 43);
            }

        //moves the sprite back in bounds if it ever exits
        if (locX + velocityX <= -15) {
            player.relocate(locX += 5, locY);
        }
        if (locX + velocityX >= LENGTH - 20) {
            player.relocate(locX -= 5, locY);
        }
        if (locY + velocityY <= -15) {
            player.relocate(locX, locY += 5);
        }
        if (locY + velocityY >= WIDTH - 55) {
            player.relocate(locX, locY -= 5);
        }

        //added stuff start ------------------------------------------------------------------
//        if((locX >= 58 && locX <=157) && (locY >=-50 && locY<=21)) {
//            enterFunc.setVisible(true);
//        }else {
//            enterFunc.setVisible(false);
//        }
//        if((locX >= 207 && locX <=306) && (locY >=323 && locY<=343)) {
//            enterFunc2.setVisible(true);
//        }else {
//            enterFunc2.setVisible(false);
//        }
//        if(check == false) {
//            instructions1.setVisible(false);
//        }
        //added stuff end --------------------------------------------------------------------
    }

    public void ins(KeyEvent e) {
        if (e.getCode().isLetterKey()) {
            check = false;
        }
    }

    /**
     * Detects if the sprite hit box collides with the boundaries specified
     *
     * @param x x coordinate
     * @param y y coordinate
     * @param width width
     * @param height height
     */

    public void collision(int x, int y, int width, int height) {
        //creates rectangle that serves as hit box
        Rectangle bounds = new Rectangle(x, y, width, height);

        //if the sprite hit box intersects with this hit box and there is not already a collision
        if (rectangle.getBoundsInParent().intersects(bounds.getBoundsInParent()) && !collided) {
            collided = true;

            //sets the side that collided to false
            if (up) {
                up = false;
                canMoveUp = false;
            }
            if (down) {
                down = false;
                canMoveDown = false;
            }
            if (left) {
                left = false;
                canMoveLeft = false;
            }
            if (right) {
                right = false;
                canMoveRight = false;
            }
        }
        setVelocity();

        //resets the movement when un-collided
        if (!rectangle.intersects(x, y, width, height)) {
            canMoveUp = true;
            canMoveDown = true;
            canMoveLeft = true;
            canMoveRight = true;
            collided = false;
        }
    }
}
