package me.zhang.coreJava;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Zhang on 10/6/2017 3:41 PM.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 100_000, 2013, 5, 3);
        staff[1] = new Employee("Harry Hacker", 500_000, 2012, 2, 24);
        staff[2] = new Employee("Tony Tester", 1_000_000, 2010, 8, 17);
        System.out.println(Arrays.deepToString(staff));

        // raise salary
        for (Employee employee : staff) {
            employee.raiseSalary(5);
        }
        System.out.println(Arrays.deepToString(staff));

        Employee carl = staff[0];
        Date hireDay = carl.getHireDay();
        double tenYearsInMilliSeconds = 10 * 365.25 * 24 * 60 * 60 * 1000;
        hireDay.setTime((long) (hireDay.getTime() - tenYearsInMilliSeconds));
        // give Carl ten years of added seniority
        // hireDay is a copy of the real one, it doesn't work!
        System.out.println(carl);
    }

}
