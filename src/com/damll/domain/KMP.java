package com.damll.domain;

public class KMP {
    /**
     * 寻找公共字符串的长度
     * */
    public int[] get_next(String T) {
        int[] next = new int[T.length()];
        next[0] =-1;
        if (T.length() == 1) {
            return next;
        }
        if (T.length() ==2) {
            next[1] =0;
            return next;
        }
        int k;
       for (int j =2; j < T.length(); j++) {
           //饶晕了，这个k是什么意思？

           k = next[j-1];
           while (k != -1) {
               //为什么字符串的j-1位要和字符串的k位作比较，比较成功之后有赋值给next[j],
               // 这三行代码我给大神跪了！！！！
               if (T.charAt(j-1) == T.charAt(k)) {
                   next[j] = k + 1;
                   break;

               }else {
                   k = next[k];
               }
               next[j] = 0;
           }
       }
       return next;
    }





    public static void main(String[] args) {
        KMP kmp = new KMP();
        int[] k = kmp.get_next("abab");
        for (int i =0;i<k.length;i++) {
            System.out.println(k[i]);
        }

    }
}
