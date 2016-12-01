package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class App {

    public static void main(String[] args) {
        Shape triangle = new Triangle(new GreenColor());
        triangle.withColor();

        Shape pentagon = new Pentagon(new RedColor());
        pentagon.withColor();
    }

}
