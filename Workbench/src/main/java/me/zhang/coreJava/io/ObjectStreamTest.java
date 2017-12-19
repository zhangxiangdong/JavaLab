package me.zhang.coreJava.io;

import me.zhang.coreJava.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/12/19.
 */
public class ObjectStreamTest {

    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Carl Cracker", 100_000, 2013, 5, 3));
        staff.add(new Employee("Harry Hacker", 500_000, 2012, 2, 24));
        staff.add(new Employee("Tony Tester", 1_000_000, 2010, 8, 17));
        System.out.println(System.identityHashCode(staff));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            //noinspection unchecked
            staff = (List<Employee>) in.readObject();
            System.out.println(System.identityHashCode(staff)); // readObject() creates a brand new object
            System.out.println(staff);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
