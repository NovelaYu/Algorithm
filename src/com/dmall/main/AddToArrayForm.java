package com.dmall.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {
    //1、可以将整数进行移位之后分别与数据进行加减，这个时候需要容容器来进行数据分析反转。
    //2、可以将整数转换我字符串，整个字符串进行从末尾进行加减操作
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<Integer>();
        int N = A.length;
        int i = N;
        while (-- i >=0 || K >0) {
            if (i >=0 ) {
                K += A[i];
            }
            ans.add(K % 10);
            K /= 10;
        }
        // 工具类，可对List进行操作
        Collections.reverse(ans);
        return ans;
    }
}
