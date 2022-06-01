package com.GUI;

import com.utility.APImanager;
import com.utility.GUI_utility;
import com.webApplication.Operation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;

import static com.GUI.Default_State.stage;

public class ListTheAPIs_State {
    private final int font_size = 23;
    private final APImanager myManager;


    public ListTheAPIs_State(String file_path)
    {
        this.myManager = new APImanager(file_path);
    }



    public  Scene draw () throws IOException {
        Group root = GUI_utility.setUp_main_Node();
        Scene myScene = new Scene(root);

        final int number_of_APIs = this.myManager.get_api().size();

        root.getChildren().add(GUI_utility.UML(Color.BLACK, "You have "+number_of_APIs +" APIs !") );
        GridPane LeftGrid = GUI_utility.Setupgrid(true, font_size, number_of_APIs);
        GridPane RightGrid = GUI_utility.Setupgrid(false, font_size, number_of_APIs);

        Button button;
        for (int i = 0; i < number_of_APIs; i++)
        {
            Operation myOp = myManager.get_api().get(i);
            LeftGrid.add(GUI_utility.make_Text_left(myOp.get_name(), font_size), 0, i);
            RightGrid.add(GUI_utility.make_Text_right("Click for more info",font_size) , 0,i);
            button =GUI_utility.setUp_Info_button_onGrid(i, 0, RightGrid, myScene);

            button.setOnAction(e -> {
                Default_State.scenes.push(myScene);
                try {
                    stage.setScene(myOp.draw());
                } catch (IOException ex) {
                    System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");

                }
            });
            root.getChildren().add(button);
        }

        root.getChildren().addAll(RightGrid, LeftGrid);
        return myScene;
    }

}
