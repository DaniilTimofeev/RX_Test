package com.example.demo.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;
import reactor.core.publisher.Mono;

public class PostGetRequest {


//    public static String sendGET(String URL) throws IOException {
//        URL obj = new URL(URL);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("GET");
//        //        con.setRequestProperty("User-Agent", USER_AGENT);
//        int responseCode = con.getResponseCode();

//        return con.

//        System.out.println("GET Response Code :: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) { // success
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // print result
//            System.out.println(response.toString());
//        } else {
//            System.out.println("GET request not worked");
//        }

//    }

//    public static void sendPOST(String postJson, String correlationId) throws IOException {
//        URL obj = new URL(null);
//
//
////
////
////        ResponseEntity<T> response = RestUtils.httpRequest(method, resource, requestBody, responseType, headersBuilder, requestFactory -> {
////            requestFactory.setConnectionRequestTimeout(JIRA_STATUSCHECK_CONNECTION_REQUEST_TIMEOUT_MS);
////            requestFactory.setConnectTimeout(JIRA_STATUSCHECK_CONNECTION_TIMEOUT_MS);
////            requestFactory.setReadTimeout(JIRA_STATUSCHECK_CONNECTION_READ_TIMEOUT_MS);
////        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
////        con.setRequestMethod("POST");
////        //        con.setRequestProperty("User-Agent", USER_AGENT);
////
////        // For POST only - START
////        con.setDoOutput(true);
////        OutputStream os = con.getOutputStream();
////        //        os.write(POST_PARAMS.getBytes());
////        os.flush();
////        os.close();
////        // For POST only - END
////
////        int responseCode = con.getResponseCode();
////        System.out.println("POST Response Code :: " + responseCode);
////
////        if (responseCode == HttpURLConnection.HTTP_OK) { //success
////            BufferedReader in = new BufferedReader(new InputStreamReader(
////                con.getInputStream()));
////            String inputLine;
////            StringBuffer response = new StringBuffer();
////
////            while ((inputLine = in.readLine()) != null) {
////                response.append(inputLine);
////            }
////            in.close();
////
////            // print result
////            System.out.println(response.toString());
////        } else {
////            System.out.println("POST request not worked");
////        }
//    }



//    public static <T> ResponseEntity<T> httpRequest(HttpMethod method, String resource, Object body, Class<T> responseType) {
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//
//        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
//
//        RestTemplate restTemplate = RestUtils.getRestTemplate(requestFactoryConfigurator);
//        return restTemplate.exchange(resource, method, entity, responseType, uriVariables);
//    }



    public static ResponseEntity<?> sendRequest(String requestBody, String x_correlationid){
//        WebClient client = WebClient.create("http://localhost:8080");

//        WebClient client = WebClient.builder()
//            .baseUrl("http://localhost:8080")
////            .defaultCookie("cookieKey", "cookieValue")
//            .defaultHeader("x-correlationid", x_correlationid)
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .uri
////            .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
//            .build();

//        WebClient client =
////            WebClient.create("http://localhost:8080");
//
//         WebClient.builder()
////            .uri("/api/v1/registrations")
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .defaultHeader("x-correlationid", x_correlationid);
////            .(requestBody, String.class);
//        UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.POST);



        WebClient client = WebClient.create("http://localhost:8080");

        UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.POST);
        RequestBodySpec bodySpec = uriSpec.uri("/api/v1/registrations");

        RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue(requestBody);

//        ResponseSpec responseSpec = headersSpec.header(
//                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).header("x_correlationid", x_correlationid)
////            .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
////            .acceptCharset(StandardCharsets.UTF_8)
////            .ifNoneMatch("*")
////            .ifModifiedSince(ZonedDateTime.now())
//            .retrieve();



//        Mono<String> response =
//        ClientResponse clientResponse = headersSpec.header(
//            HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).
//            header("x_correlationid", x_correlationid).
//            exchangeToMono(ClientResponse
////                response -> {
////
////                return response;
//////            if (response.statusCode().equals(HttpStatus.OK)) {
//////                return response.bodyToMono(String.class);
//////            } else if (response.statusCode().is4xxClientError()) {
//////                return Mono.just("Error response");
//////            } else {
//////                return response.createException()
//////                    .flatMap(Mono::error);
//////            }
////        }
//        );
//
////        Mono<String> response = headersSpec.exchangeToMono(response -> {
////            if (response.statusCode().equals(HttpStatus.OK)) {
////                return response.bodyToMono(String.class);
////            } else if (response.statusCode().is4xxClientError()) {
////                return Mono.just("Error response");
////            } else {
////                return response.createException()
////                    .flatMap(Mono::error);
////            }
//        });

        return null;
    }



    public static ResponseEntity<String> sendPost(String requestBody,  String x_correlationid) throws ParseException {

        WebClient client = WebClient.create();


        //MediaType.APPLICATION_JSON_VALUE
        ClientResponse clientResponse = client.post()
            .uri("http://localhost:8080/api/v1/registrations")
            .header("x-correlationid", x_correlationid)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
//            .body(Mono.just((JSONObject) new JSONParser().parse(requestBody)), JSONObject.class)
//            .body(requestBody, String.class)
            .exchange()
            .block();

        return clientResponse.toEntity(String.class).block();
    }


    public static ResponseEntity<String> sendGet(String registrationId,  String x_correlationid) {
        WebClient client = WebClient.create();


        //MediaType.APPLICATION_JSON_VALUE
        ClientResponse clientResponse = client.get()
            .uri("http://localhost:8080/api/v1/registrations/" + registrationId)
            .header("x-correlationid", x_correlationid)
            .exchange()
            .block();

        return clientResponse.toEntity(String.class).block();
    }

}
