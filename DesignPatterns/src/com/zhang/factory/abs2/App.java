package com.zhang.factory.abs2;

import com.zhang.factory.abs2.elf.ElfKingdomFactory;
import com.zhang.factory.abs2.orc.OrcKindomFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class App {

    public static void main(String[] args) {
        createKingdom(new OrcKindomFactory());
        System.out.println();
        createKingdom(new ElfKingdomFactory());
    }

    private static void createKingdom(KingdomFactory factory) {
        King king = factory.createKing();
        Castle castle = factory.createCastle();
        Army army = factory.createArmy();

        System.out.println(king);
        System.out.println(castle);
        System.out.println(army);
    }

}
