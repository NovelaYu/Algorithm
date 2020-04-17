package com.yu.main;

import com.yu.domain.MatchNumber;

public class AddString {
    public String addString(String num1, String num2) {
        // index的用法,从指定位置开始查找指定字符在字符串中第一次出现的索引，如果没有此字符，则返回-1.
        /*if (num1.indexOf(0,1)=='0' || num2.indexOf(0,1)=='0') {
            return null;
        }*/
        if (num1 == null || num2 == null || ("").equals(num1) || ("").equals(num2)) {
            return null;
        }

        //检查第一个字符是否为0,如果为0呢
        if ((num1.charAt(0)=='0' && num1.length()>1) || (num2.charAt(0)=='0' && num2.length()>1)) {
            return null;
        }
        //正则表达式的比较
        if (!MatchNumber.ANY_NUBBER_PATTER.matcher(num1).matches() || !MatchNumber.ANY_NUBBER_PATTER.matcher(num2).matches()) {
            return null;
        }
        //事实已经证明我这个算法有问题，根本走不通，缝缝补补，修修剪剪
        StringBuffer sb = new StringBuffer();
        int g =0;
        for (int i=num1.length()-1,j=num2.length()-1,m=0;i>=0 || j>=0;i--,j--,m++) {
            int s = i<0?0:num1.charAt(i)-'0';
            int d = j<0?0:num2.charAt(j)-'0';
            int total = (s+d+g)%10;
            g = (s+d+g)/10;
            sb = sb.append(total);
        }
        if (g!=0) {
            sb.append(g);
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        AddString addString = new AddString();
        System.out.println(addString.addString("1","9"));
    }
}
