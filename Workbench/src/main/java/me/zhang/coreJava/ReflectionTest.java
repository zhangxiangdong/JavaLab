package me.zhang.coreJava;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Created by Zhang on 2017/10/13 20:04.
 */
public class ReflectionTest {

    public static void main(String[] args) throws NoSuchFieldException {
        Employee employee = new Employee();
        Manager manager = new Manager();

        Class employeeClass = employee.getClass();
        Class managerClass = manager.getClass();

        // get class name
        String employeeClassName = employeeClass.getName();
        String simpleEmployeeClassName = employeeClass.getSimpleName();
        String managerClassName = managerClass.getName();
        String simpleManagerClassName = managerClass.getSimpleName();

        System.out.println("******************");
        System.out.println(employeeClassName);
        System.out.println(simpleEmployeeClassName);
        System.out.println(managerClassName);
        System.out.println(simpleManagerClassName);

        try {
            // initialize class object by class name
            employeeClass = Class.forName(employeeClassName);
            managerClass = Class.forName(managerClassName);

            System.out.println("******************");
            System.out.println(employeeClass.getName());
            System.out.println(managerClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<Employee> employeeCls = Employee.class;
        Class<Manager> managerCls = Manager.class;

        System.out.println("******************");
        System.out.println(employeeCls.getName());
        System.out.println(managerCls.getName());

        Class<Integer> intCls = int.class;
        Class<Double[]> doubleArrayCls = Double[].class;

        System.out.println("******************");
        System.out.println(intCls.getName());
        System.out.println(doubleArrayCls.getName());

        try {
            Employee clsEmployee = employeeCls.newInstance();
            Manager clsManager = managerCls.newInstance();

            System.out.println("******************");
            System.out.println(clsEmployee);
            System.out.println(clsManager);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Employee reflectiveEmployee = Employee
                    .class
                    .getConstructor(String.class, double.class, int.class, int.class, int.class)
                    .newInstance("Jim", 300_000, 2013, 3, 15);
            Manager reflectiveManager = (Manager) Class
                    .forName(managerClassName)
                    .getConstructor(String.class, double.class, int.class, int.class, int.class)
                    .newInstance("Hanks", 1_000_000, 2009, 11, 25);
            reflectiveManager.setBonus(5_000);

            System.out.println("******************");
            System.out.println(reflectiveEmployee);
            System.out.println(reflectiveManager);

            // Employee.class.getField("name"); method only find the field if it's public
            Field nameField = Employee.class.getDeclaredField("name");
            nameField.setAccessible(true);
            Class nameType = nameField.getType();
            int nameModifiers = nameField.getModifiers();

            System.out.println("******************");
            System.out.println(nameField.get(reflectiveEmployee));
            System.out.println(nameType.getName());
            System.out.println(Modifier.toString(nameModifiers));

            Method getHireDayMethod = Employee.class.getMethod("getHireDay");
            Class getHireDayReturnType = getHireDayMethod.getReturnType();
            int getNameModifiers = getHireDayMethod.getModifiers();

            System.out.println("******************");
            System.out.println(getHireDayMethod.invoke(reflectiveEmployee));
            System.out.println(getHireDayReturnType.getName());
            System.out.println(Modifier.toString(getNameModifiers));

            Constructor<Employee> employeeConstructor = Employee
                    .class
                    .getConstructor(String.class, double.class, int.class, int.class, int.class);
            int employeeConstructorParameterCount = employeeConstructor.getParameterCount();
            Class[] employeeConstructorParameterTypes = employeeConstructor.getParameterTypes();

            System.out.println("******************");
            System.out.println(employeeConstructor.getName());
            System.out.println(employeeConstructorParameterCount);
            System.out.println(Arrays.toString(employeeConstructorParameterTypes));
        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
