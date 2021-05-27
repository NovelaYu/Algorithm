package com.yu.main;
/**
* @Author: yu.xiang
* @Description:
* @Date: 11:21 2021/5/27
 * 1、不用函数，求出x的平方根，平方根为整数
**/

public class SqrtX {

    /*1、二分法，从中间找符合条件的数*/

    public static int binarySearch(int x) {
        int index = -1;
        int left = 0;
        int right = x;
        while (left <= right) {
            /*中间坐标正确的求值方式，如果是(left+right)/2,那就会多取一段*/
            int middle = left + (right -left)/2;
            if (middle * middle == x) {
                return middle;
            }
            if (middle * middle > x) {
                /*因为中间位置已经比较过了，所以再比较就没有意义了，需要往前再挪一位*/
                right = middle - 1;

            }
            if (middle * middle < x) {
                /*获取比较小的中间值，left也需要在中间位置往后挪一位*/
                index = middle;
                left = middle + 1;
            }
        }
        return index;
    }



    /*牛顿迭代:n = x*x; 那么 n/x <= x;
    如果在寻找x的过程中，n/x 和 x 的均值更接近于平方根*/

    public static int newTown(int x) {
        return (int)sqrt(x,x);
    }

    public static double sqrt(double n,int x) {
        /*牛顿迭代的关键是寻找中位数，公式 (x/n+n)/2;*/
      /*  double res = (x/n + n)/2;
        if (res == n) {
            return n;
        } else {
           return sqrt(res,x);
        }*/

      while ((x/n +n)/2 != n) {
          n = (x/n +n)/2;
      }
      return n;

    }


    public static void main(String[] args) {
        //System.out.println(SqrtX.binarySearch(24));
        System.out.println(SqrtX.newTown(17));
    }
}
