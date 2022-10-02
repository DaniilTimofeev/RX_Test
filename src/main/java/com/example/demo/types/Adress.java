package com.example.demo.types;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;



public class Adress{
        /* required:
           - addressLine1
           - countryIsoCode
        */

    public String locale;
    //example: en


    @Size(min = 1, max = 150)
    public String addressLine1;
        /* maxLength: 150
         minLength: 1
        */
    //example: Gateway House

    @Size(min = 0, max = 150)
    public String addressLine2;
        /* maxLength: 150
         minLength: 0
        */
    //example: Gateway House

    @Size(min = 0, max = 150)
    public String addressLine3;
        /* maxLength: 150
         minLength: 0
        */
    //example: Gateway House

    @Size(max = 40)
    public String city;
    //maxLength: 40
    // example: Richmond

    @Size(max = 60)
    public String state;
    //maxLength: 60
    //example: Surrey

    @Size(max = 60)
    public String postcode;
    //maxLength: 60
    //example: TW9 1DN

    @Size(min = 1)
    public String countryIsoCode;
    //minLength: 1
    //example: GBR



    //additionalProperties: false
}