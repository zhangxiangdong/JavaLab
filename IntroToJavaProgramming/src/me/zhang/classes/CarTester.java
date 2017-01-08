package me.zhang.classes;

/**
 * Created by Zhang on 1/8/2017 5:42 PM.
 */
public class CarTester {

    public static void main(String[] args) {
        final double amount = 10.0;

        int mpg = 50;
        Car mySmart = new Car(mpg);
        // Fill with gas
        mySmart.addGas(amount);

        // Drive car
        double smartDistance = 200.0;
        mySmart.drive(smartDistance);

        // Show gas level
        System.out.println("Gas in tank: " + mySmart.getGasInTank());
        System.out.println("Expected: " + (amount - smartDistance / mpg));

        int milesPerGallon = 5;
        Car myHummer = new Car(milesPerGallon);
        // Fill with gas
        myHummer.addGas(amount);

        // Drive car
        double hummberDistance = 30.0;
        myHummer.drive(hummberDistance);

        // Show gas level
        System.out.println("Gas in tank: " + myHummer.getGasInTank());
        System.out.println("Expected: " + (amount - hummberDistance / milesPerGallon));
    }

}
