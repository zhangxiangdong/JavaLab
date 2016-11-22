package com.zhang.factory.abs2;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public abstract class AbsKing implements King {
    protected String name;

    @Override
    public String getName() {
        return name;
    }
}
