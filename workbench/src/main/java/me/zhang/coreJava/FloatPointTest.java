package me.zhang.coreJava;

/**
 * Created by Zhang on 9/30/2017 3:04 PM.
 */
public strictfp class FloatPointTest implements StrictInterface {

    private static final double PI = Math.PI;

    public static strictfp void main(String[] args) {
        FloatPointTest fp = new FloatPointTest();
        System.out.println(fp.strictFloatPointCalc(1.0, 2.0, 3.0));
        System.out.println(fp.strictFloatPointCalc(PI, PI, PI));
    }

    @Override
    public strictfp double strictFloatPointCalc(double x, double y, double z) {
        return x * y / z;
    }

}
