package com.yu.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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


 /**1、输入16进制转换为10进制，
  * 2、需要判断输入的数是否为16进制的数字
  * 3、将16进制对应的字符在hashap中保存
  * 4、将开始为0的字符串截取，0x要单独处理
  *
  * ***/


  public static String getIndexString(String input) {
      /*起始位是否为0，如果为0就截取掉*/
      while (input.substring(0,1).equals("0")) {
          /**这里要排除数组越界的危险,beginIndex 默认结尾为字符串长度**/
          input = input.substring(1);
          if (("").equals(input)) {
              return "0";
          }
      }
      return input;
  }

    public static int coverstNumber(String input) {
        HashMap map = new HashMap();
        /*二进制左边是高位，右边是低位*/
        map.put("0","0000");
        map.put("1","0001");
        map.put("2","0010");
        map.put("3","0011");
        map.put("4","0100");
        map.put("5","0101");
        map.put("6","0110");
        map.put("7","0111");
        map.put("8","1000");
        map.put("9","1001");
        map.put("A","1010");
        map.put("B","1011");
        map.put("C","1100");
        map.put("D","1101");
        map.put("E","1110");
        map.put("F","1111");

        int length = input.length();
        /**特殊条件处理,首字符为0的直接干掉**/
       /* if (input.equals("0") || input.equals("0x0") || input.equals("0x")) {
            return 0;
        }*/
       if (("").equals(input)) {
           return 0;
       }
        if (input.length() >2) {
            /**1、如果字符串开头是0x，则不需要去除掉前面两个字符**/
            if (input.substring(0,2).equals("0x")) {
                input = input.substring(2,length);
            }
        }

        input = getIndexString(input);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < input.length();i++) {
            /**1、如果输入字符串中有字符越界则返回0**/
            if (!map.containsKey(input.substring(i,i+1))) {
                return 0;
            }

            buffer.append(map.get(input.substring(i,i+1)));
        }

         String data = buffer.toString();
        // 二进制再转换为十进制
        int total =0;
        int m = 1;
        for (int j = data.length()-1 ; j >0; j--) {
            m = m *2;
            if (data.substring(j-1,j).equals("0")) {
                continue;
            } else {
                total += m ;
            }
        }

        if (data.substring(data.length()-1).equals("1")) {
            total = total+1;
        }
        return total;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            /*scanner.nextLine()每读一次，程序就要阻塞一次，需要一个变量将读出的数据保存起来*/
            String data = scanner.nextLine();
            if (data.equals("end")) {
                break;
            }
            list.add(data);


        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(coverstNumber(list.get(i)));
        }
    }
}
