package me.zhang.classes;

/**
 * Created by Zhang on 1/8/2017 3:27 PM.
 */
public class Car {

    private double gasInTank;
    private double milesDriven;
    private final double milesPerGallon;

    public Car(double mpg) {
        /* Initialize instance variables */
        gasInTank = 0;
        milesDriven = 0;
        milesPerGallon = mpg;
    }

    public void addGas(double amount) {
        gasInTank += amount;
    }

    public void drive(double distance) {
        milesDriven += distance;

        double gasConsumed = distance / milesPerGallon;
        gasInTank -= gasConsumed;
    }

    public double getMilesDriven() {
        return milesDriven;
    }

    public double getGasInTank() {
        return gasInTank;
    }

}
