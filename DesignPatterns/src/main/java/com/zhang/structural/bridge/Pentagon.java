package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class Pentagon extends Shape {
    public Pentagon(Color c) {
        super(c);
    }

    @Override
    public void withColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }
}
