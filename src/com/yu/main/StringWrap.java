package com.yu.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @Author: yu.xiang
* @Description:
* @Date: 16:33 2021/5/18
 * 1、联系输入字符串，每个字符串长度不大于100
 * 2、输出字符串每八个一行，不及八个的后面补零
 * 3、输出长度为8的新字符串数组
**/

public class StringWrap {

    /***
     * 1、这题对我来的的难度主要是 Scanner 的应用
     * */
    public static List<String> getStringArray() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
       // String str ;
        //1、hasNextLine 以回车键作为结束
        //2、nextLine 遇到空白，next()会自动去掉空白，不能得到带空白字符串的字符
        System.out.println("输入数据:");
        while (scanner.hasNextLine()) {
            // 当遇到空时退出循环
            if (scanner.nextLine().equals("end")) {
                break;
            }
            String str = scanner.nextLine();
            list.add(str);
        }
        System.out.println("结束输出");
        scanner.close();
        for (int i = 0; i<list.size(); i++) {
            String input = list.get(i);
            if (input.length() % 8 != 0) {
                for (int j =input.length()%8; j<8; j++) {
                    input +="0";
                }
                for (int j =0;j<input.length();j+=8) {
                    list1.add(input.substring(j,j+8));
                }

            }
        }


        return list1;
    }

    public static void main(String[] args) {
        List list1 = StringWrap.getStringArray();
        for (int i = 0; i<list1.size();i++) {
            System.out.println(list1.get(i));
        }


    }
}
