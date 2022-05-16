package Dallash;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import java.io.IOException;


public class main {

    static XSSFWorkbook wb = null;
    static JSONObject requestJSONObject = new JSONObject();
    static JSONObject responseJSONObject= new JSONObject();
    static JSONObject APIJSONObject = new JSONObject();








    public static void main(String[] args) {
        BasicConfigurator.configure();

        try {
            wb = ExcelRead.get_Workbook("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\Excels\\basic.xlsx");
        } catch (IOException e) {
            System.out.println("err reading the file\n");
            return;
        }

        recursion(null, -1);

        APIJSONObject.put("request",requestJSONObject);
        APIJSONObject.put("response",responseJSONObject);
        System.out.println(APIJSONObject);
    }


    public static void recursion(JSONObject JSONobject, int i)
    {
        i++;
        if (i==21)  return;

        String Cureent_cell = ExcelRead.read_Cell(i, 1, 0, wb).getStringCellValue();
        String type = ExcelRead.read_Cell(i, 2, 0, wb).getStringCellValue();
        String[] array =Cureent_cell.split("/");
        String last_value = array[array.length - 1];

        if (type.equals("string"))
        {
            if(array.length > 2) JSONobject.put(last_value, "string");
            if (array.length == 2)
            {
                if(isRequest(i)) requestJSONObject.put(last_value, "string");
                else responseJSONObject.put(last_value, "string");
            }
            recursion(JSONobject,i);
        }
        else
        {
            JSONObject inner = new JSONObject();
            recursion(inner,i);
            if(array.length > 2) JSONobject.put(type, inner);
            if (array.length == 2)
            {
                if(isRequest(i)) requestJSONObject.put(type, inner);
                else responseJSONObject.put(type, inner);
            }
        }


    }



    public static boolean isRequest(int x)
    {
        String Cureent_cell = ExcelRead.read_Cell(x, 0, 0, wb).getStringCellValue();
        if (Cureent_cell.equals("I")) return true;
        if (Cureent_cell.equals("O")) return false;
        else return false;
    }




}
