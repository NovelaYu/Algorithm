package com.yu.main;

/**
* @Author: yu.xiang
* @Description:
* @Date: 15:36 2021/5/18
 * 1、本题主要考察快慢指针，
 * 在有序数组中空间复杂度为O(1)的情况下，对数组进行去重，输出去重后的数组大小
 * 2、如[1,2,2,3,3,4,4,5,5]，去重之后[1,2,3,4,5],长度为5
 * 3、这道题是不允许用set和map 来进行去重的
 *
**/

public class SortedArrayDuplicates {

    public static int getLengthArray(int[] arrays) {
        if (arrays.length == 0) {
            return 0;
        }

        int i=0; // 慢指针
        //int j=1; //块指针
        for (int j =1;j<arrays.length; j++) {
            if (arrays[i] != arrays[j]) {
                arrays[i+1] = arrays[j];
                i++;
            }

        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arrys = new int[]{1,2,2,3,3,4,4,5,5};
        System.out.println(SortedArrayDuplicates.getLengthArray(arrys));
    }
}
