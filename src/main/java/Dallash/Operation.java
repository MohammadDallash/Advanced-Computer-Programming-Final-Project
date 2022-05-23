package Dallash;

public class Operation {
    private String API_NAME;
    private  String HTTP_Operation;
    private  String REST_URL;
    private Protocol request;
    private Protocol response;


    public Operation (String API_NAME, String HTTP_Operation, String REST_URL)
    {
        this.API_NAME = API_NAME;
        this.HTTP_Operation = HTTP_Operation;
        this.REST_URL = REST_URL;
    }



}
