package com.GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
public class Hello_World extends Application{
    private static final int length = 800;

        public static void main (String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Group root = new Group();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);


        stage.setWidth(length);
        stage.setHeight(length);
        stage.setTitle("my Http program!");
        stage.setResizable(false);



        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);





        Rectangle myRectangle = new Rectangle();
        myRectangle.setX(0.1*length);myRectangle.setY(0.1*length);
        myRectangle.setWidth(0.8*length);myRectangle.setHeight(0.8*length);
        myRectangle.setFill(Color.rgb(254,187,100));
        myRectangle.setStrokeWidth(5);
        myRectangle.setArcHeight(50);myRectangle.setArcWidth(50);
        myRectangle.setStroke(Color.BLACK);
        root.getChildren().add(myRectangle);


        Line myLine = new Line();
        myLine.setStartX(0.1*length);myLine.setStartY(0.25*length);
        myLine.setEndX(0.9*length); myLine.setEndY(0.25*length);
        myLine.setStrokeWidth(5);
        myLine.setStroke(Color.BLACK);
        root.getChildren().add(myLine);

        Text myText = new Text("Name :" );
        myText.setX(0.15*length);myText.setY(0.2*length);
        myText.setFont(Font.font("Consolas", 0.0625*length));
        myText.setFill(Color.BLACK);
        root.getChildren().add(myText);



        Image icon = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\icon.png");
        stage.getIcons().add(icon);

        stage.show();
    }
}