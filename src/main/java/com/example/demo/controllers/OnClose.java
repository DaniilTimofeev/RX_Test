package com.example.demo.controllers;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.File;

@Component
public class OnClose {

    @PreDestroy
    public void destroy() {
        File folder = new File("./database/");
        File[] files = folder.listFiles();
        if(files!=null) { //some JVMs return null for empty dirs
            for(File f: files) {

                    f.delete();

            }
        }
    }
}