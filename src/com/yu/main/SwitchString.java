package com.yu.main;

import java.util.Stack;

public class SwitchString {

    public String swithcString(String s) {
        String s1 ="" ;
        Stack stack = new Stack();
        for (int i =s.length()-1;i>-1;i--) {
            stack.push(s.charAt(i));
            if (('\0')==s.charAt(i) || Character.isSpaceChar(s.charAt(i))) {
                while (!stack.empty()) {
                    s1 +=stack.pop();
                }

            }
        }
        return s1;
    }

    public static void main(String[] args) {
        SwitchString switchString = new SwitchString();
        String s = switchString.swithcString(" The sky is blue");
        System.out.println(s);
    }

}
