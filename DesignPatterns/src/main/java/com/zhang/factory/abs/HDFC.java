package com.zhang.factory.abs;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public class HDFC implements Bank {
    private final String BNAME;

    public HDFC() {
        BNAME = "HDFC BANK";
    }

    public String getBankName() {
        return BNAME;
    }
}
