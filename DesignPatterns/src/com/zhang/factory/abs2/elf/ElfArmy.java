package com.zhang.factory.abs2.elf;

import com.zhang.factory.abs2.AbsArmy;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfArmy extends AbsArmy {

    public ElfArmy() {
        number = 12000;
    }

    @Override
    public String toString() {
        return "ElfArmy{" +
                "number=" + number +
                '}';
    }

}
