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

public class Operation {
    public String API_NAME;
    public String HTTP_Operation;
    public String REST_URL;
    public Protocol request = new Protocol();
    public Protocol response = new Protocol();


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

        GridPane LeftGrid = new GridPane();
        for (int i = 0; i < 4; i++) {
            RowConstraints rowConstraint = new RowConstraints(50);
            rowConstraint.setValignment(VPos.TOP);
            LeftGrid.getRowConstraints().add(rowConstraint);
        }
        GridPane.setValignment(LeftGrid ,VPos.TOP);
        GridPane.setHalignment(LeftGrid, HPos.LEFT);

        LeftGrid.setLayoutX(120);
        LeftGrid.setLayoutY(230);
        LeftGrid.add(make_Text("HTTP Operation : " + this.HTTP_Operation), 0, 0);
        LeftGrid.add(make_Text("REST URL : " + this.REST_URL), 0, 1);
        LeftGrid.add(make_Text((this.request == null) ? "" : "Request"), 0, 2);
        LeftGrid.add(make_Text((this.response == null) ? "" : "response"), 0, 3);
        root.getChildren().add(LeftGrid);


        GridPane RightGrid = new GridPane();
        for (int i = 0; i < 4; i++) {
            RowConstraints rowConstraint = new RowConstraints(50);
            rowConstraint.setValignment(VPos.TOP);
            ColumnConstraints ColumnConstraints = new ColumnConstraints();
            ColumnConstraints.setHalignment(HPos.RIGHT);
            RightGrid.getColumnConstraints().add(ColumnConstraints);
            RightGrid.getRowConstraints().add(rowConstraint);
        }
        GridPane.setValignment(RightGrid ,VPos.TOP);
        GridPane.setHalignment(RightGrid, HPos.LEFT);

        RightGrid.setLayoutX(250);
        RightGrid.setLayoutY(230);
        RightGrid.add(make_Text_RIGHT("[No of objects: " + String.valueOf(this.request.get_Nobj()) + " No of fields: " + String.valueOf(this.request.get_Nfield()) + "]"), 0, 2);
        RightGrid.add(make_Text_RIGHT("[No of objects: " + String.valueOf(this.response.get_Nobj()) + " No of fields: " + String.valueOf(this.response.get_Nfield()) + "]"), 0, 3);
        //RightGrid.setGridLinesVisible(true);
        root.getChildren().add(RightGrid);




        Button btnn = GUI_utility.set_button_onGrid(0,0,LeftGrid);
        btnn.setOnAction(e -> System.out.println("hi"));

        root.getChildren().add(btnn);



        return myScene;
    }


    public Text make_Text(String s) {
        Text text = new Text(s);
        text.setFont(Font.font("Consolas", 24));
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setTextOrigin(VPos.TOP);

        return text;
    }


    public Text make_Text_RIGHT(String s) {
        Text text = new Text(s);
        text.setFont(Font.font("Consolas", 24));
        text.setFill(Color.RED);
        text.setTextOrigin(VPos.TOP);
        return text;
    }






}
