package com.dmall.main;

import com.damll.domain.MatchNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddBinary {

    public static class MatchNumber1 {
        /**正则表达式利用其预编译功能，可以加快正则匹配速度**/
        /**非静态内部类不能有静态方法**/
        //成员内部类必须先实例化外部对象然后再实例化成员内部类
        //static在类的加载的时候就会存在在内存中，要使用某个类的static属性或方法，类必须加载到jvm中
        //内部类并未加载到jvm
        public static Pattern NUMBER_PATTER= Pattern.compile("[0-1]+");
        // 内部类应用外部类的方法
        public void test() {
            System.out.println(new AddBinary().addBinary("1","2"));
        }
    }

    public String addBinary(String a, String b) {
        /**先判断非空字符**/
        if (a == null || ("").equals(a) || a.length() == 0) {
            return b;
        }
        if (b == null || ("").equals(b) || b.length() == 0) {
            // 外部类引用内部类的方法
            new MatchNumber1().test();
            return a;
        }
        /**再进行正则表达式匹配a**/
        Matcher matherA = AddBinary.MatchNumber1.NUMBER_PATTER.matcher(a);
        if (!matherA.matches()) {
            System.out.println("匹配错误");
            return null;

        }

        /**再进行正则表达式匹配b**/
        Matcher matherB = MatchNumber.NUMBER_PATTER.matcher(b);
        if (!matherB.matches()) {
            System.out.println("匹配错误");
            return null;
        }

        StringBuilder ans = new StringBuilder();
        int ca = 0;
        //多重判断
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            //'1'-'0' 得到的事该字符型的具体的值
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            System.out.println(sum);
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String c1 = "1111";
        String c2 = "000011";
        // addBinary.addBinary(c1,c2);
        Character s1 = 'A';
        int s2 = '1';
        //这样转换为ASCII值，50
        System.out.println((int) (s1));
        System.out.println((s2-'0'));
        //正常字符串加减
        System.out.println((int)s1);
        // 非数字字节码的增加转换为ASCII码值
        System.out.println('A' - '0');
        // 数字的字节码直接相减
        System.out.println('4' - '0');

    }
}
