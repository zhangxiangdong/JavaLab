package me.zhang.coreJava.io;

import me.zhang.coreJava.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/12/15.
 */
public class ReadWriteTest {

    public static void main(String[] args) {
        Employee employee0 = new Employee("Carl Cracker", 100_000, 2013, 5, 3);
        Employee employee1 = new Employee("Harry Hacker", 500_000, 2012, 2, 24);
        Employee employee2 = new Employee("Tim Jacky", 300_000, 2016, 12, 2);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee0);
        employees.add(employee1);
        employees.add(employee2);

        final String fileName = "employees.data";
        writeData(fileName, employees);
        employees = readData(fileName);
        System.out.println(employees);
    }

    private static void writeData(String fileName, List<Employee> employees) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            GregorianCalendar calendar = new GregorianCalendar();
            StringBuilder builder = new StringBuilder();
            for (Employee employee : employees) {
                calendar.setTime(employee.getHireDay());

                // Tim Jacky|300000|2016|12|2
                builder.append(employee.getName());
                builder.append("|");
                builder.append(employee.getSalary());
                builder.append("|");
                builder.append(calendar.get(Calendar.YEAR));
                builder.append("|");
                builder.append(calendar.get(Calendar.MONTH) + 1);
                builder.append("|");
                builder.append(calendar.get(Calendar.DAY_OF_MONTH));

                builder.append(System.lineSeparator());
            }
            writer.println(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    private static List<Employee> readData(String fileName) {
        List<Employee> employees = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                // Tim Jacky|300000|2016|12|2
                String[] e = line.split("\\|");
                if (e.length == 5)
                    employees.add(
                            new Employee(
                                    e[0],
                                    Double.parseDouble(e[1]),
                                    Integer.parseInt(e[2]),
                                    Integer.parseInt(e[3]),
                                    Integer.parseInt(e[4])
                            ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

}
