package me.zhang.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("D:\\xanadu.txt");
             FileOutputStream out = new FileOutputStream("D:\\outagain.txt")) {
            int b;
            while ((b = in.read()) != -1) {
                System.out.print((char) b);
                out.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
