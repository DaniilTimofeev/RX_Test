package com.example.demo.types;
public class Person
{

        /*required:
          - email
          - firstName
          - lastName
        */

    public String firstName;

    //maxLength: 150
    //minLength:
    //example: Joe

    public String lastName;
    //maxLength: 150
    //minLength: 1
    //example: Bloggs

    public String email;
    //maxLength: 254
    //minLength:
    //example: jjbloggs @mailinator.com


    Adress address;



    //additionalProperties: false
}