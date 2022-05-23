package com.utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public final class ExcelRead {
    private  ExcelRead() {}


    static public XSSFWorkbook get_Workbook(String string) throws IOException
    {
        FileInputStream myFile = new FileInputStream(string);
        return  new XSSFWorkbook(myFile);
    }

    static public String read_Cell(int Row, int Cell, int sheet, XSSFWorkbook workbook)
    {
        try
        {
            workbook.getSheetAt(sheet).getRow(Row).getCell(Cell);
            return  workbook.getSheetAt(sheet).getRow(Row).getCell(Cell).getStringCellValue();
        }
        catch (NullPointerException e)
        {
            return "";
        }
    }

    static public XSSFCell read_Cell(int Row, int Cell,  XSSFWorkbook workbook)
    {
        return (workbook.getSheetAt(0).getRow(Row).getCell(Cell));
    }

    static public XSSFRow read_Row(XSSFCell cell)
    {
        return  cell.getRow();
    }


   /* static public String Cell_toString(XSSFCell cell)
    {
        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case NUMERIC:
                System.out.print(cell.getNumericCellValue());
                break;
        }*/



    //clearAllCachedResultValues() "C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Projest\\Excels"

}
