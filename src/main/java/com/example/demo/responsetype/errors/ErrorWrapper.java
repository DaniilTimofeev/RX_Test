package com.example.demo.responsetype.errors;

import com.example.demo.responsetype.ReturnType;

public class ErrorWrapper {
    public Error error;
    public FieldError [] fieldErrors;// optional

    public ErrorWrapper(Error error, FieldError[] fieldErrors){
        this.error = error;
        this.fieldErrors = fieldErrors;
    }
}
