package com.example.demo.utility;

import com.example.demo.responsetype.success.RegistrationResponse;
import com.google.gson.Gson;

public class JSonConversion {


//    public static String objectToString(String jsonLine, Class clazz){
//
//        Gson g = new Gson();
//        return g.fromJson(jsonLine, clazz);;
//    }


    public static Object stringToObject(String jsonLine, Class clazz){
        Gson g = new Gson();
        return g.fromJson(jsonLine, clazz);
    }

}
