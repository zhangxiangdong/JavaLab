package com.zhang.creational.factory.abs2.orc;

import com.zhang.creational.factory.abs2.AbsCastle;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcCastle extends AbsCastle {
    public static final String NAME = "Neuschwanstein Castle";

    public OrcCastle() {
        name = NAME;
    }

    @Override
    public String toString() {
        return "OrcCastle{" +
                "name='" + name + '\'' +
                '}';
    }
}
