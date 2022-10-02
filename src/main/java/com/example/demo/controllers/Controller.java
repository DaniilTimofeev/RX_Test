package com.example.demo.controllers;

import com.example.demo.responsetype.success.RegistrationResponse;
import com.example.demo.registration.GetRegistrationResponse;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.responsetype.ReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ReturnType> getController(@PathVariable String registrationId,
                                                    @RequestHeader(value = "x-correlationid") String x_correlationid){

        GetRegistrationResponse responseOBJ = repository.get(x_correlationid);
//                .orElseThrow(() -> new Error("404", "User by registrationId = [" + registrationId +"] was not found"));


        //add check for UUID
        responseOBJ.id.equals(registrationId);


        ResponseEntity entity = new ResponseEntity(responseOBJ, HttpStatus.OK);



        return  entity;

        //Human friendly error message
        //TAKES registrationId(PATH) AND x-correlationid(HEADER) AS PARAMETERS
        // Retuns GetRegistrationResponse, Error
        //SHOULD ADD SEARCHING BY ID IF STORAGE LIST

    }

    //SWAP RETURN TYPE TO ResponseEntity<STRING>
    @PostMapping("/api/v1/registrations")
    public  ResponseEntity<ReturnType> postController(@RequestBody RegistrationRequest request, @RequestHeader(value = "x-correlationid") String x_correlationid){


        String userUUID = UUID.randomUUID().toString();
        repository.put(x_correlationid, new GetRegistrationResponse(request, userUUID));

//        return new RegistrationResponse(userUUID);

        return new ResponseEntity<>(new RegistrationResponse(userUUID), HttpStatus.CREATED);

//        repository
        //Takes RegistrationRequest(HEADER) as a parameter
        //SHOULD FORM GetRegistrationResponse object
        // returns RegistrationResponse, ErrorResponse or Error
//        return null;
    }


//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}
