package com.example.demo.controllers;

import com.example.demo.database.ObjectIO;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.responsetype.errors.Error;
import com.example.demo.responsetype.errors.ErrorWrapper;
import com.example.demo.responsetype.success.GetRegistrationResponse;
import com.example.demo.responsetype.success.RegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.UUID;
import static com.example.demo.database.ObjectIO.ReadObjectFromFile;
import static com.example.demo.database.ObjectIO.WriteObjectToFile;


@RestController
public class Controller {


    @GetMapping("/api/v1/registrations/{registrationId}")
    public ResponseEntity<?> getController(@PathVariable String registrationId,
                                           @NotNull @NotEmpty @RequestHeader(value = "x-correlationid") String x_correlationid) {

        try {
            GetRegistrationResponse responseOBJ =  (GetRegistrationResponse)ReadObjectFromFile(x_correlationid);
            if (responseOBJ.id.equals(registrationId) == false)
                throw new NullPointerException();

            return new ResponseEntity(responseOBJ, HttpStatus.OK);
        } catch (NullPointerException npe) {
            return new ResponseEntity(new ErrorWrapper(new Error("InternalServerError", "User with [" + registrationId + "] registration id and [" + x_correlationid + "] x_correlationid was not found "), null), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/api/v1/registrations",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postController(@Valid @RequestBody RegistrationRequest request, @RequestHeader(value = "x-correlationid") String x_correlationid) {

        String userUUID = UUID.randomUUID().toString();
        System.out.println("Sdfasfsdfdsafdasfasdfdsaf");
        if (request.registrationDate == null) {
            GetRegistrationResponse data = new GetRegistrationResponse(request, userUUID);
//            repository.put(x_correlationid, data);
            System.out.println("here");
            WriteObjectToFile(x_correlationid, data);
        }else {

            GetRegistrationResponse data = new GetRegistrationResponse(request, userUUID, request.registrationDate);
            WriteObjectToFile(x_correlationid, data);
//            repository.put(x_correlationid, data);
            System.out.println("here");
        }
        return new ResponseEntity<>(new RegistrationResponse(userUUID), HttpStatus.CREATED);

    }


    @DeleteMapping("/api/v1/registrations/{registrationId}")
    public ResponseEntity<?> deleteRegistered(@PathVariable String registrationId,
                                              @NotNull @NotEmpty @RequestHeader(value = "x-correlationid") String x_correlationid) {
//        try {
//            if (repository.get(x_correlationid).id.equals(registrationId))
//                repository.remove(x_correlationid);
//            else
//                throw new NullPointerException();
//        } catch (NullPointerException ex) {
//            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
