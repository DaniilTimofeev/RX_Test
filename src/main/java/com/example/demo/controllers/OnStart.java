package com.example.demo.controllers;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

@Component
class OnStart {


    @PostConstruct
    private void init() {
        File file = new File("./database");
        if(!file.exists()) {
            file.mkdirs();
        }
    }

}