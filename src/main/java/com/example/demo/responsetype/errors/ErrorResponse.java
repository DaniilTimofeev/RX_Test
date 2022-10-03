package com.example.demo.responsetype.errors;

public class ErrorResponse{

    private Error error;
    private FieldError [] fieldErrors;// optional

    public ErrorResponse(Error error, FieldError[] fieldErrors){
        this.error = error;
        this.fieldErrors = fieldErrors;
    }




}