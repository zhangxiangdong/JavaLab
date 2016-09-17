package me.zhang.importstatic;

import java.text.NumberFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.text.NumberFormat.getInstance;

/**
 * Do Not!!!
 */


/**
 * Created by Zhang on 2015/6/12 上午 10:16 .
 */
public class Client {

    /* 编译器最短路径原则，优先调用本类中的变量、常量、方法 */
    private static final double PI = 3.141592653589793;

    // 输入半径和精度，计算面积
    public static void main(String[] args) {
        double s = Math.PI * parseDouble(args[0]);
        NumberFormat nf = getInstance();
        nf.setMaximumFractionDigits(parseInt(args[1]));
        formatMessage(nf.format(s));
    }

    // 格式化输出
    private static void formatMessage(String s) {
        System.out.println("圆的面积是：" + s);
    }

}
