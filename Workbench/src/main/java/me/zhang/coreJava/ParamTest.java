package me.zhang.coreJava;

/**
 * Created by Zhang on 10/7/2017 8:44 PM.
 */
public class ParamTest {

    public static void main(String[] args) {
        /* 1. Methods can't modify numeric parameters */
        System.out.println("Testing tripleValue: ");
        double percent = 10;
        System.out.println("Before: percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);

        /* 2. Methods can change the state of object parameters */
        System.out.println("\nTesting tripleSalary: ");
        Employee carl = new Employee("Carl Cracker", 100_000, 2013, 5, 3);
        System.out.println("Before: salary = " + carl.getSalary());
        tripleSalary(carl);
        System.out.println("After: salary = " + carl.getSalary());

        /* 3. Methods can't attach new objects to object parameters */
        System.out.println("\nTesting swap: ");
        Employee a = new Employee("Alice", 70_000, 2013, 5, 24);
        Employee b = new Employee("Bob", 60_000, 2015, 2, 4);
        System.out.println("Before: a = " + a.getName());
        System.out.println("Before: b = " + b.getName());
        swap(a, b);
        System.out.println("After: a = " + a.getName());
        System.out.println("After: b = " + b.getName());
    }

    private static void tripleValue(double x) { // it doesn't work
        x = x * 3;
        System.out.println("End of method: x = " + x);
    }

    private static void tripleSalary(Employee x) { // it works
        x.raiseSalary(200);
        System.out.println("End of method: salary = " + x.getSalary());
    }

    private static void swap(Employee x, Employee y) { // swap failed
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x = " + x.getName());
        System.out.println("End of method: y = " + y.getName());
    }

}
