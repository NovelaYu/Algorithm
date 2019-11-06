package com.dmall.main;

public class Solution {

    //int 型倒序排列
    public int reserse(int x) {
        int rev = 0;
        // 内部赋值，循环内嵌套
        while (x!=0) {
            int pop = x %10;
            //内部循环
            x /= 10;
            if (rev > Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop > 7 )) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            //内存溢出必须前置校验，不然全报错
            //栈：先进后出。推出的值乘10，余数相加
            rev = rev *10 +pop;

        }
        return rev;
    }

    //回文数
    public boolean isPalindrome(int x) {
        //用字符串需要非常大的空间来存储
      /*  String s = String.valueOf(x);
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        if (s.length()==1) {
            return true;
        }
        if (s.length() %2 ==0) {
            for (int n=0;n<s.length()/2;n++) {
                builder1.append(s.charAt(n));
            }
            for (int m=s.length()-1;m>=s.length()/2;m--) {
                builder2.append(s.charAt(m));
            }
        }else {
            for (int n=0;n<s.length()/2;n++) {
                builder1.append(s.charAt(n));
            }
            for (int m=s.length()-1;m>s.length()/2;m--) {
                builder2.append(s.charAt(m));
            }
        }

        if (builder1.toString().equals(builder2.toString())) {
            return true;
        }else {
            return false;
        }*/

         // String 内置函数，反转
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);

    }

    // 1、用字符串占据大量空间
    // 2、反转后半部分,后半部分数值如果和前半部分相等则是回文
    // 3、负数天然不是
    public  boolean optimizeIsPalindrome(int x) {
        // 如果最后一位是0，天然不是回文
        // 如果是负数，然不是回文
        if (x <0 || (x %10 ==0 && x !=0)) {
            return false;
        }

        int resve =0;
        // 解决溢出问题
        // 将时间复杂度减少了一半
        while (x > resve){
            resve = resve *10 + x%10;
            x /=10;
        }
        Long l1 = 1L;
        Long l2 = 1222L;
        if (l1.equals(l2)) {
            return false;
        }

        return x== resve || x== resve/10;

    }



    public static void main(String[] args) {
        Solution s = new Solution();
        //int x = 1534236469;
        //System.out.println(s.reserse(x));
        System.out.println(s.isPalindrome(10022201));
        Long l1 = 1L;
        Long l2 = 128L;
        System.out.println(l1.equals(l2));
    }
}
