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
       /*   这里把传入的L,R 保存起来干什么？
       * 1、固定住边界，两边的位置永远不会变
       * */
       int left = L, right = R;
       int pivot = numbers[left];
       while (left < right) {
           /*如果左边坐标小于右边坐标，且右边的值大于基准值，右边的坐标左移动*/
           while (left < right && numbers[right] >= pivot) {
               right--;
           }
           /*如果左边小于右边且右边地址小于标准值，右边的值放在标准值的位置且退出循环*/
           if (left < right) {
               numbers[left] = numbers[right];
           }
           /*此时轮到左边循环了，如果左边的值小于等于基准值，则左边的坐标右移动*/
           while (left < right && numbers[left] <= pivot) {
               left++;
           }

           /*如果左边的值大于基准值，且左下标小于右下标，那左边的值赋予给右边值，右边是没有动的，所以右边的值也赋予了*/
           if (left < right) {
               numbers[right] = numbers[left];
           }
           if (left >= right) {
               numbers[left] = pivot;
           }
       }
       /*左边边界循环完毕之后，返回整个数组，这个数组就是右边的数都大于等于基准值*/
        /*L始终为0*/
        quickSort(L,right-1,numbers);
        /*R始终为4*/
        quickSort(right+1,R,numbers);
        return numbers;
    }

     /* 可以将最大值的前三个保存下来，最小值的前两个保存下来
      一次循环搞定*/

     public static int[] getMaxInt(int[] input) {
         int[] result = new int[5];
         int max =4; int second =3 ;int third=2;
         int min =1; int secondMin=0;
         if (input.length<5) {
             return input;
         }

         for (int i=0;i<input.length;i++) {
             if (result[max] <= input[i] ) {
                 result[third] = result[second];
                 result[second] = result[max];
                 result[max] = input[i];
             }


            if (result[min] >= input[i]) {
                result[secondMin] =result[min];
                result[min] = input[i];

            }

         }


         return result;
     }

    public static void main(String[] args) {
        int[] numbers = new int[]{-1,-5,3,1,2,3,4,4,5,1,-10,-100,-100,100};
        System.out.println(getMaxInt(numbers));
    }
}
