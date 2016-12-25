package net.zhang.mvc;

/**
 * Created by Zhang on 2016/12/25 11:36.
 */
public class MVCCalculator {

    public static void main(String[] args) {
        CalculatorView theView = new CalculatorView();
        CalculatorModel theModel = new CalculatorModel();
        new CalculatorController(theView, theModel);
        theView.setVisible(true);
    }

}
