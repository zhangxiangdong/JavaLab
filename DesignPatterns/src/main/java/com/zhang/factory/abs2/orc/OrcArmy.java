package com.zhang.factory.abs2.orc;

import com.zhang.factory.abs2.AbsArmy;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcArmy extends AbsArmy {

    public OrcArmy() {
        number = 2300;
    }

    @Override
    public String toString() {
        return "OrcArmy{" +
                "number=" + number +
                '}';
    }

}
