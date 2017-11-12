package me.zhang.coreJava.exception;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Zhang on 2017/11/12 10:06.
 */
public class TestLogger {

    /* custom logger */
    private static final Logger LOGGER = Logger.getLogger(TestLogger.class.getPackage().getName());

    static {
        Logger.getGlobal().setLevel(Level.INFO);

        try {
            LOGGER.addHandler(new FileHandler()); // default path: C:\Users\{your username}\java{#}.log
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Logger.getGlobal().info("TestLogger.main");
        LOGGER.info("Log from custom logger");
        Thread.dumpStack();
    }

}
