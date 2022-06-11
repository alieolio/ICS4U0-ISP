/**
 * The Latter, a game aimed to spread awareness about the adversities of gender inequality
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva V.
 *
 * <p>
 * Version 1 - 06.10.2022
 * Created working code to give random questions with proper answering
 * </p>
 *
 * @version 06.10.2022
 * @author Artemis Chen
 */

package TheLatter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class QuizQuestions extends Application {
    /**
     * Main method for the quiz questions
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }


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
     * Integer to keep track of the question number
     */
    int question = 0;
    /**
     * Integer to keep track of the number of points
     */
    int points = 0;
    /**
     * Integer to keep track of the number of questions answered
     */
    int count = 0;

    /**
     * This method is called when the application is started.
     * It creates the scene and adds the elements to it.
     *
     * @param stage The stage of the game
     * @throws Exception Prevents crashes
     */
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        //background image
        FileInputStream bg = new FileInputStream("room 2.png");
        Image image = new Image(bg);
        ImageView background = new ImageView(image);

        //question 1
        FileInputStream question = new FileInputStream("boss q1.png");
        Image questionImage = new Image(question);
        questionImageView = new ImageView(questionImage);
        questionImageView.relocate(12, 12);

        //question 2
        FileInputStream question2 = new FileInputStream("boss q2.png");
        Image questionImage2 = new Image(question2);
        questionImageView2 = new ImageView(questionImage2);
        questionImageView2.relocate(12, 12);

        //question 3
        FileInputStream question3 = new FileInputStream("boss q3.png");
        Image questionImage3 = new Image(question3);
        questionImageView3 = new ImageView(questionImage3);
        questionImageView3.relocate(12, 12);

        //question 4
        FileInputStream question4 = new FileInputStream("boss q4.png");
        Image questionImage4 = new Image(question4);
        questionImageView4 = new ImageView(questionImage4);
        questionImageView4.relocate(12, 12);

        //question 5
        FileInputStream question5 = new FileInputStream("boss q5.png");
        Image questionImage5 = new Image(question5);
        questionImageView5 = new ImageView(questionImage5);
        questionImageView5.relocate(12, 12);

        //question 6
        FileInputStream question6 = new FileInputStream("boss q6.png");
        Image questionImage6 = new Image(question6);
        questionImageView6 = new ImageView(questionImage6);
        questionImageView6.relocate(12, 12);

        //question 7
        FileInputStream question7 = new FileInputStream("boss q7.png");
        Image questionImage7 = new Image(question7);
        questionImageView7 = new ImageView(questionImage7);
        questionImageView7.relocate(12, 12);

        //correct answer and with one point
        FileInputStream correctPoint1 = new FileInputStream("correct 1.png");
        Image correctImage = new Image(correctPoint1);
        correct1 = new ImageView(correctImage);
        correct1.relocate(12, 12);

        //correct answer and with two points
        FileInputStream correctPoint2 = new FileInputStream("correct 2.png");
        Image correctImage2 = new Image(correctPoint2);
        correct2 = new ImageView(correctImage2);
        correct2.relocate(12, 12);

        //correct answer and with three points
        FileInputStream correctPoint3 = new FileInputStream("correct 3.png");
        Image correctImage3 = new Image(correctPoint3);
        correct3 = new ImageView(correctImage3);
        correct3.relocate(12, 12);

        //incorrect answer
        FileInputStream incorrect = new FileInputStream("incorrect.png");
        Image incorrectImage = new Image(incorrect);
        this.incorrect = new ImageView(incorrectImage);
        this.incorrect.relocate(12, 12);

        //makes the elements invisible
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

        //adds the elements to the group
        group.getChildren().add(background);
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

        //creates the scene
        scene = new Scene(group, 512, 393);

        //runs the scene
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                pickQuestion();
            }
        });
        stage.show();
        start(stage);
    }

    /**
     * This method is used to pick a question.
     * It checks if the question has been answered and if not, it picks a new question.
     */
    public void pickQuestion() {
        //checks if the question has been answered
        question = (int) (Math.random() * 7);
        while (questionsAsked[question]) {
            question = (int) (Math.random() * 7);
        }
        //sets the question screen to visible
        if (question == 0 && !questionsAsked[0]) {
            questionImageView.setVisible(true);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer();
        } else if (question == 1 && !questionsAsked[1]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(true);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer();
        } else if (question == 2 && !questionsAsked[2]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(true);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer();
        } else if (question == 3 && !questionsAsked[3]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(true);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer();
        } else if (question == 4 && !questionsAsked[4]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(true);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(false);
            answer();
        } else if (question == 5 && !questionsAsked[5]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(true);
            questionImageView7.setVisible(false);
            answer();
        } else if (question == 6 && !questionsAsked[6]) {
            questionImageView.setVisible(false);
            questionImageView2.setVisible(false);
            questionImageView3.setVisible(false);
            questionImageView4.setVisible(false);
            questionImageView5.setVisible(false);
            questionImageView6.setVisible(false);
            questionImageView7.setVisible(true);
            answer();
        }
        //sets the question number to answered
        questionsAsked[question] = true;
    }

    /**
     * This method is used to answer the question.
     * It checks if the answer is correct and if so, it adds points to the player.
     */
    public void answer() {
        //checks the question number
        if (question == 0) {
            scene.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    //checks if the answer is correct
                    if (keyEvent.getCode().equals(KeyCode.DIGIT1)) {
                        points += 1;
                        questionImageView.setVisible(false);
                        correct1.setVisible(true);
                        reset();
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView.setVisible(false);
                        incorrect.setVisible(true);
                        reset();
                    }
                }
            });
        } else if (question == 1) {
            scene.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    //checks if the answer is correct
                    if (keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        points += 3;
                        questionImageView2.setVisible(false);
                        correct3.setVisible(true);
                        reset();
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        questionImageView2.setVisible(false);
                        incorrect.setVisible(true);
                        reset();
                    }
                }
            });
        } else if (question == 2) {
            scene.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    //checks if the answer is correct
                    if (keyEvent.getCode().equals(KeyCode.DIGIT2)) {
                        points += 2;
                        questionImageView3.setVisible(false);
                        correct2.setVisible(true);
                        reset();
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView3.setVisible(false);
                        incorrect.setVisible(true);
                        reset();
                    }
                }
            });
        } else if (question == 3) {
            scene.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    //checks if the answer is correct
                    if (keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        points += 1;
                        questionImageView4.setVisible(false);
                        correct1.setVisible(true);
                        reset();
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView4.setVisible(false);
                        incorrect.setVisible(true);
                        reset();
                    }
                }
            });
        } else if (question == 4) {
            scene.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    //checks if the answer is correct
                    if (keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        points += 1;
                        questionImageView5.setVisible(false);
                        correct1.setVisible(true);
                        reset();
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        questionImageView5.setVisible(false);
                        incorrect.setVisible(true);
                        reset();
                    }
                }
            });
        } else if (question == 5) {
            scene.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    //checks if the answer is correct
                    if (keyEvent.getCode().equals(KeyCode.DIGIT1)) {
                        points += 2;
                        questionImageView6.setVisible(false);
                        correct2.setVisible(true);
                        reset();
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        questionImageView6.setVisible(false);
                        incorrect.setVisible(true);
                        reset();
                    }
                }
            });
        } else if (question == 6) {
            scene.setOnKeyPressed(new EventHandler<>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    //checks if the answer is correct
                    if (keyEvent.getCode().equals(KeyCode.DIGIT4)) {
                        points += 3;
                        questionImageView7.setVisible(false);
                        correct3.setVisible(true);
                        reset();
                    } else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.DIGIT3)) {
                        questionImageView7.setVisible(false);
                        incorrect.setVisible(true);
                        reset();
                    }
                }
            });
        }
    }

    /**
     * This method is used to reset the questions.
     * It makes all the screens invisible and moves on to the next question.
     */
    public void reset() {
        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                //checks if the key pressed is the key to move to next screen
                if (keyEvent.getCode().equals(KeyCode.C)) {
                    count++;
                    correct1.setVisible(false);
                    correct2.setVisible(false);
                    correct3.setVisible(false);
                    incorrect.setVisible(false);
                    //ensures that there are still questions to be answered
                    if (count < 7)
                        pickQuestion();
                    //if there are no more questions to be answered, turn off all the screens
                    if (count == 7) {
                        questionImageView.setVisible(false);
                        questionImageView2.setVisible(false);
                        questionImageView3.setVisible(false);
                        questionImageView4.setVisible(false);
                        questionImageView5.setVisible(false);
                        questionImageView6.setVisible(false);
                        questionImageView7.setVisible(false);
                    }
                }
            }
        });
    }
}