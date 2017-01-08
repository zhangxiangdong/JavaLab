package com.zhang.structural.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhang on 12/14/2016 10:39 PM.
 */
public class RectFactory {

    // This factoryMethod only creates a new rectangle if it
    // uses a color not previously used

    // Intrinsic State: Color
    // Extrinsic State: X & Y Values

    // The HashMap uses the color as the key for every
    // rectangle it will make up to 8 total

    private static final Map<Color, MyRect> rectsByColor = new HashMap<>();

    public static MyRect getRect(Color color) {
        // Add new rectangle to HashMap
        // Checks if a rectangle with a specific
        // color has been made. If not it makes a
        // new one, otherwise it returns one made already
        return rectsByColor.computeIfAbsent(color, k -> new MyRect(color));
    }

}
