package com.yu.main;

public class AddDigits {
    public int addDigits(int num) {
        if (num < 0) {
            return 0;
        }
        return this.foreachAdd(num);
    }

    public int foreachAdd(int num) {
       //递归函数返回的是个函数！！
        if (num <10) {
            return num;
        }else {
            return foreachAdd(foreachAdd(num / 10) + foreachAdd(num % 10));
        }

    }

    /**分堆思想，以10分堆涉及到进位，但是以9来分堆，就不用关心进位**/
    /****/
    public int addDigits1(int num) {
        return (num-1)%9+1;
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits1(10000));
    }

}
