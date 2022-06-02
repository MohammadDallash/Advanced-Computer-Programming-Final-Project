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
        XSSFWorkbook myworkbook = new XSSFWorkbook(myFile);
        myFile.close();
        return  myworkbook ;
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


}
