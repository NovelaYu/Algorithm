package com.yu.main;

import java.math.BigDecimal;

/**
 * @author yu.xiang
 * 主要是字符串的截取函数和匹配函数
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        //先判断是否为空，再取长度和值
        if (strs ==  null || strs.length<=0) {
            return "";
        }
        int len=strs[0].length();
        int m =0;
        for (int i =0;i<strs.length;i++) {
             len = Math.min(len,strs[i].length());
             if (("").equals(strs[i])) {
                 return "";
             }
        }
        for (int n =0;n<len;n++) {
            for (m=0;m<strs.length-1;m++) {
                //空的字符串数组越界
                if (strs[m].charAt(n)==strs[strs.length-1].charAt(n)) {
                    continue;
                }else {
                    if (builder.length()<=0) {
                        return "";
                    }else {
                        return builder.toString();
                    }

                }
            }
            builder.append(strs[m].charAt(n));
        }
        return builder.toString();
    }


    public String longestCommonPrefix1(String[] strs) {
        if (strs==null || strs.length==0) {return "";}
        String prefix = strs[0];
        //递归循环判断，常量池获取对象d
        for (int i =1;i <strs.length;i++) {
            //整个字符串出现的位置
            while (strs[i].indexOf(prefix) != 0) {
                //String的内置函数很重要，截串匹配
                prefix = prefix.substring(0, prefix.length() - 1);
                //很精简，如果有一个没有匹配上就直接返回了
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 找个标准位置，逐个递归很重要
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {return "";}
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                //第几位和字符串长度相等，跳出循环，字符串的位置要比长度多一位
                //字符串不相等，跳出循环
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    //截串右侧的字符其实未取到
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }

    /**
     * 用二分法递归进行数组的比较
     * 二分法每次都是从有序数组中折半
     * @param
     */
   public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length ==0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str:strs) {
            minLen = Math.min(minLen,str.length());
        }
        int low =1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) /2;
            if (isCommonPrefix(strs,middle)) {
                low = middle + 1;
            }else {
                high = middle -1;
            }
        }
        return strs[0].substring(0,(low + high)/2);
    }

    public boolean isCommonPrefix(String[] strs, int len) {
       String str1 = strs[0].substring(0,len);
       for (int i =1; i<strs.length;i++) {
            //判断一个字符串是否是另一个字符串某个位置开始的字符串
           if (!strs[i].startsWith(str1)) {
               return false;
           }
       }
       return true;
    }


    public static void main(String[] args) {
       // LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
       // String[] strs = null;
       // System.out.println(longestCommonPrefix.longestCommonPrefix1(strs));
       /* String[] strs1 = {"abc","ac"};
        System.out.println(longestCommonPrefix.longestCommonPrefix1(strs1));
       *//* String s = "a";
        System.out.println(s.charAt(0));*//*
       String str1 = "abc";
       String str2 ="ab";
       String str3 = new String("abc");
       String str4 = new String("abc");
       *//*str2经过编译优化之后，会先去堆的常量池找是否有"abc"，如果有则直接引用该地址*//*
        System.out.println(str1==str2);
        // str3经过new之后会直接从堆生成一个内存空间
        System.out.println(str1==str3);
        System.out.println(str3==str4);
        System.out.println(str1.substring(0,1));
        System.out.println(longestCommonPrefix.longestCommonPrefix2(strs1));*/
        //System.out.println(new BigDecimal(2256000).divide(new BigDecimal(4788),0,BigDecimal.ROUND_HALF_UP).longValue());
        if (2<1 && true) {
            System.out.println("false");
        }else if(true) {
            System.out.println("第一次循环");
        }else {
            System.out.println("第二次循环");
        }
   }

}

