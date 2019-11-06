package com.dmall.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        boolean flag = true;
        if (bits.length <0 || bits.length >1000) {
            flag =false;
        }
        for (int i =0;i<bits.length;) {
            if (bits[i] != 0 && bits[i] != 1) {
                return false;
            }
            if (bits[i] == 0) {
                i++;
                continue;
            }
            //防止数组越界 {1,1,1,0}
            if (bits[i] == 1 && i < bits.length-2) {
                i += 2;
                continue;
            }
            //要判断数组越界
            if (i == bits.length -2 && bits[i] == 1) {
                return false;
            }else {
                return true;
            }
        }
        return flag;
    }


    public boolean isOneBitCCharacter1(int[] ars) {
        int i = 0;
        //道理都是相同的，但是有更好的实现方式
        // 0就加1，1就加2，归结到一起就是自身加1
        // 让变量尽可能的少
        while (i < ars.length - 1) {
            i += ars[i] + 1;
        }
        return i == ars.length - 1;
    }

    // 倒数第二个0中间的1为基数个，则为false；
    // 倒数第二个0中间的1为偶数个，则为true;
    // 时间复杂度如果不是拉到极限，比上两种都要小，空间复杂度也只有两个常量。
    public boolean isOneBitCCharacter2(int[] bits) {
        int j =0;
        for (int i=bits.length-2; i>=0;) {
            if (bits[i] == 0) {
                break;
            }else {
                i--;
                j++;
                continue;
            }
        }
        if (j % 2 == 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        // alt+enter 快速进入实现类中
        // for 循环进行元素的增减，用迭代器代替for循环
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
       /* Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (("2").equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(list.toString());
*/
       /* for (String item : list) {
            if (("2").equals(item)) {
                list.remove(item);
            }
            System.out.println(list.toString());
        }*/

       //用普通的for循环也可以
        for (int i =0;i<list.size();i++) {
            if (("2").equals(list.get(i))) {
                list.remove(list.get(i));
            }
            System.out.println(list.toString());
        }

    }



}
