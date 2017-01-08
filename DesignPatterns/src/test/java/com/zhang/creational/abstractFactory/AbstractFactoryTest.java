package com.zhang.creational.abstractFactory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class AbstractFactoryTest {

    private App app = new App();
    private KingdomFactory elfFactory;
    private KingdomFactory orcFactory;

    @Before
    public void setUp() {
        elfFactory = new ElfKingdomFactory();
        orcFactory = new OrcKingdomFactory();
    }

    @Test
    public void king() {
        final King elfKing = app.getKing(elfFactory);
        assertTrue(elfKing instanceof ElfKing);
        assertEquals(ElfKing.NAME, elfKing.getName());
        final King orcKing = app.getKing(orcFactory);
        assertTrue(orcKing instanceof OrcKing);
        assertEquals(OrcKing.NAME, orcKing.getName());
    }

    @Test
    public void castle() {
        final Castle elfCastle = app.getCastle(elfFactory);
        assertTrue(elfCastle instanceof ElfCastle);
        assertEquals(ElfCastle.NAME, elfCastle.getName());
        final Castle orcCastle = app.getCastle(orcFactory);
        assertTrue(orcCastle instanceof OrcCastle);
        assertEquals(OrcCastle.NAME, orcCastle.getName());
    }

    @Test
    public void army() {
        final Army elfArmy = app.getArmy(elfFactory);
        assertTrue(elfArmy instanceof ElfArmy);
        assertEquals(ElfArmy.NUMBER, elfArmy.getNumber());
        final Army orcArmy = app.getArmy(orcFactory);
        assertTrue(orcArmy instanceof OrcArmy);
        assertEquals(OrcArmy.NUMBER, orcArmy.getNumber());
    }

    @Test
    public void createElfKingdom() {
        app.createKingdom(elfFactory);
        final King king = app.getKing();
        final Castle castle = app.getCastle();
        final Army army = app.getArmy();
        assertTrue(king instanceof ElfKing);
        assertEquals(ElfKing.NAME, king.getName());
        assertTrue(castle instanceof ElfCastle);
        assertEquals(ElfCastle.NAME, castle.getName());
        assertTrue(army instanceof ElfArmy);
        assertEquals(ElfArmy.NUMBER, army.getNumber());
    }

    @Test
    public void createOrcKingdom() {
        app.createKingdom(orcFactory);
        final King king = app.getKing();
        final Castle castle = app.getCastle();
        final Army army = app.getArmy();
        assertTrue(king instanceof OrcKing);
        assertEquals(OrcKing.NAME, king.getName());
        assertTrue(castle instanceof OrcCastle);
        assertEquals(OrcCastle.NAME, castle.getName());
        assertTrue(army instanceof OrcArmy);
        assertEquals(OrcArmy.NUMBER, army.getNumber());
    }

}
