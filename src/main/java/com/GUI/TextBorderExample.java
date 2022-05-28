package com.GUI;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextBorderExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Group root = new Group();

        root.getChildren().addAll(
                new Text("This"), new Text("Is"), new Text("A"), createBorderedText("Red"), new Text("Bordered"), new Text("Text")
        );

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private Node createBorderedText(String text) {
        final HBox hbox = new HBox();
        hbox.getChildren().add(new Text(text));
        hbox.setStyle("-fx-border-color: red;-fx-background-color:red;");
        return hbox ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}