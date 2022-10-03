package com.example.demo;

import com.example.demo.responsetype.errors.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

public class main {
    public static void main(String[] args) {
//
//        UUID uuid = UUID.randomUUID();
//
////        UUID sa = UUID.fromString("");
////        String uuidAsString = uuid.toString();
//        System.out.println("II ==  " + uuid);
//        System.out.println("BB ==  " + uuid.toString());
//
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault()).format(new Date()));

        String asdas = "responseOBsadJ";

        System.out.println(new ResponseEntity(new Error("InternalServerError", "User with [" + "eqwewqewqewqeqw" + "] registration id and [" + 1234 + "] x_correlationid was not found "), HttpStatus.NOT_FOUND));

    }
}
