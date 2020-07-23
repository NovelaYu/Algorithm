package com.yu.main;

public class StringCovertToZ {

    /**
     * 时间复杂度并没有降低，有两个两层循环，
     * 先取出来放一个二维数组String[][],再循环遍历将String取出来
     *
     * **/
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows < 2) {
            return s;
        }
         /**求列数,不知道怎么算，弄个最大的吧**/
        // int line = s.length()/(numRows) *(numRows-1)+1;
           int line;
        if ((s.length()-numRows)%(numRows-1)==0) {
            line = (s.length()-numRows)/(numRows-1)+1;
        }else {
            line = (s.length()-numRows)/(numRows-1)+2;
        }

         Character[][] characters = new Character[numRows][line];
         int low =0;
         for (int i=0,j =0;i<s.length();i++,j++) {
             if (j == numRows) {
                 int tmp = numRows -2;
                 for (;tmp>0;tmp--) {
                     low ++;
                     if (i > s.length() -1) {
                         break;
                     }
                     characters[tmp][low] =s.charAt(i);
                     /**主要是二维数组循环，每次循环一次，i和j都会自增
                      * 需要在赋值之后自增行数和列数
                      * **/
                     i++;
                     if (i > s.length() -1) {
                         break;
                     }

                 }

              if (tmp == 0) {
                  j = tmp;
                  low++;
                  /**每次单独赋值都需要判断数值是否越界**/
                  if (i > s.length() -1) {
                      break;
                  }
                  characters[j][low] = s.charAt(i);

              }

             }else {
                 characters[j][low] = s.charAt(i);
             }
         }
        StringBuffer stringBuffer = new StringBuffer();

        for (int m=0;m<numRows; m++) {
             for (int n=0;n<line;n++) {
                 if (characters[m][n] == null) {
                     continue;
                 }
                stringBuffer.append(characters[m][n].toString());
             }
         }



        return stringBuffer.toString();
    }


   /**
   * @Author: yu.xiang
   * @Description:
   * @Date: 15:23 2020/7/23
    * 用StringBulider 每行做拼接
    *
   **/


   public String StringCovertZ(String s, int numRows) {
       if (s.length() ==0 || s == null || numRows <2) {
           return s;
       }

      StringBuilder[] array = new StringBuilder[numRows];

       for (int i=0;i<array.length;i++) {
           /**实例化StringBuilder**/
           array[i] = new StringBuilder();
       }

       int dir = 1;
       int index = 0;
       for (int i=0; i<s.length();i++) {
            array[index].append(s.charAt(i));
            index += dir;
            /**提前一步判断，再循环之后才生效
             * 倒数第二步时，标志位转变正负号，倒数一位仍然正常循环
             * **/
            if (index == 0 || index == numRows-1) {
                /**这个dir实在是太妙了，比单独的循环加加，减减要妙
                 * 总结：多个循环有规律可循时，需要注意各个标志位的联动
                 * 要注意，位置的增减变化
                 * **/
                dir = -dir;
            }
      }

      StringBuilder s1 = new StringBuilder();
    for (StringBuilder string:array) {
        s1.append(string.toString());
    }

       return s1.toString();
   }


    public static void main(String[] args) {
        StringCovertToZ s = new StringCovertToZ();
        String s1 = "ABAB";
        System.out.println(s.StringCovertZ(s1,2));
    }
}
