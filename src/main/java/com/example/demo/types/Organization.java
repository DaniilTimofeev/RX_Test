package com.example.demo.types;
public class Organization
{


        /*required:
        - address
        - name
        */



    public String name;
    //maxLength: 120
    //minLength: 1
    //example: Acme Ltd

    public Adress address;

    //additionalProperties: false
}