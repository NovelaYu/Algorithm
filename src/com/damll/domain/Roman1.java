package com.damll.domain;

public enum  Roman1 {
    IV(4,"IV"),
    IX(9,"IX"),
    IL(49,"IL"),
    IC(99,"IC"),
    ID(499,"IV"),
    IM(999,"IM"),
    CD(400,"CD"),
    CM(900,"CM");

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
    Roman1(int value,String code) {
        this.value = value;
        this.code = code;
    }



    public static int getValue(String code) {
        for (Roman1 roman1:Roman1.values()) {
            if (code.equals(roman1.getCode())) {
                return roman1.getValue();
            }
        }
        return 0;

    }

}
