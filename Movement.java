package com.latter.thelatter;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.io.FileInputStream;

public abstract class Movement extends Application{

    final int LENGTH = 512;
    final int WIDTH = 393;
    private boolean up, down, left, right;
    private int speed = 5;
    int velocityX, velocityY;
    int locX = 237, locY = 305;

    private boolean check = true;
    boolean factCheck = false;
    boolean clear = false;
    int bu = 0;
    int oc = 0;

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
     * Sets the movement speed when the correct key is pressed
     *
     * @param e The key pressed
     */
    public int velStart(KeyEvent e) {
        //sets movement variables to true if possible
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
            case E:
                return 0;
            case V:
                return 1;
        }
        return -1;
    }

    /**
     * Resets the movement speed back to 0 when key is released
     *
     * @param e The key released
     */

    public void velStop(KeyEvent e) {
        //sets movement variables to false
        factCheck = false;
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
            case V:
                oc = 0;
                factCheck = true;
                break;
        }
    }

    /**
     * Changes the velocity of the sprite either left, right, up, or down
     */
    public void setVelocity() {
        if (up) velocityY = -speed;
        if (down) velocityY = speed;
        if (right) velocityX = speed;
        if (left) velocityX = -speed;
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

    public void ins(KeyEvent e) {
        if (e.getCode().isLetterKey()) {
            check = false;
        }
    }


    /* I•M•P•O•R•T•A•N•T MOVEMENT STUFF------------- */
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

    /**
     * Moves the character
     */
    public void movement(int room, ImageView player, ImageView enterFunc, ImageView enterFunc2, ImageView viewF) {

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
        // figuring out where stuff is
        System.out.println(locX + " " + locY);

        // coordinates for button exit hovering
        int x11 = 0;
        int x12 = 0;
        int y11 = 0;
        int y12 = 0;
        int x21 = 0;
        int x22 = 0;
        int y21 = 0;
        int y22 = 0;
        switch(room){
            case 1:
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
                // fact things
                System.out.println(oc);
                if((locX>=340 && locX<=380) && (locY>=328 && locY<360)) {
                //first fact -> smallest couch thing
                    viewF.relocate(310, 295);
                    viewF.setVisible(true);
                    oc = 1;
                } else if((locX>=437 && locX<=512) && (locY>=95 && locY<=150)) {
                // second fact -> behind couch
                    viewF.relocate(436, 95);
                    viewF.setVisible(true);
                    oc = 2;
                } else if((locX>=305 && locX<=340) && (locY>=147 && locY<=180)) {
                //third fact
                    viewF.relocate(305, 147);
                    viewF.setVisible(true);
                    oc = 3;
                } else if((locX>=50 && locX<=100) && (locY>=205 && locY<=225)) {
                // fourth fact -> plant
                    viewF.relocate(38, 300);
                    viewF.setVisible(true);
                    oc = 4;
                } else if((locX>=175 && locX<=200) && (locY>=0 && locY<=30)) {
                //fifth fact
                    viewF.relocate(175, 0);
                    viewF.setVisible(true);
                    oc = 5;
                } else {
                    viewF.setVisible(false);
                    oc = 0;
                }
                // coordinates for exit buttons
                x11 = 58;
                x12 = 58+99;
                y11 = -50;
                y12 = -50+71;
                x21 = 44;
                x22 = 0;
                y21 = 313;
                y22 = 0;
                break;
            case 2:
                  //ensures that the sprite is in bounds
                  if ((up || down || left || right))
                      if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55) {
                          //detects collision and prevents sprite from moving if there is collision
                          //collision(62, 68, 179, 183);
                          //moves sprite
                          player.relocate(locX += velocityX, locY += velocityY);
                          //moves the hit box of sprite
                          rectangle.setX(locX + 5);
                          rectangle.setY(locY + 43);
                      }
                  x11 = 460;
                  x12 = 440 + 71;
                  y11 = -50;
                  y12 = -50+119;
                  x21 = 44;
                  x22 = 44+99;
                  y21 = 313;
                  y22 = 343;
                  break;
            case 3:
                //ensures that the sprite is in bounds
                if ((up || down || left || right))
                    if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55) {
                        //detects collision and prevents sprite from moving if there is collision
                        //collision(62, 68, 179, 183);
                        //moves sprite
                        player.relocate(locX += velocityX, locY += velocityY);
                        //moves the hit box of sprite
                        rectangle.setX(locX + 5);
                        rectangle.setY(locY + 43);
                    }
                 x11 = -10;
                 x12 = 15;
                 y11 = -50;
                 y12 = -50+119;
                 x21 = 475;
                 x22 = 480+71;
                 y21 = 223;
                 y22 = 313;
                 break;
            case 4:
                //ensures that the sprite is in bounds
                if ((up || down || left || right))
                    if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55) {
                        //detects collision and prevents sprite from moving if there is collision
                        //collision(62, 68, 179, 183);
                        //moves sprite
                        player.relocate(locX += velocityX, locY += velocityY);
                        //moves the hit box of sprite
                        rectangle.setX(locX + 5);
                        rectangle.setY(locY + 43);
                    }
                 x11 = -10;
                 x12 = 15;
                 y11 = 223;
                 y12 = 313;
                 x21 = 475;
                 x22 = 480+71;
                 y21 = 223;
                 y22 = 313;
                 break;
            case 5:
                //ensures that the sprite is in bounds
                if ((up || down || left || right))
                    if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55) {
                        //detects collision and prevents sprite from moving if there is collision
                        //collision(62, 68, 179, 183);
                        //moves sprite
                        player.relocate(locX += velocityX, locY += velocityY);
                        //moves the hit box of sprite
                        rectangle.setX(locX + 5);
                        rectangle.setY(locY + 43);
                    }
                x11 = -10;
                x12 = 15;
                y11 = 223;
                y12 = 313;
                x21 = 330;
                x22 = 390;
                y21 = 35;
                y22 = 60;
                break;
        }
        
        // hovering exit button thing
        System.out.println(x11 + "." + x12 + "." + y11 + "." + y12);
        System.out.println(locX + ", " + locY);
        if ((locX >= x11 & locX <= x12) && (locY >= y11 && locY <= y12)) {
            enterFunc.setVisible(true);
            clear = true;
            bu = 2;
        } else if ((locX >= x21 && locX <= x22) && (locY >= y21 && locY <= y22)) {
            enterFunc2.setVisible(true);
            clear = true;
            bu = 1;
        } else {
            enterFunc2.setVisible(false);
            enterFunc.setVisible(false);
            clear = false;
            bu = 0;
        }
    }
}
