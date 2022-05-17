package Dallash;

import org.apache.log4j.BasicConfigurator;


public class main
{

    public static void main(String[] args)
    {
        BasicConfigurator.configure();
        APImanager myManager =  new APImanager("C:\\Users\\Mohammad Dallash\\Documents\\GitHub\\Advanced-Computer-Programming-Final-Project\\Excels\\basic.xlsx");
        System.out.println(myManager.get_api());
    }

}
