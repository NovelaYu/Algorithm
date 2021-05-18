package com.yu.main;

/***
 * 1、查找100以内的素数个数
 * 2、素数就是只能被1和自己整除，1 不是素数，2、3是素数，4不是素数，4=2*2
 */
public class AiShai {


    /**暴力解决**/
    public int getLengthSu(int input) {
        /**
         * 1、要把变量运用起来，有时候相乘不能解决问题，相除可以解决
         * 2、分步骤解决问题，不用所有解决都放在一个方法中
         **/
        int count = 0;
        for (int i = 2; i <= input; i++) {
            count += isPrimse(i) ? 0 : 1;
        }

        return count;

    }

    public boolean isPrimse(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return true;
            }
        }
        return false;
    }


    /***
     * 1、埃筛法，将每个数标记，
     * 2、最妙的一步是，外层循环自增,i不能自增，通过对j赋值进行自增，j = 2*i; j+=i;
     * **/
   public int eratosthenes(int x) {
       boolean[] numbers = new boolean[x];
       int count = 0;
       for (int i =2; i < x; i++) {
            if (!numbers[i]) {
                count++;
                // 2*3,2*4,2*5,循环内很多变量可以使用，不止 j++
                for (int j = i * i; j < x; j+=i) {
                    numbers[j] = true;
                }
            }
       }
       return count;
   }



    public static void main(String[] args) {
        AiShai aiShai = new AiShai();
        System.out.println(aiShai.eratosthenes(100));
    }
}
