package com.yu.domain;

public class KMP {
    /**
     * 寻找待比较的公共字符串的长度
     * 将相同
     * */
    public int[] get_prefix(String T) {
        int[] prefix = new int[T.length()];
        int length = T.length();
        // len是指最大公共前后缀的值
        int len=0;
        // k指的是当前指针
        int k =1;
        prefix[0] = 0;
        if (length ==1) {
            return prefix;
        }
        while (k < length) {
            if (T.charAt(len) == T.charAt(k)) {
                len++;
                prefix[k]=len;
                k++;
                System.out.println(prefix[k]);
            }else {
                /**这是一个递归，回退到上一个公共前缀的大小又开始循环比较
                 * 因为前面已经比较了是相等的*/
                len = prefix[k -1];
                k++;
                System.out.println(prefix[k]);
            }

        }
        return prefix;

    }

    /**
     * 对数组整体右移动一位，为甚要右移动？
     * 因为如果字符匹配失位，指针需要回溯一位，将数组向后偏移一位，得到一个新的数组
     * 开始的，要将对应的公共前缀回退到上一个公共前缀结束的位置
     * 依次移动位置
     * **/
    public int[] get_next(int[] prefix) {
        int next[] = new int[prefix.length];
        for (int i=1;i<prefix.length;i++) {
            next[i]=prefix[i-1];
        }
        next[0]=-1;
        return next;
    }

    /*****
     * 将字符串T和字符串S进行对比，如果完全匹配上就退出
     * @param
     */

    public int get_KMP(String S,String T) {
        int[] next = this.get_next(this.get_prefix(T));
        int SLength = S.length();
        int TLength = T.length();
        int i=0,j=0;
        while (i < SLength && j < TLength) {
            // 当j是-1是会产生数组越界
            if (S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            }else {
                j = next[j];
                // 如果遇到了-1，那么整体向右移动一位
                if (j==-1) {
                    j++;
                    i++;
                }
            }
        }
        if (j == TLength) {
            return j;
        }else {
            j = -1;

        }
        return j;
    }


    public static void main(String[] args) {
       /* KMP kmp = new KMP();
        int[] k = kmp.get_prefix("aaaa");
        int[] next = kmp.get_next(k);
        for (int i =0;i<next.length;i++) {
            System.out.println(next[i]);
        }
       String s ="abcaba";
       String t = "aba";
        System.out.println(kmp.get_KMP(s,t));
        String st = "123456789";
       kmp.get_prefix(st);*/
        //String[] s = new String[1];
        //System.out.println(s[0]);

        //Class clazz = kmp.getClass();
      //  System.out.println(clazz.getClassLoader());
        //System.out.println(Thread.currentThread().getContextClassLoader());
        //System.out.println(ClassLoader.getSystemClassLoader());

    }
}
