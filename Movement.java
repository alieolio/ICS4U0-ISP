package com.latter.thelatter;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.io.FileInputStream;

public abstract class Movement extends Application{

    final int LENGTH = 512;
    final int WIDTH = 393;

    private boolean up, down, left, right;
    private int locX, locY, velocityX, velocityY;
    private int speed = 5;

    private boolean clear = false;


    /**
     * Sets the movement speed when the correct key is pressed
     *
     * @param e The key pressed
     */
    public boolean velStart(KeyEvent e) {
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
            case E:
                return true;
        }
        return false;
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
    public void movement(ImageView player, ImageView enterFunc, ImageView enterFunc2, String room) {
        
        /*
        PROBABLY HAVE TO SET DIFFERENT VALUES FOR ENTERFUNC DEPENDING ON ROOM
         */
        /*
        int e1xm = 0, e1xM = 0, e1ym = 0, e1yM = 0;
        int e2xm = 0, e2xM = 0, e2ym = 0, e2yM = 0;
        int state = 0;
        switch (room) {
            case "office":
                e1xm = 58;
                e1y = -50;
                state = 0;
                break;
            case "boss":
                state = 1;
                break;
            default:
                e1x = -10;
                e1y = 200;
                break;
        }
        */

        //ensures in bounds (not fully working)
        if (locX + velocityX >= -15 && locX + velocityX <= LENGTH - 20 /*subtract character width*/
                && locY + velocityY >= -15 && locY + velocityY <= WIDTH - 55 /*subtract character length*/)
            player.relocate(locX += velocityX, locY += velocityY);

        // hovering exit button thing
        if ((locX >= 58 && locX <= 58 + 99) && (locY >= -50 && locY <= -50 + 71)) {
            enterFunc.setVisible(true);
            clear = true;
        } else if ((locX >= 207 && locX <= 306) && (locY >= 323 && locY <= 343)) {
            enterFunc2.setVisible(true);
            clear = true;
        } else {
            enterFunc2.setVisible(false);
            enterFunc.setVisible(false);
            clear = false;
        }
    }

    public boolean getClear(){
        return clear;
    }

}
