package me.zhang.coreJava.io;

import java.io.*;

/**
 * Created by zhangxiangdong on 2017/12/19.
 */
public class Orientation implements Serializable {

    private static final long serialVersionUID = 6683443932407538245L;
    public static final Orientation HORIZONTAL = new Orientation(1);
    public static final Orientation VERTICAL = new Orientation(2);

    private int value;

    public Orientation(int value) {
        this.value = value;
    }

    // called by system
    protected Object readResolve() throws ObjectStreamException {
        if (value == 1) return HORIZONTAL;
        if (value == 2) return VERTICAL;
        return null; // shouldn't happen
    }

    public static void main(String[] args) {
        final String fileName = "orientation.dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(Orientation.HORIZONTAL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Orientation orientation = (Orientation) in.readObject();
            if (orientation == Orientation.HORIZONTAL) {
                System.out.println("horizontal!");
            } else {
                System.out.println("deserialize failed!");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
