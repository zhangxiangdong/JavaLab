package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcKing extends AbstractKing {
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
