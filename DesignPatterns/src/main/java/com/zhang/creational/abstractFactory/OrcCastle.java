package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcCastle extends AbstractCastle {
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
