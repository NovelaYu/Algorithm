package com.yu.main;

import java.util.HashMap;

/**
* @Author: yu.xiang
* @Description:
* @Date: 16:39 2021/5/17
 *
 *
**/

public class Main {

    //1、计算最后一个单词字符串的长度
    public static int getStringLength(String s) {
        String[] result = s.split(" ");
        String data = result[result.length-1];
        return data.length();
    }

    //2、获取输入输出字符串的个数
    public static int getMaxString(String large,String in) {
        String data = large.toUpperCase();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0;i < data.length(); i++) {
            if (hashMap.containsKey(data.charAt(i))) {
                hashMap.put(data.charAt(i),hashMap.get(data.charAt(i))+1);
            }else {
                hashMap.put(data.charAt(i),1);
            }
        }

        return hashMap.get(in.toUpperCase().charAt(0));
    }


    public static void main(String[] args) {
        System.out.println(Main.getMaxString("Aavvv dsds","a"));
    }
}
