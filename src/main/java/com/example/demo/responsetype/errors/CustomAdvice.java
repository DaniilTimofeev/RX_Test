package com.example.demo.responsetype.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@org.springframework.web.bind.annotation.ControllerAdvice
public class CustomAdvice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> conflict(MethodArgumentNotValidException exception) {

        List<org.springframework.validation.FieldError> exceptionFieldsList = exception.getFieldErrors();
        int errorFieldsSize = exceptionFieldsList.size();
        FieldError[] errorList = new FieldError[errorFieldsSize];
        for (int i = 0; i < errorFieldsSize; i++) {
            errorList[i] = new FieldError(exceptionFieldsList.get(i).getField(), "ValidationFailed", exceptionFieldsList.get(i).getDefaultMessage());

        }
        return new ResponseEntity<>(new ErrorResponse(new Error("ValidationFailed", null), errorList), HttpStatus.BAD_REQUEST);
    }
}
