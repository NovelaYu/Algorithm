package com.damll.domain;

import java.util.ArrayList;
import java.util.List;

public enum  Roman {
    I(1,"I"),
    V(5,"V"),
    X(10,"X"),
    L(50,"L"),
    C(100,"C"),
    D(500,"D"),
    M(1000,"M");

    //变量和方法必须放在枚举值后面
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    // 构造方法默认私有
    Roman(int value,String code) {
        this.value = value;
        this.code = code;
    }



    public static int getValue(String code) {
        for (Roman roman:Roman.values()) {
            if (code.equals(roman.getCode())) {
                return roman.getValue();
            }
        }
             return 0;

        }

}
