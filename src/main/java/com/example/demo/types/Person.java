package com.example.demo.types;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Person
{

        /*required:
          - email
          - firstName
          - lastName
        */

    @Size(min = 1, max = 150)
    public String firstName;
    //example: Joe

    @Size(min = 1, max = 150)
    public String lastName;
    //example: Bloggs

    @Email
    @Size(min = 1, max = 254)
    public String email;
    //example: jjbloggs @mailinator.com


    Adress address;



    //additionalProperties: false
}