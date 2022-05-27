package com.webApplication;


import com.GUI.myApp;
import com.utility.GUI_utility;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

import static com.GUI.myApp.css;
import static com.GUI.myApp.stage;

public class Operation {
    public String API_NAME;
    public String HTTP_Operation;
    public String REST_URL;
    public Protocol request = new Protocol();
    public Protocol response = new Protocol();
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

    public Scene draw() {
        Group root = new Group();
        Scene myScene = new Scene(root);

        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);
        root.getChildren().add(GUI_utility.UML(Color.BLACK, myApp.scale, "API NAME : " + this.API_NAME));

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
        btnnReq.setOnAction(e -> stage.setScene(this.request.draw("Request")));

        Button btnnRes = GUI_utility.setUp_button_onGrid(3,0,RightGrid,myScene);
        btnnRes.setOnAction(e -> stage.setScene(this.response.draw("Response")));

        root.getChildren().addAll(btnnReq, btnnRes);
        //LeftGrid.setGridLinesVisible(true);RightGrid.setGridLinesVisible(true);



        return myScene;
    }








}
