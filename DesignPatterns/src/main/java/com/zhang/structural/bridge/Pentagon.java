package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class Pentagon extends Shape {
    public Pentagon(Stainable c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with stainable ");
        stainable.applyColor();
    }
}
