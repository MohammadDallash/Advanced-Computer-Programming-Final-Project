package Dallash;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

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

        System.out.println(ExcelRead.read_Cell(0, 0, 0, wb).getStringCellValue());

    }


}
