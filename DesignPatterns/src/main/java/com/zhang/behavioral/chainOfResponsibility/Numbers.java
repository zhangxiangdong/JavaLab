package com.zhang.behavioral.chainOfResponsibility;

/**
 * Created by Zhang on 12/8/2016 10:51 PM.
 */
public class Numbers {

    private int numberOne;
    private int numberTwo;

    private String calculationWanted;

    public Numbers(int numberOne, int numberTwo, String calculationWanted) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.calculationWanted = calculationWanted;
    }

    public int getNumberOne() {
        return numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public String getCalculationWanted() {
        return calculationWanted;
    }
}
