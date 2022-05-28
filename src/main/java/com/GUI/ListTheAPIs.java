package com.GUI;

import com.utility.GUI_utility;
import com.webApplication.Operation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static com.GUI.myApp.myManager;
import static com.GUI.myApp.stage;

public class ListTheAPIs {
    private static int font_size = 23;
    private ListTheAPIs(){}



    public static Scene draw ()
    {

        Group root = new Group();
        Scene myScene = new Scene(root);
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
        return myScene;
    }

}
