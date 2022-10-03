package com.example.demo.types;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class Organization {
        /*required:
        - address
        - name
        */

    @Size(min = 1, max = 120)
    public String name;

    @Valid
    public Adress address;

}