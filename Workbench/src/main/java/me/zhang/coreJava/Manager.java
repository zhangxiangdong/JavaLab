package me.zhang.coreJava;

/**
 * Created by Zhang on 10/8/2017 9:59 PM.
 */
public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0; // default bonus
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        // super is not a reference
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", hireDay=" + hireDay +
                ", bonus=" + bonus +
                '}';
    }
}
