package com.example.demo.utility;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class PostGetRequest {

    public static ResponseEntity<String> sendPost(String requestBody,  String x_correlationid) {

        WebClient client = WebClient.create();



        ClientResponse clientResponse = client.post()
            .uri("http://localhost:8080/api/v1/registrations")
            .header("x-correlationid", x_correlationid)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .block();

        return clientResponse.toEntity(String.class).block();
    }


    public static ResponseEntity<String> sendGet(String registrationId,  String x_correlationid) {
        WebClient client = WebClient.create();


        ClientResponse clientResponse = client.get()
            .uri("http://localhost:8080/api/v1/registrations/" + registrationId)
            .header("x-correlationid", x_correlationid)
            .exchange()
            .block();

        return clientResponse.toEntity(String.class).block();
    }

}
