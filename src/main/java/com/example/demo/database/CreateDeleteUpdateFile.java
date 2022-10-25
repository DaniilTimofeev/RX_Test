package com.example.demo.database;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import com.example.demo.responsetype.success.GetRegistrationResponse;
import org.springframework.http.HttpStatus;

public class CreateDeleteUpdateFile {



    public static HttpStatus writeToAFile(String corr_x, GetRegistrationResponse data){
        try {
            File myObj = new File(corr_x);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                    FileWriter myWriter = new FileWriter(corr_x);
//                myWriter.write(data);
                return HttpStatus.CREATED;
            } else {
                System.out.println("File already exists.");
                return HttpStatus.BAD_REQUEST;
            }
        } catch (IOException e) {
            System.out.println("An error occurred. Couldn't create file");
            e.printStackTrace();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }






}

