package com.zhang.creational.factoryMethod;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public class FactoryPatternTest {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape rectangle = factory.createANewShape(ShapeType.RECTANGLE);
        rectangle.draw();

        Shape triangle = factory.createANewShape(ShapeType.TRIANGLE);
        triangle.draw();

        Shape square = factory.createANewShape(ShapeType.SQUARE);
        square.draw();

        Shape circle = factory.createANewShape(ShapeType.CIRCLE);
        circle.draw();

        Shape unknown = factory.createANewShape(ShapeType.UNKNOWN);
        unknown.draw();

    }

}
