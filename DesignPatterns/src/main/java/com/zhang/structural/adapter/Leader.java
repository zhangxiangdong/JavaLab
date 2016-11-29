package com.zhang.structural.adapter;

/**
 * Created by zhangxiangdong on 2016/11/29.
 */
public class Leader {

    private final BattleVehicle battleVehicle;

    public Leader(BattleVehicle battleVehicle) {
        this.battleVehicle = battleVehicle;
    }

    public void control() {
        battleVehicle.move();
    }

    public void collide() {
        battleVehicle.attack();
    }

}
