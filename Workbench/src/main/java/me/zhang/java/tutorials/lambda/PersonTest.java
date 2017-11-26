package me.zhang.java.tutorials.lambda;

import me.zhang.java.tutorials.lambda.Person.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Zhang on 11/26/2017 8:42 PM.
 */
public class PersonTest {

    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Lucy", 23, Gender.FEMALE, "18510728644"));
        roster.add(new Person("Jimmy", 22, Gender.MALE, "18510728643"));
        roster.add(new Person("Kevin", 20, Gender.FEMALE, "18510728642"));
        roster.add(new Person("Zhang", 25, Gender.MALE, "18510728641"));

        // Specify Search Criteria Code with a Lambda Expression
        Person.printPerson(
                roster,
                person -> person.getGender() == Gender.MALE && person.getAge() > 23,
                person -> person.getName() + ": " + person.getPhone(),
                System.out::println
        );

        processElements(
                roster,
                person -> person.getGender() == Gender.FEMALE && person.getAge() > 20,
                person -> person.getName() + ": " + person.getPhone(),
                System.out::println
        );
    }

    /**
     * A generic version of {@link Person::printPerson} method.
     *
     * @param source a source of objects from the collection source
     * @param tester filters objects that match the Predicate object tester
     * @param mapper maps each filtered object to a value
     * @param block  performs an action on each mapped object as specified by the Consumer object block
     */
    private static <A, B> void processElements(Iterable<A> source,
                                               Predicate<A> tester,
                                               Function<A, B> mapper,
                                               Consumer<B> block) {
        for (A a : source) {
            if (tester.test(a)) {
                B data = mapper.apply(a);
                block.accept(data);
            }
        }
    }

}
