package com.zhang.factory.abs2.orc;

import com.zhang.factory.abs2.AbsCastle;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcCastle extends AbsCastle {
    public OrcCastle() {
        name = "Neuschwanstein Castle";
    }

    @Override
    public String toString() {
        return "OrcCastle{" +
                "name='" + name + '\'' +
                '}';
    }
}
