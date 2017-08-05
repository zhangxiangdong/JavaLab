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
        result = powerWithUnsignedExponent(base, absExponent);
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

}
