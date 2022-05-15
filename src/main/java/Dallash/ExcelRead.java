package Dallash;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public final class ExcelRead {
    private  ExcelRead() {};


    static public HSSFWorkbook get_Workbook(String string) throws IOException
    {
        FileInputStream myFile = new FileInputStream(string);
        return  new HSSFWorkbook(myFile);
    }

    static public HSSFCell read_Cell(int Row, int Cell, int sheet, HSSFWorkbook workbook)
    {
        return (workbook.getSheetAt(sheet).getRow(Row).getCell(Cell));
    }

    static public HSSFCell read_Cell(int Row, int Cell,  HSSFWorkbook workbook)
    {
        return (workbook.getSheetAt(0).getRow(Row).getCell(Cell));
    }

    static public HSSFRow read_Row(HSSFCell cell)
    {
        return  cell.getRow();
    }

    static public HSSFCell read_Row(HSSFRow row)
    {
        return  row.getCell();
    }



    //todo clearAllCachedResultValues() "C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Projest\\Excels"

}
