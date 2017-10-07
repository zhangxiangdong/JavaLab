package me.zhang.coreJava;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Zhang on 10/6/2017 3:41 PM.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Carl Cracker", 100_000, 2013, 5, 3);
        staff[1] = new Employee("Harry Hacker", 500_000, 2012, 2, 24);
        staff[2] = new Employee("Tony Tester", 1_000_000, 2010, 8, 17);
        staff[3] = new Employee();
        System.out.println(Arrays.deepToString(staff));

        Employee zhang = staff[3];
        zhang.setName("Zhang");
        zhang.setSalary(300_000);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.AUGUST, 31);
        zhang.setHireDay(calendar.getTime());
        System.out.println(zhang);

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
