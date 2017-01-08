package me.zhang.classes;

/**
 * Created by Zhang on 1/8/2017 5:42 PM.
 */
public class CarTester {

    public static void main(String[] args) {
        Car myCar = new Car();
        // Fill with gas
        myCar.addGas(10);

        // Drive car
        myCar.drive(200);

        // Show gas level
        System.out.println("Gas in tank: " + myCar.getGasInTank());
        System.out.println("Expected: " + (10.0 - 200.0 / 50));
    }

}
