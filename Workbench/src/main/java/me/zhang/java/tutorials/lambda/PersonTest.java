package me.zhang.java.tutorials.lambda;

import me.zhang.java.tutorials.lambda.Person.Gender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang on 11/26/2017 8:42 PM.
 */
public class PersonTest {

    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Lucy", 23, Gender.FEMALE, "18510728644"));
        roster.add(new Person("Jimmy", 22, Gender.MALE, "18510728643"));
        roster.add(new Person("Kevin", 20, Gender.MALE, "18510728642"));
        roster.add(new Person("Zhang", 25, Gender.MALE, "18510728641"));

        // Specify Search Criteria Code with a Lambda Expression
        Person.printPerson(
                roster,
                person -> person.getGender() == Gender.MALE && person.getAge() > 23,
                person -> person.getName() + ": " + person.getPhone(),
                System.out::println
        );
    }

}
