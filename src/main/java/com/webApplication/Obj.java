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

import java.util.ArrayList;

import static com.GUI.myApp.stage;

public class Obj {
    private final String mandatory;
    private final String name;
    private ArrayList<Obj> objs = new ArrayList<Obj>();
    private ArrayList<Field> fields = new ArrayList<Field>();
    private final int font_size = 23;

    public Obj(String name ,String mandatory)
    {
        this.mandatory = mandatory;
        this.name = name;
    }

    public void addObj(Obj obj)
    {
        this.objs.add(obj);
    }

    public void addField (Field field)
    {
        this.fields.add(field);
    }


    public int get_Nfield()
    {
        return this.fields.size();
    }


    public int get_Nobj()
    {
        return this.objs.size();
    }


    public String getMandatory()
    {
        return this.mandatory;
    }

    public String getName()
    {
        return this.name;
    }

    public Scene draw()
    {
        Group root = new Group();
        Scene myScene = new Scene(root);

        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);
        root.getChildren().add(GUI_utility.UML(Color.BLACK, myApp.scale, this.name + " [Mandatory: "+ this.mandatory + "]"));

        GridPane LeftGrid = GUI_utility.Setupgrid(true, font_size, this.objs.size() + this.fields.size());
        GridPane RightGrid = GUI_utility.Setupgrid(false, font_size, this.objs.size() + this.fields.size());

        Field field; Button btn;
        for (int i = 0; i < this.objs.size(); i++)
        {
            Obj obj = this.objs.get(i);
            LeftGrid.add(GUI_utility.make_Text_left(obj.getName(), font_size), 0, i);
            RightGrid.add(GUI_utility.make_Text_right(obj.get_Nobj(), obj.get_Nfield(),font_size) , 0,i);
            btn = GUI_utility.setUp_button_onGrid(i,0,RightGrid,myScene);

            btn.setOnAction(e -> {
                    myApp.scence.push(myScene);
                    stage.setScene(obj.draw());
            });
            root.getChildren().add(btn);
        }

        for (int i = 0; i < this.fields.size(); i++)
        {
            field = this.fields.get(i);
            LeftGrid.add(GUI_utility.make_Text_left(field.getName(), font_size), 0, i+this.objs.size());
            RightGrid.add(GUI_utility.make_Text_right("Click for more info",font_size) , 0,i+this.objs.size());
            btn =GUI_utility.setUp_Info_button_onGrid(i + this.objs.size(), 0, RightGrid, myScene);
            Field finalField = field;
            btn.setOnAction(e -> {
                myApp.scence.push(myScene);
                stage.setScene(finalField.draw());
            });
            root.getChildren().add(btn);
        }



        Button back_Button = GUI_utility.back_button(GUI_utility.btn_X,GUI_utility.btn_Y,font_size,myScene);
        back_Button.setOnAction(e-> stage.setScene(myApp.scence.pop()));
        root.getChildren().addAll(LeftGrid, RightGrid, back_Button);
        return myScene;
    }
}
