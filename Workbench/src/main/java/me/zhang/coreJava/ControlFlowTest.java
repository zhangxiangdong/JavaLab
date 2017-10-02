package me.zhang.coreJava;

/**
 * Created by Zhang on 10/2/2017 2:37 PM.
 */
public class ControlFlowTest {

    public static void main(String[] args) {
        int x = -3;
        int sign = 0;
        // else与第二个if配对
        if (x <= 0) if (x != 0) sign = 1;
        else sign = -1;
        System.out.println(sign);
    }

}
