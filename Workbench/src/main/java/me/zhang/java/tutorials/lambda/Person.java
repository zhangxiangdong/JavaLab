package me.zhang.java.tutorials.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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
    private String phone;

    public Person(String name, int age, Gender gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public static void printPerson(List<Person> roster,
                                   Predicate<Person> tester,
                                   Function<Person, String> mapper,
                                   Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

}
