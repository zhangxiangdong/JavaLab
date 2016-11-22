package com.zhang.factory.abs2.orc;

import com.zhang.factory.abs2.AbsKing;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcKing extends AbsKing {
    public OrcKing() {
        name = "Rick";
    }

    @Override
    public String toString() {
        return "OrcKing{" +
                "name='" + name + '\'' +
                '}';
    }
}
