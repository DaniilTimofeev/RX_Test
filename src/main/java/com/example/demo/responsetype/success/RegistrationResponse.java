package com.example.demo.responsetype.success;

public class RegistrationResponse {

    public String registrationId;

    public RegistrationResponse(String userUUID) {
        this.registrationId = userUUID;
    }

}
