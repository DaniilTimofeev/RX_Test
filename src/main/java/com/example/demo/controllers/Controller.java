package com.example.demo.controllers;

import com.example.demo.responsetype.errors.Error;
import com.example.demo.responsetype.errors.ErrorWrapper;
import com.example.demo.responsetype.success.RegistrationResponse;
import com.example.demo.responsetype.success.GetRegistrationResponse;
import com.example.demo.registration.RegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.UUID;


@RestController
public class Controller {

//    private final UserRepository repository;
    private final HashMap<String, GetRegistrationResponse> repository;

    Controller() {
//        this.repository = repository;
        repository = new HashMap<>();
    }

//SWAP RETURN TYPE TO ResponseEntity<String>
    @GetMapping("/api/v1/registrations/{registrationId}")
    public ResponseEntity<?> getController(@PathVariable String registrationId,
                                                    @RequestHeader(value = "x-correlationid") String x_correlationid){
        ResponseEntity entity;


        try {
            GetRegistrationResponse responseOBJ = repository.get(x_correlationid);
            responseOBJ.id.equals(registrationId);
            entity = new ResponseEntity(responseOBJ, HttpStatus.OK);

        }catch(NullPointerException npe){
            //return
            entity = new ResponseEntity<>(new ErrorWrapper(new Error("InternalServerError", "User with [" + registrationId + "] registration id as not found "), null), HttpStatus.NOT_FOUND);
        }

        //add check for UUID



        return  entity;

        //Human friendly error message
        //TAKES registrationId(PATH) AND x-correlationid(HEADER) AS PARAMETERS
        // Retuns GetRegistrationResponse, Error
        //SHOULD ADD SEARCHING BY ID IF STORAGE LIST

    }

    //SWAP RETURN TYPE TO ResponseEntity<STRING>
    @PostMapping("/api/v1/registrations")
    public  ResponseEntity<?> postController(@Valid @RequestBody RegistrationRequest request, @RequestHeader(value = "x-correlationid") String x_correlationid){

        String userUUID = UUID.randomUUID().toString();
        repository.put(x_correlationid, new GetRegistrationResponse(request, userUUID));
        return new ResponseEntity<>(new RegistrationResponse(userUUID), HttpStatus.CREATED);

        // returns RegistrationResponse, ErrorResponse or Error
    }


//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}
