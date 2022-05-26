package com.webApplication;


import com.GUI.myApp;
import com.utility.GUI_utility;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
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







        /*Text req_info = new Text("[No of objects: " + String.valueOf(this.request.get_Nobj()) +" No of fields: " + String.valueOf(this.request.get_Nfield()) + "]");

        req_info.setLayoutY((0.525 - myApp.scale*0.25) * myApp.length+ 3 *skip_line);req_info.setLayoutX(myApp.length* ((1-myApp.scale+0.1)*0.5));
        req_info.setWrappingWidth(565);
        req_info.setTextAlignment(TextAlignment.RIGHT);
        req_info.setFont(myfont);
        req_info.setFill(Color.RED);
        root.getChildren().add(req_info);


        Text res_info = new Text("No of objects: " + String.valueOf(this.response.get_Nobj()) +"No of fields: " + String.valueOf(this.response.get_Nfield()) );
        res_info.setFont(myfont);
        res_info.setFill(Color.RED);
        root.getChildren().add(res_info);*/

        GridPane LeftGrid = new GridPane();
        LeftGrid.setPadding(new Insets(240,0,0,120));
        LeftGrid.setVgap(30);
        LeftGrid.add(make_Text("HTTP Operation : " + this.HTTP_Operation ), 0, 0);
        LeftGrid.add(make_Text("REST URL : " + this.REST_URL), 0, 1);
        LeftGrid.add(make_Text((this.request == null)? "":"request" ), 0, 2);
        LeftGrid.add(make_Text((this.response == null)? "":"response" ), 0, 3);
        root.getChildren().add(LeftGrid);



        GridPane RightGrid = new GridPane();
        RightGrid.setPadding(new Insets(240,0,0,120));
        RightGrid.setVgap(30);
        RightGrid.add(make_Text_RIGHT(""), 0, 0);
        RightGrid.add(make_Text_RIGHT(""), 0, 1);
        RightGrid.add(make_Text_RIGHT("[No of objects: " + String.valueOf(this.request.get_Nobj()) +" No of fields: " + String.valueOf(this.request.get_Nfield())+"]"), 0, 2);
        RightGrid.add(make_Text_RIGHT("[No of objects: " + String.valueOf(this.response.get_Nobj()) +" No of fields: " + String.valueOf(this.response.get_Nfield()) + "]"), 0, 3);

        root.getChildren().add(RightGrid);





/*
        Button btn=new Button();
        btn.setGraphic(getNodeByRowColumnIndex(0,0,LeftGrid));
        btn.setLayoutX(getNodeByRowColumnIndex(0,0,LeftGrid).getLayoutX());
        btn.setLayoutY(getNodeByRowColumnIndex(0,0,LeftGrid).getLayoutY());
           //btn.setBackground(Background.EMPTY);
        btn.setOnAction(e-> System.out.println("hi"));


        root.getChildren().add(btn);*/


        return myScene;
    }


    public Text make_Text(String s)
    {
        Text Text = new Text(s);
        Text.setFont(Font.font("Consolas", 24));
        Text.setFill(Color.BLACK);
        Text.setTextAlignment(TextAlignment.LEFT);
        return Text;
    }


    public Text make_Text_RIGHT(String s)
    {
        Text Text = new Text(s);
        Text.setFont(Font.font("Consolas", 24));
        Text.setFill(Color.RED);
        Text.setWrappingWidth(580);
        Text.setTextAlignment(TextAlignment.RIGHT);
        return Text;
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

}
