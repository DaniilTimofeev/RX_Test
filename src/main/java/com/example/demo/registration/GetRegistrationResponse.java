package com.example.demo.registration;

import com.example.demo.registration.RegistrationRequest;
import com.example.demo.responsetype.ReturnType;
import com.example.demo.types.Organization;
import com.example.demo.types.Person;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GetRegistrationResponse implements ReturnType {
        /*required:
        - person
        - registrationDate
        */

    public String id;

    //  format: uuid


    public String registrationDate;
    // format: date-time
    // example: '2020-05-21T23:11:46.5983455+03:00'


    public String locale;
    //example: en

    public @Valid Person person;

    public @Valid Organization organisation;

    public GetRegistrationResponse(RegistrationRequest request, String id){
        this.id = id;
        this.person = request.person;
        this.registrationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault()).format(new Date());
        this.locale = request.locale;
        this.organisation = request.organisation;
    }


    //additionalProperties: false
}