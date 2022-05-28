package com.GUI;
import com.utility.APImanager;
import com.utility.GUI_utility;
import com.webApplication.Field;
import com.webApplication.Operation;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import org.apache.poi.sl.draw.geom.GuideIf;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class myApp extends Application{
    public static final int length = 800;
    public static final double scale = 0.8;
    public static APImanager myManager;
    public  static Stage stage;
    public  static Stack<Scene> scence = new Stack<>();
    private static int font_size = 23;


    public static void main (String[] args)
    {
        BasicConfigurator.configure();
        myManager =  new APImanager("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\Excels\\basic.xlsx");

        Application.launch(args);
    }

    @Override
    public void start(Stage s) throws Exception
    {
        stage = new Stage();
        Group root = new Group();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);

        stage.setWidth(length);
        stage.setHeight(length);
        stage.setTitle("my Http program!");
        stage.setResizable(false);
        Image icon = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\icon.png");
        stage.getIcons().add(icon);



        int size = myManager.get_api().size();

        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);
        root.getChildren().add(GUI_utility.UML(Color.BLACK, myApp.scale, "You have "+Integer.toString(size) +" APIs !") );

        GridPane LeftGrid = GUI_utility.Setupgrid(true, font_size, size);
        GridPane RightGrid = GUI_utility.Setupgrid(false, font_size, size);

        Button btn;
        for (int i = 0; i < size; i++)
        {
            Operation myOp = myManager.get_api().get(i);
            LeftGrid.add(GUI_utility.make_Text_left(myOp.get_name(), font_size), 0, i);
            RightGrid.add(GUI_utility.make_Text_right("Click for more info",font_size) , 0,i);
            btn =GUI_utility.setUp_Info_button_onGrid(i, 0, RightGrid, myScene);

            btn.setOnAction(e -> {
                myApp.scence.push(myScene);
                stage.setScene(myOp.draw());
            });
            root.getChildren().add(btn);
        }

        root.getChildren().addAll(RightGrid, LeftGrid);


        stage.setScene(myScene);


        stage.show();
    }
}