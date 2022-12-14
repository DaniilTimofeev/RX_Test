package com.example.demo.types;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Adress {
        /* required:
           - addressLine1
           - countryIsoCode
        */

    public String locale;

    @NotNull
    @Size(min = 1, max = 150)
    public String addressLine1;


    @Size(min = 0, max = 150)
    public String addressLine2;


    @Size(min = 0, max = 150)
    public String addressLine3;


    @Size(max = 40)
    public String city;


    @Size(max = 60)
    public String state;


    @Size(max = 60)
    public String postcode;

    @NotNull
    @Size(min = 1)
    public String countryIsoCode;

    public boolean equals(Adress passedObject){
        return true;
    }

}