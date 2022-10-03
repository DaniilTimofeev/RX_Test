package com.example.demo.responsetype.errors;

public class Error{
    public final String  code;//Optional

    public final String message;//Optional

    public Error(String code, String message)    {
        this.code = code;
        this.message = message;
    }

    //additionalProperties: false
}
