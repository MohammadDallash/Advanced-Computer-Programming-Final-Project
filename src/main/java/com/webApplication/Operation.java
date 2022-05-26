package com.webApplication;


import com.GUI.myApp;
import com.utility.GUI_utility;
import javafx.event.ActionEvent;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import org.apache.poi.ss.formula.functions.T;

public class Operation {
    public String API_NAME;
    public   String HTTP_Operation;
    public   String REST_URL;
    public Protocol request = new Protocol();
    public Protocol response= new Protocol();


    public Operation (String API_NAME, String HTTP_Operation, String REST_URL)
    {
        this.API_NAME = API_NAME;
        this.HTTP_Operation = HTTP_Operation;
        this.REST_URL = REST_URL;
    }

    public  void add_request_Obj (Obj obj)
    {
        this.request.addObj(obj);
    }

    public  void add_response_Obj (Obj obj)
    {
        this.response.addObj(obj);
    }


    public  void add_request_Field (Field field)
    {
        this.request.addField(field);
    }

    public  void add_response_Field (Field field)
    {
        this.response.addField(field);
    }

    public Scene draw ()
    {
        Group root = new Group();
        Scene myScene = new Scene(root);

        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);
        root.getChildren().add(GUI_utility.UML(Color.BLACK, myApp.scale,"API NAME : "+ this.API_NAME));




        Font myfont = Font.font("Consolas", 0.0365*myApp.length*myApp.scale);
        double skip_line  = 0.067 * myApp.length*myApp.scale;

        Text mainText = new Text("HTTP Operation : " + this.REST_URL +  "\nREST URL : " + this.REST_URL + ((this.request == null)? "":"\nrequest") +((this.response == null)? "":"\nresponse"));
        mainText.setLayoutY((0.525 - myApp.scale*0.25) * myApp.length);mainText.setLayoutX(myApp.length* (0.55-0.5*myApp.scale));
        mainText.setFont(myfont);
        mainText.setFill(Color.BLACK);
        mainText.setLineSpacing(0.025*myApp.length*myApp.scale);
        root.getChildren().add(mainText);

        Text req_info = new Text("[No of objects: " + String.valueOf(this.request.get_Nobj()) +" No of fields: " + String.valueOf(this.request.get_Nfield()) + "]");

        req_info.setLayoutY((0.525 - myApp.scale*0.25) * myApp.length+ 3 *skip_line);req_info.setLayoutX(myApp.length* ((1-myApp.scale+0.1)*0.5));
        req_info.setWrappingWidth(565);
        req_info.setTextAlignment(TextAlignment.RIGHT);
        req_info.setFont(myfont);
        req_info.setFill(Color.BLACK);
        root.getChildren().add(req_info);


        Text res_info = new Text("No of objects: " + String.valueOf(this.response.get_Nobj()) +"No of fields: " + String.valueOf(this.response.get_Nfield()) );
        res_info.setFont(myfont);
        res_info.setFill(Color.BLACK);
        root.getChildren().add(res_info);


/*
        Button btn=new Button();
        //btn.setGraphic(mainText);
        btn.setLayoutX(mainText.getLayoutX());btn.setLayoutY(mainText.getLayoutY());
        //btn.setBackground(Background.EMPTY);
        btn.setOnAction(e-> System.out.println("hi"));


        root.getChildren().add(btn);*/


        return myScene;
    }



}
