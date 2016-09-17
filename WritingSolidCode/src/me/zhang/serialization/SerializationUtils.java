package me.zhang.serialization;

import java.io.*;

/**
 * Created by Zhang on 2015/6/12 上午 11:24 .
 */
public class SerializationUtils {

    private static final String FILE_NAME = "D:\\person.bin";

    public static void writeObject(Serializable in) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(in);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject() {
        Object obj = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
