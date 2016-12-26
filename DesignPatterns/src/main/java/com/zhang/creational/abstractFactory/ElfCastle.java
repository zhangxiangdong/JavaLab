package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfCastle extends AbstractCastle {

    public static final String NAME = "Mont Saint Michel";

    public ElfCastle() {
        name = NAME;
    }

    @Override
    public String toString() {
        return "ElfCastle{" +
                "name='" + name + '\'' +
                '}';
    }
}
