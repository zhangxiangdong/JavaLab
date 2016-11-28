package com.zhang.creational.factory.abs;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public class SBI implements Bank {
    private final String BNAME;

    public SBI() {
        BNAME = "SBI BANK";
    }

    public String getBankName() {
        return BNAME;
    }
}
