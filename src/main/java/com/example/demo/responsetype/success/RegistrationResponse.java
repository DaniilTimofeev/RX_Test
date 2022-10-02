package com.example.demo.responsetype.success;

import com.example.demo.responsetype.ReturnType;

public class RegistrationResponse {

    public String registrationId;
    public RegistrationResponse(String userUUID){
        this.registrationId = userUUID;
    }

}
