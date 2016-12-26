package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcArmy extends AbstractArmy {

    public static final int NUMBER = 23000;

    public OrcArmy() {
        number = NUMBER;
    }

    @Override
    public String toString() {
        return "OrcArmy{" +
                "number=" + number +
                '}';
    }

}
