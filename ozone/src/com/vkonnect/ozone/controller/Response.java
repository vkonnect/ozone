package com.vkonnect.ozone.controller;


public class Response
{

    private Object responseBody;
    private String message;
    private int responseCode;


    public Response()
    {
        responseCode = 200; // default HTTP 200 OK
    }


    public Object getResponseBody ()
    {
        return responseBody;
    }


    public void setResponseBody (Object responseBody)
    {
        this.responseBody = responseBody;
    }


    public String getMessage ()
    {
        return message;
    }


    public void setMessage (String message)
    {
        this.message = message;
    }


    public int getResponseCode ()
    {
        return responseCode;
    }


    public void setResponseCode (int responseCode)
    {
        this.responseCode = responseCode;
    }


}