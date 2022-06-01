package com.webApplication;

import com.GUI.Default_State;
import com.utility.GUI_utility;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import static com.GUI.Default_State.stage;

public class Protocol {
    private final ArrayList<Obj> objs = new ArrayList<>();
    private final ArrayList<Field> fields = new ArrayList<>();
    private final int font_size = 23;

    public Protocol()
    {

    }



    public void addObj (Obj obj)
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

    public Scene draw(String type)
    {
        Group root = GUI_utility.setUp_main_Node();
        Scene myScene = new Scene(root);
        
        root.getChildren().add(GUI_utility.UML(Color.BLACK, type));

        GridPane LeftGrid = GUI_utility.Setupgrid(true, font_size, this.objs.size() + this.fields.size());
        GridPane RightGrid = GUI_utility.Setupgrid(false, font_size, this.objs.size() + this.fields.size());


        Field field;Button btn;
        for (int i = 0; i < this.objs.size(); i++)
        {
            Obj obj = this.objs.get(i);
            LeftGrid.add(GUI_utility.make_Text_left(obj.getName(), font_size), 0, i);
            RightGrid.add(GUI_utility.make_Text_right(obj.get_Nobj(), obj.get_Nfield(),font_size) , 0,i);
            btn = GUI_utility.setUp_button_onGrid(i,0,RightGrid,myScene);
            Obj finalObj = obj;
            btn.setOnAction(e -> {
                Default_State.scenes.push(myScene);
                stage.setScene(finalObj.draw());
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
                Default_State.scenes.push(myScene);
                stage.setScene(finalField.draw());
            });
            root.getChildren().add(btn);
        }


        Button back_Button = GUI_utility.back_button(GUI_utility.btn_X,GUI_utility.btn_Y,font_size,myScene);
        back_Button.setOnAction(e-> stage.setScene(Default_State.scenes.pop()));
        root.getChildren().addAll(LeftGrid, RightGrid, back_Button);




        return myScene;
    }

}
