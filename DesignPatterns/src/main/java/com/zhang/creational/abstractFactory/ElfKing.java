package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfKing extends AbstractKing {

    public static final String NAME = "Jim";

    public ElfKing() {
        name = NAME;
    }

    @Override
    public String toString() {
        return "ElfKing{" +
                "name='" + name + '\'' +
                '}';
    }
}
