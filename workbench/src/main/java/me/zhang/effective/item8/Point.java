package me.zhang.effective.item8;

import java.awt.*;
import java.util.Objects;

/**
 * Created by zhangxiangdong on 2017/12/22.
 */
public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point that = (Point) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class ColorPoint {

    private Point point;
    private Color color;

    public ColorPoint(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public ColorPoint(double x, double y, Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorPoint that = (ColorPoint) o;
        return Objects.equals(point, that.point) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }
}
