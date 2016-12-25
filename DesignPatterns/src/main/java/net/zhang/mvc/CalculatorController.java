package net.zhang.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Zhang on 2016/12/25 11:28.
 * <p>
 * The Controller coordinates interactions
 * between the View and Model.
 */
public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        // Tell the View that when ever the calculate button
        // is clicked to execute the actionPerformed method
        // in the CalculateListener inner class
        this.theView.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int firstNumber, secondNumber;

            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered
            try {
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();
                theModel.addTwoNumbers(firstNumber, secondNumber);

                theView.setCalcSolution(theModel.getCalculationValue());
            } catch (NumberFormatException ex) {
                theView.displayErrorMessage("You need to enter two integers");
            }
        }
    }

}
