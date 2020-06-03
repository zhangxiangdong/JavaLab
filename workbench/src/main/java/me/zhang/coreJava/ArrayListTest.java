package me.zhang.coreJava;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Zhang on 2017/10/12 21:49.
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Carl Cracker", 100_000, 2013, 5, 3));
        staff.add(new Employee("Harry Hacker", 500_000, 2012, 2, 24));
        Manager boss = new Manager("Tony Tester", 1_000_000, 2010, 8, 17);
        boss.setBonus(5_000);
        staff.add(boss);
        staff.add(new Employee());
        printEmployees(staff);

        System.out.println("----------------------");
        Employee[] employees = new Employee[staff.size()];
        staff.toArray(employees);
        printEmployees(employees);

        System.out.println("**********************");
        staff.ensureCapacity(100);
        printArrayLength(staff);
        System.out.println("List size: " + staff.size());

        System.out.println("----------------------");
        for (int i = 0; i < 90; i++) {
            staff.add(new Employee());
        }
        staff.trimToSize();
        printArrayLength(staff);
        System.out.println("List size: " + staff.size());

    }

    private static void printArrayLength(ArrayList<Employee> staff) {
        try {
            Field field = staff.getClass().getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] elementData = (Object[]) field.get(staff);
            System.out.println("Array length: " + elementData.length);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void printEmployees(ArrayList<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    private static void printEmployees(Employee[] employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
