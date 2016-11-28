package com.zhang.creational.factory.abs2.orc;

import com.zhang.creational.factory.abs2.AbsKing;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcKing extends AbsKing {
    public static final String NAME = "Rick";

    public OrcKing() {
        name = NAME;
    }

    @Override
    public String toString() {
        return "OrcKing{" +
                "name='" + name + '\'' +
                '}';
    }
}
