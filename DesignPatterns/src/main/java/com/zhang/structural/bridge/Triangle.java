package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class Triangle extends Shape {
    public Triangle(Color c) {
        super(c);
    }

    @Override
    public void withColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}
