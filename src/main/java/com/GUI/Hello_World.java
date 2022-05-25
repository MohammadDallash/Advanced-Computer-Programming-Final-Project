package com.GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
public class Hello_World extends Application{

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


        stage.setWidth(420);
        stage.setHeight(420);
        stage.setTitle("my Http program!");
        stage.setResizable(false);





        Image icon = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\icon.png");
        stage.getIcons().add(icon);

        stage.show();
    }
}