package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public abstract class AbstractKing implements King {
    protected String name;

    @Override
    public String getName() {
        return name;
    }
}
