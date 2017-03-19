package me.zhang.fundamentalDataTypes;

/**
 * Created by Zhang on 3/19/2017 12:00 PM.
 */
public class Checkerboard {

    /**
     * Return red(1) or blue(0) color.
     * If both row and col are even or odd, returns blue color;
     * else returns red color.
     *
     * @param row row
     * @param col column
     * @return color
     */
    public int getColor(int row, int col) {
        return (row + col) % 2;
    }
}
