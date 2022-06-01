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

import static com.GUI.Default_State.stage;

public class Operation {
    private final String API_NAME;
    private final String HTTP_Operation;
    private final String REST_URL;
    private final Protocol request = new Protocol();
    private final Protocol response = new Protocol();
    private final int font_size = 23;


    public Operation(String API_NAME, String HTTP_Operation, String REST_URL) {
        this.API_NAME = API_NAME;
        this.HTTP_Operation = HTTP_Operation;
        this.REST_URL = REST_URL;
    }

    public void add_request_Obj(Obj obj) {
        this.request.addObj(obj);
    }

    public void add_response_Obj(Obj obj) {
        this.response.addObj(obj);
    }


    public void add_request_Field(Field field) {
        this.request.addField(field);
    }

    public void add_response_Field(Field field) {
        this.response.addField(field);
    }

    public String get_name()
    {
        return this.API_NAME;
    }

    public Scene draw() {
        Group root = GUI_utility.setUp_main_Node();
        Scene myScene = new Scene(root);

        root.getChildren().add(GUI_utility.UML(Color.BLACK, "API NAME : " + this.API_NAME));

        GridPane LeftGrid = GUI_utility.Setupgrid(true, font_size, 4);

        LeftGrid.add(GUI_utility.make_Text_left(("HTTP Operation : " + this.HTTP_Operation), font_size), 0, 0);

        LeftGrid.add(GUI_utility.make_Text_left(("REST URL : " + this.REST_URL), font_size), 0, 1);
        LeftGrid.add(GUI_utility.make_Text_left("request", font_size), 0, 2);
        LeftGrid.add(GUI_utility.make_Text_left("response", font_size), 0, 3);
        root.getChildren().add(LeftGrid);


        GridPane RightGrid = GUI_utility.Setupgrid(false ,font_size, 4);
        RightGrid.add(GUI_utility.make_Text_right(this.request.get_Nobj(),this.request.get_Nfield(),font_size), 0, 2);
        RightGrid.add(GUI_utility.make_Text_right(response.get_Nobj(),this.response.get_Nfield(),font_size), 0, 3);
        root.getChildren().add(RightGrid);




        Button btnnReq = GUI_utility.setUp_button_onGrid(2,0,RightGrid,myScene);
        btnnReq.setOnAction(e -> {
            Default_State.scenes.push(myScene);
            stage.setScene(this.request.draw("request"));
        });

        Protocol res = this.response;
        Button btnnRes = GUI_utility.setUp_button_onGrid(3,0,RightGrid,myScene);
        btnnRes.setOnAction(
                e -> {
                    Default_State.scenes.push(myScene);
                    stage.setScene(res.draw("response"));
                }
        );

        Button back_Button = GUI_utility.back_button(GUI_utility.btn_X,GUI_utility.btn_Y,font_size,myScene);
        back_Button.setOnAction(e-> stage.setScene(Default_State.scenes.pop()));

        root.getChildren().addAll(btnnReq, btnnRes, back_Button);



        return myScene;
    }








}
