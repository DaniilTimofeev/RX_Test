package com.example.demo.types;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
        /*required:
          - email
          - firstName
          - lastName
        */

    @NotNull
    @Size(min = 1, max = 150)
    public String firstName;


    @NotNull
    @Size(min = 1, max = 150)
    public String lastName;


    @NotNull
    @Email
    @Size(min = 1, max = 254)
    public String email;

    @Valid
    public Adress address;


}