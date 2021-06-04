package com.yu.main;

import java.util.HashMap;

public class Apple extends Fruit {

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("1","1");
        hashMap.put("2","2");

        for (String key:hashMap.keySet()) {
            if (key.equals("1")) {
                hashMap.remove(key);
            }
        }
        System.out.println(hashMap);
    }
}
