package com.zhang.factory.abs2.elf;

import com.zhang.factory.abs2.AbsCastle;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfCastle extends AbsCastle {

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
