package com.zhang.creational.factory.abs2.orc;

import com.zhang.creational.factory.abs2.Army;
import com.zhang.creational.factory.abs2.Castle;
import com.zhang.creational.factory.abs2.King;
import com.zhang.creational.factory.abs2.KingdomFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class OrcKingdomFactory implements KingdomFactory {

    public OrcKingdomFactory() {

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
