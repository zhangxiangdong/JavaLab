package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public abstract class AbstractArmy implements Army {
    protected int number;

    @Override
    public int getNumber() {
        return number;
    }
}
