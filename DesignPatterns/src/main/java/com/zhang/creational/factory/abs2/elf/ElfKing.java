package com.zhang.creational.factory.abs2.elf;

import com.zhang.creational.factory.abs2.AbsKing;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfKing extends AbsKing {

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
