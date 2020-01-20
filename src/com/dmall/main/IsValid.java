package com.dmall.main;

import com.damll.domain.Roman;

import java.math.BigDecimal;
import java.util.*;

public class IsValid {
    public boolean isValid(String s) {
        if (s.length() %2 !=0) {
            return false;
        }
        if (s==null || ("").equals(s)) {
            return true;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(s.charAt(0));
        for (int i=1;i<s.length();i++) {
            if (linkedList.size()==0) {
                linkedList.add(s.charAt(i));
            }else {
                //右边的始终要比左边大
                if (s.charAt(i)-1 == (Character)linkedList.getLast() || s.charAt(i)-2 == (Character)linkedList.getLast()) {
                    linkedList.removeLast();
                }else {
                    //判断最后一位是否能抵消
                    if (linkedList.size()==i+1) {
                        return false;
                    }else {
                        linkedList.add(s.charAt(i));
                    }

                }
            }

        }

        if (linkedList.size() > 0) {
            return false;
        }
        return true;

    }

    /**
     * stack 来解决，linkList不用这么多判断
     * stack 继承自Vector,Vector继承自list
     * 一共只有三种符号，用一个map将三个符号给收集出来，这样就不用写硬代码将地址值相加
     * @param args
     */

    // 用于匹配左半部分
    private HashMap<Character,Character> mappings;

    //无参构造函数构造实例,将三种字符串全初始化在里面
    public IsValid() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put('(',')');
        this.mappings.put('{','}');
        this.mappings.put('[',']');
    }


    public boolean isValid1(String s) {

        if (s.length() %2 !=0) {
            return false;
        }
        if (s==null || ("").equals(s)) {
            return true;
        }
        if (!this.mappings.containsKey(s.charAt(0))) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        for (int i =0;i<s.length();i++) {
           if (stack.isEmpty()) {
               stack.push(s.charAt(i));
           }else {
                   // 构造参数还需要判断数组越界
                   //读取栈顶元素
                   if (this.mappings.containsKey(stack.peek()) && this.mappings.get(stack.peek())==s.charAt(i)) {
                       //弹出栈顶元素，并返回栈顶元素
                       stack.pop();
                   }else {
                       stack.push(s.charAt(i));
                   }

           }

        }

       return stack.isEmpty();
    }

    public String test() {
        List list = null;
        String s2 = "开始";
        try {
            list = new ArrayList();
            /**这个不算数组越界，不会抛异常**/
            for (int i =0; i<list.size();i++) {
                if (("0000").equals(list.toString())) {
                    System.out.println(true);
                }
            }
            Integer i = Integer.valueOf(s2);
        } catch (Exception e) {
            s2="捕获异常";
            //e.printStackTrace();
            //捕获异常之后，会输出
            System.out.println(s2);
            return s2;

        }
        System.out.println("不会输出异常");
        System.out.println(s2);
        return s2;
    }

    public int getInt(int key) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        return map.get(key);
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
      /*  Boolean have =false;
        Boolean is = false;
        boolean fresh = true;
        if(have && !is) {
            System.out.println("生产订单非平台自运营");
        }else if(is) {
            System.out.println("生产订单平台自运营");
        }else{
            if (fresh) {
                System.out.println("尝鲜");
            }else{
                System.out.println("全不是");
            }

        }*/

        try {
            System.out.println(isValid.getInt(2));
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("捕获异常");
        }

    }



}
