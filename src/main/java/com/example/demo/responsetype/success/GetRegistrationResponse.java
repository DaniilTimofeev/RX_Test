package com.example.demo.responsetype.success;

import com.example.demo.registration.RegistrationRequest;
import com.example.demo.types.Organization;
import com.example.demo.types.Person;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GetRegistrationResponse implements Serializable {
        /*required:
        - person
        - registrationDate
        */

    public String id;

    @NotNull
    public String registrationDate;

    public String locale;

    @NotNull
    @Valid
    public Person person;

    @Valid
    public Organization organisation;

    public GetRegistrationResponse(RegistrationRequest request, String id) {
        this.id = id;
        this.person = request.person;
        this.registrationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault()).format(new Date());
        this.locale = request.locale;
        this.organisation = request.organisation;
    }

    public GetRegistrationResponse(RegistrationRequest request, String id, String registrationDate) {
        this.id = id;
        this.person = request.person;
        this.registrationDate = registrationDate;
        this.locale = request.locale;
        this.organisation = request.organisation;

    }


}