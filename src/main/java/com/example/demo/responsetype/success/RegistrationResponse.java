package com.example.demo.responsetype.success;

import com.example.demo.responsetype.ReturnType;

public class RegistrationResponse implements ReturnType {

    public String registrationId;
    public RegistrationResponse(String userUUID){
        this.registrationId = userUUID;
    }

}
