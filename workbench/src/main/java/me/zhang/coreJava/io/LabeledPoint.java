package me.zhang.coreJava.io;

import java.io.*;

/**
 * Created by zhangxiangdong on 2017/12/19.
 */
public class LabeledPoint implements Serializable {

    private static final long serialVersionUID = 2478379807910541220L;
    private String label;
    private transient Point point;

    public LabeledPoint(String label, Point point) {
        this.label = label;
        this.point = point;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' +
                ", point=" + point +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeDouble(point.getX());
        out.writeDouble(point.getY());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        point = new Point(in.readDouble(), in.readDouble());
    }

    public static void main(String[] args) {
        Point point = new Point(100, 200);
        LabeledPoint labeledPoint = new LabeledPoint("Diagonal", point);
        System.out.println(labeledPoint);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("labeledpoint.dat"))) {
            out.writeObject(labeledPoint);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("labeledpoint.dat"))) {
            labeledPoint = (LabeledPoint) in.readObject();
            System.out.println(labeledPoint);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
