package com.zhang.factory.abs2;

import com.zhang.factory.abs2.elf.ElfKingdomFactory;
import com.zhang.factory.abs2.orc.OrcKingdomFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        app.createKingdom(new OrcKingdomFactory());
        System.out.println();
        app.createKingdom(new ElfKingdomFactory());
    }

    private void createKingdom(KingdomFactory factory) {
        King king = getKing(factory);
        System.out.println(king);

        Castle castle = getCastle(factory);
        System.out.println(castle);

        Army army = getArmy(factory);
        System.out.println(army);
    }

    King getKing(final KingdomFactory factory) {
        return factory.createKing();
    }

    Castle getCastle(KingdomFactory factory) {
        return factory.createCastle();
    }

    Army getArmy(KingdomFactory factory) {
        return factory.createArmy();
    }
}
