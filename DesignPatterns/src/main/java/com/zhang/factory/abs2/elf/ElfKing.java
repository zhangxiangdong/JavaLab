package com.zhang.factory.abs2.elf;

import com.zhang.factory.abs2.AbsKing;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfKing extends AbsKing {

    public ElfKing() {
        name = "Jim";
    }

    @Override
    public String toString() {
        return "ElfKing{" +
                "name='" + name + '\'' +
                '}';
    }
}
