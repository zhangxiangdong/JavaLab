package me.zhang.decorator.java.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zhang on 10/25/2015 10:30 上午.
 */
public class InputTest {

    public static void main(String[] args) {
        printOriginalSentence();
        System.out.println();
        printLowerCaseSentence();
    }

    private static void printOriginalSentence() {
        int c;
        try {
            String root = System.getProperty("user.dir");
            InputStream in = new BufferedInputStream(
                    new FileInputStream(String.format("%s\\%s", root, "test.txt"))
            );

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printLowerCaseSentence() {
        int c;
        try {
            String root = System.getProperty("user.dir");
            InputStream in = new LowerCaseInputStream( // 使用LowerCaseInputStream过滤器装饰
                    new BufferedInputStream(
                            new FileInputStream(String.format("%s\\%s", root, "test.txt"))
                    )
            );

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
