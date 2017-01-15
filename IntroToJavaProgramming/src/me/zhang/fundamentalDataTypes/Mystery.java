package me.zhang.fundamentalDataTypes;

/**
 * Created by Zhang on 1/15/2017 2:58 PM.
 */
public class Mystery {

    public static void main(String[] args) {
        System.out.println(getIntegerMystery());
        System.out.println(getDoubleMystery());
        System.out.println(getTotalPrice());
    }

    private static int getIntegerMystery() {
        int oneMillion = 1000000;
        return oneMillion * oneMillion;
    }

    private static double getDoubleMystery() {
        double oneMillion = 1000000;
        return oneMillion * oneMillion;
    }

    private static double getTotalPrice() {
        double unitPrice = 4.35;
        return 100 * unitPrice;
    }

}
