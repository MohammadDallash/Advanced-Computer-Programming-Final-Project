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


        stage.setWidth(length);
        stage.setHeight(length);
        stage.setTitle("my Http program!");
        stage.setResizable(false);
        Image icon = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\icon.png");
        stage.getIcons().add(icon);






        stage.setScene(ListTheAPIs.draw());


        stage.show();
    }
}