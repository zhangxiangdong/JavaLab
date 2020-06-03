package me.zhang.coreJava;

import java.util.Arrays;

/**
 * Created by Zhang on 10/8/2017 10:37 PM.
 */
public class ManagerTest {

    public static void main(String[] args) {
        Manager[] managers = new Manager[3];
        managers[0] = new Manager("Lucia", 1_000_000, 2009, 3, 1);
        managers[1] = new Manager("Hanks", 1_200_000, 2008, 12, 13);

        Employee[] employees = managers;
        // Attention!
        // Exception occurs
        // java.lang.ArrayStoreException
        employees[2] = new Employee("Tommy", 500_000, 2016, 4, 8);

        managers[2].setBonus(500);

        System.out.println(Arrays.deepToString(employees));
    }

}
