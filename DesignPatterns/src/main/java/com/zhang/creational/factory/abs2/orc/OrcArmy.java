package com.zhang.creational.factory.abs2.orc;

import com.zhang.creational.factory.abs2.AbsArmy;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcArmy extends AbsArmy {

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
