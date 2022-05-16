package Dallash;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        XSSFWorkbook wb = null;
        try {
            wb = ExcelRead.get_Workbook("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\Excels\\basic.xlsx");
        } catch (IOException e) {
            System.out.println("err reading the file\n");
            return;
        }
        String Cureent_cell;
        String type;
        String last_value;
        Stack<JSONObject> stack = new Stack<>();
        JSONObject mainJSONObject = new JSONObject();

        JSONObject JsonObj;



        for (int i= 0; i <4; i++)
        {
            Cureent_cell = ExcelRead.read_Cell(i, 0, 0, wb).getStringCellValue();
            type = ExcelRead.read_Cell(i, 1, 0, wb).getStringCellValue();
            String [] array =Cureent_cell.split("/");
            last_value = array[array.length - 1];



            if ( type.equals("string") )
            {
                stack.peek().put(last_value , "string");
            }
            else
            {
                JSONObject JSONobject = new JSONObject();
                stack.push(JSONobject);
            }

        }



        mainJSONObject.put("object1" , stack.pop());
        System.out.println(mainJSONObject);

    }


}
