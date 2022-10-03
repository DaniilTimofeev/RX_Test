package com.example.demo.types;

import javax.validation.Valid;
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


    @Size(min = 1, max = 150)
    public String lastName;


    @Email
    @Size(min = 1, max = 254)
    public String email;

    @Valid
    public Adress address;


}