package com.zhang.behavioral.chainOfResponsibility;

/**
 * Created by Zhang on 12/8/2016 10:53 PM.
 */
public class AddNumbers extends BaseChain {

    @Override
    public void calculate(Numbers request) {
        if (request.getCalculationWanted().equals("+")) {
            int numberOne = request.getNumberOne();
            int numberTwo = request.getNumberTwo();
            int result = numberOne + numberTwo;
            System.out.println(String.format("%d + %d = %d", numberOne, numberTwo, result));
        } else {
            nextChain.calculate(request);
        }
    }
}
