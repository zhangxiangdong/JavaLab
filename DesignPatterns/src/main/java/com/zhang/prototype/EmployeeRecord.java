package com.zhang.prototype;

/**
 * Created by Zhang on 11/27/2016 7:40 PM.
 */
public class EmployeeRecord implements Prototype {

    private final int id;
    private final String name, designation;
    private final double salary;
    private final String address;

    private EmployeeRecord(Builder builder) {
        id = builder.id;
        name = builder.name;
        designation = builder.designation;
        salary = builder.salary;
        address = builder.address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public static final class Builder {

        private int id;
        private String name, designation;
        private double salary;
        private String address;

        public Builder(int id, String name) {
            if (id == 0) {
                throw new IllegalArgumentException("id can not be 0");
            }
            if (name == null) {
                throw new IllegalArgumentException("name can not be null");
            }
            this.id = id;
            this.name = name;
        }

        public Builder withDesignation(String designation) {
            this.designation = designation;
            return this;
        }

        public Builder withSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeRecord build() {
            return new EmployeeRecord(this);
        }

    }

    @Override
    public Prototype getClone() {
        return new EmployeeRecord.Builder(id, name)
                .withAddress(address)
                .withDesignation(designation)
                .withSalary(salary)
                .build();
    }

    @Override
    public String toString() {
        return "EmployeeRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}
