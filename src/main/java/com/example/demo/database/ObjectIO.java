package com.example.demo.database;

import com.example.demo.responsetype.success.GetRegistrationResponse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIO {




    public static void WriteObjectToFile(String corr_x, GetRegistrationResponse data) {
        final String filepath= "./database/" + corr_x;
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(data);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            System.out.println("HERERERERE");
            ex.printStackTrace();
        }
    }



    public static void ReadObjectFromAFile(String corr_x) {
        final String filepath= "./database/" + corr_x;
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.close();
            System.out.println("The Object  was succesfully read from a file");

        } catch (Exception ex) {
            System.out.println("HERERERERE");
            ex.printStackTrace();
        }
    }



    public static Object ReadObjectFromFile(String corr_x) {

        try {
            final String filepath= "./database/" + corr_x;
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



}
