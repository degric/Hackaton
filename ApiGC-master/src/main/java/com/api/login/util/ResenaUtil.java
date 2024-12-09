package com.api.login.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResenaUtil {
    private ResenaUtil(){

    }

    public static ResponseEntity<String> getResponseEntity1(String message, HttpStatus httpStatus){
        return new ResponseEntity<String>("Mensaje" + message, httpStatus);
    }

    public static String getUUID(){
        Date date = new Date();
        long time= date.getTime();
        return "hola" + time;
    }

    public static JSONArray getJsonArrayFromString(String data) throws JSONException{
        JSONArray jsonArray = new JSONArray();
        return jsonArray;
    }


}
