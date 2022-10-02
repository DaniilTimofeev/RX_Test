package com.example.demo.responsetype.errors;

import com.example.demo.responsetype.ReturnType;

public class ErrorResponse{

    private Error error;
    private FieldError [] fieldErrors;// optional

    public ErrorResponse(Error error, FieldError[] fieldErrors){
        this.error = error;
        this.fieldErrors = fieldErrors;
    }


    //additionalProperties: false


}