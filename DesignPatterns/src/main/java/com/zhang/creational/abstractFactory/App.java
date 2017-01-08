package com.zhang.creational.abstractFactory;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class App {

    private King king;
    private Castle castle;
    private Army army;

    public static void main(String[] args) {
        App app = new App();
        app.createKingdom(new OrcKingdomFactory());
        System.out.println();
        app.createKingdom(new ElfKingdomFactory());
    }

    void createKingdom(KingdomFactory factory) {
        King king = getKing(factory);
        setKing(king);
        System.out.println(king);

        Castle castle = getCastle(factory);
        setCastle(castle);
        System.out.println(castle);

        Army army = getArmy(factory);
        setArmy(army);
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

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }
}
