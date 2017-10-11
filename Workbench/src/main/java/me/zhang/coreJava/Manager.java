package me.zhang.coreJava;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        // super.equals checked that this and obj belong to the same class
        Manager other = (Manager) obj;
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(bonus);
    }
}
