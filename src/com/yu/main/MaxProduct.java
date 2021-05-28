package com.yu.main;

/**
* @Author: yu.xiang
* @Description:
* @Date: 17:04 2021/5/27
 * 1、获取数组最大的三个数乘积，并输出乘积
**/

public class MaxProduct {

    /*用快速排序，时间复杂度是 n(logn)*/

    public static int[] quickSort(int L, int R ,int[] numbers) {
        /*1、取基准值，将小的放左边，大的放右边
        * 2、左边有比基准值小的，就继续右移动，移动到比右侧小为止
        * 3、右边又比基准值大的，就继续做移动，移动到比基准值小位置
        * 4、左边和右边相等，退出循环，基准值为左边的位置
        *
        * */
       if (L >=R) {
           return numbers;
       }
       /*这里把传入的L,R 保存起来干什么？*/
       int left = L, right = R;
       int pivot = numbers[left];
       while (left < right) {
           while (left < right && numbers[right] >= pivot) {
               right--;
           }
           if (left < right) {
               numbers[left] = numbers[right];
           }
           while (left < right && numbers[left] <= pivot) {
               left++;
           }
           if (left < right) {
               numbers[right] = numbers[left];
           }
           if (left >= right) {
               numbers[left] = pivot;
           }
       }
        quickSort(L,right-1,numbers);
        quickSort(right+1,R,numbers);
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,5,1};
        System.out.println(quickSort(0,3,numbers));
    }
}
