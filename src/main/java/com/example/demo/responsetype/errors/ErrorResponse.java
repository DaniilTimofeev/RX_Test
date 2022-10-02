package com.example.demo.responsetype.errors;

import com.example.demo.responsetype.ReturnType;

public class ErrorResponse implements ReturnType {

    private Error error;
    private FieldError [] fieldErrors;// optional

    public ErrorResponse(Error error, FieldError[] fieldErrors){
        this.error = error;
        this.fieldErrors = fieldErrors;
    }


    public Error getError(){
        return this.error;
    }

    public FieldError[] getFieldError(){
        return this.fieldErrors;
    }

    //additionalProperties: false


}