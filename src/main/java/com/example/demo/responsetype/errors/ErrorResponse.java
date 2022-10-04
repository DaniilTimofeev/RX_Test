package com.example.demo.responsetype.errors;

public class ErrorResponse {

    public Error error;
    public FieldError[] fieldErrors;// optional

    public ErrorResponse(Error error, FieldError[] fieldErrors) {
        this.error = error;
        this.fieldErrors = fieldErrors;
    }


}