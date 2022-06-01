package com.GUI;
import com.utility.GUI_utility;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Default_State extends Application{
    public  static Stage stage;
    public  static Stack<Scene> scenes = new Stack<>();


    public static void main (String[] args)
    {
        BasicConfigurator.configure();

        Application.launch(args);
    }

    @Override
    public void start(Stage s) throws Exception
    {
        stage = GUI_utility.setUp_Stage();
        Group root = GUI_utility.setUp_main_Node();
        Scene myScene = new Scene(root);

        FileChooser file_chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.xlsx");
        file_chooser.getExtensionFilters().add(extFilter);

        Text massage_to_the_user = new Text("Select the Excel from your PC!");
        massage_to_the_user.setFont(Font.font("Consolas", 35));
        massage_to_the_user.setFill(Color.RED);



        VBox smallVbox = new VBox();

        smallVbox.getChildren().add(massage_to_the_user);
        smallVbox.setStyle("-fx-background-color:white;-fx-background-radius: 1px;");
        smallVbox.setAlignment(Pos.CENTER);
        smallVbox.setMinHeight(40+massage_to_the_user.getBoundsInParent().getHeight());
        smallVbox.setMaxWidth(40+massage_to_the_user.getBoundsInParent().getWidth());


        Button Show_dialog_button = new Button("Show open dialog");

        Show_dialog_button.setFont(Font.font("Consolas", 30));


        Show_dialog_button.setStyle("-fx-border-width: 2;-fx-background-radius: 12px; -fx-border-radius: 12px;-fx-text-fill: rgb(12,13,00);-fx-border-color:rgb(12,13,0);-fx-background-color:white;");
        Show_dialog_button.setOnMouseEntered(e-> {
            Show_dialog_button.setStyle("-fx-text-fill: white;-fx-border-width: 2;-fx-background-radius: 12px; -fx-border-radius: 12px;-fx-border-color:rgb(12,13,0); -fx-background-color: rgb(12,13,0);");
            myScene.setCursor(Cursor.HAND);
        });
        Show_dialog_button.setOnMouseExited(e-> {
            Show_dialog_button.setStyle("-fx-border-width: 2;-fx-background-radius: 12px; -fx-border-radius: 12px;-fx-text-fill: rgb(12,13,00);-fx-border-color:rgb(12,13,0);-fx-background-color:white;");
            myScene.setCursor(Cursor.DEFAULT);
        });


        VBox vbox = new VBox(150, smallVbox, Show_dialog_button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(800);vbox.setMinHeight(800);
        root.getChildren().addAll(vbox);
        vbox.setLayoutY(-50);

       Show_dialog_button.setOnAction
        (
            e->
            {
                File file = file_chooser.showOpenDialog(stage);

                if (file != null)
                {
                    massage_to_the_user.setText(file.getName()+ " selected");
                    smallVbox.setMinHeight(40+massage_to_the_user.getBoundsInParent().getHeight());
                    smallVbox.setMaxWidth(40+massage_to_the_user.getBoundsInParent().getWidth());
                    Show_dialog_button.setVisible(false);
                    root.getChildren().add(ready(myScene, file.getAbsolutePath() ));
                }

            }
        );


        stage.setScene(myScene);



        stage.show();
    }

    public VBox ready(Scene myScene, String file_path)
    {
        Button Go_button = new Button("Go!");
        VBox vbox = new VBox(0, Go_button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(800);vbox.setMinHeight(800);


        Go_button.setFont(Font.font("Consolas", 25));


        Go_button.setStyle("-fx-background-radius: 22px; -fx-border-radius: 22px;-fx-text-fill: rgb(20,130,45);-fx-border-color:rgb(20,130,45);-fx-background-color:white;");
        Go_button.setOnMouseEntered(e-> {
            Go_button.setStyle("-fx-background-radius: 22px; -fx-border-radius: 22px;-fx-border-color:rgb(20,130,45); -fx-background-color: rgb(20,130,45);");
            myScene.setCursor(Cursor.HAND);
            Go_button.setTextFill(Color.WHITE);
        });
        Go_button.setOnMouseExited(e-> {
            Go_button.setStyle("-fx-background-radius: 22px; -fx-border-radius: 22px;-fx-text-fill: rgb(20,130,45);-fx-border-color:rgb(20,130,45);-fx-background-color:white;");
            myScene.setCursor(Cursor.DEFAULT);
        });


            Go_button.setOnAction(e->{
                ListTheAPIs_State listObj = new ListTheAPIs_State(file_path);
                try {
                    stage.setScene(listObj.draw());
                } catch (IOException ex) {
                    System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");

                }
            });

        vbox.setLayoutY(56);


        return vbox;
    }
}




