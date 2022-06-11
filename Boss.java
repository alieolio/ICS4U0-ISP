/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva V.
 *
 * Version 1 - 05.27.2022
 *
 * Version 2 - 06.03.2022
 *
 * Version 3 - 06.10.2022
 *
 * @version 06.10.2022
 * @author Alicia Chung
 */

package com.latter.thelatter;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import java.io.IOException;

public class Boss{
    /*
        Variable Name   Type        Description
        background       ImageView   The background of the scene
        player           ImageView   The player
        enterFunc        ImageView   The first entrance to the boss
        enterFunc2       ImageView   The second entrance to the boss
        questionImage       ImageView   Question 1
        questionImage2       ImageView   Question 2
        questionImage3       ImageView   Question 3
        questionImage4       ImageView   Question 4
        questionImage5       ImageView   Question 5
        questionImage6       ImageView   Question 6
        questionImage7       ImageView   Question 7
        scene            Scene       Environment of the game
        correct1         ImageView   Point score with one point
        correct2         ImageView   Point score with two points
        correct3         ImageView   Point score with three points
        incorrect        ImageView   Point score with wrong answer
        questionsAsked   boolean[]     Check if the question has been answered
     */
    /**
     * The background of the scene
     */
    ImageView background = new ImageView();
    /**
     * The player
     */
    ImageView player = new ImageView();
    /**
     * The first entrance to the boss
     */
    ImageView enterFunc = new ImageView();
    /**
     * The second entrance to the boss
     */
    ImageView enterFunc2 = new ImageView();
    // more images
    /**
     * Question 1
     */
    ImageView questionImageView;
    /**
     * Question 2
     */
    ImageView questionImageView2;
    /**
     * Question 3
     */
    ImageView questionImageView3;
    /**
     * Question 4
     */
    ImageView questionImageView4;
    /**
     * Question 5
     */
    ImageView questionImageView5;
    /**
     * Question 6
     */
    ImageView questionImageView6;
    /**
     * Question 7
     */
    ImageView questionImageView7;
    /**
     * Environment of the game
     */
    Scene scene;
    /**
     * Point screen with one point
     */
    ImageView correct1;
    /**
     * Point screen with two points
     */
    ImageView correct2;
    /**
     * Point screen with three points
     */
    ImageView correct3;
    /**
     * Point screen with wrong answer
     */
    ImageView incorrect;
    /**
     * Boolean array to check if the question has been answered
     */
    boolean[] questionsAsked = new boolean[7];

    /**
     * Constructor for the boss
     */

    public Group bossO (){
        Group group = new Group();
        try{
            // add background
            FileInputStream input = new FileInputStream("room 2.png");
            Image image = new Image(input);
            background.setImage(image);
            group.getChildren().add(background);
            // other graphics
            FileInputStream playerImage = new FileInputStream("player.png");
            image = new Image(playerImage);
            player.setImage(image);
            FileInputStream ent = new FileInputStream("enter button.png");
            Image p = new Image(ent);
            enterFunc.setImage(p);
            FileInputStream ent2 = new FileInputStream("enter button.png");
            Image p2 = new Image(ent2);
            enterFunc2.setImage(p2);

            FileInputStream question = new FileInputStream("boss q1.png");
            Image questionImage = new Image(question);
            questionImageView = new ImageView(questionImage);
            questionImageView.relocate(12, 12);

            FileInputStream question2 = new FileInputStream("boss q2.png");
            Image questionImage2 = new Image(question2);
            questionImageView2 = new ImageView(questionImage2);
            questionImageView2.relocate(12, 12);

            FileInputStream question3 = new FileInputStream("boss q3.png");
            Image questionImage3 = new Image(question3);
            questionImageView3 = new ImageView(questionImage3);
            questionImageView3.relocate(12, 12);

            FileInputStream question4 = new FileInputStream("boss q4.png");
            Image questionImage4 = new Image(question4);
            questionImageView4 = new ImageView(questionImage4);
            questionImageView4.relocate(12, 12);

            FileInputStream question5 = new FileInputStream("boss q5.png");
            Image questionImage5 = new Image(question5);
            questionImageView5 = new ImageView(questionImage5);
            questionImageView5.relocate(12, 12);

            FileInputStream question6 = new FileInputStream("boss q6.png");
            Image questionImage6 = new Image(question6);
            questionImageView6 = new ImageView(questionImage6);
            questionImageView6.relocate(12, 12);

            FileInputStream question7 = new FileInputStream("boss q7.png");
            Image questionImage7 = new Image(question7);
            questionImageView7 = new ImageView(questionImage7);
            questionImageView7.relocate(12, 12);

            FileInputStream correctPoint1 = new FileInputStream("correct 1.png");
            Image correctImage = new Image(correctPoint1);
            correct1 = new ImageView(correctImage);
            correct1.relocate(12, 12);

            FileInputStream correctPoint2 = new FileInputStream("correct 2.png");
            Image correctImage2 = new Image(correctPoint2);
            correct2 = new ImageView(correctImage2);
            correct2.relocate(12, 12);

            FileInputStream correctPoint3 = new FileInputStream("correct 3.png");
            Image correctImage3 = new Image(correctPoint3);
            correct3 = new ImageView(correctImage3);
            correct3.relocate(12, 12);

            FileInputStream incorrect = new FileInputStream("incorrect.png");
            Image incorrectImage = new Image(incorrect);
            this.incorrect = new ImageView(incorrectImage);
            this.incorrect.relocate(12, 12);

            // positioning enters
            group.getChildren().add(enterFunc);
            enterFunc.setVisible(false);
            enterFunc.setX(412);
            enterFunc.setY(-5);

            group.getChildren().add(enterFunc2);
            enterFunc2.setVisible(false);
            enterFunc2.setX(57);
            enterFunc2.setY(368);

            // adding player to screen
            group.getChildren().add(player);
            player.relocate(90, 300);

            //quizzes
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            correct1.setVisible(false);
            correct2.setVisible(false);
            correct3.setVisible(false);
            this.incorrect.setVisible(false);
            group.getChildren().add(questionImageView);
            group.getChildren().add(questionImageView2);
            group.getChildren().add(questionImageView3);
            group.getChildren().add(questionImageView4);
            group.getChildren().add(questionImageView5);
            group.getChildren().add(questionImageView6);
            group.getChildren().add(questionImageView7);
            group.getChildren().add(correct1);
            group.getChildren().add(correct2);
            group.getChildren().add(correct3);
            group.getChildren().add(this.incorrect);

        } catch (IOException e){
        }

        System.out.println("boss " + group.getChildren().toString());
        System.out.println();
        return group;
    }



}
