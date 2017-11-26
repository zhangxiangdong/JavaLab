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
        roster.add(new Person("Lucy", 23, Gender.FEMALE));
        roster.add(new Person("Jimmy", 22, Gender.MALE));
        roster.add(new Person("Kevin", 25, Gender.MALE));

        // Specify Search Criteria Code with a Lambda Expression
        Person.printPerson(roster, p -> p.getGender() == Gender.MALE && p.getAge() > 23);
    }

}
