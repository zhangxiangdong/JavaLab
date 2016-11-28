package com.zhang.creational.factory.abs;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public class ICICI implements Bank {
    private final String BNAME;

    ICICI() {
        BNAME = "ICICI BANK";
    }

    public String getBankName() {
        return BNAME;
    }
}
