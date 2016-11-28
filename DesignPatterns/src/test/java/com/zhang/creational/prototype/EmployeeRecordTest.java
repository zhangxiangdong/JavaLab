package com.zhang.creational.prototype;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created by Zhang on 11/27/2016 8:33 PM.
 */
public class EmployeeRecordTest {

    /**
     * Test whether the mirrored object contains same fields as the copied one.
     * Note: the two objects do not refer to the same object.
     */
    @Test
    public void testGetClone() {
        EmployeeRecord employeeRecord = new EmployeeRecord.Builder(121, "Jim")
                .withAddress("Peking")
                .withDesignation("Android Engineer")
                .withSalary(12000)
                .build();
        System.out.println(employeeRecord);

        EmployeeRecord mirror = (EmployeeRecord) employeeRecord.getClone();
        assertNotSame(employeeRecord, mirror);

        assertEquals(employeeRecord.getId(), mirror.getId());
        assertEquals(employeeRecord.getName(), mirror.getName());
        assertEquals(employeeRecord.getAddress(), mirror.getAddress());
        assertEquals(employeeRecord.getDesignation(), mirror.getDesignation());
        assertEquals(employeeRecord.getSalary(), mirror.getSalary(), 0);
    }

}