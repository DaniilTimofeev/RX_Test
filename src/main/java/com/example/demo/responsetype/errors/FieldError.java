package com.example.demo.responsetype.errors;

public class FieldError {

    public String field;//optional

    public final String code;//optional

    public final String message;//optional


    public FieldError(String field, String code, String message) {
        this.field = field;
        this.code = code;
        this.message = message;
    }
}