import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Instructions {
    /**
     * This method works to create and layout the background images and buttons for the instructions screen.
     * @param b
     * @return sp
     */
    public StackPane instr(Button b){
        StackPane sp = new StackPane();

        /*
        Variable Name            Type                        Purpose
        input                    FileInputStream             Setting the image of the game instructions
        image                    Image                       Storing the instructions image as 'Image'
        back                     Image                       Storing the image for the 'back' button
        iv                       ImageView                   Storing the instructions image into 'ImageView'
         */
        FileInputStream input;
        Image image;
        Image back;
        ImageView iv;
        try{
            //get images and store the into variables
            input = new FileInputStream("instructions.png");
            image = new Image(input);
            input = new FileInputStream("instrback.png");
            back = new Image(input);

            //adding image to background of console
            iv = new ImageView(image);

            //button
            b.setGraphic(new ImageView(back));
            b.setTranslateX(195);
            b.setTranslateY(172);
            
            sp.getChildren().addAll(iv, b);
        } catch (IOException e){
        }

        return sp;
    }
}
