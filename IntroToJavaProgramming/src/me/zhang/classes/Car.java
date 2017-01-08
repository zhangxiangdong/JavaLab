package me.zhang.classes;

/**
 * Created by Zhang on 1/8/2017 3:27 PM.
 */
public class Car {

    private double gasInTank;
    private double milesDriven;
    private static final double MILES_PER_GALLON = 50;

    public void addGas(double amount) {
        gasInTank += amount;
    }

    public void drive(double distance) {
        milesDriven += distance;

        double gasConsumed = distance / MILES_PER_GALLON;
        gasInTank -= gasConsumed;
    }

    public double getMilesDriven() {
        return milesDriven;
    }

    public double getGasInTank() {
        return gasInTank;
    }

}
