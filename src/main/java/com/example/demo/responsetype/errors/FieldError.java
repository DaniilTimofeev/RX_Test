package com.example.demo.responsetype.errors;

import com.example.demo.responsetype.ReturnType;

public class FieldError {

    private String field;//optional

    private final String code;//optional

    private final String message;//optional


    public FieldError(String field, String code, String message){
        this.field = field;
        this.code = code;
        this.message = message;
    }

    public String getField(){
        return this.field;
    }

    public String getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }


    //additionalProperties: false
}