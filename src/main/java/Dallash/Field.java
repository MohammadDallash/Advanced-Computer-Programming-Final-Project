package Dallash;

public class Field {
    private final String Allowed_Values;
    private final String mandatory;
    private final String name;

    public Field (String name,String Allowed_Values,  String mandatory)
    {
        this.name = name;
        this.Allowed_Values = Allowed_Values;
        this.mandatory = mandatory;
    }

    public String getAllowed_Values()
    {
        return this.Allowed_Values;
    }
    public String getMandatory()
    {
        return this.mandatory;
    }

    public String getName() {
        return this.name;
    }
}
