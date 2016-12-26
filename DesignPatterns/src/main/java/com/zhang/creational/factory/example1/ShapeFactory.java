package com.zhang.creational.factory.example1;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public class ShapeFactory {

    public Shape createANewShape(ShapeType shapeType) {
        Shape newShape;
        switch (shapeType) {
            case CIRCLE:
                newShape = new Circle();
                break;
            case RECTANGLE:
                newShape = new Rectangle();
                break;
            case SQUARE:
                newShape = new Square();
                break;
            case TRIANGLE:
                newShape = new Triangle();
                break;
            default:
                throw new IllegalArgumentException("Unkown shape.");
        }
        return newShape;
    }

}
