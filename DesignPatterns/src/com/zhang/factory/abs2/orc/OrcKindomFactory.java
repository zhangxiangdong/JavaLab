package com.zhang.factory.abs2.orc;

import com.zhang.factory.abs2.Army;
import com.zhang.factory.abs2.Castle;
import com.zhang.factory.abs2.King;
import com.zhang.factory.abs2.KingdomFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcKindomFactory implements KingdomFactory {

    public OrcKindomFactory() {

    }

    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }
}
