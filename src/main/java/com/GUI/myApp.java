package com.GUI;
import com.utility.APImanager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;

import java.io.File;
import java.util.Stack;

public class myApp extends Application{
    public static final int length = 800;
    public static final double scale = 0.8;
    public static APImanager myManager;
    public  static Stage stage;
    public  static Stack<Scene> scence = new Stack<>();



    public static void main (String[] args)
    {
        BasicConfigurator.configure();

        Application.launch(args);
    }

    @Override
    public void start(Stage s) throws Exception
    {
        stage = new Stage();

        Group root = new Group();
        stage.setWidth(length);
        stage.setHeight(length);
        stage.setTitle("myHttp program!");
        stage.setResizable(false);
        Image icon = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\icon.png");
        stage.getIcons().add(icon);

        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);

        Scene myScene = new Scene(root);
        FileChooser file_chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.xlsx");
        file_chooser.getExtensionFilters().add(extFilter);

        Text text = new Text("Select the Excel from your PC!");
        text.setFont(Font.font("Consolas", 40));
        text.setFill(Color.RED);



        VBox smallVbox = new VBox();

        smallVbox.getChildren().add(text);
        smallVbox.setStyle("-fx-background-color:white;-fx-background-radius: 1px;");
        smallVbox.setAlignment(Pos.CENTER);
        smallVbox.setMinHeight(40+text.getBoundsInParent().getHeight());
        smallVbox.setMaxWidth(40+text.getBoundsInParent().getWidth());


        Button btnn = new Button("Show open dialog");

        btnn.setFont(Font.font("Consolas", 30));


        btnn.setStyle("-fx-border-width: 2;-fx-background-radius: 12px; -fx-border-radius: 12px;-fx-text-fill: rgb(12,13,00);-fx-border-color:rgb(12,13,0);-fx-background-color:white;");
        btnn.setOnMouseEntered(e-> {
            btnn.setStyle("-fx-border-width: 2;-fx-background-radius: 12px; -fx-border-radius: 12px;-fx-border-color:rgb(12,13,0); -fx-background-color: rgb(12,13,0);");
            myScene.setCursor(Cursor.HAND);
            btnn.setTextFill(Color.WHITE);
        });
        btnn.setOnMouseExited(e-> {
            btnn.setStyle("-fx-border-width: 2;-fx-background-radius: 12px; -fx-border-radius: 12px;-fx-text-fill: rgb(12,13,0);-fx-border-color:rgb(12,13,0);-fx-background-color:white;");
            myScene.setCursor(Cursor.DEFAULT);
        });


        VBox vbox = new VBox(150, smallVbox, btnn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(800);vbox.setMinHeight(800);
        root.getChildren().addAll(vbox);
        vbox.setLayoutY(-50);



        btnn.setOnAction(e->{
            File file = file_chooser.showOpenDialog(stage);

            if (file != null) {
                text.setText(file.getName()+ " selected");
                smallVbox.setMinHeight(40+text.getBoundsInParent().getHeight());
                smallVbox.setMaxWidth(40+text.getBoundsInParent().getWidth());
                btnn.setVisible(false);
                root.getChildren().add(ready(myScene, file.getAbsolutePath() ));
            }});










        stage.setScene(myScene);



        stage.show();
    }

    public VBox ready(Scene myScene, String file_path)
    {
        Button GObtnn = new Button("Go!");
        VBox vbox = new VBox(0, GObtnn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(800);vbox.setMinHeight(800);


        GObtnn.setFont(Font.font("Consolas", 30));


        GObtnn.setStyle("-fx-background-radius: 22px; -fx-border-radius: 22px;-fx-text-fill: rgb(20,130,45);-fx-border-color:rgb(20,130,45);-fx-background-color:white;");
        GObtnn.setOnMouseEntered(e-> {
            GObtnn.setStyle("-fx-background-radius: 22px; -fx-border-radius: 22px;-fx-border-color:rgb(20,130,45); -fx-background-color: rgb(20,130,45);");
            myScene.setCursor(Cursor.HAND);
            GObtnn.setTextFill(Color.WHITE);
        });
        GObtnn.setOnMouseExited(e-> {
            GObtnn.setStyle("-fx-background-radius: 22px; -fx-border-radius: 22px;-fx-text-fill: rgb(20,130,45);-fx-border-color:rgb(20,130,45);-fx-background-color:white;");
            myScene.setCursor(Cursor.DEFAULT);
        });


            GObtnn.setOnAction(e->{
                ListTheAPIs listObj = new ListTheAPIs(file_path);
                stage.setScene(listObj.draw());
                });

        vbox.setLayoutY(56);


        return vbox;
    }
}


