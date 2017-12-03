package me.zhang.coreJava.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * Created by Zhang on 12/3/2017 12:21 PM.
 */
public class PriorityTest {

    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new GregorianCalendar(1893, Calendar.JULY, 21));
        priorityQueue.add(new GregorianCalendar(1907, Calendar.NOVEMBER, 2));
        priorityQueue.add(new GregorianCalendar(1976, Calendar.SEPTEMBER, 13));
        priorityQueue.add(new GregorianCalendar(2010, Calendar.DECEMBER, 1));
        priorityQueue.add(new GregorianCalendar(1992, Calendar.MARCH, 7));

        System.out.println("Iterating over elements: ");
        for (GregorianCalendar calendar : priorityQueue) {
            // The Iterator provided in method iterator() is not guaranteed
            // to traverse the elements of the priority queue in any particular order.
            // If you need ordered traversal, consider using Arrays.sort(pq.toArray()).
            System.out.println(calendar.get(Calendar.YEAR));
        }

        System.out.println("Removing elements: ");
        while (!priorityQueue.isEmpty()) {
            // The head of this queue is the least element with respect to the specified ordering.
            // By default: their natural ordering.
            System.out.println(priorityQueue.remove().get(Calendar.YEAR));
        }
    }

}
