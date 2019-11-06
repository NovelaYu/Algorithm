package com.dmall.main;

import java.util.HashMap;

//罗马数字转整
//1、罗马数字无负数；
//2、罗马数字大的数字在小的数字右侧就是做减法，在左侧就是做加法
public class RomanToInt {
    public int romanToInt(String s ) {
        if (s == null || s.length() == 0 || s.contains("-")) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int result = -1;
        if (map.containsKey(s.charAt(len-1))) {
             result = map.get(s.charAt(len - 1));
        }

        for (int i = len - 2; i >= 0; i--) {
            if (!map.containsKey(s.charAt(i))) {
                return -1;
            }
            //数组越界
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }

        }
        return result;

    }

    public static void main(String[] args) {
       HashMap<Character,Integer> map = new HashMap<>();
       //单引号是character，双引号是String
       map.put('I',5);
       System.out.println(map.get('s')==null);
    }
}
