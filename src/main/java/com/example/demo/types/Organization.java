package com.example.demo.types;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Organization {
    /*required:
    - address
    - name
    */
    @NotNull
    @Size(min = 1, max = 120)
    public String name;

    @NotNull
    @Valid
    public Adress address;

}