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
         /**求列数**/
         int line = s.length()/(numRows + numRows -2) *(numRows-1)+1;
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

    public static void main(String[] args) {
        StringCovertToZ s = new StringCovertToZ();
        String s1 = "ABCD";
        System.out.println(s.convert(s1,3));
    }
}
