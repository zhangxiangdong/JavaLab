package net.zhang.mvc;

/**
 * Created by Zhang on 2016/12/25 11:18.
 * <p>
 * The Model performs all the calculations needed
 * and that is it. It doesn't know the View exists.
 */
public class CalculatorModel {

    // Holds the value of the sum of the numbers
    // entered in the View.
    private int calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber) {
        calculationValue = firstNumber + secondNumber;
    }

    public int getCalculationValue() {
        return calculationValue;
    }

}
