package com.zhang.structural.adapter;

/**
 * Created by zhangxiangdong on 2016/11/29.
 */
public class App {

    public static void main(String[] args) {
        Leader leader = new Leader(new BattleCar());
        leader.control();
        leader.collide();
    }

}
