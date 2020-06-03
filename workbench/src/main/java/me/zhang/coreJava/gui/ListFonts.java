package me.zhang.coreJava.gui;

import java.awt.*;

/**
 * Created by Zhang on 2017/10/22 14:51.
 */
public class ListFonts {

    public static void main(String[] args) {
        /* print out all available fonts on current system */
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }

}
