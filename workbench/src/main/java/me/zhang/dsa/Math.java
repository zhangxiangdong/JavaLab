package me.zhang.dsa;

/**
 * Created by Zhang on 8/5/2017 9:23 AM.
 */
public class Math {

    static final double THRESHOLD = 0.0000001;

    public double power(double base, int exponent) {
        if (isZero(base) && exponent <= 0) {
            throw new IllegalArgumentException(String.format("base: %f, exponent: %d", base, exponent));
        }
        double result;
        int absExponent = exponent < 0 ? -exponent : exponent;
        // 计算指数为正数的整数次方
        result = pwue(base, absExponent);
        // 指数小于0，对计算结果取倒数
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    private boolean isZero(double value) {
        return value >= -THRESHOLD && value <= THRESHOLD;
    }

    private double powerWithUnsignedExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 参考 me.zhang.dsa 包下：a的n次方.png
     */
    private double pwue(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // 位移操作比/运算符效率高
        double result = pwue(base, exponent >> 1);
        result *= result;
        // 判断exponent是否为奇数（比%运算符效率高）
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Math math = new Math();
        System.out.println(math.power(2, 2));
        System.out.println(math.power(2, -3));
        System.out.println(math.power(2, 0));

        System.out.println(math.power(-3, 2));
        System.out.println(math.power(-3, -3));
        System.out.println(math.power(-3, 0));

        System.out.println(math.power(0, 4));
        try {
            System.out.println(math.power(0, -5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(math.power(0, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
