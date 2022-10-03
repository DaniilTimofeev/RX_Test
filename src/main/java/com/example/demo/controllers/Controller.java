package com.example.demo.controllers;

import com.example.demo.responsetype.errors.Error;
import com.example.demo.responsetype.errors.ErrorResponse;
import com.example.demo.responsetype.errors.ErrorWrapper;
import com.example.demo.responsetype.success.RegistrationResponse;
import com.example.demo.responsetype.success.GetRegistrationResponse;
import com.example.demo.registration.RegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
public class Controller {
    private final HashMap<String, GetRegistrationResponse> repository;

    Controller() {
        repository = new HashMap<>();
    }

    @GetMapping("/api/v1/registrations/{registrationId}")
    public ResponseEntity<?> getController(@PathVariable String registrationId,
                                                    @NotNull @NotEmpty @RequestHeader(value = "x-correlationid") String x_correlationid){
        ResponseEntity entity;
        try {
            GetRegistrationResponse responseOBJ = repository.get(x_correlationid);
            if(responseOBJ.id.equals(registrationId)==false)
                throw new NullPointerException();

            return new ResponseEntity(responseOBJ, HttpStatus.OK);
        }catch(NullPointerException npe) {
            return new ResponseEntity(new ErrorWrapper(new Error("InternalServerError", "User with [" + registrationId + "] registration id and [" + x_correlationid + "] x_correlationid was not found "), null), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/api/v1/registrations")
    public  ResponseEntity<?> postController(@Valid @RequestBody RegistrationRequest request, @RequestHeader(value = "x-correlationid") String x_correlationid){

        String userUUID = UUID.randomUUID().toString();
        repository.put(x_correlationid, new GetRegistrationResponse(request, userUUID));
        return new ResponseEntity<>(new RegistrationResponse(userUUID), HttpStatus.CREATED);

    }



    @DeleteMapping("/api/v1/registrations/{registrationId}")
    public ResponseEntity<?> deleteRegistered(@PathVariable String registrationId,
                                                    @NotNull @NotEmpty @RequestHeader(value = "x-correlationid") String x_correlationid) {
        try{
            if(repository.get(x_correlationid).id.equals(registrationId))
                repository.remove(x_correlationid);
            else
                throw new NullPointerException();
        }catch(NullPointerException ex){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> conflict(MethodArgumentNotValidException exception, @RequestBody RegistrationRequest request) {
        ArrayList<String> errorList = new ArrayList<>();
        for(FieldError error : exception.getFieldErrors())
            errorList.add(error.getDefaultMessage());
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

}
