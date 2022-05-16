package Dallash;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Stack;

public class main {


    static String Cureent_cell;
    static String type;
    static String last_value;
    static int i = 0;
    static XSSFWorkbook wb = null;


    public static void main(String[] args) {
        BasicConfigurator.configure();

        try {
            wb = ExcelRead.get_Workbook("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\Excels\\basic.xlsx");
        } catch (IOException e) {
            System.out.println("err reading the file\n");
            return;
        }



        JSONObject mainJSONObject = new JSONObject();


        recursion("object1", mainJSONObject);
        System.out.println(mainJSONObject);

    }


    public static void recursion(String lookFor, JSONObject JSONobject)
    {
        Cureent_cell = ExcelRead.read_Cell(i, 0, 0, wb).getStringCellValue();
        type = ExcelRead.read_Cell(i, 1, 0, wb).getStringCellValue();
        String [] array =Cureent_cell.split("/");
        last_value = array[array.length - 1];
        if (array.length <= 2 )  return;

        if (type.equals("string"))
        {
            JSONobject.put(lookFor, last_value);
            i++;
            recursion(lookFor, JSONobject);
        }
        else
        {
            JSONObject inner = new JSONObject();
            i++;
            recursion(type, inner);
            JSONobject.put(type, inner);
        }


    }



}
