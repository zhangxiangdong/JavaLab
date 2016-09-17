package me.zhang.basic.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Li on 4/16/2016 10:00 PM.
 */
public class CheckedExceptions {
    public static void main(String[] args) {
        iOException();
    }

    private static void iOException() {
        InputStream in = UncheckedExceptions.class.getResourceAsStream("demos.txt");
        /* Since Java 7, there is no need to close the stream, because it implements AutoCloseable */
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
