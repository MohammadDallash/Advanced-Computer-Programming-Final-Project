package Dallash;

public class Operation {
    private String API_NAME;
    private  String HTTP_Operation;
    private  String REST_URL;
    private Protocol request = new Protocol();
    private Protocol response= new Protocol();


    public Operation (String API_NAME, String HTTP_Operation, String REST_URL)
    {
        this.API_NAME = API_NAME;
        this.HTTP_Operation = HTTP_Operation;
        this.REST_URL = REST_URL;
    }

    public  void add_request_Obj (Obj obj)
    {
        this.request.addObj(obj);
    }

    public  void add_response_Obj (Obj obj)
    {
        this.response.addObj(obj);
    }


    public  void add_request_Field (Field field)
    {
        this.request.addField(field);
    }

    public  void add_response_Field (Field field)
    {
        this.response.addField(field);
    }



}
