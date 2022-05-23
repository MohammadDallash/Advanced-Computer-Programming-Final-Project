package com.webApplication;

import com.webApplication.Field;
import com.webApplication.Obj;

import java.util.ArrayList;

public class Protocol {
    private ArrayList<Obj> objs = new ArrayList<Obj>();
    private ArrayList<Field> fields = new ArrayList<Field>();

    public Protocol()
    {

    }



    public void addObj (Obj obj)
    {
        this.objs.add(obj);
    }


    public void addField (Field field)
    {
        this.fields.add(field);
    }

}
