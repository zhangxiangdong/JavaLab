package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfArmy extends AbstractArmy {

    public static final int NUMBER = 12000;

    public ElfArmy() {
        number = NUMBER;
    }

    @Override
    public String toString() {
        return "ElfArmy{" +
                "number=" + number +
                '}';
    }

}
