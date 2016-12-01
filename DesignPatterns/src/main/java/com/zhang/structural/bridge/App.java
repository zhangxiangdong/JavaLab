package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class App {

    public static void main(String[] args) {
        /* Say I want a green triangle */
        Shape triangle = new Triangle(new GreenColor());
        triangle.withColor();

        /* Or a red pentagon */
        Shape pentagon = new Pentagon(new RedColor());
        pentagon.withColor();
    }

}
