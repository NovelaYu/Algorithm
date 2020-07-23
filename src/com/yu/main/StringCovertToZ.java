package com.yu.main;

public class StringCovertToZ {

    /**
     * 时间复杂度并没有降低，有两个两层循环，
     * 先取出来放一个二维数组String[][],再循环遍历将String取出来
     * 当 numRows =2 时，数组越界
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
                 if (numRows !=2) {
                     int tmp = numRows -2;
                     low++;
                     if (i > s.length()-1) {
                         break;
                     }
                     /**行数为2的时候怎么办？！**/
                     characters[tmp][low] =s.charAt(i);
                     tmp--;
                     for (;tmp>0;tmp--) {
                         low ++;
                         j++;
                         i++;
                         if (i > s.length() -1) {
                             break;
                         }
                         characters[tmp][low] =s.charAt(i);

                     }

                     /**行数为2的时候搞不定的**/
                     if (tmp == 0 && numRows ==2) {
                         j = -1;
                         low++;
                     }
                 }
                 if (numRows ==2) {
                     low++;
                     int index = numRows - 1;
                     characters[index][low] = s.charAt(i);
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
        String s1 = "123456789";
        System.out.println(s.convert(s1,2));
    }
}
