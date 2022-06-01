package com.utility;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public final class GUI_utility {
    private static final int window_width = 800;
    private static final int window_height = 800;
    public static final int margin = 40;
    public static final int UML_start_X = 80; public static int UML_start_Y = 80;
    public static final int btn_X = 560; public static final int btn_Y = 650;
    private static final int UML_Width = 640;
    private static final int UML_Height = UML_Width;
    private static final int Line_Y = 208;
    private GUI_utility() {}


    public static Group UML (Color color, String string)
    {
        Group root = new Group();

        Rectangle myRectangle = new Rectangle();
        myRectangle.setX(UML_start_X);myRectangle.setY(UML_start_Y);
        myRectangle.setWidth(UML_Width);myRectangle.setHeight(UML_Height);
        myRectangle.setFill(Color.rgb(254,187,100));
        myRectangle.setStrokeWidth(5);
        myRectangle.setArcHeight(50);myRectangle.setArcWidth(50);
        myRectangle.setStroke(color);
        root.getChildren().add(myRectangle);


        Line myLine = new Line();
        myLine.setStartX(UML_start_X);myLine.setStartY(Line_Y);
        myLine.setEndX(UML_start_X+UML_Width); myLine.setEndY(Line_Y);
        myLine.setStrokeWidth(5);
        myLine.setStroke(color);
        root.getChildren().add(myLine);

        Text Header = new Text(string);
        Header.setTextOrigin(VPos.CENTER);
        Header.setY(144);Header.setX(120);
        Header.setFont(Font.font("Consolas", 30));
        Header.setFill(Color.BLACK);
        root.getChildren().add(Header);

        return root;

    }

    public static Button setUp_button_onGrid(final int row, final int column, GridPane gridPane, Scene scene)
    {
        Button btnn = new Button();
        Node myNode = getNodeByRowColumnIndex(row, column, gridPane);
        btnn.setGraphic(myNode);
        double font_size = ((Text)myNode).getFont().getSize();
        double width = myNode.getBoundsInParent().getWidth();
        btnn.setLayoutX(gridPane.getLayoutX()-7 - width);
        btnn.setLayoutY(gridPane.getLayoutY() + (row * font_size*2)-4);

        btnn.setStyle("transition-duration: 0.4s;-fx-border-color:red;-fx-background-color:null;");
        btnn.setOnMouseEntered(e-> {
            btnn.setStyle("transition-duration: 0.4s;-fx-border-color:red; -fx-background-color: red;");
            scene.setCursor(Cursor.HAND);
            ((Text)myNode).setFill(Color.rgb(254,187,100));
        });
        btnn.setOnMouseExited(e-> {
            btnn.setStyle("-fx-text-fill: red;-fx-border-color:red;-fx-background-color:null;");
            scene.setCursor(Cursor.DEFAULT);
            ((Text)myNode).setFill(Color.RED);
        });
        return btnn;

    }

    public  static Button back_button(int x, int y, int fontSize, Scene scene)
    {
        Button btnn = new Button("previous");
        btnn.setFont(Font.font("Consolas", fontSize));
        btnn.setLayoutX(x);
        btnn.setLayoutY(y);

        btnn.setStyle("-fx-text-fill: rgb(26,117,2);-fx-border-color:rgb(26,117,2);-fx-background-color:null;");
        btnn.setOnMouseEntered(e-> {
            btnn.setStyle("-fx-border-color:rgb(26,117,2); -fx-background-color: rgb(26,117,2);");
            scene.setCursor(Cursor.HAND);
            btnn.setTextFill(Color.rgb(254,187,100));
        });
        btnn.setOnMouseExited(e-> {
            btnn.setStyle("-fx-text-fill: rgb(26,117,2);-fx-border-color:rgb(26,117,2);-fx-background-color:null;");
            scene.setCursor(Cursor.DEFAULT);
        });


        return btnn;
    }

    public static Button setUp_Info_button_onGrid(final int row, final int column, GridPane gridPane, Scene scene)
    {
        Button btnn = new Button();
        Node myNode = getNodeByRowColumnIndex(row, column, gridPane);
        double font_size = ((Text)myNode).getFont().getSize();
        btnn.setGraphic(myNode);
        double width = myNode.getBoundsInParent().getWidth();
        btnn.setLayoutX(gridPane.getLayoutX()-7 - width );
        btnn.setLayoutY(gridPane.getLayoutY() + (row * 2 *font_size)-4);

        btnn.setStyle("-fx-border-color:red;-fx-background-color:null;");
        btnn.setOnMouseEntered(e-> {
            btnn.setStyle("-fx-border-color:red; -fx-background-color: red;");
            scene.setCursor(Cursor.HAND);
            ((Text)myNode).setFill(Color.rgb(254,187,100));
        });
        btnn.setOnMouseExited(e-> {
            btnn.setStyle("-fx-text-fill: red;-fx-border-color:red;-fx-background-color:null;");
            scene.setCursor(Cursor.DEFAULT);
            ((Text)myNode).setFill(Color.RED);
        });

        return btnn;

    }






    public static Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
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

    public static GridPane Setupgrid(boolean left , int fontSize, int NofRows)
    {
        GridPane grid = new GridPane();
        grid.setLayoutX(UML_start_X +margin + ((left)? 0:(UML_Width - 2*margin)) );
        grid.setLayoutY(UML_start_Y + 150);


        for (int i = 0; i < NofRows; i++) {
            RowConstraints rowConstraint = new RowConstraints(fontSize*2);
            rowConstraint.setValignment(VPos.TOP);
            ColumnConstraints ColumnConstraints = new ColumnConstraints();
            ColumnConstraints.setHalignment(HPos.RIGHT);
            if (left) ColumnConstraints.setHalignment(HPos.LEFT);
            grid.getColumnConstraints().add(ColumnConstraints);
            grid.getRowConstraints().add(rowConstraint);
        }
        return grid;
    }


    public static Text make_Text_left(String s, int fontSize)
    {
        Text text = new Text(s);
        text.setFont(Font.font("Consolas", fontSize));
        text.setFill(Color.BLACK);

        return text;
    }

    public static Text make_Text_right(int NofObjects,int NofFields, int fontSize)
    {
        Text text = new Text("[No of objects: " + String.valueOf(NofObjects) + " No of fields: " + String.valueOf(NofFields) + "]");
        text.setFont(Font.font("Consolas", fontSize));
        text.setFill(Color.RED);



        return text;
    }


    public static Text make_Text_right(String s, int fontSize)
    {
        Text text = new Text(s);
        text.setFont(Font.font("Consolas", fontSize));
        text.setFill(Color.RED);

        return text;
    }

    public static Group setUp_main_Node()
    {
        Group root = new Group();
        Image background = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\background.png");
        ImageView background_img = new ImageView(background);
        root.getChildren().add(background_img);
        return  root;
    }

    public static Stage setUp_Stage()
    {
        Stage stage = new Stage();

        stage.setWidth(800);
        stage.setHeight(800);
        stage.setTitle("myHttp program!");
        stage.setResizable(false);
        Image icon = new Image("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\src\\icon.png");
        stage.getIcons().add(icon);

        return  stage;
    }




}
