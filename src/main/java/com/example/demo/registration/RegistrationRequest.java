package com.example.demo.registration;

import com.example.demo.types.Organization;
import com.example.demo.types.Person;

public class RegistrationRequest
{
        /*required:
        - person
        - registrationDate
      */

    
    public String registrationDate;
    //format: date-time
    //example: '2020-05-21T23:11:46.5983455+03:00'
    public String locale;
    //example: en
    public Person person;

    public Organization organisation;



    // additionalProperties: false
}