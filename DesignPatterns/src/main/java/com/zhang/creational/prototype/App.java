package com.zhang.creational.prototype;

/**
 * Created by Zhang on 11/27/2016 7:42 PM.
 */
public class App {

    public static void main(String[] args) {
        EmployeeRecord employeeRecord = new EmployeeRecord.Builder(121, "Jim")
                .withAddress("Peking")
                .withDesignation("Android Engineer")
                .withSalary(12000)
                .build();
        System.out.println(employeeRecord);

        EmployeeRecord mirror = (EmployeeRecord) employeeRecord.getClone();
        System.out.println(mirror);
    }

}
