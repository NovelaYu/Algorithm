package com.yu.domain;

/**
 *
 * 练习动态规划项目
 * 分别使用递归和动态规划的方式完成(非递归)
 * Author yu.xiang
 * ***/
public class  DP {

    /**
     * 一个数组 1 2 4 1 7 8 3 求出不相邻两个数的最大值
     * 比如可以是1+8=9，选择的数下一个一定不能相邻 3+7
     * 用递归找出比较大的两个值之和
     */
    public int getMaxByRec(int[] arry,int index) {
        // 基准线，出界值
         if (index == 0) {
             return arry[0];
         }
         if (index == 1) {
             return Math.max(arry[0],arry[1]);
         }
         //用递归找出找出两个中较大值
         int use = arry[index] + getMaxByRec(arry,index-2);
         int unUse = getMaxByRec(arry,index-1);
         return Math.max(use,unUse);
    }


    /*****
     *
     * 用动态规划的方式，将重复计算的值进行保存，减少计算量
     * 动态规划需要找出
     * 1、最优化子结构
     * 2、最佳公式
     * 3、状态转移公式
     * @Author yu.xiang
     */

    public int getDymic(int[] arry,int index) {
        int[] opt = new int[arry.length];
        /***
         * 这里不需要判断，直接赋值了，可以理解为动态规划是从前面往后面相加
         * 这里是拿空间换时间
         */
        //边界1
        opt[0] = arry[0];
        // 边界2
        opt[1] = Math.max(arry[0],arry[1]);

        for (int i=2;i<arry.length;i++) {
            int use = arry[i] + opt[i-2];
            int unse = opt[i-1];
            opt[i] = Math.max(use,unse);
        }
        return opt[index];

    }



    public static void main(String[] args) {
        int[] arry = {1,2,4,1,7,8,3};
        DP dp = new DP();
        System.out.println("递归："+ dp.getMaxByRec(arry,6));
        System.out.println("动态规划："+ dp.getDymic(arry,6));
    }
}
