package com.damll.domain;

import java.util.regex.Pattern;

public class MatchNumber {
    /**正则表达式利用其预编译功能，可以加快正则匹配速度**/

    public static Pattern NUMBER_PATTER= Pattern.compile("[0-1]+");

    public static Pattern ANY_NUBBER_PATTER = Pattern.compile("^[1-9]\\d*$");
}
