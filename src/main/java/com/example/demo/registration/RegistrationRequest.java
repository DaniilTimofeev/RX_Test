package com.example.demo.registration;

import com.example.demo.types.Organization;
import com.example.demo.types.Person;

import javax.validation.Valid;

public class RegistrationRequest{
        /*required:
        - person
        - registrationDate
      */

    
    public String registrationDate;

    public String locale;
    //example: en

    @Valid
    public Person person;

    @Valid
    public Organization organisation;


}