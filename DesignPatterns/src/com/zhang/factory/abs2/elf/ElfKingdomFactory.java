package com.zhang.factory.abs2.elf;

import com.zhang.factory.abs2.Army;
import com.zhang.factory.abs2.Castle;
import com.zhang.factory.abs2.King;
import com.zhang.factory.abs2.KingdomFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfKingdomFactory implements KingdomFactory {

    public ElfKingdomFactory() {

    }

    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
