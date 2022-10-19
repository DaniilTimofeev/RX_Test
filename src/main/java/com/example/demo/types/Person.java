package com.example.demo.types;

import java.util.Objects;
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


    public boolean equals(Person passedObject) {
       if(this.firstName.equals(passedObject.firstName) && this.lastName.equals(passedObject.lastName) && this.email.equals(passedObject.email)){
           if(this.address != null)
               if(!this.address.equals(passedObject.address))
                   return false;
           return true;
       }

       return false;
    }


}