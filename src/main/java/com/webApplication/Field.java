package com.webApplication;


import com.GUI.myApp;
import com.utility.GUI_utility;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static com.GUI.myApp.stage;

public class Field {
    private final String Allowed_Values;
    private final String mandatory;
    private final String name;
    private final int font_size = 23;

    public Field (String name,String Allowed_Values,  String mandatory)
    {
        this.name = name;
        this.Allowed_Values = Allowed_Values;
        this.mandatory = mandatory;
    }

    public String getAllowed_Values()
    {
        return this.Allowed_Values;
    }
    public String getMandatory()
    {
        return this.mandatory;
    }

    public String getName() {
        return this.name;
    }


    public Scene draw()
    {
        Group root = new Group();
        Scene myScene = new Scene(root);

        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);
        root.getChildren().add(GUI_utility.UML(Color.BLACK, myApp.scale, "Name : " + this.name));

        GridPane LeftGrid = GUI_utility.Setupgrid(true, font_size, 2);

        LeftGrid.add(GUI_utility.make_Text_left("Allowed Values : " + ((this.Allowed_Values.length() == 0) ? "every thing !":this.Allowed_Values), font_size), 0, 0);
        LeftGrid.add(GUI_utility.make_Text_left("Mandatory : " +this.mandatory, font_size), 0, 1);



        Button back_Button = GUI_utility.back_button(GUI_utility.btn_X,GUI_utility.btn_Y,font_size,myScene);
        back_Button.setOnAction(
                new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent e)
                    {
                        Scene temp = myApp.scence.remove(myApp.scence.size() - 1);
                        stage.setScene(temp);
                    }
                }
        );

        root.getChildren().addAll(LeftGrid, back_Button);
        return myScene;
    }
}
