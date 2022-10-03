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

            if(x_correlationid.equals("cyberpunk2077"))
                return new ResponseEntity(new ErrorWrapper(new Error("InternalServerError", "We are sorry, the problem is on our side"), null), HttpStatus.INTERNAL_SERVER_ERROR);

            GetRegistrationResponse responseOBJ = repository.get(x_correlationid);
            if(responseOBJ.id.equals(registrationId)==false)
                throw new NullPointerException();
            return new ResponseEntity(responseOBJ, HttpStatus.OK);
        }catch(NullPointerException npe) {
            return new ResponseEntity(new ErrorWrapper(new Error("InternalServerError", "User with [" + registrationId + "] registration id and [" + x_correlationid + "] x_correlationid was not found "), null), HttpStatus.NOT_FOUND);
        }
        // Retuns GetRegistrationResponse, Error
    }




    @PostMapping("/api/v1/registrations")
    public  ResponseEntity<?> postController(@Valid @RequestBody RegistrationRequest request, @RequestHeader(value = "x-correlationid") String x_correlationid){

        String userUUID = UUID.randomUUID().toString();
        repository.put(x_correlationid, new GetRegistrationResponse(request, userUUID));
        return new ResponseEntity<>(new RegistrationResponse(userUUID), HttpStatus.CREATED);

        // returns RegistrationResponse, ErrorResponse or Error
    }




    ///ADD CHECK @Valid






//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}
