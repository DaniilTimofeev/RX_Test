package com.example.demo.responsetype.errors;

import com.example.demo.responsetype.ReturnType;

public class Error extends RuntimeException implements ReturnType {
    private final String  code;//Optional

    private final String message;//Optional

    public Error(String code, String message)    {
        this.code = code;
        this.message = message;
    }

    //additionalProperties: false
}
