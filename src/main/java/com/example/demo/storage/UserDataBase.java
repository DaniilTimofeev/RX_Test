package com.example.demo.storage;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

@Configuration
public class UserDataBase {
    private static final Logger log = LoggerFactory.getLogger(UserDataBase.class);

//    public static ArrayList<GetRegistrationResponse> userStorage;

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {};
    }
}
