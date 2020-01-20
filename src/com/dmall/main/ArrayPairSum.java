package com.dmall.main;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ArrayPairSum {
    /** 冒泡排序:相邻的两个数比较，数字较小的放在左边，数字较大的放在右边
     * 时间复杂度 O(n*n),排序效率依然不高**/
    public int[] maopaoArray(int[] nums) {
        int k;
        for (int i =0; i<nums.length;i++) {
            /**每次比较都比上次少1，因为每次冒泡总会把最大的那个冒出去**/
            for (int j =0;j<nums.length-1-i;j++) {
                if (nums[j] > nums[j+1]) {
                    //小的换到前面，大的换到后面，需要有个中间过渡参数
                    k=nums[j];nums[j]=nums[j+1];nums[j+1]=k;
                }
            }
        }
        return nums;
    }

    /**快速排序:选择一个基准数，从右边开始与这个基准数比较，比他大放在右边；
     * 从左边开始与这个基准数比较，比他小放在左边
     * 循环递归
     * 这个排序依然不行。平均情况下 O(nlogn)，最差情况下O(n^2),速度取决于期选取的基准值
     * 快速排序比冒泡，选择排序和直接插入排序要难，在于他的基准位置的值一直在变化**/
    public int[] quicklyArray(int[] nums,int start,int end) {
        //基准值，递归
        int base = nums[start],i=start,j=end;
        //临时值
        int temp;
        if (start < end) {
            while (nums[i] < base && i< end) {
                i ++;
            }
            while (nums[j] > base && j>start) {
                j--;
            }

            if (i<=j) {
                //只交换一次
                temp = nums[i];nums[i]=nums[j];nums[j]=temp;
                //为下一次递归做准备
                i++;j--;
            }

        }

        /**从左到右找小的，基准值是上一次循环的值**/
        if(end > i) {
            quicklyArray(nums,i,end);
        }

        /**从右到左找大的，基准值是上一次循环的开始值，结束值是上一次循环的结束值**/
        if (start<j) {
            quicklyArray(nums,start,j);
        }

        return nums;

    }


    /**选择排序是一种简单直观的算法，从待排序的数据元素中选出最小或最大的一个元素，
     * 存放在序列的起始位置，直到全部排序的数据元素排完
     * 和冒泡排序有什么区别？
     * 答：冒泡排序是循环比较相邻的数据，选择排序是按顺序比较，找最大值或最小值，每次比较只交换一次位置**/
    public int[] selectArray(int[] nums) {
        int temp;
        for (int j =0;j<nums.length;j++) {
             int min = j;
             /**找出最小的值**/
            for (int i =j+1;i <nums.length;i++) {
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }
            /**如果和其实位置不相等，则交换位置**/
            if (min != j) {
                temp = nums[j];
                nums[j] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }

    /**直接插入排序是一种最简单的排序方法，其基本操作是将一条记录插入到已排好的有序列表中，这个有序链表不用重新开个空间，在原有的数组进行排列就行了，
     * 从而得到一个新的，记录数量增1的有序表
     * 每次从无序表中取出第一个元素，把它插入到有序表的合适位置，使有序表仍然有序
     * 1、第一趟比较前两个数，然后把第二个数按大小插入到有序表中，小的放在前面，大的放在后面；
     * 2、第二趟把第三个数据与前两个数从后向前扫描，把第三个数按大小插入到有序表中；
     * 3、依次进行下去，进行了(n-1)趟扫描以后就完成了整个排序过程
     * **/
    public int[] straightArray(int[] nums) {
        for (int i =0; i < nums.length; i++) {
            int j = i -1,tmp = nums[i];// 临时值
            while (j >= 0 && tmp < nums[j]) { //序列从后到前循环，将大于tmp的数向后移动一格
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = tmp;// 后面的数如果大于前一个数，就跳出循环。每次拿后一个数和最大的比依次比较
                            // 将需要插入的数放在要插入的位置
        }
        return nums;
    }

    /*****
     *
     * 希尔排序是插入排序的一种又称"缩小增量排序"，是直接插入排序算法的一种更高效的改进版本，当直接插入排序数据量巨大时。
     * 直接插入排序在数据量小时或者数组有序时，会显得高效。希尔排序的模板就是要把数组变得有序的情况下使用直接插入排序，
     * 如果无序就让数组数量变小再使用直接插入排序
     * 1、将数的个数设为n，取奇数k=n/2，将下标差值为k的数分为一组，构成有序序列
     * 2、再取K=k/2,将下标差值为k的数分为一组，构成有序序列
     * 3、重复第二步，直到k=1执行简单插入排序
     *
     */
    public int[] shellSort(int[] nums) {
        int N = nums.length;
        for (int gap = N/2; gap >0; gap /= 2) { // 多加一层循环，每次减少的都折半
            for (int i = gap; i< N ; i++) {
               int j = i-gap; // 一次移动的位置是当时位置的一半，分段之后后一位和前一位对比
               int temp = nums[i];
               while (j >= 0 && temp < nums[j]) {
                   nums[j + gap] = nums[j];
                   j -= gap;
               }
               nums[j+gap] = temp; //这里也是一次移动的位置是对折的一半
            }
        }

        return nums;
    }


    /****
     *
     * 归并排序是建立在归并操作上的基于分治理的一种有效的排序算法。该排序是一种稳定的排序方法
     * 1、先对相邻的两个数进行排序，再和相邻的两堆进行排序。
     * 2、如果一堆的第一个数小于或大于另一堆的最后一个数，两个直接进行堆排序。
     *
     *
     */
    public int[] mergeSort(int[] nums) {
        int N = nums.length;
        sort(nums,0,N-1);
        return nums;
    }

    /**
     * 先把数组分开
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public int[] sort(int[] nums ,int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(nums,low, mid);
            sort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
        return nums;
    }

    public void merge(int[] nums, int low ,int mid, int high) {
        //每次需要构建一个空间来存储数据
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        // 把较小的数先移动到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[i++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }

        // 把右边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x =0; x < temp.length; x++) {
            nums[x+low] = temp[x];
        }
    }


    public int arrayPairSum(int[] nums) {


        // TODO 归并排序

        // todo 堆排序

        //todo 计数排序
        //nums = this.maopaoArray(nums);
        nums = this.quicklyArray(nums,0,3);
        int sum =0;
        for (int i=0;i<nums.length;i=i+2) {
            sum += nums[i];
        }
        return sum;

    }


    public static Integer getAllMinute(Integer day,Integer hour, Integer minute) {
        int minu = 0;
        if (Objects.nonNull(day)) {
            minu += day*24*60;
        }
        if (Objects.nonNull(hour)) {
            minu += hour * 60;
        }
        if (Objects.nonNull(minute)) {
            minu += minute;
        }
        return minu <= 0?null:minu;

    }

    public static void main(String[] args) {
        ArrayPairSum s = new ArrayPairSum();
        int[] nums = {1,4,3,2};
        int[] result = s.mergeSort(nums);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]+"");
        }


    }
}
