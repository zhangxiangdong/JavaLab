package me.zhang.coreJava;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Zhang on 10/6/2017 4:01 PM.
 */
public class Employee {

    private static int nextId = 1;

    private int id;
    private String name;
    private double salary;
    private Date hireDay;

    public Employee() {
        this.id = nextId++;
        this.name = "";
        this.salary = 0;
        this.hireDay = new Date();
    }

    public Employee(String name, double salary, int year, int month, int day) {
        // each employee has a unique id
        // start from 1
        this.id = nextId++;
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        // avoid breaking the encapsulation
        return (Date) hireDay.clone();
    }

    public void raiseSalary(int byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
