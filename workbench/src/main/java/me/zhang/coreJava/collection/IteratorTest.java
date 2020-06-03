package me.zhang.coreJava.collection;

import java.util.*;

/**
 * Created by Zhang on 11/26/2017 3:40 PM.
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("Lily");
        staff.add("Bob");
        staff.add("Amy");

        iterate(staff);

        insert(staff);

        modifyWithListIterator(staff);

        try {
            throwConcurrentModificationException(staff);
        } catch (ConcurrentModificationException e) {
            System.out.println("Concurrent Modification Exception");
        }
    }

    private static void throwConcurrentModificationException(List<String> staff) {
        System.out.println("*****************");
        Iterator<String> iterator0 = staff.iterator();
        Iterator<String> iterator1 = staff.iterator();
        iterator0.next();
        iterator0.remove();
        // iterator1 is invalid now!
        iterator1.next();
    }

    private static void modifyWithListIterator(List<String> staff) {
        System.out.println("*****************");
        /*
                                Lucia   Lily   Bob
           cursor positions:  ^       ^      ^     ^
         */
        ListIterator<String> listIterator = staff.listIterator();

        /*
                Lucia   Lily   Bob
              ^
         */
        listIterator.next();

        /*
                Lucia   Lily   Bob
                      ^
         */
        listIterator.next();

        /*
                Lucia   Lily   Bob
                             ^
         */
        listIterator.add("Carl"); // add Carl to the position before current position of cursor
        System.out.println(staff);

        /*
                Lucia   Lily   Carl   Bob
                                    ^
         */
        String lastElement = listIterator.next();
        System.out.println(lastElement); // Bob

        System.out.println("*****************");
        listIterator.set("Tom"); // change Bob to Tom
        System.out.println(staff);
    }

    private static void insert(List<String> staff) {
        System.out.println("*****************");
        staff.add(0, "Lucia");
        System.out.println(staff);
    }

    private static void iterate(List<String> staff) {
        Iterator<String> iterator = staff.iterator();
        String first = iterator.next();
        String second = iterator.next();
        String third = iterator.next();
        iterator.remove(); // remove Amy
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(staff);

        ListIterator<String> listIterator = staff.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.nextIndex() + "^" + listIterator.next() + " -> ");
        }
        System.out.println();

        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previousIndex() + "^" + listIterator.previous() + " -> ");
        }
        System.out.println();
    }

}
