package Dallash;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import java.io.IOException;


public class main {



    static int i = -1;
    static XSSFWorkbook wb = null;
    static JSONObject mainJSONObject = new JSONObject();

    public static void main(String[] args) {
        BasicConfigurator.configure();

        try {
            wb = ExcelRead.get_Workbook("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\Excels\\basic.xlsx");
        } catch (IOException e) {
            System.out.println("err reading the file\n");
            return;
        }




        recursion( mainJSONObject);
        System.out.print(mainJSONObject);

    }


    public static void recursion(JSONObject JSONobject)
    {
        i++;
        if (i==21)  return;

        String Cureent_cell = ExcelRead.read_Cell(i, 0, 0, wb).getStringCellValue();
        String type = ExcelRead.read_Cell(i, 1, 0, wb).getStringCellValue();
        String [] array =Cureent_cell.split("/");
        String  last_value = array[array.length - 1];

        if (type.equals("string"))
        {
            if(array.length > 2) JSONobject.put(last_value, "string");
            if (array.length == 2) mainJSONObject.put(last_value, "string");
            recursion(JSONobject);
        }
        else
        {
            JSONObject inner = new JSONObject();
            recursion(inner);
            if(array.length > 2) JSONobject.put(type, inner);
            if (array.length == 2)mainJSONObject.put(type, inner);
        }


    }



}
