package com.GUI;
import com.utility.APImanager;
import com.utility.GUI_utility;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;

public class myApp extends Application{
    public static final int length = 800;
    public static final double scale = 0.8;
    public static APImanager myManager;
    public  static Stage stage;

    public static void main (String[] args)
    {
        BasicConfigurator.configure();
        myManager =  new APImanager("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\Excels\\basic.xlsx");
        System.out.println(myManager.get_api());

        Application.launch(args);
    }

    @Override
    public void start(Stage s) throws Exception
    {
        Group root = new Group();
        Scene myScene = new Scene(root);
        stage = new Stage();
        stage.setScene(myScene);

        stage.setWidth(length);
        stage.setHeight(length);
        stage.setTitle("my Http program!");
        stage.setResizable(false);



        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);






        root.getChildren().add(GUI_utility.UML(Color.BLACK, scale,"hello"));

        Text myText = new Text("Name :" );
        myText.setTextOrigin(VPos.CENTER);
        myText.setY(((1-scale)*0.5 + scale*0.1) * length);myText.setX(myApp.length* ((1-scale+0.1)*0.5));
        myText.setFont(Font.font("Consolas", 0.0625*length*scale*1.25));
        myText.setFill(Color.BLACK);
        root.getChildren().add(myText);



        Image icon = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\icon.png");
        stage.getIcons().add(icon);
        stage.setScene(myManager.get_api().get(0).draw());
        stage.show();
    }
}