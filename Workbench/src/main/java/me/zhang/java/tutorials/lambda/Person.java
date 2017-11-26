package me.zhang.java.tutorials.lambda;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Zhang on 11/26/2017 8:35 PM.
 */
public class Person {

    public enum Gender {
        MALE, FEMALE
    }

    private String name;
    private int age;
    private Gender gender;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }

    public void print() {
        System.out.println(toString());
    }

    public static void printPerson(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.print();
            }
        }
    }

}
