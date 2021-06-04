package com.yu.main;

import java.util.Arrays;
import java.util.HashMap;

/**
* @Author: yu.xiang
* @Description:
* @Date: 17:36 2021/6/1
 * 1、给定一个数组和一个目标值，寻找数组当中的两个值之和，等于目标值
 * 2、返回两个值的地址值，不允许重复使用两个值
 *
 *
**/

public class FindTarget {

    /*这道题用暴力循环，循环两次，时间复杂度就是O(n*n),
    但是不允许使用重复值，这样就可用map将值给存储起来，target - numbers[i]==目标值，
    如果目标值在map中，则找到该值，如果目标值没有在map中，则存下numbers[i]即可*/

    public static int[] getTarget(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(target-numbers[i])) {
                return new int[]{i,map.get(target-numbers[i])};
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    /*todo,如果是一个有序数组，如何通过二分法求目标值*/

   /* 二分法是找一个值，先确认当前的值是所求的值，另一个值通过二分法来查找
   * 1、需要掌握如何寻找下标？
   * */

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5,10,-12};
        System.out.println(Arrays.toString(getTarget(numbers,6)));
    }
}
