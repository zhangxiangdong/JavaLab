package me.zhang.coreJava;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Created by Zhang on 10/6/2017 4:01 PM.
 */
public class Employee extends Person {

    private static int nextId = 1;

    // static initialization block
    static {
        nextId = (int) (Math.random() * 10_000);
    }

    // each employee has a unique id
    // start from a random number(<10,000)
    private int id = assignId();

    private static int assignId() {
        return nextId++;
    }

    private String name = "";
    private double salary = 0;
    protected Date hireDay;

    // object initialization block
    {
        hireDay = new Date();
    }

    public Employee() {
    }

    public Employee(String name, double salary, int year, int month, int day) {
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

    @Override
    public String getDescription() {
        return "An employee with a salary of $" + salary;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        // avoid breaking the encapsulation
        return (Date) hireDay.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
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

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()");
        super.finalize();
    }

    @Override
    public boolean equals(Object obj) {
        // a quick test to see if the objects are identical
        if (this == obj) {
            return true;
        }

        // must return false if the explicit parameter is null
        if (obj == null) {
            return false;
        }

        // if the classes don't match, they can't be equal
        if (getClass() != obj.getClass()) {
            return false;
        }
//        if (!(obj instanceof Employee)) {
//            return false;
//        }

        // now we know obj is a non-null Employee
        Employee other = (Employee) obj;

        // test whether the fields have identical values
        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }
}
