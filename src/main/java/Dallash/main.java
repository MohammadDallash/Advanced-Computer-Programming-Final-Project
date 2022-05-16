package Dallash;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
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
        String data;
        Stack<String> stack = new Stack<>();
        for (int i= 0; i <3; i++)
        {
            data = ExcelRead.read_Cell(i, 0, 0, wb).getStringCellValue();
            String [] array =data.split("/");
            stack.push(  array[array.length-1]  );
        }

        System.out.println(stack);


    }


}
