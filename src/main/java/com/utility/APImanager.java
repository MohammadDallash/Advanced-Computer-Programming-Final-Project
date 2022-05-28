package com.utility;

import com.webApplication.Field;
import com.webApplication.Obj;
import com.webApplication.Operation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class APImanager {

    private XSSFWorkbook wb = null;
    private  int EOF;


    private ArrayList<Operation> Service = new ArrayList<Operation>();

    private int iterator;

    public APImanager(String file_path)
    {
        try
        {
            wb = ExcelRead.get_Workbook(file_path);
            this.EOF = wb.getSheetAt(0).getLastRowNum();
        } catch (IOException e)
        {
            System.out.println("err reading the file\n");
        }

    }


    public ArrayList<Operation> get_api()
    {
        String Current_cell;

        for (this.iterator = 0; iterator < this.EOF; this.iterator++)
        {
            Current_cell = ExcelRead.read_Cell(this.iterator, 0, 0, wb);
            if (Current_cell.startsWith("REST Operation Mapping"))
            {
                String APIname = Current_cell.replace("REST Operation Mapping (","").replace(")","");
                Operation operation = new Operation(APIname, ExcelRead.read_Cell(iterator+2, 0, 0, wb), ExcelRead.read_Cell(iterator+2, 1, 0, wb));


                while (this.iterator < this.EOF)
                {
                    this.iterator ++;
                    Current_cell = ExcelRead.read_Cell(this.iterator, 0, 0, wb);
                    if (Current_cell.equals("I/o")) break;
                }
                recursion(null , operation, this.iterator);

                this.Service.add(operation);
            }
        }

        return this.Service;
    }

    public  void recursion(Obj obj, Operation operation, int i )
    {
        i++;
        String Cureent_cell = ExcelRead.read_Cell(i, 1, 0, wb);
        if (i>=this.EOF || Cureent_cell.equals(""))
        {
            this.iterator = i;
            return;
        }
        String type = ExcelRead.read_Cell(i, 2, 0, wb);
        String[] array =Cureent_cell.split("/");
        String last_value = array[array.length - 1];

        if (type.equals("string"))
        {
            String Allowed_Values =  ExcelRead.read_Cell(i, 3, 0, wb);
            String Mandatory = ExcelRead.read_Cell(i, 4, 0, wb);
            if(array.length > 2) obj.addField( new Field(last_value, Allowed_Values, Mandatory));
            if (array.length == 2)
            {
                if(isRequest(i)) operation.add_request_Field(new Field(last_value, Allowed_Values, Mandatory));
                else operation.add_response_Field(new Field(last_value, Allowed_Values, Mandatory));
            }
            recursion( obj, operation, i);
        }
        else
        {
            Obj inner = new Obj(last_value, get_Mandatory(i));
            recursion( inner, operation, i);
            if(array.length > 2) obj.addObj(inner);
            if (array.length == 2)
            {
                if(isRequest(i)) operation.add_request_Obj(inner);
                else operation.add_response_Obj(inner);
            }
        }
    }


    public  boolean isRequest(int x)
    {
        String Cureent_cell = ExcelRead.read_Cell(x, 0, 0, wb);
        if (Cureent_cell.equals("I")) return true;
        return false;
    }



    public String get_Mandatory(int x)
    {
        return ExcelRead.read_Cell(x, 4, 0, wb);
    }



}
