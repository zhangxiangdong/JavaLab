package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class Triangle extends Shape {
    public Triangle(Stainable c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with stainable ");
        stainable.applyColor();
    }
}
