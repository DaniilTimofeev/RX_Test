package com.example.demo;

import static com.example.demo.utility.JSonConversion.stringToObject;
import static com.example.demo.utility.PostGetRequest.sendGet;
import static com.example.demo.utility.PostGetRequest.sendPost;

import com.example.demo.registration.RegistrationRequest;
import com.example.demo.responsetype.success.GetRegistrationResponse;
import com.example.demo.responsetype.success.RegistrationResponse;
import org.junit.jupiter.api.Assertions;
import jdk.jfr.Description;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void positiveTest() throws ParseException {

        final String CORRELATION_ID =  "12345";

        ResponseEntity<String> postResponse = sendPost(registrationRequestJsonString(), CORRELATION_ID);

        //assertion of post status codes
        Assertions.assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
        RegistrationResponse registrationResponseObject = (RegistrationResponse) stringToObject(postResponse.getBody(),RegistrationResponse.class);

        //assertion of get status codes
        ResponseEntity<String> getResponse = sendGet(registrationResponseObject.registrationId, CORRELATION_ID);
        Assertions.assertEquals(HttpStatus.OK, getResponse.getStatusCode());

        GetRegistrationResponse getResponseObject = (GetRegistrationResponse) stringToObject(getResponse.getBody(), GetRegistrationResponse.class);



        //assertion of expected and actual json objects

        Assertions.assertEquals(registrationRequestJsonString(), getResponse.getBody());

        //        GetRegistrationResponse getRegistrationResponse = (GetRegistrationResponse)stringToObject(sendGet(postResponse.ge.registrationId,"12345").getBody(), GetRegistrationResponse.class);

//        ResponseEntity<?> getResponse =


        //        RegistrationResponse s = (RegistrationResponse)stringToObject(body, RegistrationResponse.class);
//
//        RegistrationRequest requestObject=  (RegistrationRequest)stringToObject(registrationRequestJsonString(), RegistrationRequest.class);
//
//
//        System.out.println(s.registrationId);
//
//        GetRegistrationResponse getRegistrationResponse = (GetRegistrationResponse)stringToObject(sendGet(s.registrationId,"12345").getBody(), GetRegistrationResponse.class);
//        System.out.println(getRegistrationResponse.organisation.name);



    }


    @Test
    @Description("Missing FirstName")
    void negativeTest(){


    }

    public static String registrationRequestJsonString() {
        return "{\n" + "  \"registrationDate\": \"2020-05-21T23:11:46.616597+03:00\",\n" + "  \"locale\": \"en\",\n" + "  \"person\": {\n" + "    \"firstName\": \"Joe\",\n"
            + "    \"lastName\": \"Bloggs\",\n" + "    \"email\": \"jjbloggs@mailinator.com\",\n" + "    \"address\": {\n" + "      \"locale\": \"en\",\n"
            + "      \"addressLine1\": \"Gateway House\",\n" + "      \"addressLine2\": \"28 The Quadrant\",\n" + "      \"addressLine3\": \"\",\n" + "      \"city\": \"Richmond\",\n"
            + "      \"state\": \"Surrey\",\n" + "      \"postcode\": \"TW9 1DN\",\n" + "      \"countryIsoCode\": \"GBR\"\n" + "    }\n" + "  },\n" + "  \"organisation\": {\n"
            + "    \"name\": \"Acme Ltd\",\n" + "    \"address\": {\n" + "      \"locale\": \"en\",\n" + "      \"addressLine1\": \"Gateway House\",\n"
            + "      \"addressLine2\": \"28 The Quadrant\",\n" + "      \"addressLine3\": \"\",\n" + "      \"city\": \"Richmond\",\n" + "      \"state\": \"Surrey\",\n"
            + "      \"postcode\": \"TW9 1DN\",\n" + "      \"countryIsoCode\": \"GBR\"\n" + "    }\n" + "  }\n" + "}";
    }





}
