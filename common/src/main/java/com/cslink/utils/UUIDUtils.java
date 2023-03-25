package com.cslink.utils;


import java.util.UUID;

public class UUIDUtils {

    public static String getUUID(){
        String id = UUID.randomUUID().toString();
        String uid = id.replaceAll("-", "");
        return uid;
    }
}
