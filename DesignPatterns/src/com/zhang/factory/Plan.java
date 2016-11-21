package com.zhang.factory;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public abstract class Plan {

    protected double rate;

    abstract void getRate();

    public void calculateBill(int units) {
        System.out.println(units * rate);
    }

}
