package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class main {
    public static void main(String[] args) {

        UUID uuid = UUID.randomUUID();

//        UUID sa = UUID.fromString("");
//        String uuidAsString = uuid.toString();
        System.out.println("II ==  " + uuid);
        System.out.println("BB ==  " + uuid.toString());

        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault()).format(new Date()));

    }
}
