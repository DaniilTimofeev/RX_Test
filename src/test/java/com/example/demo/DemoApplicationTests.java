package com.example.demo;

import static com.example.demo.utility.PostGetRequest.sendGet;
import static com.example.demo.utility.PostGetRequest.sendPost;

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
//        String registrationId = sendGET("/api/v1/registrations/1234");
//        System.out.println("=============================================");
//        sendPOST(getCreateExpertJsonString(), );
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
