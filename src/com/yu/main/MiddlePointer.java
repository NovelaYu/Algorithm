package com.yu.main;


import java.util.Arrays;
import java.util.List;

/**
* @Author: yu.xiang
* @Description:
* @Date: 18:06 2021/5/20
 * 1、求中心下标，左边的值之和和右边的值之和相等
 * 2、如果有多个值相等，则取最左边这个
 * 解题思路：
 * 1、求出数组之和
 * 2、求左边数组之和，如果相等则返回
**/

public class MiddlePointer {

    public int getMiddlePointer(int[] input) {
        /*用stream 流来处理数组之和*/
        int sum = Arrays.stream(input).sum();

        int total = 0;
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            total += input[i];
            if (total*2 == sum) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void main(String[] args) {
      /*  MiddlePointer middlePointer = new MiddlePointer();
        //int[] data = new int[]{1,-1,2,3,-2,5,7,9,10,-9,1,3};
        int[] data = new int[]{1,-1,1,1,1,1};
        System.out.println(middlePointer.getMiddlePointer(data));*/
        List<String> names = Arrays.asList("张三","李四","王五","赵柳","张五六七","王少","赵四","张仁","李星");
        //需求：找出 姓张中名字最长的
        int maxLengthStartWithZ = names.parallelStream()
                .filter(name -> name.startsWith("张"))
                .mapToInt(String::length)
                .max()
                .getAsInt();
        System.out.println(names.get(maxLengthStartWithZ));
    }
}
