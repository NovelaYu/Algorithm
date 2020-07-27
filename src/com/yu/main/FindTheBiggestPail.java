package com.yu.main;

public class FindTheBiggestPail {

    /**
     *
     * @param height
     * @return
     * 1、先找到最大的值，以此作为标杆
     * 2、再比较两边的水桶面积
     *
     */
    public int maxArea(int[] height) {
        if (height.length <2) {
            return height[0];
        }
        int maxArea = 0;
        int tmp =0;
        /**寻找当前数量距离最远的大于等于的数**/
        for (int i=0; i<height.length;i++) {
            for (int j=height.length-1;j>0;j++) {
                if (height[i] <height[j]) {
                    tmp = height[i] *(j-i);
                }else {
                    tmp = height[j] * (j-i);
                }
                maxArea = tmp>maxArea?tmp:maxArea;
            }
        }


        return maxArea;
    }

    /**
     *
     * @param height
     * @return
     * 1、Letcode的解法是先找边界,固定双边界
     * 2、木桶效应：装水多少是由最小的那块木板决定的
     */
    public int LetMAxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int maxArea =0;
        while (left < right) {
            int tmp = (height[left]<height[right]?height[left]:height[right]) *(right-left);
            maxArea = maxArea>tmp?maxArea:tmp;
            /**数量小的那一边进行移动，因为数量大的那边不论怎么移动，长都比之前小，但是高是固定的
             * 数量小的那一边进行移动，长会缩小，但是高会变高，可能高度会大于长度
             * */
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        FindTheBiggestPail findTheBiggestPail = new FindTheBiggestPail();
        int[] a = {1,2,3,4};
        System.out.println(findTheBiggestPail.LetMAxArea(a));
    }
}
