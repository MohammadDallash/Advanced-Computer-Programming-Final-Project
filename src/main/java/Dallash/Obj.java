package Dallash;

import java.util.ArrayList;

public class Obj {
    private final String mandatory;
    private final String name;
    private ArrayList<Obj> objs = new ArrayList<Obj>();
    private ArrayList<Field> fields = new ArrayList<Field>();

    public Obj(String name ,String mandatory)
    {
        this.mandatory = mandatory;
        this.name = name;
    }

    public void addObj(Obj obj)
    {
        this.objs.add(obj);
    }

    public void addField (Field field)
    {
        this.fields.add(field);
    }


    public String getMandatory()
    {
        return this.mandatory;
    }

    public String getName()
    {
        return this.name;
    }
}
