package com.example.demo;

import static com.example.demo.utility.PostGetRequest.sendGet;
import static com.example.demo.utility.PostGetRequest.sendPost;

import com.example.demo.responsetype.success.GetRegistrationResponse;
import com.example.demo.responsetype.success.RegistrationResponse;
import com.google.gson.Gson;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws ParseException {

        String body = sendPost(getCreateExpertJsonString(), "12345").getBody();

        System.out.println(body);

        Gson g = new Gson();
        RegistrationResponse s = g.fromJson(body, RegistrationResponse.class);

        System.out.println(s.registrationId);

        GetRegistrationResponse getRegistrationResponse = g.fromJson(sendGet(s.registrationId,"12345").getBody(), GetRegistrationResponse.class);
        System.out.println(getRegistrationResponse.organisation.name);



    }


    public static String getCreateExpertJsonString() {
        return "{\n" + "  \"registrationDate\": \"2020-05-21T23:11:46.616597+03:00\",\n" + "  \"locale\": \"en\",\n" + "  \"person\": {\n" + "    \"firstName\": \"Joe\",\n"
            + "    \"lastName\": \"Bloggs\",\n" + "    \"email\": \"jjbloggs@mailinator.com\",\n" + "    \"address\": {\n" + "      \"locale\": \"en\",\n"
            + "      \"addressLine1\": \"Gateway House\",\n" + "      \"addressLine2\": \"28 The Quadrant\",\n" + "      \"addressLine3\": \"\",\n" + "      \"city\": \"Richmond\",\n"
            + "      \"state\": \"Surrey\",\n" + "      \"postcode\": \"TW9 1DN\",\n" + "      \"countryIsoCode\": \"GBR\"\n" + "    }\n" + "  },\n" + "  \"organisation\": {\n"
            + "    \"name\": \"Acme Ltd\",\n" + "    \"address\": {\n" + "      \"locale\": \"en\",\n" + "      \"addressLine1\": \"Gateway House\",\n"
            + "      \"addressLine2\": \"28 The Quadrant\",\n" + "      \"addressLine3\": \"\",\n" + "      \"city\": \"Richmond\",\n" + "      \"state\": \"Surrey\",\n"
            + "      \"postcode\": \"TW9 1DN\",\n" + "      \"countryIsoCode\": \"GBR\"\n" + "    }\n" + "  }\n" + "}";
    }





}
