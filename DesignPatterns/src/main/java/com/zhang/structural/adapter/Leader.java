package com.zhang.structural.adapter;

/**
 * Created by zhangxiangdong on 2016/11/29.
 */
public class Leader implements BattleVehicle {

    private final BattleVehicle battleVehicle;

    public Leader(BattleVehicle battleVehicle) {
        this.battleVehicle = battleVehicle;
    }

    @Override
    public void move() {
        battleVehicle.move();
    }

    @Override
    public void attack() {
        battleVehicle.attack();
    }
}
