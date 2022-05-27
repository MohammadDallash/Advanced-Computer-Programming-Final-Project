package com.webApplication;

import com.GUI.myApp;
import com.utility.GUI_utility;
import com.webApplication.Field;
import com.webApplication.Obj;
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

public class Protocol {
    private ArrayList<Obj> objs = new ArrayList<Obj>();
    private ArrayList<Field> fields = new ArrayList<Field>();
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
        Group root = new Group();
        Scene myScene = new Scene(root);

        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);
        root.getChildren().add(GUI_utility.UML(Color.BLACK, myApp.scale, type));

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
                myApp.scence.add(finalObj.draw());
                stage.setScene(myApp.scence.get(myApp.scence.size() - 1));
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
                myApp.scence.add(finalField.draw());
                stage.setScene(myApp.scence.get(myApp.scence.size() - 1));

            });
            root.getChildren().add(btn);
        }
        //LeftGrid.setGridLinesVisible(true);RightGrid.setGridLinesVisible(true);


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
        root.getChildren().addAll(LeftGrid, RightGrid, back_Button);




        return myScene;
    }

}
