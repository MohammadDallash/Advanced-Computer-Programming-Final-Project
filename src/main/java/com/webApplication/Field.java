package com.webApplication;


import com.GUI.Default_State;
import com.utility.GUI_utility;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;

import static com.GUI.Default_State.stage;

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

    public String getName() {
        return this.name;
    }


    public Scene draw() throws IOException {
        Group root = GUI_utility.setUp_main_Node();
        Scene myScene = new Scene(root);


        root.getChildren().add(GUI_utility.UML(Color.BLACK,  "Name : " + this.name));

        GridPane LeftGrid = GUI_utility.Setupgrid(true, font_size, 2);

        LeftGrid.add(GUI_utility.make_Text_left("Allowed Values : " + ((this.Allowed_Values.length() == 0) ? "every thing !":this.Allowed_Values), font_size), 0, 0);
        LeftGrid.add(GUI_utility.make_Text_left("Mandatory : " +this.mandatory, font_size), 0, 1);



        Button back_Button = GUI_utility.back_button(GUI_utility.btn_X,GUI_utility.btn_Y,font_size,myScene);
        back_Button.setOnAction(e-> stage.setScene(Default_State.scenes.pop()));

        root.getChildren().addAll(LeftGrid, back_Button);
        return myScene;
    }
}
